package casia.isiteam.api.http.controller;

import casia.isiteam.api.http.router.RequestRouter;
import org.apache.http.impl.client.CloseableHttpClient;

import java.util.Map;

/**
 * ClassName: CasiaHttpUtil
 * Description: unknown
 * <p>
 * Created by casia.wzy on 2020/4/26
 * Email: zhiyou_wang@foxmail.com
 */
public class CasiaHttpUtil extends RequestRouter {

    public String post(String url ){
        return getRequestPost().doRequest(url,null,null,null);
    }
    public String post(String url , Map<String, String> heardParams){
        return getRequestPost().doRequest(url,heardParams,null,null);
    }
    public String post(String url , Map<String, String> heardParams, Map<String, String> formParams, String bodyParams){
        return getRequestPost().doRequest(url,heardParams,formParams,bodyParams);
    }
    public String post(String url , Map<String, String> heardParams, Map<String, String> formParams, String bodyParams,Integer timeout){
        return getRequestPost().doRequest(url,heardParams,formParams,bodyParams,timeout);
    }
    public String post(CloseableHttpClient httpClient, String url , Map<String, String> heardParams, Map<String, String> formParams, String bodyParams){
        return getRequestPost().doRequest(httpClient,url,heardParams,formParams,bodyParams);
    }
    public String post(CloseableHttpClient httpClient, String url , Map<String, String> heardParams, Map<String, String> formParams, String bodyParams,Integer timeout){
        return getRequestPost().doRequest(httpClient,url,heardParams,formParams,bodyParams,timeout);
    }

    public String get(String url ){
        return getRequestGet().doRequest(url,null,null,null);
    }
    public String get(String url , Map<String, String> heardParams){
        return getRequestGet().doRequest(url,heardParams,null,null);
    }
    public String get(String url , Map<String, String> heardParams,Integer timeout){
        return getRequestGet().doRequest(url,heardParams,null,null,timeout);
    }
    public String get(CloseableHttpClient httpClient,String url , Map<String, String> heardParams){
        return getRequestGet().doRequest(httpClient, url,heardParams,null,null);
    }
    public String get(CloseableHttpClient httpClient,String url , Map<String, String> heardParams,Integer timeout){
        return getRequestGet().doRequest(httpClient, url,heardParams,null,null,timeout);
    }

    public String delete(String url ){
        return getRequestDelete().doRequest(url,null,null,null);
    }
    public String delete(String url , Map<String, String> heardParams){
        return getRequestDelete().doRequest(url,heardParams,null,null);
    }
    public String delete( String url , Map<String, String> heardParams, Map<String, String> params, String body){
        return getRequestDelete().doRequest(url,heardParams,params,body);
    }
    public String delete( String url , Map<String, String> heardParams, Map<String, String> params, String body,Integer timeout){
        return getRequestDelete().doRequest(url,heardParams,params,body,timeout);
    }
    public String delete(CloseableHttpClient httpClient, String url , Map<String, String> heardParams){
        return getRequestDelete().doRequest(httpClient,url,heardParams,null,null);
    }
    public String delete(CloseableHttpClient httpClient, String url , Map<String, String> heardParams, Map<String, String> params, String body){
        return getRequestDelete().doRequest(httpClient,url,heardParams,params,body);
    }
    public String delete(CloseableHttpClient httpClient, String url , Map<String, String> heardParams, Map<String, String> params, String body,Integer timeout){
        return getRequestDelete().doRequest(httpClient,url,heardParams,params,body,timeout);
    }
    public String put(String url ){
        return getRequestPut().doRequest(url,null,null,null);
    }
    public String put(String url , Map<String, String> heardParams){
        return getRequestPut().doRequest(url,heardParams,null,null);
    }
    public String put(String url , Map<String, String> heardParams,Map<String, String> formParams, String bodyParams){
        return getRequestPut().doRequest(url,heardParams,formParams,bodyParams);
    }
    public String put(String url , Map<String, String> heardParams,Map<String, String> formParams, String bodyParams,Integer timeout){
        return getRequestPut().doRequest(url,heardParams,formParams,bodyParams,timeout);
    }
    public String put(CloseableHttpClient httpClient, String url , Map<String, String> heardParams,Map<String, String> formParams, String bodyParams){
        return getRequestPut().doRequest(httpClient,url,heardParams,formParams,bodyParams);
    }
    public String put(CloseableHttpClient httpClient, String url , Map<String, String> heardParams,Map<String, String> formParams, String bodyParams,Integer timeout){
        return getRequestPut().doRequest(httpClient,url,heardParams,formParams,bodyParams,timeout);
    }
}
