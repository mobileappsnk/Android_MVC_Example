package nk.mobileapps.androidmvcexample.login;


import android.annotation.SuppressLint;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;

/**
 * LoginController intercepts the on click login button event, verify the inputs 
 */
@SuppressLint("NewApi")
public class LoginController implements OnClickListener{

	private final String TAG = "Login controller";
	
	private LoginView loginView;
	private LoginControllerListener listener;
	

	public LoginController(LoginView loginView, LoginControllerListener listener) {
		this.loginView = loginView;
		this.listener = listener;
	}

	/**
	 * Login button was clicked
	 */
	@Override
	public void onClick(View v) {
		Log.i(TAG, "onClick");
		
		// Check for a valid email address.
		if(loginView.getLogin().isEmpty() || loginView.getLogin().equals(""))
            loginView.setLoginError("This field is required");
		else
			if(!loginView.getLogin().contains("@"))
				loginView.setLoginError("This email address is invalid");

		// Check for a valid password.
		if(loginView.getPassword().isEmpty() || loginView.getPassword().equals(""))
			loginView.setPasswordError("This field is required");
		else
			if(loginView.getPassword().length() < 3)
				loginView.setPasswordError("This field is required");
		else
			//If all inputs are rights than go next
			//Here you'll probably call a web service that will verify
			//the login
			//We just inform the LoginActivity that login is successful
			listener.onLoginSuccess();
	}

}
