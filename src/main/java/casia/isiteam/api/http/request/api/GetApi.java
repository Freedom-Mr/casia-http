package casia.isiteam.api.http.request.api;

import casia.isiteam.api.http.request.RequestApi;
import casia.isiteam.api.http.router.HttpClientRouter;
import casia.isiteam.api.toolutil.Validator;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Map;

/**
 * ClassName: GetApi
 * Description: unknown
 * <p>
 * Created by casia.wzy on 2020/4/26
 * Email: zhiyou_wang@foxmail.com
 */
public class GetApi implements RequestApi {
    private Logger logger = LoggerFactory.getLogger( this.getClass());

    @Override
    public String doRequest(String url,Map<String, String> heardParms, Map<String, String> formParams, String bodyParams) {
        return doRequest(null,url, heardParms,formParams,bodyParams,null);
    }
    @Override
    public String doRequest(String url,Map<String, String> heardParms, Map<String, String> formParams, String bodyParams,Integer timeout) {
        return doRequest(null,url, heardParms,formParams,bodyParams,timeout);
    }
    @Override
    public String doRequest(CloseableHttpClient closeableHttpClient, String url,Map<String, String> heardParms, Map<String, String> formParams, String bodyParams) {
        return doRequest(closeableHttpClient,url, heardParms,formParams,bodyParams,null);
    }
    @Override
    public String doRequest(CloseableHttpClient closeableHttpClient, String url,Map<String, String> heardParms, Map<String, String> formParams, String bodyParams,Integer timeout) {
//        logger.debug("get -> {}",url);
        CloseableHttpClient httpClient = Validator.check(closeableHttpClient)  ? closeableHttpClient : new HttpClientRouter().closeableHttpClient(timeout);
        CloseableHttpResponse httpResponse = null;

        try {
            HttpGet httpGet = new HttpGet(url);
            httpGet.setConfig(AssemblyApi.requestConfig(timeout));

            if( Validator.check(heardParms) ){
                for(String key:heardParms.keySet() ){
                    if( Validator.check(key) ){
                        httpGet.addHeader(key,heardParms.get(key));
                    }
                }
            }
            httpResponse = httpClient.execute(httpGet);
            return AssemblyApi.getResult(httpResponse);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        } finally {
            try {
                if( Validator.check(httpResponse) ){
                    httpResponse.close();
                }
                if( Validator.check(httpClient) ){
                    httpClient.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "";
    }

}
