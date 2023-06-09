package io.github.changebooks.web;

import io.github.changebooks.code.base.JsonParser;

import java.io.Serializable;

/**
 * 发送消息，删除操作
 *
 * @author changebooks@qq.com
 */
public class MsgDelete<T> implements Serializable {
    /**
     * 主键
     */
    private Long id;

    /**
     * 删除前的数据
     */
    private T before;

    /**
     * 软删？
     */
    private Boolean soft;

    @Override
    public String toString() {
        return JsonParser.toJson(this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public T getBefore() {
        return before;
    }

    public void setBefore(T before) {
        this.before = before;
    }

    public Boolean getSoft() {
        return soft;
    }

    public void setSoft(Boolean soft) {
        this.soft = soft;
    }

}
