using System.Collections;
using System.Collections.Generic;
using UnityEngine.UI;
using UnityEngine;
using System.Linq;

public class singletonManager : MonoBehaviour {

    private static singletonManager _instance;

    public static singletonManager Instance
    {
        get
        {
            if (_instance == null)
            {
                GameObject go = new GameObject("singletonManager");
                go.AddComponent<singletonManager>();
            }
            return _instance;
        }
    }

    //delegate void MultiDelegate();//here you make the delegate
    //MultiDelegate myMultiDelegate;// and here you give it a name

    //obsticles - questons list
    public List<GameObject> obsticleAnswersList = new List<GameObject>();
    public List<GameObject> activeAnswers = new List<GameObject>();
    public Dictionary<int,string> answerDict = new Dictionary<int, string>();
    public Dictionary<int, string> questionDict = new Dictionary<int, string>();

    public string[] questionStrings;
    //public List<string> questionStrgs = new List<string>();
    public List<GameObject> activeTiles = new List<GameObject>();
    public List<string> askedQuestionlist = new List<string>();
    public List<string> colidedAnswerList = new List<string>();
    public List<string> trueAnswerList = new List<string>();
    public List<int> pointList = new List<int>();

    public MainMenu mainMenu;
    public Result resultPrefab;

    //planes
    [SerializeField]
    public GameObject[] platformPrefabs;
    public int platformLenghtZ = 55;//length
    public float spawnPlatformeOffsetZ = -5.0f;//where platform/object should spawn
    public float safeZone = 50.0f;//this is the legth on the z axix before deletePlatform() 
    public Transform playerTransform;
    //public int totalScore;

    //UI
    public List<Text> obsticleText = new List<Text>();
    public Text scoreText;//when setting score txt drag gameObject to the existing script
    public Text winText;
    public Text question;
    public Text yourAnswer;
    public Text trueAnswer;
    public Text point;
    public Text total;
    public Text hintTxt;
    public Text pauseTxt;
    public Text levelTxt;
    public Text questionText;

    public GameObject result;
    public GameObject hint;
    public GameObject pauseBtn;
    public GameObject pauseOptionBtn;

    public GameObject nextlevelBtn;
    public int hintCounter = 3;

    //player
    public int score;
    public int answerCount;
    public float objSpeed = 5.0f;
    public int answerBoxSpawnOffsetZ = 50;
    public float moveSpeed;
    public float directionSpeed = 10.0f;
    public float jumpForce = 500.0f;
    //public bool isSet;

    void Start()
    {
        //automaticMovement.isLevelHigher();
        playerTransform = GameObject.FindGameObjectWithTag("Player").transform;
        singletonManager.Instance.hintTxt.text = "Hint: " + hintCounter.ToString();
        levelTxt.text = "Level: " + automaticMovement.level.ToString();
        
        //moveSpeed = 10.0f;
        //mainMenu = FindObjectOfType<MainMenu>();
        //pos = new Vector3(0f, 2f, 50f);
        //myMultiDelegate += spawnEnemyObj;//this is how you call a function
        //myMultiDelegate += TurnRed;

        // myMultiDelegate();

        //myDelegate = OnTriggerEnter;//this is how you pass a function to it
        //myDelegate(50);//here you can call it

        //myDelegate = DoubleNum;
        //myDelegate(50);
    }

    void TurnRed()
    {
        GetComponent<Renderer>().material.color = Color.red;
    }

    void Awake()
    {
        _instance = this;
    }

    public void setScoreText()
    {
        scoreText.text = "Score: " + score.ToString();
        //if the score is More or is 9 winText is You Win!
        //singletonManager.Instance.hintTxt.text = singletonManager.Instance.hintCounter.ToString();

        if ( answerCount >= automaticMovement.totalScore)
        {
            //Debug.Log("SETSCORETEXT CALLED :D");

            int pointListSum = pointList.Sum();

            Time.timeScale = 0;//pauses game
            //Debug.Log("NEW Speed: " + moveSpeed);

            if (result == null)
            {
                result = GameObject.FindGameObjectWithTag("ShowResult");
            }
            result.gameObject.SetActive(true);

            float heightOffset = -10.0f;

            for (int i = 0; i < askedQuestionlist.Count; i++)
            {
                //float y = 0.0f;

                Result tempResult = Instantiate(resultPrefab, Vector3.zero, Quaternion.identity);//this instantiate the object in the result class

                RectTransform tempRect = tempResult.GetComponent<RectTransform>();

                tempResult.transform.SetParent(mainMenu.transform);

                tempRect.anchoredPosition = new Vector2(0, i* heightOffset);

                //tempRect.anchoredPosition = new Vector3(0, 0, 0);

                //Debug.Log("pos.x: " + tempResult.transform.position.x);

                //Debug.Log("tempRect.anchoredPosition: " + tempRect.anchoredPosition);

                //Debug.Log("localPos.x: " + tempResult.transform.localPosition.x);

                tempResult.questionTxt.text = askedQuestionlist[i];
                tempResult.yourAnswerTxt.text = colidedAnswerList[i];
                tempResult.trueAnswerTxt.text = trueAnswerList[i];
                tempResult.pointsTxt.text = pointList[i].ToString();
                total.text = pointListSum.ToString();
            }

            
        }

        if (score < 0)
        {
            //print("You Lose!!");
            score = 0;
            scoreText.text = "Score: " + score;

            //winText.gameObject.SetActive(true);
            //winText.text = "Bruhh!!!";
        }
    }
}
