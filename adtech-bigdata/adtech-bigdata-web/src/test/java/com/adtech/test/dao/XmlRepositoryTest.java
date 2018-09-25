package com.adtech.test.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.adtech.StartupApplication;
import com.adtech.dao.XmlMongoRepository;
import com.adtech.entity.XmlTemplate;
import com.adtech.entity.XmlTreeNode;
import com.adtech.service.XmlEntityService;
import com.adtech.service.XmlMongodbService;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=StartupApplication.class)
public class XmlRepositoryTest {
	
	@Autowired
	XmlMongodbService mService;
	
	@Autowired
	XmlEntityService docService;
	
	@Autowired
	XmlMongoRepository xRepository;
	
	@Test
	public void instDoc(){
		XmlTreeNode ent = docService.parseXml("H:\\logs\\demo1.xml");
		System.out.println("xml: "+ent.getAttributeList().size()+"\t"+ent.getChildreNodes().size());

		Map<String, Object> map = new HashMap<String, Object>();
		XmlTemplate xe = new XmlTemplate();
		
		map.put("XmlTreeNode", xe.getName());
		//mService.insert("xmlTreeNode", map);
		
		xRepository.insert(ent);
		
	}
	
//	public void findTes(){
//		BasicDBObject gt = new BasicDBObject("$gt",24);
//		BasicDBObject eq = new BasicDBObject("code","5ba9ea5dc904a7041c3ea486");
//		Object object = mongoTemplate.find(new BasicQuery(eq), XmlTreeNode.class);//必须为实体对象
//		System.out.println("toString:  "+object);
//	}
	
	//@Test
	public void findALL() {
		DBCursor cuosor = mService.queryAll("xmlTreeNode");
		System.out.println("count size:  "+cuosor.count());
	}

	@Test
	public void queryById() {
		//Query query = new Query(Criteria.where("id").is(demoEntity.getId()));
		//Update update = new Update();
		Map<String, Object> cMap = mService.getById("xmlTreeNode", "5ba9ea5dc904a7041c3ea486", new ArrayList<String>());
		System.out.println("service count:  "+cMap.size());
	}
	
	
}
