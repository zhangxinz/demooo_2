package com.zhiyou.model;

import com.zhiyou.Fruits.Fruits;

import lombok.Data;
@Data
public class Pear implements Fruits{
	private String name;
	private Integer age;
	@Override
	public void bloom() {
		System.out.println("Ƥ��������");
	}

	@Override
	public void result() {
		System.out.println("Ƥ�������");
	}
	
}
