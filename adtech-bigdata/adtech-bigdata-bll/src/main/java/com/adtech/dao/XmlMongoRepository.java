package com.adtech.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.adtech.entity.XmlTreeNode;

public interface XmlMongoRepository  extends MongoRepository<XmlTreeNode, Long>{

}
