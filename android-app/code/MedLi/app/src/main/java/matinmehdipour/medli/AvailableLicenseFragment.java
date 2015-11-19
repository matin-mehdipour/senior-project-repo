package matinmehdipour.medli;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

/**
 * Created by matt on 11/18/15.
 */
public class AvailableLicenseFragment extends Fragment
{
    View v;


    ListView availableLV;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        v = inflater.inflate(R.layout.avail_license_frag, container, false);


        availableLV = (ListView)v.findViewById(R.id.avail_license_lv);

        LayoutInflater inflater1 = getActivity().getLayoutInflater();

        availableLV.setEmptyView(inflater1.inflate(R.layout.empty_view, null, false));

        return v;
    }
}
