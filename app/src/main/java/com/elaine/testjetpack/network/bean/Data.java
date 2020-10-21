package com.elaine.testjetpack.network.bean;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Data{

	@SerializedName("over")
	private boolean over;

	@SerializedName("pageCount")
	private int pageCount;

	@SerializedName("total")
	private int total;

	@SerializedName("curPage")
	private int curPage;

	@SerializedName("offset")
	private int offset;

	@SerializedName("size")
	private int size;

	@SerializedName("datas")
	private List<DatasItem> datas;

	public boolean isOver(){
		return over;
	}

	public int getPageCount(){
		return pageCount;
	}

	public int getTotal(){
		return total;
	}

	public int getCurPage(){
		return curPage;
	}

	public int getOffset(){
		return offset;
	}

	public int getSize(){
		return size;
	}

	public List<DatasItem> getDatas(){
		return datas;
	}
}