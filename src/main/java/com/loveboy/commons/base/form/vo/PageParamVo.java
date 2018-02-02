package com.loveboy.commons.base.form.vo;

public class PageParamVo {

	private int pageNum = 1;
	private int pageSize = 10;
	private int totalPage = 0;

	private int startIndex = 0;

	private Long totalRecord = 0L;

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		if (pageNum <= 0) {
			pageNum = 1;
		}
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getStartIndex() {
		if (pageNum == 1) {
			startIndex = 0;
		} else {
			startIndex = pageNum * pageSize;
		}
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public Long getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(Long totalRecord) {
		this.totalRecord = totalRecord;
	}

}
