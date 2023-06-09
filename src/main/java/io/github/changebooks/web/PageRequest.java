package io.github.changebooks.web;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 分页条件
 *
 * @author changebooks@qq.com
 */
@ApiModel
public class PageRequest extends BaseRequest {

    @ApiModelProperty(value = "每页行数", required = false, dataType = "Integer", example = "10")
    private Integer pageSize;

    @ApiModelProperty(value = "当前页码", required = false, dataType = "Integer", example = "1")
    private Integer pageNum;

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

}
