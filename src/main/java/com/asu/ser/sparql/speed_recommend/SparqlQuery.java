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

import org.json.JSONArray;
import org.json.JSONObject;

import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.rdf.model.Literal;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;

public class SparqlQuery {
	
	Model model;
	
	SparqlQuery(Model model) {
		this.model = model;
		
	}
	
	
	
	/*
	 * Runs sparql and calculates severity and updated the json object
	 */
	
	public void runQueryForSeverity(JSONObject sevvalues)
	
	{
		String qstr = "";
		String col = "";
		float total = 0;
		float weightcalc = 0;
		JSONArray keyvallist = new JSONArray();
		int size = 0;
		int factors = 4;
		/* for weather */
		for(int outer=0;outer < factors;outer ++)
		{
		if(outer == 0) {
		keyvallist = sevvalues.getJSONArray("Weather"); size = keyvallist.length(); col = "Weather";}
		else if(outer ==1 ) {keyvallist = sevvalues.getJSONArray("Light"); size = keyvallist.length(); col = "Light";}
		else if(outer ==2 ) {keyvallist = sevvalues.getJSONArray("Road_type"); size = keyvallist.length(); col="Road_type";}
		else if(outer == 3) {keyvallist = sevvalues.getJSONArray("Road_Condition"); size = keyvallist.length(); col="Road_Condition";}
		 
		 //System.out.println(size);
		 String predicate = keyvallist.getJSONObject(size-1).get("Predicate").toString();
		 Float severity = (float) 0;
		 String factor = "";
		 for(int i=0;i<size-1;i++)
		 {
			 total = 0;
			 weightcalc = 0;
			 
			 for(int k =1;k<=3;k++)
				 
			 { 
				factor = keyvallist.getJSONObject(i).keys().next().toString();
				qstr = formQueryString(col,factor,predicate,k);
			    Query query = QueryFactory.create(qstr);
				QueryExecution qe = QueryExecutionFactory.create(query,model);
				ResultSet results = qe.execSelect();
				QuerySolution row = results.next() ;
			    String value1 = row.getLiteral("count")!= null? row.getLiteral("count").toString() : "NULL";
			    Literal val1 = row.getLiteral("count");
			    int countval = val1.getInt();
			    //System.out.println(countval);
			    total += countval ;
			    weightcalc += (countval * k);
			    
			 }
			 //System.out.println("Total" + total + "Weight" + weightcalc);
			 
			 if(weightcalc !=0 && total !=0) {
			 severity = (float) (weightcalc/total);
			 }
			 else {severity = (float) 0;}
			 JSONObject jobj = new JSONObject();
			 jobj = keyvallist.getJSONObject(i);
			 jobj.put(factor,severity);
			 //keyvallist.put(jobj);
			 
	}
		 
		 //System.out.println(keyvallist);
}
		//System.out.println(sevvalues);
		//return sevvalues;
}
	
	/* This function helps to form query string using the column and predicates given*/
	public String formQueryString(String col, String filterStr, String predicate, int severity)
	{
	if(col == "Weather") {
		String queryOntoTest = "PREFIX act:<http://www.semanticweb.org/narmadaravalinamburi/ontologies/2020/10/accidents-ontology#>"+
		"PREFIX xsd:<http://www.w3.org/2001/XMLSchema>" 
				+
				"SELECT (COUNT(*) AS ?count) WHERE"
				    + "{"
					+ "?subject act:has_coordinates ?obj ; act:has_severity ?sev" + "."
				    + "?obj act:has_name ?pl_name."
				    + "?subject act:weather_during_accident ?weather ."
					+ "?weather act:" + predicate + " ?name."
				    + "FILTER regex(str(?name)," + "'" + filterStr + "'" + ") FILTER (?sev = " + severity + ")} " ;
	    //System.out.println(queryOntoTest);
		return queryOntoTest;
	}
	
	else if(col == "Light")
	{
		String queryOntoTest = "PREFIX act:<http://www.semanticweb.org/narmadaravalinamburi/ontologies/2020/10/accidents-ontology#>"+
				"PREFIX xsd:<http://www.w3.org/2001/XMLSchema>" 
						+
						"SELECT (COUNT(*) AS ?count) WHERE"
						    + "{"
							+ "?subject act:has_coordinates ?obj ; act:has_severity ?sev" + "."
						    + "?obj act:has_name ?pl_name."
						    + "?subject act:" + predicate + " ?name."
						    + "FILTER regex(str(?name)," + "'" + filterStr + "'" + ") FILTER (?sev = " + severity + ")} " ;
		//System.out.println(queryOntoTest);
		return queryOntoTest;
	}
	
	else if(col == "Road_type") {
		String queryOntoTest = "PREFIX act:<http://www.semanticweb.org/narmadaravalinamburi/ontologies/2020/10/accidents-ontology#>"+
				"PREFIX xsd:<http://www.w3.org/2001/XMLSchema>" 
						+
						"SELECT (COUNT(*) AS ?count) WHERE"
						    + "{"
							+ "?subject act:has_coordinates ?obj ; act:has_severity ?sev" + "."
						    + "?obj act:has_name ?pl_name."
						    + "?subject act:occured_on ?road ."
							+ "?road act:" + predicate + " ?name."
						    + "FILTER regex(str(?name)," + "'" + filterStr + "'" + ") FILTER (?sev = " + severity + ")} " ;
		//System.out.println(queryOntoTest);
		return queryOntoTest;
	}
	
	else if(col == "Road_Condition") {
		String queryOntoTest = "PREFIX act:<http://www.semanticweb.org/narmadaravalinamburi/ontologies/2020/10/accidents-ontology#>"+
				"PREFIX xsd:<http://www.w3.org/2001/XMLSchema>" 
						+
						"SELECT (COUNT(*) AS ?count) WHERE"
						    + "{"
							+ "?subject act:has_coordinates ?obj ; act:has_severity ?sev" + "."
						    + "?obj act:has_name ?pl_name."
						    + "?subject act:occured_on ?road ."
							+ "?road act:" + predicate + " ?name."
						    + "FILTER regex(str(?name)," + "'" + filterStr + "'" + ") FILTER (?sev = " + severity + ")} " ;
		//System.out.println(queryOntoTest);
		return queryOntoTest;
		
	}
	return "";
}
		
	
	/*
	 * For running any sparql queries, that can be used by other modules.
	 */
	
	public void runGeneralQuery(String qstr) {
		
	}
	

}











