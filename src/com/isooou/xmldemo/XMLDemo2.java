/*
 * 
 * XML学习--读
 * 
 */


package com.isooou.xmldemo;

import java.io.File;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class XMLDemo2 {

	public static void parseXML(){
	
		SAXReader parser = new SAXReader();//获取XML解析对象
		try{
			Document doc = parser.read(new File("dept.xml"));//获取XML文件
			Element root = doc.getRootElement();//获取根对象
			System.out.println("根元素名称： "+root.getName());
			
			Element e1 = root.element("dept");//获取子对象
			System.out.println("子元素名称： "+e1.getName());
			
			Attribute att = e1.attribute("deptid");//获取子对象属性
			System.out.println("子元素属性名---值： "+att.getName()+"---"+att.getValue());
			
			Element ee1 = e1.element("deptname");//获取子子对象
			System.out.println("子子对象1名---内容："+ee1.getName()+"---"+ee1.getText());
			
			Element ee2 = e1.element("deptnum");
			System.out.println("子子对象2名---内容："+ee2.getName()+"---"+ee2.getText());
			
			Element ee3 = e1.element("deptdesc");
			System.out.println("子子对象3名---内容："+ee3.getName()+"---"+ee3.getText());
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args){
		parseXML();
	}
	
}
