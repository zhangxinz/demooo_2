package com.zhiyou.model;

import com.zhiyou.Fruits.Fruits;

import lombok.Data;
@Data
public class Grape implements Fruits{
	private String name;
	private Integer age;
	@Override
	public void bloom() {
		System.out.println("个瑞pe开花了");
	}

	@Override
	public void result() {
		System.out.println("个瑞pe结果了");
	}

	
}
