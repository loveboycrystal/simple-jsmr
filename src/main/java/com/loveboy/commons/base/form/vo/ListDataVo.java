package com.loveboy.commons.base.form.vo;

import java.util.List;

import com.github.pagehelper.Page;

public class ListDataVo<T> {
	private T list;

	private Long totalCount;

	public ListDataVo() {
	}

	public ListDataVo(T list) {
		super();
		this.setList(list);
	}

	public ListDataVo(T list, Long totalCount) {
		super();
		this.list = list;
		this.totalCount = totalCount;
	}

	public T getList() {
		return list;
	}

	public void setList(T list) {
		if (list == null) {
			this.setTotalCount(0l);
		} else {
			if (list instanceof java.util.List) {
				try {
					this.setTotalCount(Long.valueOf( ((Page) ((List) list) ).getTotal() ));
				} catch (Exception e) {
					this.setTotalCount(Long.valueOf( (((List) list) ).size() ));
				}
			} else {
				this.setTotalCount(1l);
			}
		}
		this.list = list;
	}

	public Long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}

}
