package com.trinhtv3.common;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public abstract class PageList<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected int pageSize = 10;
	
	protected int currentpage;
	
	/** .*/
	protected Map<String, Boolean>  sortableKeys;
	  
	public PageList(int pageSize) {
		this.pageSize = pageSize;
		this.currentpage = 0;
	}
	
	public boolean hasNext() {
		return getCurrentPage() < totalPage();
	}
	
	public int getCurrentPage() {
		return this.currentpage;
	}
	
	
	public int getPageSize() {
		return this.pageSize;
	}
	
	public int totalPage() {
		return (int) Math.ceil(count() /(double) pageSize);
	}
	
	public abstract long count();
	
	protected abstract List<T> get(int from);
	public List<T> next() {
		currentpage ++;
		
		int from = (currentpage -1) * pageSize;
		return get(from);
	}
	
	public List<T> previous() {
		currentpage --;
		int from = (currentpage -1) * pageSize;
		return get(from);
	}
	
	public List<T> getPage(int pageNumber) {
		currentpage = pageNumber;
	    int from = (currentpage - 1) * pageSize;
	    return get(from);
	}
	
	public void setSortable(Map<String, Boolean> keys) {
	    this.sortableKeys = keys;
	  }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
