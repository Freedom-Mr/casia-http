package casia.isiteam.api.http.controller;

import junit.framework.TestCase;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;

import java.util.HashMap;
import java.util.Map;
/**
 * ClassName: CasiaHttpUtilTest
 * Description: unknown
 * <p>
 * Created by casia.wzy on 2020/4/26
 * Email: zhiyou_wang@foxmail.com
 */
public class CasiaHttpUtilTest extends TestCase {

    private CasiaHttpUtil casiaHttpUtil = new CasiaHttpUtil();

    public void testPost() {
        System.out.println(casiaHttpUtil.post("https://www.baidu.com/"));
    }
    public void testPost1() {
//        System.out.println(casiaHttpUtil.post("http://192.168.12.21:9200/event_threads_ref_beihang,event_news_ref_beihang,event_mblog_ref_beihang/beihang_data/_search",null,null,"{\"size\":1}"));
        System.out.println(casiaHttpUtil.post("https://165.232.131.142/cgi-bin/nph-hz.cgi/en/E0/https/std.stheadline.com/daily/hongkong/%E6%97%A5%E5%A0%B1-%E6%B8%AF%E8%81%9E",null,null,"{\"size\":1}",60000));
    }

    public void testPost2() {
        Map<String,String> heards = new HashMap<>();
        heards.put("Authorization","Basic ZWxhc3RpYzoxMjM0NTY=");

        String body = "{\"password\":\"123456\",\"roles\":[\"web_role\"],\"full_name\":\"web\",\"email\":\"zhiyou_wang@foxmail.com\",\"metadata\":{\"intelligence\":7}}";

        System.out.println(casiaHttpUtil.post("http://192.168.5.103:9200/_xpack/security/user/data",heards,null,body));
    }
    public void testPost3() {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        Map<String,String> heards = new HashMap<>();
        heards.put("Authorization","Basic ZWxhc3RpYzoxMjM0NTY=");

        String body = "{\"password\":\"123456\",\"roles\":[\"web_role\"],\"full_name\":\"web\",\"email\":\"zhiyou_wang@foxmail.com\",\"metadata\":{\"intelligence\":7}}";

        System.out.println(casiaHttpUtil.post(httpClient,"http://192.168.5.103:9200/_xpack/security/user/data",heards,null,body));
    }


    public void testGet() {
//        System.out.println(casiaHttpUtil.get("https://baidu.com/"));
        System.out.println(casiaHttpUtil.get("https://baidu.com/",null,1000));
    }
    public void testGet1() {
        Map<String,String> heards = new HashMap<>();
        heards.put("Authorization","Basic ZWxhc3RpYzoxMjM0NTY=");
//        heards.put("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
//        heards.put("Accept-Language","zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2");
//        heards.put("Accept-Encoding","gzip, deflate");
//        heards.put("Connection","keep-alive");
//        heards.put("Upgrade-Insecure-Requests","1");
//        heards.put("Content-Type","application/json");
        System.out.println(casiaHttpUtil.get("http://192.168.5.103:9200/_xpack/security/_authenticate",heards));
    }

    public void testDelete() {

    }
    public void testDelete1() {
        Map<String,String> heards = new HashMap<>();
        heards.put("Authorization","Basic ZWxhc3RpYzoxMjM0NTY=");
        System.out.println(casiaHttpUtil.delete("http://192.168.5.103:9200/_xpack/security/user/data",heards));
    }


    public void testPut() {
        Map<String,String> heards = new HashMap<>();
        heards.put("Authorization","Basic ZWxhc3RpYzoxMjM0NTY=");
        heards.put("Content-Type","application/json");

        String mapping = "{\"settings\":{\"number_of_shards\":1,\"number_of_replicas\":1,\"refresh_interval\":\"5s\",\"translog\":{\"flush_threshold_size\":\"3gb\"},\"merge\":{\"scheduler\":{\"max_thread_count\":\"1\"}},\"analysis\":{\"normalizer\":{\"my_normalizer\":{\"type\":\"custom\",\"char_filter\":[],\"filter\":[\"lowercase\",\"asciifolding\"]}}}},\"mappings\":{\"test_data\":{\"dynamic\":\"false\",\"_source\":{\"enabled\":true},\"properties\":{\"id\":{\"index\":\"not_analyzed\",\"type\":\"long\"},\"eid\":{\"index\":\"not_analyzed\",\"type\":\"integer\"},\"name\":{\"index\":\"not_analyzed\",\"type\":\"keyword\",\"normalizer\":\"my_normalizer\"},\"org\":{\"index\":\"not_analyzed\",\"type\":\"keyword\"},\"title\":{\"analyzer\":\"ik_max_word\",\"search_analyzer\":\"ik_max_word\",\"type\":\"text\"},\"content\":{\"analyzer\":\"ik_max_word\",\"search_analyzer\":\"ik_max_word\",\"fielddata\":true,\"store\":true,\"type\":\"text\"},\"ip\":{\"type\":\"ip\"},\"lal\":{\"type\":\"geo_point\"},\"pubtime\":{\"format\":\"yyyy-MM-dd HH:mm:ss\",\"type\":\"date\"}}}}}";
        System.out.println(casiaHttpUtil.put("http://192.168.5.103:9200/test",heards,null,mapping));

    }
    public void testPut1() {
        Map<String,String> heards = new HashMap<>();
        heards.put("Authorization","Basic ZWxhc3RpYzoxMjM0NTY=");
        System.out.println(casiaHttpUtil.put("http://192.168.5.103:9200/_xpack/security/user/web/_enable",heards));
    }
    public void testPut3() {
    }
}