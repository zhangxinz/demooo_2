package com.zhiyou.Factory;

import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.zhiyou.Fruits.Fruits;
import com.zhiyou.model.Apple;

public class Test {

	public static void main(String[] args) {
		Map<String, Map<String,String>> maps = new HashMap<>();
		Set<String> set = new HashSet<>();
		set.add("��������!!!!!");
		
		
		
	}
	public static Map<String, String> method(){
		Map<String,String> map=new HashMap();
		SAXReader reader=new SAXReader();
		try {
			//ͨ��reader�����read��������xml�ļ�,��ȡdocument����
			Document document = reader.read(new File("C:\\Users\\liu\\workspace\\Oh My God\\src\\com\\zhiyou\\Factory\\application.xml"));
			//ͨ��document�����ȡ���ڵ�bookstore
			Element bookStore = document.getRootElement();
			//ͨ��elment�����elemengtIterator������ȡ������
			Iterator iterator = bookStore.elementIterator();
			//����������,��ȡ���ڵ��е���Ϣ
			while (iterator.hasNext()) {
				Element f = (Element)iterator.next();
				//��ȡˮ����������������ֵ
				List<Attribute> attributes = f.attributes();
//				for (Attribute attr : attributes) {
//					System.out.println("������:"+attr.getName()+"--����ֵ:"+attr.getValue());
//				}
				for (int i = 0; i < attributes.size(); i++) {
					map.put(attributes.get(i).getValue(), attributes.get(i+1).getValue());
					i++;
				}
			}
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}
	public static Fruits getBean(String key){
		//��ȡmap���ϲ�����
		Map<String, String> map = method();
		Set<String> keySet = map.keySet();
		String value = null;
		for (String string : keySet) {
			//�жϴ�������key�ͼ����е�key�Ƿ����
			if(key.equals(string)){
				value=map.get(string);
			}
		}
		Fruits f=null;
		try {
			Class class1 = Class.forName(value);
			f = (Fruits)class1.newInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return f;
	}
}
