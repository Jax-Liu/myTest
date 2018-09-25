package com.adtech.entity;

import java.util.List;

import org.bson.types.ObjectId;

public class XmlTemplate {
	
	private ObjectId _id;
	private String name;
	private String description;
	private String version;
	private List<XmlTreeNode> nodeList;
	public ObjectId get_id() {
		return _id;
	}
	public void set_id(ObjectId _id) {
		this._id = _id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public List<XmlTreeNode> getNodeList() {
		return nodeList;
	}
	public void setNodeList(List<XmlTreeNode> nodeList) {
		this.nodeList = nodeList;
	}
	
}