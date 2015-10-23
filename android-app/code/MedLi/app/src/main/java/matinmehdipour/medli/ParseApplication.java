package matinmehdipour.medli;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseCrashReporting;

public class ParseApplication extends Application
{

    @Override
    public void onCreate()
    {
        super.onCreate();

        ParseCrashReporting.enable(this);
        Parse.enableLocalDatastore(this);
        Parse.initialize(this, "38l5kZBzGpllHlnK2smDASmsior0h6Ay4phjYkvX", "YU98ajwNAjzePYoAn5FAoMYpwwBfFgF4tZzL9Z2k");
    }
}
