package casia.isiteam.api.http.router;

import casia.isiteam.api.http.common.HeaderInit;
import casia.isiteam.api.toolutil.Validator;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

/**
 * ClassName: HttpClientRouter
 * Description: unknown
 * <p>
 * Created by casia.wzy on 2020/4/26
 * Email: zhiyou_wang@foxmail.com
 */
public class HttpClientRouter {

    /**
     * 装饰者模式
     * @return
     */
    public CloseableHttpClient closeableHttpClient(Integer SOCKET_TIMEOUT) {
        SOCKET_TIMEOUT = Validator.check(SOCKET_TIMEOUT) ? SOCKET_TIMEOUT : 60000*5;
//        CloseableHttpClient httpClient = HttpClients.createDefault();
        RequestConfig.Builder builder = RequestConfig.custom();
        RequestConfig config = builder.setSocketTimeout(SOCKET_TIMEOUT)
                .setConnectTimeout(SOCKET_TIMEOUT)
                .setConnectionRequestTimeout(SOCKET_TIMEOUT)
                .setStaleConnectionCheckEnabled(true).build();
          CloseableHttpClient httpClient = HttpClientBuilder.create()
//                .setUserAgent(HeaderInit.User_Agent_Firefox).setDefaultRequestConfig(config)
                .setUserAgent(HeaderInit.User_Agent_Firefox)
                .build();
        return httpClient;
    }

}
