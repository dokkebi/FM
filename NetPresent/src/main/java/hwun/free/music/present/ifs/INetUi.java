package hwun.free.music.present.ifs;

/**
 * Created by HWUN on 2014-08-04.
 */
public interface INetUi {
    /**웹 페이지 소스를 구합니다.
     * @param targetUrl 소스를 구하려는 페이지 주소.
     */ 
    void getHtmlSource(String targetUrl);
}
