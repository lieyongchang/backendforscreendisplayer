package com.techstudio.model.dto;

import java.util.List;

public class RegisteredObjectDetailsApiDto {

	// variables
	private String status;
	private int code;
	private List<RegisteredObjectDetailsObjDto> ObjectsToCache;
	
	// getters & setters
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public List<RegisteredObjectDetailsObjDto> getObjectsToCache() {
		return ObjectsToCache;
	}
	public void setObjectsToCache(List<RegisteredObjectDetailsObjDto> objectsToCache) {
		this.ObjectsToCache = objectsToCache;
	}
	
}
