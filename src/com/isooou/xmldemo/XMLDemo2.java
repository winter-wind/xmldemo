/*
 * 
 * XMLѧϰ--��
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
	
		SAXReader parser = new SAXReader();//��ȡXML��������
		try{
			Document doc = parser.read(new File("dept.xml"));//��ȡXML�ļ�
			Element root = doc.getRootElement();//��ȡ������
			System.out.println("��Ԫ�����ƣ� "+root.getName());
			
			Element e1 = root.element("dept");//��ȡ�Ӷ���
			System.out.println("��Ԫ�����ƣ� "+e1.getName());
			
			Attribute att = e1.attribute("deptid");//��ȡ�Ӷ�������
			System.out.println("��Ԫ��������---ֵ�� "+att.getName()+"---"+att.getValue());
			
			Element ee1 = e1.element("deptname");//��ȡ���Ӷ���
			System.out.println("���Ӷ���1��---���ݣ�"+ee1.getName()+"---"+ee1.getText());
			
			Element ee2 = e1.element("deptnum");
			System.out.println("���Ӷ���2��---���ݣ�"+ee2.getName()+"---"+ee2.getText());
			
			Element ee3 = e1.element("deptdesc");
			System.out.println("���Ӷ���3��---���ݣ�"+ee3.getName()+"---"+ee3.getText());
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args){
		parseXML();
	}
	
}
