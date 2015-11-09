package matinmehdipour.medli;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

/**
 * Created by matt on 10/22/15.
 */
public class LoginActivity2 extends AppCompatActivity
{
    EditText usernameField;
    EditText passwordField;

    Button registerButton;
    Button loginButton;

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

        setContentView(R.layout.account_login_fragment);


    }

    private void loadMainActivity()
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void doSignUp()
    {
       /* String email = usernameField.getText().toString();
        String password = passwordField.getText().toString();

        ParseUser parseUser = new ParseUser();
        parseUser.setEmail(email);
        parseUser.setUsername(email);
        parseUser.setPassword(password);

        parseUser.signUpInBackground(new SignUpCallback()
        {
            @Override
            public void done(ParseException e)
            {
                if (e == null)
                    Toast.makeText(LoginActivity2.this, "Signed up!", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(LoginActivity2.this, "Failed", Toast.LENGTH_SHORT).show();
            }
        });*/

    }

    private void doLogin()
    {
        String email = usernameField.getText().toString();
        String password = passwordField.getText().toString();

        ParseUser parseUser = new ParseUser();
        parseUser.setEmail(email);
        parseUser.setUsername(email);
        parseUser.setPassword(password);

        ParseUser.logInInBackground(email, password, new LogInCallback()
        {
            @Override
            public void done(ParseUser parseUser, ParseException e)
            {
                if(e == null)
                {
                    loadMainActivity();
                }
            }
        });
    }
}
