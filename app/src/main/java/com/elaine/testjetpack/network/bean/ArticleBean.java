package com.elaine.testjetpack.network.bean;

import com.google.gson.annotations.SerializedName;

public class ArticleBean {

	@SerializedName("data")
	private Data data;

	@SerializedName("errorCode")
	private int errorCode;

	@SerializedName("errorMsg")
	private String errorMsg;

	public Data getData(){
		return data;
	}

	public int getErrorCode(){
		return errorCode;
	}

	public String getErrorMsg(){
		return errorMsg;
	}
}