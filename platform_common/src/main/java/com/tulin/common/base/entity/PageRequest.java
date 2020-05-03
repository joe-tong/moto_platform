package com.tulin.common.base.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@ApiModel(value = "分页")
public class PageRequest {

    @ApiModelProperty(value = "页数，注意页数从0开始", name = "page", example = "0")
    private int page;

    @ApiModelProperty(value = "每页条数", name = "size", example = "10")
    private int size;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
    
    
}
