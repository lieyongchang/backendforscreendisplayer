package com.techstudio.model.dto;

public class RegisteredObjectDetailsObjDto {

	// variables
	public int registeredObjectID;
	public String registeredObjectType;
	public String registeredObjectName;
	public String photoUrl;
	public String greedyData;
	
	// getters & setters
	public int getRegisteredObjectID() {
		return registeredObjectID;
	}
	public void setRegisteredObjectID(int registeredObjectID) {
		this.registeredObjectID = registeredObjectID;
	}
	public String getRegisteredObjectType() {
		return registeredObjectType;
	}
	public void setRegisteredObjectType(String registeredObjectType) {
		this.registeredObjectType = registeredObjectType;
	}
	public String getRegisteredObjectName() {
		return registeredObjectName;
	}
	public void setRegisteredObjectName(String registeredObjectName) {
		this.registeredObjectName = registeredObjectName;
	}
	public String getPhotoUrl() {
		return photoUrl;
	}
	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}
	public String getGreedyData() {
		return greedyData;
	}
	public void setGreedyData(String greedyData) {
		this.greedyData = greedyData;
	}
	
}
