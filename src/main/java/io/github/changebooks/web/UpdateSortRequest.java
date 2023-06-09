package io.github.changebooks.web;

import io.github.changebooks.code.base.JsonParser;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * 通过主键，修改多个排序
 *
 * @author changebooks@qq.com
 */
@ApiModel
public class UpdateSortRequest extends BaseRequest {

    @NotNull
    @ApiModelProperty(value = "主键id", required = true, dataType = "Long", example = "123456789012345678")
    private Long id;

    @NotNull
    @ApiModelProperty(value = "排序", required = true, dataType = "Integer", example = "10000")
    private Integer sort;

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

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

}
