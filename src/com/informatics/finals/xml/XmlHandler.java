package com.informatics.finals.xml;
import org.xml.sax.Attributes;
import android.content.Context;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.*;

import com.informatics.finals.objects.Event;
import com.informatics.finals.objects.Event_List;
import com.informatics.finals.objects.WeatherEntry_List;

import android.os.Handler;
import android.os.Message;
import android.util.Log;


public class XmlHandler extends DefaultHandler{
	
	private Handler xmlHandler;
	private Context context;
	private Message msg;
	private WeatherEntry_List weatherList;
	private Event_List eventList;
	private Event event;
	private StringBuilder sb;
	/*********************************************Not Complete***************************************/
	
	public XmlHandler(Context c, Handler handler){
		
		this.context=c;
		
		if(handler!=null){
			xmlHandler=handler;
			msg = new Message();
			msg.what=0;
			msg.obj= (Object)"Connecting...";
			xmlHandler.sendMessage(msg);
			
		}
		
	}
	
	
	
	public WeatherEntry_List getWeather(){
		msg = new Message();
		msg.what=0;
		msg.obj = (Object)"Downloading Weather Information";
		xmlHandler.sendMessage(msg);
		return weatherList;
	}
	
	public Event_List getEvents(){
		msg = new Message();
		msg.what =0;
		msg.obj = (Object)"Downloading Upcoming Events";
		xmlHandler.sendMessage(msg);
		return eventList;
	}

	
	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.endDocument();
	}
	
	
	  @Override
    public void endElement(String namespaceURI, String localName, String qName) throws SAXException {

		  int count=1;
        if (localName.equals("event")) {
            // add our job to the list!
            this.eventList.addEvent(this.event);
          
             msg = new Message();
            msg.what = 0;
            msg.obj = ("Storing Event :" + count);
            if (this.xmlHandler != null) {
                this.xmlHandler.sendMessage(msg);
            }

            return;
        }

        if (localName.equals("title")) {
            this.event.set_Title(this.sb.toString());
            return;
        }
        if (localName.equals("description")) {
           this.event.set_Description(this.sb.toString());
            return;
        }
        if (localName.equals("link")) {
           this.event.set_Link(this.sb.toString());
            return;
        }
        if (localName.equals("category")) {
            this.event.set_Category(this.sb.toString());
            return;
        }
        if (localName.equals("location")) {
            this.event.set_Location(this.sb.toString());
            return;
        }
        if (localName.equals("dateStart")) {
            this.event.set_DateStart(this.sb.toString());
            return;
        }
        if (localName.equals("dateEnd")) {
            this.event.set_DateEnd(this.sb.toString());
            return;
        }
       
       

    }
	@Override
	public void startDocument() throws SAXException {

		msg = new Message();
		msg.what =0;
		msg.obj = (Object)"Starting New Document";
			
		if(xmlHandler != null ){
			xmlHandler.sendMessage(msg);
			this.eventList = new Event_List(this.context);
			event = new Event();
		}
		super.startDocument();
	}

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
	
		super.startElement(uri, localName, qName, attributes);
		
		try{
		StringBuilder sb  = new StringBuilder("");
		if(localName.equals("entry")){
			msg = new Message();
			msg.what=0;
			msg.obj=(Object)localName;
			if(xmlHandler != null){xmlHandler.sendMessage(msg);
			this.event = new Event();
			}
		}
	}
		catch(Exception ee){
			Log.d("EventxmlHandler", ee.getStackTrace().toString());
		}
	}//end of try
	
	
	 @Override
	    public void characters(char ch[], int start, int length) {
	        String theString = new String(ch, start, length);
	        Log.d("Event XMLHandler", "characters[" + theString + "]");
	        this.sb.append(theString);
	    }

}
