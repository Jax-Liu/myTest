package com.adtech.entity;

import java.io.Serializable;
import java.util.List;

public class XmlTreeNode implements Serializable{
		
	private String name;
	
	private String code;
	
	private List<XmlTreeNode> childreNodes;
	
	private String description;
	
	private List<String> attributeList;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<XmlTreeNode> getChildreNodes() {
		return childreNodes;
	}

	public void setChildreNodes(List<XmlTreeNode> childreNodes) {
		this.childreNodes = childreNodes;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<String> getAttributeList() {
		return attributeList;
	}

	public void setAttributeList(List<String> attributeList) {
		this.attributeList = attributeList;
	}
	
}
