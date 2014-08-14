package music.free.hong.freemusic;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;

import hwun.free.music.present.present.NetUiPresent;

/**
 * Created by HH on 2014-08-06.
 */
public class HelloTest extends ActivityInstrumentationTestCase2<MainActivity> {

    public HelloTest() {
        super(MainActivity.class);
    }

    public void testgg() {
        Activity ac = getActivity();
        NetUiPresent p = new NetUiPresent(ac.getBaseContext());
        p.getHtmlSource("http://search.4shared.com/q/CCQD/1/music/Touch+my");
    }
}
