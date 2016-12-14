package navjot.singh.virk.taxcalculator;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by Navjot Singh Virk on 13/12/2016.
 */

public class SplashScreen extends Activity{

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        Thread timerThread = new Thread(){
            public void run(){
                try{
                    //setting the time 5000ms i.e 5seconds so,the spalsh screen will close in 5 seconds and
                    //launch the main activity
                    sleep(5000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally{
                    Intent intent = new Intent(SplashScreen.this,MainActivity.class);
                    startActivity(intent);
                }
            }
        };
        timerThread.start();
    }

    protected void onPause() {
        super.onPause();
        finish();
    }
}

//Reference: The Spalsh Screen is done with the help of this tutorial.Thanks
//http://www.coderefer.com/android-splash-screen-example-tutorial/