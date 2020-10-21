package com.elaine.testjetpack.network.bean;

import com.google.gson.annotations.SerializedName;

public class TagsItem{

	@SerializedName("name")
	private String name;

	@SerializedName("url")
	private String url;

	public String getName(){
		return name;
	}

	public String getUrl(){
		return url;
	}
}