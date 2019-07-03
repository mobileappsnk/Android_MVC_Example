package nk.mobileapps.androidmvcexample.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import nk.mobileapps.androidmvcexample.R;
import nk.mobileapps.androidmvcexample.welcome.WelcomeActivity;

public class LoginActivity extends AppCompatActivity implements LoginControllerListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Activity links the view and the controller
        LoginController loginController = new LoginController((LoginView) this.findViewById(R.id.login), this);
        //The Login controller will intercept the events of LoginView
        ((LoginView) this.findViewById(R.id.login)).setListeners(loginController);
    }

    @Override
    public void onLoginSuccess() {
        Intent intent = new Intent(this, WelcomeActivity.class);
        startActivity(intent);
    }
}
