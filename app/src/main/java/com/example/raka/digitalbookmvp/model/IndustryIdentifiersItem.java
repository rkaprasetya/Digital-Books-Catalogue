package com.example.raka.digitalbookmvp.model;


import com.google.gson.annotations.SerializedName;


public class IndustryIdentifiersItem{

	@SerializedName("identifier")
	private String identifier;

	@SerializedName("type")
	private String type;

	public void setIdentifier(String identifier){
		this.identifier = identifier;
	}

	public String getIdentifier(){
		return identifier;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	@Override
 	public String toString(){
		return 
			"IndustryIdentifiersItem{" + 
			"identifier = '" + identifier + '\'' + 
			",type = '" + type + '\'' + 
			"}";
		}
}