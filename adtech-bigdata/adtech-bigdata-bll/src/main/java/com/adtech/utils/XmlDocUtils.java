package com.adtech.utils;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adtech.entity.XmlTreeNode;

/**
 * 实际解析xml数据底层处理
 */
public class XmlDocUtils {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
		
	private static XmlDocUtils xml = new XmlDocUtils();
	public static XmlDocUtils getInstance() {
		if(xml==null){
			return new XmlDocUtils();
		}
		return xml;
	}
	
	/**
	 * 解析文本内容
	 * @param files
	 */
	public XmlTreeNode parseXML(Object files) {
		SAXReader reader = new SAXReader();
		Document doc = null;
		try {
			//区分下文件处理的方式
			if(files instanceof InputStream){
				InputStream in =(InputStream)files;
				doc = reader.read(in);
			}else if(files instanceof String){
				doc = reader.read(files.toString());
			}
			Element root = doc.getRootElement();
			
			//解析xml文件数据
			return parseElements(root);

		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 迭代获取所有数据
	 * @param root
	 * @return XmlTreeNode
	 */
	private XmlTreeNode parseElements(Element root) {
		XmlTreeNode tree = new XmlTreeNode();

		String rname = root.getName();
		tree.setName(rname);
		tree.setCode(rname);
		tree.setDescription(rname);
		List<String> attributeList = new ArrayList<String>();
		List<Attribute> attrList = root.attributes();
		for(Attribute attr : attrList){
			String name = attr.getName();
			String value = attr.getValue();
			attributeList.add(rname+"_"+name);
		}
		tree.setAttributeList(attributeList);

		List<Element> eleList = root.elements();
		if (eleList != null && eleList.size() > 0) {
			List<XmlTreeNode> childreNodes = new ArrayList<XmlTreeNode>();
			for (Element child : eleList) {
				XmlTreeNode node = parseElements(child);
				childreNodes.add(node);
			}
			tree.setChildreNodes(childreNodes);
		}
		return tree;
	}
}