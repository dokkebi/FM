package hwun.free.music.model;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
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
    public String getHtmlSource(String targetUrl) {
        StringRequest sr = new StringRequest(Request.Method.POST, "http://blog.daum.net/_blog/BlogTypeView.do?blogid=0Xoy7&articleno=12&categoryId=1&regdt=20110221150654", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                System.out.print("response : " + response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.print("error : " + error);
            }
        });
        queue.add(sr);
        return null;
    }
}
