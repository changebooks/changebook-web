package io.github.changebooks.web;

import io.github.changebooks.code.base.JsonParser;

import java.io.Serializable;

/**
 * 发送消息，新增操作
 *
 * @author changebooks@qq.com
 */
public class MsgInsert<T, S> implements Serializable {
    /**
     * 请求参数
     */
    private T request;

    /**
     * 新增后的数据
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

    public S getAfter() {
        return after;
    }

    public void setAfter(S after) {
        this.after = after;
    }

}
