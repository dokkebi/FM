package hwun.free.music.present.present;
import hwun.free.music.model.HttpUtil;
import hwun.free.music.present.ifs.INetUi;

/**
 * Created by HWUN on 2014-08-04.
 */
public class NetUiPresent implements INetUi {
    private HttpUtil httpUtil;

    @Override
    public void getHtmlSource(String targetUrl) {
        httpUtil = new HttpUtil();
        httpUtil.getHtmlSource("");
    }

}
