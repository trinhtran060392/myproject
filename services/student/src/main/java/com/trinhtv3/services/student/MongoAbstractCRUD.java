package com.trinhtv3.services.student;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.trinhtv3.common.PageList;
import com.trinhtv3.services.database.MongoPageList;

public abstract class MongoAbstractCRUD<T extends BasicDBObject> {
	
	protected DBCollection col;
	
	public long count() {
	    return this.col.count();
	  }
	  
	  public void create(T... obj) {
	    
	    this.col.insert(obj);
	  }
	  
	  public void update(T obj) {
	    
	    this.col.save(obj);
	  }
	  
	  public void delete(T obj) {
	    this.col.remove(obj);
	  }
	  
	  public void delete(String id) {
	    this.col.remove(new BasicDBObject("_id", id));
	  }
	  
	  public T get(String id) {
	    DBObject obj = this.col.findOne(new BasicDBObject("_id", id));
	    
	    return obj == null ? null : transform(obj);
	  }
	  
	  public abstract T transform(DBObject source);
	  
	  public List<T> find(DBObject query) {
	    
	    List<T> list = new ArrayList<T>();
	    DBCursor cursor = this.col.find(query);
	    try {
	      while (cursor.hasNext()) {
	        
	        DBObject object = cursor.next();
	        T instance = transform(object);
	        
	        list.add(instance);
	      }
	    }
	    finally {
	      cursor.close();
	    }
	    return list;
	    
	  }
	  
	  public List<T> getAll() {
	    
	    List<T> list = new ArrayList<T>();
	    DBCursor cursor = this.col.find();
	    
	    while (cursor.hasNext()) {
	      DBObject object = cursor.next();
	      T instance = transform(object);
	      list.add(instance);
	    }
	    return list;
	  }
	  
	  public PageList<T> query(DBObject query) {
		  return query(10, query);
	  }
	  
	  public PageList<T> query(int pageSize, DBObject query) {
		  return buildPageList(pageSize, col, query);
	  }
	  
	  @SuppressWarnings("serial")
		protected PageList<T> buildPageList(int pageSize, DBCollection col, DBObject query) {
			  
			  return new MongoPageList<T>(pageSize, col, query) {
	
				@Override
				protected List<T> get(int from) {
					
					DBObject sortable = null;
					if (this.sortableKeys != null && this.sortableKeys.size() > 0) {
						sortable = new BasicDBObject();
						for (Map.Entry<String, Boolean> entry : this.sortableKeys.entrySet()) {
							sortable.put(entry.getKey(), entry.getValue() ? 1 : -1);
						}
					}
					
					DBCursor cursor = null;
					if (sortable != null) {
						cursor = this.col.find(query).sort(sortable).skip(from).limit(pageSize);
					} else {
						cursor = this.col.find(query).skip(from).limit(pageSize);
					}
					
					List<T> list = new ArrayList<T>();
					while (cursor.hasNext()) {
						DBObject source = cursor.next();
						T entity = transform(source);
						list.add(entity);
					}
					return list;
				}
			};
		  }
		  
	  
		
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  public T findById(String id) {
	    
	    DBObject object = new BasicDBObject().append("_id", id);
	    DBObject result = this.col.findOne(object);
	    T instance = transform(result);
	    
	    return instance;
	    
	  }
	  
}
