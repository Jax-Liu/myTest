package com.adtech.service;

import java.io.InputStream;
import java.util.List;

import com.adtech.entity.XmlTreeNode;

public interface XmlEntityService {
	
	XmlTreeNode parseXml(InputStream in);
	
	XmlTreeNode parseXml(String in);
	
}
