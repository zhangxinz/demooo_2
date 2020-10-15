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
		set.add("啊啊啊啊!!!!!");
		
		
		
	}
	public static Map<String, String> method(){
		Map<String,String> map=new HashMap();
		SAXReader reader=new SAXReader();
		try {
			//通过reader对象的read方法加载xml文件,获取document对象
			Document document = reader.read(new File("C:\\Users\\liu\\workspace\\Oh My God\\src\\com\\zhiyou\\Factory\\application.xml"));
			//通过document对象获取根节点bookstore
			Element bookStore = document.getRootElement();
			//通过elment对象的elemengtIterator方法获取迭代器
			Iterator iterator = bookStore.elementIterator();
			//遍历迭代器,获取根节点中的信息
			while (iterator.hasNext()) {
				Element f = (Element)iterator.next();
				//获取水果的属性名和属性值
				List<Attribute> attributes = f.attributes();
//				for (Attribute attr : attributes) {
//					System.out.println("属性名:"+attr.getName()+"--属性值:"+attr.getValue());
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
		//获取map集合并遍历
		Map<String, String> map = method();
		Set<String> keySet = map.keySet();
		String value = null;
		for (String string : keySet) {
			//判断传进来的key和集合中的key是否相等
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
