package com.elaine.testjetpack.network.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DatasItem{

	@SerializedName("shareDate")
	private long shareDate;

	@SerializedName("projectLink")
	private String projectLink;

	@SerializedName("prefix")
	private String prefix;

	@SerializedName("canEdit")
	private boolean canEdit;

	@SerializedName("origin")
	private String origin;

	@SerializedName("link")
	private String link;

	@SerializedName("title")
	private String title;

	@SerializedName("type")
	private int type;

	@SerializedName("selfVisible")
	private int selfVisible;

	@SerializedName("apkLink")
	private String apkLink;

	@SerializedName("envelopePic")
	private String envelopePic;

	@SerializedName("audit")
	private int audit;

	@SerializedName("chapterId")
	private int chapterId;

	@SerializedName("realSuperChapterId")
	private int realSuperChapterId;

	@SerializedName("id")
	private int id;

	@SerializedName("courseId")
	private int courseId;

	@SerializedName("superChapterName")
	private String superChapterName;

	@SerializedName("descMd")
	private String descMd;

	@SerializedName("publishTime")
	private long publishTime;

	@SerializedName("niceShareDate")
	private String niceShareDate;

	@SerializedName("visible")
	private int visible;

	@SerializedName("niceDate")
	private String niceDate;

	@SerializedName("author")
	private String author;

	@SerializedName("zan")
	private int zan;

	@SerializedName("chapterName")
	private String chapterName;

	@SerializedName("userId")
	private int userId;

	@SerializedName("tags")
	private List<TagsItem> tags;

	@SerializedName("superChapterId")
	private int superChapterId;

	@SerializedName("fresh")
	private boolean fresh;

	@SerializedName("collect")
	private boolean collect;

	@SerializedName("shareUser")
	private String shareUser;

	@SerializedName("desc")
	private String desc;

	public long getShareDate(){
		return shareDate;
	}

	public String getProjectLink(){
		return projectLink;
	}

	public String getPrefix(){
		return prefix;
	}

	public boolean isCanEdit(){
		return canEdit;
	}

	public String getOrigin(){
		return origin;
	}

	public String getLink(){
		return link;
	}

	public String getTitle(){
		return title;
	}

	public int getType(){
		return type;
	}

	public int getSelfVisible(){
		return selfVisible;
	}

	public String getApkLink(){
		return apkLink;
	}

	public String getEnvelopePic(){
		return envelopePic;
	}

	public int getAudit(){
		return audit;
	}

	public int getChapterId(){
		return chapterId;
	}

	public int getRealSuperChapterId(){
		return realSuperChapterId;
	}

	public int getId(){
		return id;
	}

	public int getCourseId(){
		return courseId;
	}

	public String getSuperChapterName(){
		return superChapterName;
	}

	public String getDescMd(){
		return descMd;
	}

	public long getPublishTime(){
		return publishTime;
	}

	public String getNiceShareDate(){
		return niceShareDate;
	}

	public int getVisible(){
		return visible;
	}

	public String getNiceDate(){
		return niceDate;
	}

	public String getAuthor(){
		return author;
	}

	public int getZan(){
		return zan;
	}

	public String getChapterName(){
		return chapterName;
	}

	public int getUserId(){
		return userId;
	}

	public List<TagsItem> getTags(){
		return tags;
	}

	public int getSuperChapterId(){
		return superChapterId;
	}

	public boolean isFresh(){
		return fresh;
	}

	public boolean isCollect(){
		return collect;
	}

	public String getShareUser(){
		return shareUser;
	}

	public String getDesc(){
		return desc;
	}
}