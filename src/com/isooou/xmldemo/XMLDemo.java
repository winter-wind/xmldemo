/*
 * XML学习--读
 * */


package com.isooou.xmldemo;


import java.io.File;
import java.util.Iterator;
import java.util.List;



import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class XMLDemo {

	public XMLDemo(){
		
	}
	
	@SuppressWarnings("unchecked")
	public static void parseXML(){
		SAXReader parser = new SAXReader();//获取解析对象
		
		try{
			Document doc = parser.read(new File("dept.xml"));//获取和输出根元素
			
			Element root = doc.getRootElement();//获取根元素对象
			String rootName = root.getName();//获取根元素对象名称
			System.out.println("根元素对象名称:"+rootName);
			
			//---------------------------------------------------------------------------------
			
			List<Element> list = root.elements();//获取根元素下的子对象
			
			for(Element e:list){//遍历根元素下的子对象
				String eName = e.getName();//获取子对象名称
				System.out.println("子对象名称:"+eName);
				List<Attribute> atts = e.attributes();//获取当前子属性对象
				
				for(Attribute att:atts){//遍历子对象属性
					String attName = att.getName();//获取属性的名字
					String attValue = att.getValue();//获取属性的值
					System.out.println("子属性名字:"+attName+" 值："+attValue);
				}
				
			//----------------------------------------------------------------------------------
				Iterator<Element> iter = e.elementIterator();//获取子子对象
				
				while(iter.hasNext()){//遍历子子对象
					Element child = iter.next();
					String childName = child.getName();//获取子子对象名称
					String childText = child.getText();//获取子子元素的内容
					System.out.println("子子对象名称"+childName+" 子子元素的内容:"+childText);
				}
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args){
		parseXML();
	}
}
