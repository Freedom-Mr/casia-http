package casia.isiteam.api.http.request.api;

import casia.isiteam.api.http.common.EncodingParms;
import casia.isiteam.api.http.request.RequestApi;
import casia.isiteam.api.http.router.HttpClientRouter;
import casia.isiteam.api.toolutil.Validator;
import org.apache.http.Header;
import org.apache.http.HttpHeaders;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;
import java.io.IOException;
import java.util.stream.Collectors;

/**
 * ClassName: PostApi
 * Description: unknown
 * <p>
 * Created by casia.wzy on 2020/4/26
 * Email: zhiyou_wang@foxmail.com
 */
public class PostApi implements RequestApi {
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
//        logger.debug("post -> {}",url);
        CloseableHttpClient httpClient = Validator.check(closeableHttpClient)  ? closeableHttpClient : new HttpClientRouter().closeableHttpClient(timeout);
        CloseableHttpResponse httpResponse = null;
        String resultString = "";
        try {
            HttpPost httpPost = new HttpPost(url);
            httpPost.setConfig(AssemblyApi.requestConfig(timeout));

            if( Validator.check(heardParms) ){
                for(String key:heardParms.keySet() ){
                    if( Validator.check(key) ){
                        httpPost.addHeader(key,heardParms.get(key));
                    }
                }
            }
            if ( Validator.check(formParams) ) {
                List<NameValuePair> paramList = formParams.entrySet().stream().map(x->new BasicNameValuePair(x.getKey(), x.getValue()) ).collect(Collectors.toList());
                // 模拟表单
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(paramList);
                httpPost.setEntity(entity);
            }
            if( Validator.check(bodyParams) ){
//                StringEntity entity = new StringEntity(bodyParams, ContentType.APPLICATION_JSON);
                StringEntity entity = new StringEntity(bodyParams, EncodingParms.Encoding_UTF_8 );
                httpPost.setEntity(entity);
            }

            httpResponse = httpClient.execute(httpPost);
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
