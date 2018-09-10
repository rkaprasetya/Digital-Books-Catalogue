package com.example.raka.digitalbookmvp.model;


import com.google.gson.annotations.SerializedName;


public class ImageLinks{

	@SerializedName("thumbnail")
	private String thumbnail;

	@SerializedName("smallThumbnail")
	private String smallThumbnail;

	public void setThumbnail(String thumbnail){
		this.thumbnail = thumbnail;
	}

	public String getThumbnail(){
		return thumbnail;
	}

	public void setSmallThumbnail(String smallThumbnail){
		this.smallThumbnail = smallThumbnail;
	}

	public String getSmallThumbnail(){
		return smallThumbnail;
	}

	@Override
 	public String toString(){
		return 
			"ImageLinks{" + 
			"thumbnail = '" + thumbnail + '\'' + 
			",smallThumbnail = '" + smallThumbnail + '\'' + 
			"}";
		}
}