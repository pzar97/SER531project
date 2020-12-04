package com.asu.ser.sparql.speed_recommend;

/*
 * 
 * Author: Gayathri Sitaraman
 * Date Created: 29th November 2020
 * 
 * This was written by the aforementioned author, and can be used for 
 * grading purposes by Arizona State University. 
 * Course: SER 531 
 */



import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.*;

import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;

import riotcmd.json;



public class SevCalculator {
	public JSONObject data = new JSONObject();
	SevCalculator() 
	{
		/*
		 *   Map looks like this:
		 *   
		 *   {
		 *   Weather:[{Rainy: 9}, {Stormy: 10}, {"Predicate": "has_weather_condition"} ] 
		 *   
		 *   }
		 */
		
		/* Weather values */
		String weatherjson = "[{Normal: 0.0},{Rainy: 0.0},{Other: 0.0},{Stormy: 0.0}, {Windy:0.0}, {Snowy:0.0},{Foggy:0.0},{Predicate: has_weather_condition}]";
		
		JSONArray sevvallist = new JSONArray(weatherjson);
		data.put("Weather", sevvallist);
		
		
		/*Light conditions*/
		
		String lightjson = "[{ Day:0.0},{Night with visibility: 0.0},{Nigh with low visibility: 0.0},{Dark:0.0}, {Predicate:has_light_condition}]";
		JSONArray sevvallist1 = new JSONArray(lightjson);
		data.put("Light", sevvallist1);
		
		/*Road_type*/
		
		String road_type_json = "[{Single carriageway:0.0},{Dual carriageway:0.0},{Roundabout:0.0},{One way street:0.0},{Slip road:0.0},{Predicate:has_road_type}]";
		JSONArray sevvallist3 = new JSONArray(road_type_json);
		data.put("Road_type", sevvallist3 );
		
		/*Road_conditions*/
		
		String road_condition_json = "[{Dry:0.0},{Wet:0.0},{Ice:0.0},{Snow:0.0},{Predicate:has_road_condition}]";
		JSONArray sevvallist4 = new JSONArray(road_condition_json);
		data.put("Road_Condition", sevvallist4);
		
		//System.out.println(data);
	}
	public float invokesevcalculator(String operation , String location)
	{
		float locsev = 0;
		SevCalculator sobj = new SevCalculator();
		 Class cls = sobj.getClass();
			Model model = ModelFactory.createDefaultModel();
			model = model.read(cls.getResource("/Accidents-ontology.owl").toString());
		SparqlQuery sqobj = new SparqlQuery(model);
		
		//Setting isrealTime as boolean True
		if(operation == "LocSev") {
			 locsev = sqobj.runQueryForLocationSeverity(location);
		}
		
		
		return locsev;
		//System.out.println(sobj.data);
		//sqobj.runQueryForSeverity(sobj.data);
		//System.out.println("Values" + sobj.data);	
	}
	
	public void calcSeverity()
	{
		SevCalculator sobj = new SevCalculator();
		 Class cls = sobj.getClass();
			Model model = ModelFactory.createDefaultModel();
			model = model.read(cls.getResource("/Accidents-ontology.owl").toString());
		SparqlQuery sqobj = new SparqlQuery(model);

		sqobj.runQueryForSeverity(sobj.data);
		
		
	}
	
	
	
	}
		