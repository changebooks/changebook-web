package io.github.changebooks.web;

import io.github.changebooks.code.base.JsonParser;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 通用参数
 *
 * @author changebooks@qq.com
 */
@ApiModel
public class BaseRequest implements Serializable {

    @ApiModelProperty(value = "版本号", required = false, dataType = "Integer", example = "1")
    private Integer version;

    @ApiModelProperty(value = "输入内容编码，input encode", required = false, dataType = "String", example = "UTF-8")
    private String ie;

    @ApiModelProperty(value = "输出语种，output language type", required = false, dataType = "String", example = "ZH-CN")
    private String ol;

    @ApiModelProperty(value = "输出数据格式，output data type", required = false, dataType = "String", example = "JSON")
    private String od;

    @Override
    public String toString() {
        return JsonParser.toJson(this);
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getIe() {
        return ie;
    }

    public void setIe(String ie) {
        this.ie = ie;
    }

    public String getOl() {
        return ol;
    }

    public void setOl(String ol) {
        this.ol = ol;
    }

    public String getOd() {
        return od;
    }

    public void setOd(String od) {
        this.od = od;
    }

}
