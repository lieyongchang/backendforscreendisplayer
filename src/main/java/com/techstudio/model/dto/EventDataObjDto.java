package com.techstudio.model.dto;

public class EventDataObjDto {

	// variables
	public String biometricsId;
	public String cameraId;
	public String areaId;
	public String eventId;
	public String timestamp;
	public String registeredObjectId; //  <AreaDetailsObjDto>
	public String registeredObjectTypeId;
	public int confidenceLevel;
	public String greedyData;
	
	// getters & setters
	public String getBiometricID() {
		return biometricsId;
	}
	public void setBiometricID(String biometricID) {
		this.biometricsId = biometricID;
	}
	public String getCameraID() {
		return cameraId;
	}
	public void setCameraID(String cameraID) {
		this.cameraId = cameraID;
	}
	public String getAreaID() {
		return areaId;
	}
	public void setAreaID(String areaID) {
		this.areaId = areaID;
	}
	public String getEventID() {
		return eventId;
	}
	public void setEventID(String eventID) {
		this.eventId = eventID;
	}
	public String getTimeStamp() {
		return timestamp;
	}
	public void setTimeStamp(String timeStamp) {
		this.timestamp = timeStamp;
	}
	public String getRegisteredObjID() {
		return registeredObjectId;
	}
	public void setRegisteredObjID(String registeredObjID) {
		this.registeredObjectId = registeredObjID;
	}
	public String getRegisteredObjTypeID() {
		return registeredObjectTypeId;
	}
	public void setRegisteredObjTypeID(String registeredObjTypeID) {
		this.registeredObjectTypeId = registeredObjTypeID;
	}
	public int getConfidenceLevel() {
		return confidenceLevel;
	}
	public void setConfidenceLevel(int confidenceLevel) {
		this.confidenceLevel = confidenceLevel;
	}
	public String getGreedyData() {
		return greedyData;
	}
	public void setGreedyData(String greedyData) {
		this.greedyData = greedyData;
	}
	@Override
	public String toString() {
		return "EventDataObjDto [biometricsId=" + biometricsId + ", cameraId=" + cameraId + ", areaId=" + areaId
				+ ", eventId=" + eventId + ", timestamp=" + timestamp + ", registeredObjectId=" + registeredObjectId
				+ ", registeredObjectTypeId=" + registeredObjectTypeId + ", confidenceLevel=" + confidenceLevel
				+ ", greedyData=" + greedyData + "]";
	}
	
	
	
}
