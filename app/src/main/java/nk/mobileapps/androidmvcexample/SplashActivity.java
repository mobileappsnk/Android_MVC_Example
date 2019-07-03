package nk.mobileapps.androidmvcexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import nk.mobileapps.androidmvcexample.login.LoginActivity;
import nk.mobileapps.androidmvcexample.welcome.WelcomeActivity;

public class SplashActivity extends AppCompatActivity {

    Thread splashTread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        splashTread = new Thread() {
            @Override
            public void run() {
                try {
                    int waited = 0;
                    // Splash screen pause time
                    while (waited < 3500) {
                        sleep(100);
                        waited += 100;
                    }
                    //do something here

                } catch (InterruptedException e) {
                    // do nothing
                } finally {

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                            startActivity(intent);
                        }
                    });

                }

            }
        };
        splashTread.start();
    }
}
