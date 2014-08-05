package hwun.free.music.model;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import hwun.free.music.ifs.IHttpUtil;

/**
 * Created by HWUN on 2014-08-04.
 */
public class HttpUtil implements IHttpUtil {
    private RequestQueue queue;

    public HttpUtil(Context context) {
        queue = Volley.newRequestQueue(context);
    }

    @Override
    public void getHtmlSourceAtMethod(int method, String targetUrl, Response.Listener<String> response, Response.ErrorListener error) {
        StringRequest sr = new StringRequest(method, targetUrl, response, error);
        queue.add(sr);
    }
}
