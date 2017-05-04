/*
 * XMLѧϰ--��
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
		SAXReader parser = new SAXReader();//��ȡ��������
		
		try{
			Document doc = parser.read(new File("dept.xml"));//��ȡ�������Ԫ��
			
			Element root = doc.getRootElement();//��ȡ��Ԫ�ض���
			String rootName = root.getName();//��ȡ��Ԫ�ض�������
			System.out.println("��Ԫ�ض�������:"+rootName);
			
			//---------------------------------------------------------------------------------
			
			List<Element> list = root.elements();//��ȡ��Ԫ���µ��Ӷ���
			
			for(Element e:list){//������Ԫ���µ��Ӷ���
				String eName = e.getName();//��ȡ�Ӷ�������
				System.out.println("�Ӷ�������:"+eName);
				List<Attribute> atts = e.attributes();//��ȡ��ǰ�����Զ���
				
				for(Attribute att:atts){//�����Ӷ�������
					String attName = att.getName();//��ȡ���Ե�����
					String attValue = att.getValue();//��ȡ���Ե�ֵ
					System.out.println("����������:"+attName+" ֵ��"+attValue);
				}
				
			//----------------------------------------------------------------------------------
				Iterator<Element> iter = e.elementIterator();//��ȡ���Ӷ���
				
				while(iter.hasNext()){//�������Ӷ���
					Element child = iter.next();
					String childName = child.getName();//��ȡ���Ӷ�������
					String childText = child.getText();//��ȡ����Ԫ�ص�����
					System.out.println("���Ӷ�������"+childName+" ����Ԫ�ص�����:"+childText);
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
