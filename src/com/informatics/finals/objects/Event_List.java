package com.informatics.finals.objects;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Vector;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import com.informatics.finals.xml.XmlHandler;

import android.content.Context;
import android.util.Log;


public class Event_List {
	private Context c = null;
	private List<Event> list;
	
	public Event_List(Context context){
		this.c = context;
		list = new Vector<Event>(0);
	}

 public int addEvent(Event evn){
		this.addEvent(evn);
		return this.list.size();
	}
	private	Event getEvent(int location){
			return this.list.get(location);
		}
		
		List<Event>getAllEvents(){
		return this.list;
		}
		
	
		
		
    static Event_List parse(Context context) {
        try {
            FileInputStream fis = context.openFileInput("event.xml");

            if (fis == null) {
                return null;
            }
            // we need an input source for the sax parser
            InputSource is = new InputSource(fis);

            // create the factory
            SAXParserFactory factory = SAXParserFactory.newInstance();

            // create a parser
            SAXParser parser = factory.newSAXParser();

            // create the reader (scanner)
            XMLReader xmlreader = parser.getXMLReader();

            
            XmlHandler handler = new XmlHandler(context,null);
            // assign our handler
            xmlreader.setContentHandler(handler);

            // perform the synchronous parse
            xmlreader.parse(is);

            // clean up
            fis.close();

            // return our new joblist
            return handler.getEvents();
        } catch (Exception e) {
            Log.d("Event_List", "Error parsing event list xml from source : " + e.getMessage());
            return null;
        }
    }

}
