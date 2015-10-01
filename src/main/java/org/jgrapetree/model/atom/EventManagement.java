package org.jgrapetree.model.atom;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class EventManagement {
	private HashMap<String, String> scriptMap = new HashMap<String, String>();
	
	public List getAllEventName(){
	    ArrayList list = new ArrayList();
	    Iterator iterator = scriptMap.keySet().iterator();            
	    while (iterator.hasNext()) {
	       Object key = iterator.next();
	         list.add(key);
	    }       
	    return list;
	}
		
	public String getScript(String eventName){
		String str = scriptMap.get(eventName);
		if(str == null){
			str = "";
		}
		return str;
	}
	public void bindScript(String eventName, String scriptStr){
		scriptMap.put(eventName, scriptStr);
	}
	public void delScript(String eventName){
		scriptMap.remove(eventName);
	}
}
