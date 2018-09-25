package com.adtech.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.adtech.dao.XmlMongoRepository;
import com.adtech.entity.XmlTreeNode;
import com.adtech.service.XmlMongodbService;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

@Service
public class XmlMongodbServiceImpl implements XmlMongodbService {
	
	@Autowired
	XmlMongoRepository xmlRepository;
	
	@Autowired
	MongoTemplate mongoTemplate;

	@Autowired
	public int count(String table) {
		long size = mongoTemplate.getCollection(table).count();
		int count = Integer.valueOf(String.valueOf(size));
		return count;
	}
	
	@Override
	public void saveXmlData(XmlTreeNode xml) {
		xmlRepository.insert(xml);
	}
	
	@Override
	public DBCursor queryAll(String table) {
		return mongoTemplate.getCollection(table).find();
	}
	
	@Override
	public boolean insert(String table, Map<String, Object> values) {
		BasicDBObject obj = new BasicDBObject();
		for (Map.Entry<String, Object> entry : values.entrySet()) {
			obj.put(entry.getKey(), entry.getValue());
		}
		mongoTemplate.getCollection(table).insert(obj);
		return true;
	}
	
	@Override
	public boolean update(String table, String id, Map<String, Object> values) {
		BasicDBObject obj = new BasicDBObject();
		for (Map.Entry<String, Object> entry : values.entrySet()) {
			obj.put(entry.getKey(), entry.getValue());
		}
		BasicDBObject query = new BasicDBObject();
		query.put("_id", new ObjectId(id));
		mongoTemplate.getCollection(table).update(query, obj);
		return true;
	}
	
	@Override
	public Map<String, Object> getById(String table, String id, List<String> columns) {
		BasicDBObject query = new BasicDBObject();
		query.append("_id", new ObjectId(id));
		Map<String, Object> map = new HashMap<String, Object>();
		DBCursor iterator = null;
		iterator = mongoTemplate.getCollection(table).find(query);
		if (iterator.hasNext()) {
			DBObject next = iterator.next();
			Object objId = next.get("_id");
			map.put("_id", objId);
			for (String colum : columns) {
				Object val = next.get(colum);
				map.put(colum, val);
			}

		}
		return map;
	}
	
}
