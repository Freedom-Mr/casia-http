package casia.isiteam.api.http.request;

import org.apache.http.impl.client.CloseableHttpClient;

import java.util.Map;

/**
 * ClassName: RequestApi
 * Description: unknown
 * <p>
 * Created by casia.wzy on 2020/4/26
 * Email: zhiyou_wang@foxmail.com
 */
public interface RequestApi {
    String doRequest(String url ,Map<String, String> heardparms, Map<String, String> params, String body);
    String doRequest(CloseableHttpClient closeableHttpClient,String url , Map<String, String> heardparms, Map<String, String> params, String body);
    String doRequest(String url ,Map<String, String> heardparms, Map<String, String> params, String body,Integer timout);
    String doRequest(CloseableHttpClient closeableHttpClient,String url , Map<String, String> heardparms, Map<String, String> params, String body,Integer timout);


}
