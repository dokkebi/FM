package hwun.free.music.ifs;

import com.android.volley.Response;

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
    void getHtmlSourceAtMethod(int method, String targetUrl, Response.Listener<String> response, Response.ErrorListener error);
}
