/*
 * 创建XML
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
		
		DocumentFactory df = new DocumentFactory();//创建对象
		Document doc = df.createDocument();//获取Document
		doc.addComment("人的信息XML文件");//设置注释信息
		
		Element root = doc.addElement("peoples");//设置根元素
		
		Element p1 = root.addElement("person");//设置子1元素
		p1.addAttribute("pid", "1");//设置子1属性与值
		p1.addComment("第一个人");//设置注释信息
		Element pnameEle = p1.addElement("pname");//设置子子1元素
		pnameEle.setText("张三");
		Element psexEle = p1.addElement("psex");//设置子子2元素
		psexEle.addText("男");
		Element pageEle = p1.addElement("page");//设置子子3元素
		pageEle.addText("20");
		Element phoneEle = p1.addElement("phone");
		phoneEle.addText("12345678901");
		
		Element p2 = root.addElement("person");
		p2.addAttribute("pid", "2");
		p2.addComment("第二个人");
		Element pnameEle2 = p2.addElement("pname");
		pnameEle2.addText("张三");
		Element psexEle2 = p2.addElement("psex");
		psexEle2.addText("男");
		Element pageEle2 = p2.addElement("page");
		pageEle2.addText("20");
		Element phoneEle2 = p2.addElement("phone");
		phoneEle2 .addText("14725893652");
		
		Element p3 = p2.createCopy();//通过第二个子元素复制第三个子元素
		p3.addComment("第三个人");//《《《《《《《《《《《《《《《复制时注释有问题》》》》》》》》》》》》》》》》》》》》》》
		p3.attribute("pid").setValue("3");//修改子3元素的属性
		p3.element("pname").setText("李四");//修改子3元素
		root.add(p3);//添加到根元素
		
		try{
			OutputFormat format = new OutputFormat();//定义document输入的格式
			format.setEncoding("utf-8");//设置编码格式
			format.setIndent(true);//是否缩进
			format.setIndent("   ");//缩进几格
			format.setNewlines(true);//换行输出
			format.setSuppressDeclaration(true);
			OutputStream os = new FileOutputStream("peoples.xml");//生成的文件名及路径
			XMLWriter writer = new XMLWriter(os,format);//设置输出流格式
			writer.write(doc);//输出doc内容
			writer.close();
			os.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args){
		CreateXmlDemo();
		System.out.println("XML文件已生成");
	}
}
