package com.techstudio.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.techstudio.model.dto.EventDataObjDto;
import com.techstudio.model.dto.RegisteredObjectDetailsObjDto;

@Service
public class LiveUpdateEventService {
	
	private static final  Gson g = new Gson();
	
	// function to handle live event update:
	public void liveEventUpdateHandler(EventDataObjDto eventObj) {
		
		RegisteredObjectDetailsObjDto returnedRegisteredObj = new RegisteredObjectDetailsObjDto(); 
		
		// mock data for returnedRegisteredObj
		returnedRegisteredObj.setRegisteredObjectID(12);
		returnedRegisteredObj.setRegisteredObjectName("irfan");
		returnedRegisteredObj.setRegisteredObjectType("staff");
		returnedRegisteredObj.setPhotoUrl("www.yoyo.com");
		
		String toDisplayer = "";
	
		try {
			// send RegisteredObj for validation, update flag:
//			returnedRegisteredObj = validateRegisteredObj(eventObj.getRegisteredObjID());

			// a registeredObj will always have a photoURL based on the sequence flow given.
			if (returnedRegisteredObj.getPhotoUrl().isEmpty()) {
				// check from vms if registeredObj is there: if true refresh the cache || else
				// display as unknownObj:

			} else {
				
				// serialised the registeredObj and parse to String var
				toDisplayer = g.toJson(returnedRegisteredObj);
				
				System.out.println("in liveEventUpdateHandler || serialised registered Obj is : ");
				System.out.println(toDisplayer);

				// display the RegisteredObj to the displayer
				SocketEndpoint.sendAnEvent(toDisplayer);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// function to validate the incoming RegisteredObject:
	private RegisteredObjectDetailsObjDto validateRegisteredObj(String registeredObjID) {
		
		RegisteredObjectDetailsObjDto objToReturn = new RegisteredObjectDetailsObjDto();
		
		
		// check if registeredObj is in cache; if in cache return the obj itself. else return null.
//		if () {
//			
//		} else {
//			
//		}
		
		return objToReturn;
	}
}
