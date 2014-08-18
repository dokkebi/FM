package hwun.free.music.present.present;

import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.os.Environment;

import com.android.volley.Request;

import java.util.ArrayList;

import hwun.free.music.ifs.IResponse;
import hwun.free.music.model.HttpUtil;
import hwun.free.music.present.ifs.INetUi;
import hwun.log.HLog;

/**
 * Created by HWUN on 2014-08-04.
 */
public class NetUiPresent implements INetUi {
    private HttpUtil httpUtil;
    private Context context;
    private boolean isDownloaded = false;
    private IResponse downloadHtmlSourceResponse = new IResponse() {
        @Override
        public void onResponse(String html) {
            if (isDownloaded) return;
            String downloadUrl = httpUtil.getDownloadUrlFromSource(html);
            HLog.info("Download url >> " + downloadUrl);

            DownloadManager.Request req = new DownloadManager.Request(Uri.parse(downloadUrl));
            req.setTitle("test");
            req.setDescription("download");
            req.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, Environment.getExternalStorageDirectory().getAbsolutePath());
            HLog.info("Path :: " + Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS));
            Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).mkdirs();
            DownloadManager downMgr = (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
            downMgr.enqueue(req);
            isDownloaded = true;
            /*ArrayList<String> hrefValueList = httpUtil.getAHrefValue(html, "a.mobFileName");
            if(hrefValueList != null){
                for(String v : hrefValueList){
                    HLog.info("link url >> "+v);
                }
            }*/
        }
    };
    private IResponse firstHtmlSourceResponse = new IResponse() {
        @Override
        public void onResponse(String html) {
            ArrayList<String> hrefValueList = httpUtil.getAHrefValue(html, "a.mobFileName");
            if (hrefValueList != null) {
                for (String v : hrefValueList) {
                    httpUtil.getHtmlSourceAtMethod(Request.Method.POST, v, downloadHtmlSourceResponse);
                }
            }
        }
    };

    public NetUiPresent(Context context) {
        this.context = context;
        httpUtil = new HttpUtil(context);
    }

    @Override
    public void getHtmlSource(String targetUrl) {
        httpUtil.getHtmlSourceAtMethod(Request.Method.POST, targetUrl, firstHtmlSourceResponse);
    }
}
