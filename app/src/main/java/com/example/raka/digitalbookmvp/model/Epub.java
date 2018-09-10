package com.example.raka.digitalbookmvp.model;


import com.google.gson.annotations.SerializedName;


public class Epub{

	@SerializedName("isAvailable")
	private boolean isAvailable;

	public void setIsAvailable(boolean isAvailable){
		this.isAvailable = isAvailable;
	}

	public boolean isIsAvailable(){
		return isAvailable;
	}

	@Override
 	public String toString(){
		return 
			"Epub{" + 
			"isAvailable = '" + isAvailable + '\'' + 
			"}";
		}
}