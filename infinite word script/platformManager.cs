using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;


public class platformManager : MonoBehaviour
{
    public static bool isQuestionAnswered;
    public static bool isPlayingGame = true;

    //Renderer m_Renderer;

    //[SerializeField]
    //private GameObject[] platformPrefabs; 
    //private int zedOffset = 55;//length
    //private float spawnZ = -5.0f;//where platform/object should spawn
    //private float safeZone = 55.0f;//this is the legth on the z axix before deleteTile() 
    //private Transform playerTransform;
    //private List<GameObject> activeTiles = new List<GameObject>();
    //private Vector3 pos;
    //public Dictionary<int, string> question_answer = new Dictionary<string, string>();
    public static int counter = -1;
    public static int questionId;
    //public static Behaviour halo;

    public static string answerValue;
    public string questionValue;
    GameObject rightAnswerBox;


    private void Start ()
    {
        //Debug.Log(singletonManager.Instance.answerDict[0]);
        singletonManager.Instance.answerDict.Add(0, "Blue");
        singletonManager.Instance.answerDict.Add(1, "Family");
        singletonManager.Instance.answerDict.Add(2, "Yellow");
        singletonManager.Instance.answerDict.Add(3, "Green");
        singletonManager.Instance.answerDict.Add(4, "Earth");
        singletonManager.Instance.answerDict.Add(5, "Pencil");
        singletonManager.Instance.answerDict.Add(6, "Watch");
        singletonManager.Instance.answerDict.Add(7, "Shoes");
        singletonManager.Instance.answerDict.Add(8, "Bottle");
        singletonManager.Instance.answerDict.Add(9, "Red");

        for (int i = 0; i < singletonManager.Instance.platformPrefabs.Length; i++)
        {
            spawnPlatform();
        }
        //isLevelHigher();
        isAnswerd();
        spawnQuestions();
        answerBoxes();
        //this spawn 3 tiles and 3 obsticles
    }

    private void Update()
    {
        gameManager();
        isHalo();
    }

    private void gameManager()
    {
        if (singletonManager.Instance.playerTransform.position.z - singletonManager.Instance.safeZone >
                (singletonManager.Instance.spawnPlatformeOffsetZ - singletonManager.Instance.platformPrefabs.Length * singletonManager.Instance.platformLenghtZ)
            )//here it spawn when player position is greater than z offset
        {
            isAnswerd();
            spawnPlatform();
            spawnQuestions();
            answerBoxes();
            //deleteQuestions();
            deleteObsticles();
            deleteTile();
        }
    }

    public void isAnswerd()
    {
        isQuestionAnswered = false;
        counter++;

        if (isQuestionAnswered == false)
        {
            //MainMenu.hint = false;
            singletonManager.Instance.colidedAnswerList.Add("No Answer");
            singletonManager.Instance.pointList.Add(automaticMovement.noPoint);
            //singletonManager.Instance.colidedAnswerList[counter] = "No Answer";
            //Debug.Log("isAnswered " + platformManager.isAswered);
        }
        //Debug.Log("isAnswered " + platformManager.isAswered);
    }

    private void spawnPlatform(int prefabIndex = -1)
    {
        GameObject go = Instantiate(singletonManager.Instance.platformPrefabs[0]) as GameObject;
        go.transform.SetParent(transform);
        go.transform.position = Vector3.forward * singletonManager.Instance.spawnPlatformeOffsetZ;
        singletonManager.Instance.spawnPlatformeOffsetZ += singletonManager.Instance.platformLenghtZ;
        singletonManager.Instance.activeTiles.Add(go);//add the active tiles to a list to re-use
    }

    private void deleteTile()
    {
        Destroy(singletonManager.Instance.activeTiles[0]);
        singletonManager.Instance.activeTiles.RemoveAt(0);
    }//destroy first from list

    //you need to find a way to load every answer specific to the question
    private void spawnQuestions()
    {
        singletonManager.Instance.questionText.text = singletonManager.Instance.questionStrings[Random.Range(0, 9)];
        //this must be added when question is answered
        singletonManager.Instance.askedQuestionlist.Add(singletonManager.Instance.questionText.text);
    }//spawn the questions

    //private void deleteQuestions()
    //{
        //Destroy(singletonManager.Instance.activeQuestions[Random.Range(0, 9)]);//destroy first from list
        //singletonManager.Instance.activeQuestions.RemoveAt(0);
        //singletonManager.Instance.activeQuestions.RemoveAt(1);
        //singletonManager.Instance.activeQuestions.RemoveAt(2);
        //singletonManager.Instance.activeQuestions.RemoveAt(3);
        //singletonManager.Instance.activeQuestions.RemoveAt(4);
        //singletonManager.Instance.activeQuestions.RemoveAt(5);
        //singletonManager.Instance.activeQuestions.RemoveAt(6);
        //singletonManager.Instance.activeQuestions.RemoveAt(7);
        //singletonManager.Instance.activeQuestions.RemoveAt(8);
        //singletonManager.Instance.activeQuestions.RemoveAt(9);

    //}//destroy first from list

    public void answerBoxes()
    {

        //float step = singletonManager.Instance.objSpeed * Time.time;

        GameObject go = Instantiate(singletonManager.Instance.obsticleAnswersList[Random.Range(0, 1)], new Vector3(-1f, 2.5f, 1f * singletonManager.Instance.answerBoxSpawnOffsetZ), Quaternion.identity);//random spawn

        for (int i = 0; i < singletonManager.Instance.questionStrings.Length; i++)
        {
            //if the question text the same as question in array make obsticle text the answer of that question
            if ( singletonManager.Instance.questionText.text == singletonManager.Instance.questionStrings[i] )
            {
                questionId = i;

                answerValue = singletonManager.Instance.answerDict[i];

                singletonManager.Instance.trueAnswerList.Add(answerValue);
                //Debug.Log("index " + i);

                Transform[] childs = (Transform[])go.GetComponentsInChildren<Transform>();

                rightAnswerBox = (GameObject)((Transform)childs[Random.Range(0, childs.Length)]).gameObject;
                rightAnswerBox.GetComponentInChildren<Text>().text = singletonManager.Instance.answerDict[i];

                //this selects a child in the box randomly
                for (int j = 0; j < childs.Length; j++)
                {
                    //randomChildGameObject.GetComponentInChildren<Text>().GetComponent("Halo");

                    //MainMenu.hint = false;

                    // this gets the text in that child and set the text to the right answer
                    //Debug.Log("childs " + childs[j].gameObject.GetComponentInChildren<Text>().text);

                    if (childs[j].gameObject.GetComponentInChildren<Text>().text == "Button")
                    //this changes the other text to random answers or the wrong answer
                    {
                        GameObject otherChildGameObject = childs[j].gameObject;

                        childs[j].gameObject.GetComponentInChildren<Text>().text = singletonManager.Instance.answerDict[Random.Range(0, i)];

                        //Debug.Log("otherChild " + otherChildGameObject);

                        if (otherChildGameObject.GetComponentInChildren<Text>().text == singletonManager.Instance.answerDict[i])
                        {
                            otherChildGameObject.GetComponentInChildren<Text>().text = singletonManager.Instance.answerDict[Random.Range(0, i)];
                        }
                    }
                }

                //CheckHalo();

            }//check if right answers is spawned
        }

        //Debug.Log("True Answer:" + answerValue );

        go.transform.SetParent(transform);

        singletonManager.Instance.answerBoxSpawnOffsetZ += singletonManager.Instance.platformLenghtZ;
        singletonManager.Instance.activeAnswers.Add(go);//add the active tiles to a list to re-use;//add the active tiles to a list to re-use
    }//spawn the obsticles

    private void isHalo()
    {
        Behaviour halo = (Behaviour)rightAnswerBox.GetComponentInChildren<Text>().GetComponent("Halo");
        //randomChildGameObject.transform.name = "I AM THE RIGHT ONE";
        //halo.transform.name = "I AM THE RIGHT HALO!!";

        if (MainMenu.hint == true)
        {
            Debug.Log("hint is true " + MainMenu.hint);
            automaticMovement.trueAnswerScore = automaticMovement.noPoint;//this turns the point to 0
            //Time.timeScale = 0.5f;
            singletonManager.Instance.moveSpeed = 3;

            halo.enabled = true;//this set the halo to true
        }
        else if (MainMenu.hint == false  )
        {
            Debug.Log("hint is false " + MainMenu.hint);
            automaticMovement.trueAnswerScore = 2;
            singletonManager.Instance.moveSpeed = 10;
            //Time.timeScale = (automaticMovement.level * 0.5f);
            halo.enabled = false;//this set the halo to true
            Debug.Log("hint false Movespeed: " + Time.timeScale);

        }

        if (singletonManager.Instance.hintCounter == 0)
        {
            singletonManager.Instance.hint.GetComponent<Button>().interactable = false;
        }
    }

    public void deleteObsticles()
    {
        Destroy(singletonManager.Instance.activeAnswers[0]);//destroy first from list
        singletonManager.Instance.activeAnswers.RemoveAt(0);
    }//destroy first from list

}
