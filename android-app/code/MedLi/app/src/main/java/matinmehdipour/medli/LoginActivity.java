package matinmehdipour.medli;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.parse.ParseUser;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        ParseUser currentUser = ParseUser.getCurrentUser();
        if (currentUser != null)
        {
            // Send logged in users to Welcome.class
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }

        setContentView(R.layout.fragment_main);


    }

    @Override
    protected void onStart()
    {
        super.onStart();


        FragmentManager fm = getSupportFragmentManager();

        fm.beginTransaction().replace(R.id.container, new LoginFragment()).commit();
    }

    public void switchToLogin()
    {
        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction().replace(R.id.container, new LoginFragment()).commit();
    }

    public void switchToRegistration()
    {
        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction().replace(R.id.container, new RegisterFragment()).commit();
    }
}

