package casia.isiteam.api.http.request.api;

import casia.isiteam.api.http.common.EncodingParms;
import casia.isiteam.api.toolutil.Validator;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * ClassName: AssemblyApi
 * Description: unknown
 * <p>
 * Created by casia.wzy on 2020/4/26
 * Email: zhiyou_wang@foxmail.com
 */
public class AssemblyApi {
    private static Logger logger = LoggerFactory.getLogger( AssemblyApi.class);

    private static int SOCKET_TIME_OUT = 5*60*1000;        //传输间隔超时
        private static int CONNECT_TIME_OUT = 20*1000;        //链接建立超时

    /**
     * 请求时间设置
     * @return
     */
    public static RequestConfig requestConfig(Integer timeout){
        return RequestConfig.custom()
                .setSocketTimeout(Validator.check(timeout)?timeout:SOCKET_TIME_OUT)
                .setConnectTimeout(CONNECT_TIME_OUT).build();
//                .setSocketTimeout(SOCKET_TIME_OUT)
//                .setConnectTimeout(CONNECT_TIME_OUT).build();
    }

    /**
     * 获取结果
     * @param httpResponse
     * @return
     */
    public static String getResult( HttpResponse httpResponse){
        String resultString = "";
        try {
            int requestStatus = httpResponse.getStatusLine().getStatusCode();
            if (requestStatus == HttpStatus.SC_OK) {
                resultString = EntityUtils.toString(httpResponse.getEntity(), EncodingParms.Encoding_UTF_8);
                logger.debug(resultString);
            }else{
                resultString = EntityUtils.toString(httpResponse.getEntity(), EncodingParms.Encoding_UTF_8);
                logger.warn("fail code -> {} ",requestStatus);
                logger.warn("\\ result html \\ {}",resultString);
            }
        } catch (IOException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }
        return resultString;
    }
}
