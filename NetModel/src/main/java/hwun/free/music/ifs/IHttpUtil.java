package hwun.free.music.ifs;

import java.util.ArrayList;

/**
 * Created by HWUN on 2014-08-04.
 */
public interface IHttpUtil {
    /**
     * Html 소스를 구합니다.
     *
     * @param method    Request.Method.Post or Request.Method.Get
     * @param targetUrl Html Url
     * @param response  Html Source
     * @param error     Error
     */
    void getHtmlSourceAtMethod(int method, String targetUrl, IResponse resp);

    ArrayList<String> getAHrefValue(String htmlSource, String findTag);

    String getDownloadUrlFromSource(String sourceHtml);
}
