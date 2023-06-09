package io.github.changebooks.web;

import io.github.changebooks.code.base.JsonParser;

import java.io.Serializable;

/**
 * 发送消息，修改操作
 *
 * @author changebooks@qq.com
 */
public class MsgUpdate<T, S> implements Serializable {
    /**
     * 请求参数
     */
    private T request;

    /**
     * 修改前的数据
     */
    private S before;

    /**
     * 修改后的数据
     */
    private S after;

    @Override
    public String toString() {
        return JsonParser.toJson(this);
    }

    public T getRequest() {
        return request;
    }

    public void setRequest(T request) {
        this.request = request;
    }

    public S getBefore() {
        return before;
    }

    public void setBefore(S before) {
        this.before = before;
    }

    public S getAfter() {
        return after;
    }

    public void setAfter(S after) {
        this.after = after;
    }

}
