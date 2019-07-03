package nk.mobileapps.androidmvcexample.login;

/**
 * Methods implemented by LoginActivity to establish a communication between
 * the LoginController and the LoginActivity
 */
public interface LoginControllerListener {
    /**
     * The method is called by Login controller to inform the
     * Login Activity about the successful login
     */
    public void onLoginSuccess();
}
