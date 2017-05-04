/*
 * ����XML
 * 
 * */


package com.isooou.xmldemo;

import java.io.FileOutputStream;
import java.io.OutputStream;

import org.dom4j.Document;
import org.dom4j.DocumentFactory;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

public class CreateXmlDemo {

	public static void CreateXmlDemo(){
		
		DocumentFactory df = new DocumentFactory();//��������
		Document doc = df.createDocument();//��ȡDocument
		doc.addComment("�˵���ϢXML�ļ�");//����ע����Ϣ
		
		Element root = doc.addElement("peoples");//���ø�Ԫ��
		
		Element p1 = root.addElement("person");//������1Ԫ��
		p1.addAttribute("pid", "1");//������1������ֵ
		p1.addComment("��һ����");//����ע����Ϣ
		Element pnameEle = p1.addElement("pname");//��������1Ԫ��
		pnameEle.setText("����");
		Element psexEle = p1.addElement("psex");//��������2Ԫ��
		psexEle.addText("��");
		Element pageEle = p1.addElement("page");//��������3Ԫ��
		pageEle.addText("20");
		Element phoneEle = p1.addElement("phone");
		phoneEle.addText("12345678901");
		
		Element p2 = root.addElement("person");
		p2.addAttribute("pid", "2");
		p2.addComment("�ڶ�����");
		Element pnameEle2 = p2.addElement("pname");
		pnameEle2.addText("����");
		Element psexEle2 = p2.addElement("psex");
		psexEle2.addText("��");
		Element pageEle2 = p2.addElement("page");
		pageEle2.addText("20");
		Element phoneEle2 = p2.addElement("phone");
		phoneEle2 .addText("14725893652");
		
		Element p3 = p2.createCopy();//ͨ���ڶ�����Ԫ�ظ��Ƶ�������Ԫ��
		p3.addComment("��������");//����������������������������������ʱע�������⡷������������������������������������������
		p3.attribute("pid").setValue("3");//�޸���3Ԫ�ص�����
		p3.element("pname").setText("����");//�޸���3Ԫ��
		root.add(p3);//��ӵ���Ԫ��
		
		try{
			OutputFormat format = new OutputFormat();//����document����ĸ�ʽ
			format.setEncoding("utf-8");//���ñ����ʽ
			format.setIndent(true);//�Ƿ�����
			format.setIndent("   ");//��������
			format.setNewlines(true);//�������
			format.setSuppressDeclaration(true);
			OutputStream os = new FileOutputStream("peoples.xml");//���ɵ��ļ�����·��
			XMLWriter writer = new XMLWriter(os,format);//�����������ʽ
			writer.write(doc);//���doc����
			writer.close();
			os.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args){
		CreateXmlDemo();
		System.out.println("XML�ļ�������");
	}
}
