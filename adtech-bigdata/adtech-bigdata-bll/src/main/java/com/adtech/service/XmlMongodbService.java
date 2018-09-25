package com.adtech.service;

import java.util.List;
import java.util.Map;

import com.adtech.entity.XmlTreeNode;
import com.mongodb.DBCursor;

public interface XmlMongodbService {
	
	//获取总数
	int count(String table);
	
	void saveXmlData(XmlTreeNode xml);
	
	boolean insert(String table, Map<String, Object> values);
	
	boolean update(String table, String id, Map<String, Object> values);
	
	Map<String, Object> getById(String table, String id, List<String> columns);
	
	DBCursor queryAll(String table);
}
