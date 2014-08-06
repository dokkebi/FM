package hwun.free.music.present.present;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;

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
        httpUtil.getHtmlSourceAtMethod(Request.Method.POST, targetUrl, new Response.Listener<String>() {
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
    }

}
