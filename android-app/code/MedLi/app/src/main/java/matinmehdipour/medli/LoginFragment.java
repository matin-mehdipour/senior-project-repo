package matinmehdipour.medli;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

/**
 * Created by matt on 11/6/15.
 */
public class LoginFragment extends Fragment implements View.OnClickListener
{
    View v;
    Button registerButton;
    Button loginButton;

    EditText emailET;
    EditText passwordET;

    LoginActivity loginActivity;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        v = inflater.inflate(R.layout.account_login_fragment, container, false);

        loginButton = (Button)v.findViewById(R.id.login_button);
        loginButton.setOnClickListener(this);

        emailET = (EditText)v.findViewById(R.id.email_et_signin);
        passwordET = (EditText)v.findViewById(R.id.password_et_signin);

        return v;
    }

    @Override
    public void onStart()
    {
        super.onStart();

        loginActivity = (LoginActivity)getActivity();

        registerButton = (Button)v.findViewById(R.id.register_button);
        registerButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        if(v == loginButton)
        {
            String email = emailET.getText().toString();
            String password = passwordET.getText().toString();


            ParseUser.logInInBackground(email, password, new LogInCallback()
            {
                @Override
                public void done(ParseUser parseUser, ParseException e)
                {
                    if(e == null)
                    {
                        Intent intent = new Intent(getActivity(), MainActivity.class);
                        startActivity(intent);
                        getActivity().finish();
                    }
                }
            });
        }
        else if(v == registerButton)
        {
            loginActivity.switchToRegistration();
        }
    }
}
