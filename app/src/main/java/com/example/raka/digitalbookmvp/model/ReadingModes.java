package com.example.raka.digitalbookmvp.model;


import com.google.gson.annotations.SerializedName;


public class ReadingModes{

	@SerializedName("image")
	private boolean image;

	@SerializedName("text")
	private boolean text;

	public void setImage(boolean image){
		this.image = image;
	}

	public boolean isImage(){
		return image;
	}

	public void setText(boolean text){
		this.text = text;
	}

	public boolean isText(){
		return text;
	}

	@Override
 	public String toString(){
		return 
			"ReadingModes{" + 
			"image = '" + image + '\'' + 
			",text = '" + text + '\'' + 
			"}";
		}
}