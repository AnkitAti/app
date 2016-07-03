package com.app.actions;

/**
 * This class searches the cooks based on the information provided.
 * @author Ankit
 * @version 1.0
 */
public class SearchAction {

	private String place;
	private String costRange;
	private String cookType;
	
	public void setPlace(String place) {
		this.place = place;
	}
	
	public String getPlace() {
		return this.place;
	}
	
	public void setCostRange(String costRange) {
		this.costRange = costRange;
	}
	
	public String getCostRange() {
		return this.costRange;
	}
	
	public void setCookType(String cookType) {
		this.cookType = cookType;
	}
	
	public String cookType() {
		return this.cookType;
	}
	
	
	public String search() {
		
		return null;
	}
}
