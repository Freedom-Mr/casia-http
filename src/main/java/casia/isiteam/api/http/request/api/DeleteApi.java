package casia.isiteam.api.http.request.api;

import casia.isiteam.api.http.request.RequestApi;
import casia.isiteam.api.http.router.HttpClientRouter;
import casia.isiteam.api.toolutil.Validator;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * ClassName: DeleteApi
 * Description: unknown
 * <p>
 * Created by casia.wzy on 2020/4/26
 * Email: zhiyou_wang@foxmail.com
 */
public class DeleteApi implements RequestApi {

    private Logger logger = LoggerFactory.getLogger( this.getClass());

    @Override
    public String doRequest(String url,Map<String, String> heardParms, Map<String, String> formParams, String bodyParams) {
        return doRequest(null,url, heardParms,formParams,bodyParams,null);
    }
    @Override
    public String doRequest(String url,Map<String, String> heardParms, Map<String, String> formParams, String bodyParams,Integer timout) {
        return doRequest(null,url, heardParms,formParams,bodyParams,timout);
    }
    @Override
    public String doRequest(CloseableHttpClient closeableHttpClient, String url,Map<String, String> heardParms, Map<String, String> formParams, String bodyParams) {
        return doRequest(closeableHttpClient,url, heardParms,formParams,bodyParams,null);
    }
    @Override
    public String doRequest(CloseableHttpClient closeableHttpClient, String url,Map<String, String> heardParms, Map<String, String> formParams, String bodyParams,Integer timout) {
//        logger.debug("delete -> {}",url);
        CloseableHttpClient httpClient = Validator.check(closeableHttpClient)  ? closeableHttpClient : new HttpClientRouter().closeableHttpClient(timout);
        CloseableHttpResponse httpResponse = null;
        String resultString = "";
        try {
            HttpDelete httpDelete = new HttpDelete(url);
            httpDelete.setConfig(AssemblyApi.requestConfig(timout));

            if( Validator.check(heardParms) ){
                heardParms.forEach( (k,v)->{ httpDelete.addHeader(k,v);});
            }
            httpResponse = httpClient.execute(httpDelete);
            resultString = AssemblyApi.getResult(httpResponse);

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
        return resultString;
    }
}
