package com.adtech.test;

import org.junit.Test;

import com.adtech.entity.XmlTreeNode;
import com.adtech.utils.XmlDocUtils;

public class UnitTest {
	
	@Test
	public void tes() {
		XmlTreeNode treeNode = XmlDocUtils.getInstance().parseXML("H:\\logs\\demo1.xml");
		System.out.println("XmlTreeNode root==>"+treeNode.getCode()+"==="+treeNode.getName()+"==="+treeNode.getChildreNodes().size());
		print1(treeNode);
	}
	
	private void print(XmlTreeNode treeNode) {
		for (String x : treeNode.getAttributeList()){
			System.out.println("XmlTreeNode root Attribute==>"+x);
		}
	}
	private void print1(XmlTreeNode treeNode) {
		if(treeNode.getChildreNodes()==null){
			return;
		}
		for (XmlTreeNode t : treeNode.getChildreNodes()) {
			print(t);
			System.out.println("ChildreNodes content==>"+t.getCode()+"===="+t.getName());
			print1(t);
		}
		
	}
}
