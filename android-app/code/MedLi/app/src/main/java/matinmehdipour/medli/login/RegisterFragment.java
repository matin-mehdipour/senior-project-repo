package matinmehdipour.medli.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

import matinmehdipour.medli.R;

/**
 * Created by matt on 11/6/15.
 */
public class RegisterFragment extends Fragment
{
    View v;
    Button backToLoginButton;

    LoginActivity loginActivity;

    //editables
    EditText fullNameET;
    EditText emailET;
    EditText passwordET;
    EditText confirmPwET;

    //spinner
    Spinner accountTypeSpinner;

    String[] accountTypeArray = {"Consumer", "Publisher"};

    Button registerButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        v = inflater.inflate(R.layout.account_register_fragment, container, false);


        emailET = (EditText)v.findViewById(R.id.email_et_signin);
        passwordET = (EditText)v.findViewById(R.id.password_et);
        confirmPwET = (EditText)v.findViewById(R.id.confirm_password_et);

        accountTypeSpinner = (Spinner)v.findViewById(R.id.account_type_spinner);



        ArrayAdapter<String> arrayAdapter =
                new ArrayAdapter<String>(getActivity(),
                        android.R.layout.simple_spinner_dropdown_item, accountTypeArray);


        registerButton = (Button)v.findViewById(R.id.register_button);
        registerButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                doRegister();

            }
        });

        return v;
    }

    private void takeBackToLogin(String email)
    {
        loginActivity.switchToLogin();
    }

    private void doRegister()
    {
        final String email = emailET.getText().toString();
        String password = passwordET.getText().toString();
        String confirmPW = confirmPwET.getText().toString();

        ParseUser parseUser = new ParseUser();
        parseUser.setUsername(email);
        parseUser.setEmail(email);
        parseUser.put("first_time", true);
        parseUser.put("setup_complete", false);
        parseUser.setPassword(password);
        parseUser.signUpInBackground(new SignUpCallback()
        {
            @Override
            public void done(ParseException e)
            {
                if(e == null)
                {
                    Toast.makeText(getActivity(), "Success!", Toast.LENGTH_SHORT).show();
                    takeBackToLogin(email);
                }
            }
        });
    }


    @Override
    public void onStart()
    {
        super.onStart();
        loginActivity = (LoginActivity)getActivity();

        backToLoginButton = (Button)v.findViewById(R.id.back_to_login_button);

        backToLoginButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                loginActivity.switchToLogin();
            }
        });
    }
}
