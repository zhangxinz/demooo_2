package com.zhiyou.Factory;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
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

public class Test2 {

	public static void main(String[] args) {
		System.out.println(method("banana"));
	}
	public static Fruits method(String s){
		//解析xml文件
		//创建SAXReader的对象reader
		SAXReader reader=new SAXReader();
		Class class1=null;
		Fruits f=null;
		String value=null;
		try {
			Map<String, String> map=new HashMap();
			//通过reader对象的reader方法加载xml文件,获得document对象
			Document document = reader.read("src\\com\\zhiyou\\Factory\\two.xml");
			Element element = document.getRootElement();
			Iterator iterator = element.elementIterator();
			while (iterator.hasNext()) {
				Element e = (Element)iterator.next();
				List<Attribute> attr = e.attributes();
				for (int i = 0; i < attr.size(); i++) {
					map.put(attr.get(i).getValue(), attr.get(i+1).getValue());
					i++;
				}
				Set<String> keySet = map.keySet();
				for (String string : keySet) {
					if(s.equals(string)){
						value=map.get(string);
					}
				}
				try {
					class1 = Class.forName(value);
					 f = (Fruits)class1.newInstance();
					 for (Attribute string : attr) {
							if(string.getValue().equals(s)){
								Iterator iterator2 = e.elementIterator();
								while (iterator2.hasNext()) {
									Element e2 = (Element)iterator2.next();
									List<Attribute> list = e2.attributes();
									for (int i = 0; i < list.size(); i++) {
										Field field = class1.getDeclaredField(list.get(i).getValue());
										field.setAccessible(true);
										if(field.getType().getName().equals("java.lang.Integer")){
											field.set(f, Integer.valueOf(e2.getStringValue()));
										}else{
											field.set(f,e2.getStringValue());
										}
									}
								}
							}
						}
					 return f;
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return f;
	}
}
