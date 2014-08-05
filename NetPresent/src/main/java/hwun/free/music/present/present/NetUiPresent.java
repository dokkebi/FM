package hwun.free.music.present.present;

import android.content.Context;

import hwun.free.music.model.HttpUtil;
import hwun.free.music.present.ifs.INetUi;

/**
 * Created by HWUN on 2014-08-04.
 */
public class NetUiPresent implements INetUi {
    private HttpUtil httpUtil;
    private Context context;

    public NetUiPresent(Context context) {
        this.context = context;
    }

    @Override
    public void getHtmlSource(String targetUrl) {
        httpUtil = new HttpUtil(context);
        // httpUtil.getHtmlSource("");
    }

}
