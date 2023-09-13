package casia.isiteam.api.http.router;

import casia.isiteam.api.http.request.RequestApi;
import casia.isiteam.api.http.request.api.DeleteApi;
import casia.isiteam.api.http.request.api.GetApi;
import casia.isiteam.api.http.request.api.PostApi;
import casia.isiteam.api.http.request.api.PutApi;

/**
 * ClassName: RequestRouter
 * Description: unknown
 * <p>
 * Created by casia.wzy on 2020/4/26
 * Email: zhiyou_wang@foxmail.com
 */
public class RequestRouter {

    protected RequestApi requestPost;
    protected RequestApi requestGet;
    protected RequestApi requestDelete;
    protected RequestApi requestPut;

    public RequestApi getRequestPost() {
        return requestPost = new PostApi();
    }

    public void setRequestPost(RequestApi requestPost) {
        this.requestPost = requestPost;
    }

    public RequestApi getRequestGet() {
        return requestGet = new GetApi();
    }

    public void setRequestGet(RequestApi requestGet) {
        this.requestGet = requestGet;
    }

    public RequestApi getRequestDelete() {
        return requestDelete= new DeleteApi();
    }

    public void setRequestDelete(RequestApi requestDelete) {
        this.requestDelete = requestDelete;
    }

    public RequestApi getRequestPut() {
        return requestPut = new PutApi();
    }

    public void setRequestPut(RequestApi requestPut) {
        this.requestPut = requestPut;
    }
}
