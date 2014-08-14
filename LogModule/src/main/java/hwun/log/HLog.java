package hwun.log;

import android.util.Log;

/**
 * Created by HH on 2014-08-14.
 */
public class HLog {
    public static final String G_TAG_NAME = "FM";

    public static void info(String log) {
        Log.i(G_TAG_NAME, log);
    }
}
