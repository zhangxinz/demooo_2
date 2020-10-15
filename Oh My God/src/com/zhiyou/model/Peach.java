package com.zhiyou.model;

import com.zhiyou.Fruits.Fruits;

import lombok.Data;
@Data
public class Peach implements Fruits{
	private String name;
	private Integer age;
	@Override
	public void bloom() {
		System.out.println("屁吃开花了");
	}

	@Override
	public void result() {
		System.out.println("屁吃结果了");
	}
	
}
