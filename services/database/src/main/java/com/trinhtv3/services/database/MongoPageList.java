package com.trinhtv3.services.database;

import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.trinhtv3.common.PageList;

public abstract class MongoPageList<T extends DBObject> extends PageList<T> {

	protected final DBObject query;
	
	protected final DBCollection col;
	
	public MongoPageList(int pageSize, DBCollection col, DBObject query) {
		super(pageSize);
		this.col = col;
		this.query = query;
	}
	
	@Override
	public long count() {
		return this.col.find(query).count();
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
