package com.tulin.common.utlis;

import com.github.pagehelper.Page;

import java.io.Serializable;
import java.util.List;

/**
 * 分页数据
 * 
 * @author ShiXian
 *
 * @param <T>
 */
public class Pages<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	// 当前页
	private int pageNum;

	// 每页的数量
	private int pageSize;

	// 总记录数
	private long total;

	private List<T> result;

	public Pages() {

	}

	public Pages(List<T> list) {
		if (list instanceof Page) {
			Page<T> page = (Page<T>) list;
			this.pageNum = page.getPageNum();
			this.pageSize = page.getPageSize();
			this.total = page.getTotal();
			this.result = page.getResult();
		} else {
			this.result = list;
		}
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public List<T> getResult() {
		return result;
	}

	public void setResult(List<T> result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "Pages [pageNum=" + pageNum + ", pageSize=" + pageSize + ", total=" + total + ", list=" + result + "]";
	}

}
