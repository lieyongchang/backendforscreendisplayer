package com.techstudio.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.EncodeException;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.techstudio.model.dto.RegisteredObjectDetailsObjDto;
import com.techstudio.util.MessageDecoder;
import com.techstudio.util.MessageEncoder;

@ServerEndpoint(
		value="/displayerData",
		decoders = MessageDecoder.class, 
		encoders = MessageEncoder.class )
public class SocketEndpoint {
	
	private Session session;
    private static final Set<SocketEndpoint> setOfEndpoints = new CopyOnWriteArraySet<>();
    private static HashMap<String, String> users = new HashMap<>();
	
	@OnOpen
    public void onOpen(Session session) throws IOException {
		
		System.out.println("onOpen is called");
        // Get session and WebSocket connection
		this.session = session;
		setOfEndpoints.add(this);
		
		Message message = new Message();
//        message.setFrom(username);
        message.setContent("Connected!");
        
        try {
            this.session.getBasicRemote().sendObject(message);
        } catch (IOException | EncodeException e) {
            e.printStackTrace();
        }

    }
	
	@OnMessage
    public void onMessage(Session session, Message message) throws IOException {
        // Handle new messages
		System.out.println("onMessage is called!");
    }
	
	public static void sendAnEvent(String registeredObjToDisplay) throws IOException {
		try {
			// send event to subscriber
			System.out.println("sending an event!");
			Message eventMessage = new Message();
			// create the event message:
			eventMessage.setContent(registeredObjToDisplay);
			// send the eventMessage to be broadcasted:
			broadcast(eventMessage);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	private static void broadcast(Message message) throws IOException, EncodeException {
		setOfEndpoints.forEach(endpoint -> {
			synchronized (endpoint) {
				try {
					// for all subscribers send the same message :
					endpoint.session.getBasicRemote().sendObject(message);
				} catch (IOException | EncodeException e) {
					e.printStackTrace();
				}
			}
		});
	}
}
