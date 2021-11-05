package com.techstudio.form.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.techstudio.model.dto.EventDataObjDto;
import com.techstudio.service.LiveUpdateEventService;

@Controller
@RequestMapping("/api")
public class APIController {
	
	private static final ObjectMapper om = new ObjectMapper();
	
	private static final  Gson g = new Gson();
	
	@Autowired
	private LiveUpdateEventService liveUpdateEventService;
	
	private static final Log log = LogFactory.getLog(APIController.class);

	private static SimpleDateFormat YYYYMMDD_HHMMSS = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public static String getBody(HttpServletRequest request) throws IOException {

	    String body = null;
	    StringBuilder stringBuilder = new StringBuilder();
	    BufferedReader bufferedReader = null;

	    try {
	        InputStream inputStream = request.getInputStream();
	        if (inputStream != null) {
	            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
	            char[] charBuffer = new char[128];
	            int bytesRead = -1;
	            while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
	                stringBuilder.append(charBuffer, 0, bytesRead);
	            }
	        } else {
	            stringBuilder.append("");
	        }
	    } catch (IOException ex) {
	        throw ex;
	    } finally {
	        if (bufferedReader != null) {
	            try {
	                bufferedReader.close();
	            } catch (IOException ex) {
	                throw ex;
	            }
	        }
	    }

	    body = stringBuilder.toString();
	    return body;
	}
	
//	@ResponseBody
//	@RequestMapping(value = "getPoiTypeInfo.wilas")
//	public String getPoiTypeInfo () {
//		
//		log.info("getPoiInfo() | 900 | | get all the added poi type");
//		
//		String result = "";
//		
//		try {
//			result = om.writeValueAsString(plotTypeList);
//			log.debug("getPoiInfo() | 900 | Done convert plot type list to json string.");
//		} catch (JsonProcessingException e) {
//			log.error("getPoiInfo() | 900 | Error when convert plot type list to json string: "+e.hashCode());
//			return "[]";
//		}
//		
//		return result;
//	}
	
	// function to Listen for event feeds coming from Event Handler Engine
	@ResponseBody
	@RequestMapping(
			value="/getEvent",
			headers = "Accept=application/json")
	public String getEventFeed(HttpServletRequest request,
            HttpServletResponse response) {
		
		String reqBody = "";
		
		String result = "";
		
		try {
			// get body from the request:
			reqBody = getBody(request);
			System.out.println("getEventFeed Request called || ");
			System.out.println(reqBody);
			// deserialised the json body
			EventDataObjDto eventObj = g.fromJson(reqBody, EventDataObjDto.class);
			System.out.println("testing eventObj || " + eventObj.toString());
			
			// send EventObj to service handler
			liveUpdateEventService.liveEventUpdateHandler(eventObj);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	};
	
	// function to Call VMS for Registered Object Details Data.
	public String getRegisteredObjectDetails() {
		
		String request = "";
		return request;
	};
	
	
}
