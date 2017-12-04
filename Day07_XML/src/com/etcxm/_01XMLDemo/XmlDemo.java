package com.etcxm._01XMLDemo;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XmlDemo {
	private static File f = new File("src/contacts.xml");
	public static void main(String[] args) throws Exception, SAXException, IOException {
		//getXml();
		//getLinkmanName();
		//updatelinkManEmail();
		//addlinkman();
		//setAttr();
		//deleteEle();
		createXMl();
	}
	
//	需求：在xml不存在的情况下，保存一个新的联系人到xml中
	public static void createXMl() throws SAXException, IOException, ParserConfigurationException, TransformerException{
		DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		if(f.exists()){
			System.out.println("存在");
			
			//存在就解析
			Document doc = builder.parse(f);
			System.out.println(doc);
		}else{
		   System.out.println("不存在");
		   //不存在就创建
		   Document doc = builder.newDocument();
		   //根元素
		   Element contact1s = doc.createElement("contact1s");
		   doc.appendChild(contact1s);
		   
		   TransformerFactory  factory = TransformerFactory.newInstance();
		   Transformer tran = factory.newTransformer();
		   Source xmlSource = new DOMSource(doc);//内存中xml
		   Result  outputTarget = new StreamResult(f);//文件中xml
		   tran.transform(xmlSource, outputTarget);
		}
		
//		
//		System.out.println(doc);
	}
	
	
	//需求：删除第三个联系人信息
	public static void deleteEle() throws Exception, IOException, ParserConfigurationException{
//		1：获取Document对象
		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(f);
//		2：获取根元素对象
		Element root = doc.getDocumentElement();
//		3：获取第三个linkman元素
		Element linkman = (Element)root.getElementsByTagName("linkman").item(2);
//		4：删除第三个linkman元素
		root.removeChild(linkman);
//		5：更新到xml文件中
		TransformerFactory  factory = TransformerFactory.newInstance();
		Transformer tran = factory.newTransformer();
		Source xmlSource = new DOMSource(doc);//内存中xml
		Result  outputTarget = new StreamResult(f);//文件中xml
		tran.transform(xmlSource, outputTarget);

	}
	
	//需求:操作XML的属性,设置/获取第三个联系人的属性
	public static void setAttr() throws Exception, IOException, ParserConfigurationException{
//		1：获取Document对象
		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(f);
//		2：获取根元素
		Element root = doc.getDocumentElement();
//		3：获取第三个linkman元素
		Element linkman =(Element)root.getElementsByTagName("linkman").item(2);
//		    设置属性：需要同步
		linkman.setAttribute("id", "14");
		
		TransformerFactory  factory = TransformerFactory.newInstance();
		Transformer tran = factory.newTransformer();
		Source xmlSource = new DOMSource(doc);//内存中xml
		Result  outputTarget = new StreamResult(f);//文件中xml
		tran.transform(xmlSource, outputTarget);
//		    获取属性：不需要同步

	}
	
//	需求：往xml中新增一个新的联系人
	public static void addlinkman() throws Exception, IOException, ParserConfigurationException{
//		1：获取Document对象
		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(f);
//		2：获取根元素
		Element root = doc.getDocumentElement();
//		3：创建linkman,name,email,address,group元素
		Element linkmanEl =  doc.createElement("linkman");
		
		Element nameEl =  doc.createElement("name");
		Element emailEl =  doc.createElement("email");
		Element addressEl =  doc.createElement("address");
		Element groupEl =  doc.createElement("group");
		
//		4：设置name,email,address,group元素的文本内容
		nameEl.setTextContent("tom");
		emailEl.setTextContent("kk@163.com");
		addressEl.setTextContent("厦门市软件园二期");
		groupEl.setTextContent("第3组");
//		5：设置name,email,address,group作为linkman的子元素
		linkmanEl.appendChild(nameEl);
		linkmanEl.appendChild(emailEl);
		linkmanEl.appendChild(addressEl);
		linkmanEl.appendChild(groupEl);
		
//		6：把新的linkman元素作为根的子元素
		root.appendChild(linkmanEl);
//		7：更新到xml文件中
		TransformerFactory  factory = TransformerFactory.newInstance();
		Transformer tran = factory.newTransformer();
		Source xmlSource = new DOMSource(doc);//内存中xml
		Result  outputTarget = new StreamResult(f);//文件中xml
		tran.transform(xmlSource, outputTarget);
		
	}
	
	//修改xml中的内容
    public static void updatelinkManEmail() throws Exception{
//    	1：获取Document对象
    	DocumentBuilderFactory  dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db =  dbf.newDocumentBuilder();
		Document dc = db.parse(f);
//    	2：获取根元素对象
		Element root = dc.getDocumentElement();
//    	3：获取第一个linkman元素
		Element linkman = (Element)root.getElementsByTagName("linkman").item(0);
//    	4：获取该linkman元素下的第一个email元素
		Element email = (Element)linkman.getElementsByTagName("email").item(0);
//    	5：修改email元素的文本内容
		email.setTextContent("yy@163.com");
		//System.out.println(email.getTextContent());
//    	6：把内存中的数据同步到xml文件中(Transformer)
		TransformerFactory  factory = TransformerFactory.newInstance();
		Transformer tran = factory.newTransformer();
		Source xmlSource = new DOMSource(dc);//内存中xml
		Result  outputTarget = new StreamResult(f);//文件中xml
		tran.transform(xmlSource, outputTarget);
		
		

    }
	
	
//	需求：获取第二个联系人的姓名
	public static void getLinkmanName() throws ParserConfigurationException, SAXException, IOException{
//		1：获取Document对象  XML文档对象
		DocumentBuilderFactory  dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db =  dbf.newDocumentBuilder();
		Document dc = db.parse(f);
//		2：获取根元素对象:contacts
		Element root =  dc.getDocumentElement();
		//System.out.println(root);
//		3：获取根元素下找到第二个linkman元素
		NodeList list = root.getElementsByTagName("linkman");
		//System.out.println(list.getLength());
		Element linkman = (Element) list.item(1);
		//System.out.println(linkman);
//		4：获取linkman元素下的第一个name元素
		NodeList linkNamelist = linkman.getElementsByTagName("name");
		//System.out.println(linkNamelist.getLength());
		Element name = (Element)linkNamelist.item(0);
		//System.out.println(name);
//		5：获取该name元素的文本内容
		String content = name.getTextContent();
		//System.out.println(content);
		

	}

	
	//1.加载xml的内容
	public static void getXml() throws ParserConfigurationException, SAXException, IOException{
		
		//1.DocumentBuilderFactory这个对象
		DocumentBuilderFactory  dbf = DocumentBuilderFactory.newInstance();
		
		//2.DocumentBuilder这个对象
		DocumentBuilder db =  dbf.newDocumentBuilder();
		
		//3.Document对象
		
		Document dc = db.parse(f);
		System.out.println(dc);
		
	}
	
	
}
