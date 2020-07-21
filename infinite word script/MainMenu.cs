using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;
using UnityEngine.UI;

public class MainMenu : MonoBehaviour {
    public static bool hint;
    

    public void nextLevel()
    {
        SceneManager.LoadScene(1);
        platformManager.counter = -1;
        automaticMovement.level++;
        //Time.timeScale = (automaticMovement.level * 0.5f);
        //Time.timeScale = 0.5f;
        //singletonManager.Instance.moveSpeed = automaticMovement.newMovespeed;
        //automaticMovement.isLevelHigher();
    }

    public void pauseBtn()
    {
        platformManager.isPlayingGame = false;
        Time.timeScale = 0;
        singletonManager.Instance.pauseOptionBtn.gameObject.SetActive(true);
        singletonManager.Instance.pauseBtn.gameObject.SetActive(false);
        //singletonManager.Instance.pauseTxt.text = "Resume";
    }

    public void resumeBtn()
    {
        if (platformManager.isPlayingGame == false)
        {
            singletonManager.Instance.pauseBtn.gameObject.SetActive(true);
            singletonManager.Instance.pauseOptionBtn.gameObject.SetActive(false);
            if(automaticMovement.level == 1)
            {
                Time.timeScale = 1;
            }
            else
            {
                Time.timeScale = (automaticMovement.level * 0.5f);

            }

            platformManager.isPlayingGame = true;
        }

        //platformManager.isPlayingGame = true;
        //Time.timeScale = 0;
        //singletonManager.Instance.pauseTxt.text = "Resume";
    }

    public void HintBtn()
    {
        hint = true;
        
        Debug.Log("Hint button was Clicked!!");
        singletonManager.Instance.hintCounter--;
        singletonManager.Instance.hintTxt.text = "Hint: " + singletonManager.Instance.hintCounter.ToString();
        //Debug.Log("HINT COUNT: " + singletonManager.Instance.hintCounter);
    }

    // Use this for initialization
    public void PlayGame ()
    {
        //SceneManager.LoadScene(SceneManager.GetActiveScene().buildIndex + 1);
        SceneManager.LoadScene(1);
        platformManager.counter = -1;
        automaticMovement.level = 1;
        //automaticMovement.isLevelHigher();
        Time.timeScale = 1;
    }

    public void QuitToMenu()
    {
        //Debug.Log("Game Quit!");
        SceneManager.LoadScene(0);
    }


    public void QuitGame()
    {
        Debug.Log("Game Quit!");
        Application.Quit();
    }

}
