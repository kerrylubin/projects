using System.Collections;
using UnityEngine.UI;
using System.Collections.Generic;
using UnityEngine;
using System.Linq;


public class automaticMovement : MonoBehaviour
{
    public static int level = 1;
    public static string collectedAnswer;
    //public static int truePoint = 2;
    public static int falsePoint = 1;
    public static int noPoint = 0;
    public static int trueAnswerScore = 2;
    public static int falseAnswerScore = 0;
    public static int totalScore = 6;
    //public float jumpForce = 500.0f;
    //public string answerValue;
    //public string questionValue;
    Rigidbody rb;

    void Start()
    {
        //singletonManager.Instance.moveSpeed = 10.0f;
        isLevelHigher();
        //answer = FindObjectOfType<answerScript>();//this how you access a variable in a different class/script
        singletonManager.Instance.score = 0;
        singletonManager.Instance.setScoreText();

        rb = GetComponent<Rigidbody>();
    }



    void FixedUpdate()
    {
        //isLevelHigher();

        if (Input.GetKeyDown(KeyCode.Space))
        {
            if(transform.position.y <= 1.5f)
            {
                rb.AddForce(new Vector3(0,6,0) * 2, ForceMode.Impulse );
            }
            //controller.attachedRigidbody.AddForce(Vector3.up * 3000);

        }

        //Debug.Log(answ());

        //moveVector = Vector3.zero;
        // X = Left and Right
        //moveVector.x = Input.GetAxisRaw("Horizontal") * 5;
        // Y = Up and Down
        //moveVector.y = Input.GetAxisRaw("Jump") * 5;
        // Z = Forward and Backward
        //moveVector.z = moveSpeed;

        rb.MovePosition(this.transform.position + new Vector3(Input.GetAxisRaw("Horizontal") * singletonManager.Instance.directionSpeed, 0, singletonManager.Instance.moveSpeed) * Time.deltaTime);

        //rb.MovePosition((Vector3.forward * moveSpeed) * Time.deltaTime);//automove forward every frame
    }

    //Update is called once per frame
    void Update()
    {
        //foreach (KeyValuePair<int, string> answer in singletonManager.Instance.answerDict)
        //{
        //    answerValue = answer.Value;

        //    //Debug.Log("Answer Key:" + answer.Key);
        //    //Debug.Log("Answer Value:" + answer.Value);
        //}

        

        //Debug.Log("isAswered: " + platformManager.isAswered );
    }

    public static void isLevelHigher()
    {
        singletonManager.Instance.moveSpeed = 10.0f;
        ////Debug.Log("Level: " + level);
        
        if (level > 1)
        {
            //float newMovespeed = (singletonManager.Instance.moveSpeed * 1.5f);
            //singletonManager.Instance.moveSpeed = newMovespeed;

            Time.timeScale = (automaticMovement.level * 0.5f);
            singletonManager.Instance.hint.gameObject.SetActive(true);
            singletonManager.Instance.scoreText.text = "Score: " + singletonManager.Instance.pointList.Sum().ToString();

            totalScore = totalScore - level;

            if(totalScore < 1)
            {
                totalScore = 1;
            }

            //singletonManager.Instance.moveSpeed = singletonManager.Instance.moveSpeed * 1.5f;
            if (level >= 5)
            {
                singletonManager.Instance.hintCounter = 5;
                //singletonManager.Instance.hintTxt.text = "Hint: " + singletonManager.Instance.hintCounter.ToString();
            }
            //Debug.Log("totalScore: " + totalScore);
        }
        else
        {
            //Time.timeScale = 0.5f;
            singletonManager.Instance.hint.gameObject.SetActive(false);
            //Debug.Log("Level 1 Movespeed: " + Time.timeScale);
        }

    }


    void OnTriggerEnter(Collider other)
    {
        platformManager.isQuestionAnswered = true;
        MainMenu.hint = false;

        //singletonManager.Instance.askedQuestionlist.Add(singletonManager.Instance.questionText.text);
        //Debug.Log("isAnswered HIT " + platformManager.isAswered);
        //singletonManager.Instance.trueAnswerList.Add(answerValue);

        collectedAnswer = other.GetComponentInChildren<Button>().GetComponentInChildren<Text>().text;

        //Debug.Log("Answer Colected: " + collectedAnswer);
       
        singletonManager.Instance.colidedAnswerList[platformManager.counter] = collectedAnswer;
        //singletonManager.Instance.colidedAnswerList.Add(collectedAnswer);
        //Debug.Log("colidedAnswerList: " + singletonManager.Instance.colidedAnswerList[platformManager.counter]);

        if (collectedAnswer == platformManager.answerValue && other.gameObject.CompareTag("Hit"))
        {
            print("True!!!");

            singletonManager.Instance.pointList[platformManager.counter] = trueAnswerScore;
            //singletonManager.Instance.pointList.Add(truePoint);
            other.gameObject.SetActive(false);
            singletonManager.Instance.score += trueAnswerScore;
            singletonManager.Instance.answerCount += trueAnswerScore;

            singletonManager.Instance.setScoreText();
            //Debug.Log("Answer Value:" + answerValue);

            if (level == 8 )
            {
                singletonManager.Instance.nextlevelBtn.gameObject.SetActive(false);
                singletonManager.Instance.winText.gameObject.SetActive(true);
                singletonManager.Instance.winText.text = "You Win!!!";
            }
        }
        else if(collectedAnswer != platformManager.answerValue && other.gameObject.CompareTag("Hit"))
        {
            print("False!!!");

            singletonManager.Instance.pointList[platformManager.counter] = falseAnswerScore;
            //singletonManager.Instance.pointList.Add(falsePoint);
            other.gameObject.SetActive(true);
            singletonManager.Instance.score -= falsePoint;
            singletonManager.Instance.setScoreText();
            //Debug.Log("collected Answer Value:" + collectedAnswer);
        }
    }
}

