package com.zhiyou.model;

import com.zhiyou.Fruits.Fruits;

import lombok.Data;
@Data
public class Apple implements Fruits{
	private String name;
	private Integer age;
	@Override
	public void bloom() {
		System.out.println("���ÿ�����");
	}

	@Override
	public void result() {
		System.out.println("���ý����");
	}

	
}
