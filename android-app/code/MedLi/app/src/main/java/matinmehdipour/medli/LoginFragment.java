package matinmehdipour.medli;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by matt on 11/6/15.
 */
public class LoginFragment extends Fragment
{
    View v;
    Button registerButton;

    LoginActivity loginActivity;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        v = inflater.inflate(R.layout.account_login_fragment, container, false);
        return v;
    }

    @Override
    public void onStart()
    {
        super.onStart();

        loginActivity = (LoginActivity)getActivity();

        registerButton = (Button)v.findViewById(R.id.register_button);
        registerButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                loginActivity.switchToRegistration();
            }
        });
    }
}
