package com.etcxm._02DOM4JDemo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class Dom4jDemo {
	private static File f = new File("src/contacts.xml");
	public static void main(String[] args) throws Exception {
		//QueryAllInfo();
		createXMLDOM();
	}
	
	//需求:在XML中新增一个联系人(新的XML文档)
	public static void createXMLDOM() throws IOException{
		
		//1.新创建XML文档
		 Document document = DocumentHelper.createDocument();
		 //2.添加根元素
	     Element root = document.addElement("contacts");
	     //3.往根元素添加子节点(元素)
	     Element linkman = root.addElement("linkman");
	     linkman.addAttribute("id", "250");
	     
	     linkman.addElement("name").setText("张三");
	     linkman.addElement("email").setText("zs@163.com");
	     linkman.addElement("address").setText("中软");
	     linkman.addElement("group").setText("第3组");
	     
	     //同步
//	     FileWriter out = new FileWriter("f:/contacts.xml");
//	     document.write(out);
//	     out.close();
	     
	     OutputFormat format = OutputFormat.createPrettyPrint();
	     XMLWriter  writer = new XMLWriter(new FileOutputStream(f), format );
	     writer.write(document);
	     
	     
	     
	     
	     
	     
	}
	
	
	//需求:查询所有联系人的信息
	public static void QueryAllInfo() throws Exception{
		//1.获取XML文档
        SAXReader reader = new SAXReader();
        Document document = reader.read(f);
        System.out.println(document);
        //2.获取根元素
        Element root =  document.getRootElement();
        System.out.println(root);
        System.out.println("-------------------");
        
        //3.获取根元素的子节点(元素)
        List<Element> list = root.elements("linkman");
//        for (Object object : list) {
//			System.out.println(object);
//		}
        for (Element linkman : list) {
        	
//        	方式1
//			Element nameEl = linkman.element("name");
//			System.out.println(nameEl);
//			System.out.println(nameEl.getText());
        	
//        	方式2
        	String id = linkman.attributeValue("id");
        	String name =  linkman.elementText("name");
        	String email =  linkman.elementText("email");
        	String address =  linkman.elementText("address");
        	String group =  linkman.elementText("group");
        	System.out.println(id+","+name+","+email+","+address+","+group);
		}
        
	}

}
