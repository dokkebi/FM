package hwun.free.music.present.present;
import hwun.free.music.model.HttpUtil;
/**
 * Created by HWUN on 2014-08-04.
 */
public class NetUiPresent {
    private HttpUtil httpUtil;
    public String getHtmlSource(){
        httpUtil = new HttpUtil();
        httpUtil.getHtmlSource("");
        return "";
    }
}
