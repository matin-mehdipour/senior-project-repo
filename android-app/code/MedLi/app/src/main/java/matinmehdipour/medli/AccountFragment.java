package matinmehdipour.medli;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import matinmehdipour.medli.R;

/**
 * Created by matt on 11/10/15.
 */
public class AccountFragment extends Fragment
{
    View v;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        v = inflater.inflate(R.layout.account_fragment_layout, container, false);
        return v;
    }
}
