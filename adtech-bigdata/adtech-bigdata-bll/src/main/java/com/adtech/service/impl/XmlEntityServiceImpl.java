package com.adtech.service.impl;

import java.io.InputStream;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.adtech.entity.XmlTreeNode;
import com.adtech.service.XmlEntityService;
import com.adtech.utils.XmlDocUtils;

@Service
public class XmlEntityServiceImpl implements XmlEntityService{
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Override
	public XmlTreeNode parseXml(InputStream in) {
		try {
			// 解析XML
			return XmlDocUtils.getInstance().parseXML(in);
		} catch (Exception e) {
			;
		}
		return null;
	}
	
	@Override
	public XmlTreeNode parseXml(String in) {
		try {
			// 解析XML
			return XmlDocUtils.getInstance().parseXML(in);
		} catch (Exception e) {
			;
		}
		return null;
	}
}
