package hwun.free.music.model;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.Map;

import hwun.free.music.ifs.IHttpUtil;
import hwun.free.music.ifs.IResponse;
import hwun.log.HLog;

/**
 * Created by HWUN on 2014-08-04.
 */
public class HttpUtil implements IHttpUtil {
    private RequestQueue queue;

    public HttpUtil(Context context) {
        queue = Volley.newRequestQueue(context);
    }

    @Override
    public void getHtmlSourceAtMethod(int method, String targetUrl, final IResponse resp) {
        StringRequest sr = new StringRequest(method, targetUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (resp != null)
                    resp.onResponse(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        try {
            Map<String, String> dd = (Map<String, String>) sr.getHeaders();
            dd.put("User-Agent", "Mozilla/5.0");
            HLog.info("test");
        } catch (Exception e) {

        }
        queue.add(sr);
    }

    @Override
    public ArrayList<String> getAHrefValue(String htmlSource, String findTag) {
        //tag ex -> "a.mobFileName"
        Document doc = Jsoup.parse(htmlSource);
        Elements eles = doc.select(findTag);
        ArrayList<String> list = new ArrayList<String>();
        if (eles != null) {
            for (Element e : eles) {
                list.add(e.attr("href"));
            }
        }
        return list;
    }

    @Override
    public String getDownloadUrlFromSource(String sourceHtml) {
        Document doc = Jsoup.parse(sourceHtml);
        Elements eles = doc.select("audio[src]");
        if (eles != null && eles.size() == 1) {
            return eles.get(0).attr("src");
        } else
            return null;
    }
}
