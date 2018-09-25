package com.adtech.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

/**
 * mongo工具类
 * 
 */
public class MongoUtils {

	private static MongoUtils utils = new MongoUtils();

	public static MongoUtils getInstance() {
		if (utils == null) {
			return utils = new MongoUtils();
		}
		return utils;
	}

	/**
	 * 选取 collection
	 * 
	 * @param mongoTemplate
	 * @param collectame
	 * @return
	 */
	public DBCollection chooseCollec(MongoTemplate mongoTemplate,
			String collectionName) {
		return mongoTemplate.getCollection(collectionName);
	}

	/**
	 * 删除collectionName
	 * 
	 * @param mongoTemplate
	 * @param collectionName
	 */
	public void dropCollection(MongoTemplate mongoTemplate,
			String collectionName) {
		mongoTemplate.dropCollection(collectionName);
	}

	public DBCollection createCollection(MongoTemplate mongoTemplate,
			String collectionName) {
		return mongoTemplate.createCollection(collectionName);
	}

	public boolean insert(MongoTemplate mongoTemplate, String table,
			Map<String, Object> values) {
		BasicDBObject obj = new BasicDBObject();
		for (Map.Entry<String, Object> entry : values.entrySet()) {
			obj.put(entry.getKey(), entry.getValue());
		}
		mongoTemplate.getCollection(table).insert(obj);
		return true;
	}

	public boolean update(MongoTemplate mongoTemplate, String table, String id,
			Map<String, Object> values) {
		BasicDBObject obj = new BasicDBObject();
		for (Map.Entry<String, Object> entry : values.entrySet()) {
			obj.put(entry.getKey(), entry.getValue());
		}
		BasicDBObject query = new BasicDBObject();
		query.put("_id", new ObjectId(id));
		mongoTemplate.getCollection(table).update(query, obj);
		return true;
	}

	public Map<String, Object> getById(MongoTemplate mongoTemplate,
			String table, String id, List<String> columns) {
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
