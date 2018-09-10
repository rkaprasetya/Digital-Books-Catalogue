package com.example.raka.digitalbookmvp.model;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SaleInfo{

	@SerializedName("country")
	private String country;

	@SerializedName("isEbook")
	private boolean isEbook;

	@SerializedName("saleability")
	private String saleability;

	@SerializedName("offers")
	private List<OffersItem> offers;

	@SerializedName("buyLink")
	private String buyLink;

	@SerializedName("retailPrice")
	private RetailPrice retailPrice;

	@SerializedName("listPrice")
	private ListPrice listPrice;

	public void setCountry(String country){
		this.country = country;
	}

	public String getCountry(){
		return country;
	}

	public void setIsEbook(boolean isEbook){
		this.isEbook = isEbook;
	}

	public boolean isIsEbook(){
		return isEbook;
	}

	public void setSaleability(String saleability){
		this.saleability = saleability;
	}

	public String getSaleability(){
		return saleability;
	}

	public void setOffers(List<OffersItem> offers){
		this.offers = offers;
	}

	public List<OffersItem> getOffers(){
		return offers;
	}

	public void setBuyLink(String buyLink){
		this.buyLink = buyLink;
	}

	public String getBuyLink(){
		return buyLink;
	}

	public void setRetailPrice(RetailPrice retailPrice){
		this.retailPrice = retailPrice;
	}

	public RetailPrice getRetailPrice(){
		return retailPrice;
	}

	public void setListPrice(ListPrice listPrice){
		this.listPrice = listPrice;
	}

	public ListPrice getListPrice(){
		return listPrice;
	}

	@Override
 	public String toString(){
		return 
			"SaleInfo{" + 
			"country = '" + country + '\'' + 
			",isEbook = '" + isEbook + '\'' + 
			",saleability = '" + saleability + '\'' + 
			",offers = '" + offers + '\'' + 
			",buyLink = '" + buyLink + '\'' + 
			",retailPrice = '" + retailPrice + '\'' + 
			",listPrice = '" + listPrice + '\'' + 
			"}";
		}
}