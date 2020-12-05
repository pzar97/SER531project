package com.asu.ser.sparql.speed_recommend;

/*
 * 
 * Author: Prashant Singh
 * Date Created: 29th November 2020
 * 
 * This was written by the aforementioned author, and can be used for 
 * grading purposes by Arizona State University. 
 * Course: SER 531 
 */

//Importing the required libraries
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

//Recommender class
public class Recommender
{
    //Declaring the attribute for Recommender class
    private static Double normalWeather;
    private static Double rainyWeather;
    private static Double stormyWeather;
    private static Double snowyWeather;
    private static Double foggyWeather;
    private static Double windyWeather;
    private static Double unknownWeather;

    private static Double singleType;
    private static Double dualType;
    private static Double roundType;
    private static Double oneType;
    private static Double slipType;
    private static Double unknownType;

    private static Double wetSurface;
    private static Double drySurface;
    private static Double iceSurface;
    private static Double snowSurface;
    private static Double floodSurface;
    private static Double unknownSurface;

    private static Double dayLight;
    private static Double nightVisibleLight;
    private static Double nightInvisibleLight;
    private static Double darkLight;
    private static Double unknownLight;
    
    //Takes input from text file where severity indices are stored.
    public Recommender()
    {
    	 String value;
 		try {
 			Scanner scanner = new Scanner(new File("SeverityIndex.txt"));
 			while (scanner.hasNextLine()) {
                 value = scanner.nextLine();
                 splitValues(value);
             }
             scanner.close();
         } catch (FileNotFoundException e) {
             e.printStackTrace();
         }
    	
    }

    //Following are setter functions for the attributes.
    public static void setnormalWeather(Double normalWeatherValue)
	{
		normalWeather = normalWeatherValue;
	}
    public static void setrainyWeather(Double rainyWeatherValue)
    {
        rainyWeather = rainyWeatherValue;
    }
    public static void setstormyWeather(Double stormyWeatherValue)
    {
        stormyWeather = stormyWeatherValue;
    }
    public static void setsnowyWeather(Double snowyWeatherValue)
    {
        snowyWeather = snowyWeatherValue;
    }
    public static void setfoggyWeather(Double foggyWeatherValue)
    {
        foggyWeather = foggyWeatherValue;
    }
    public static void setwindyWeather(Double windyWeatherValue)
    {
        windyWeather = windyWeatherValue;
    }
    public static void setunknownWeather(Double unknownWeatherValue)
    {
        unknownWeather = unknownWeatherValue;
    }
    public static void setsingleType(Double singleTypeValue)
    {
        singleType = singleTypeValue;
    }
    public static void setdualType(Double dualTypeValue)
    {
        dualType = dualTypeValue;
    }
    public static void setroundType(Double roundTypeValue)
    {
        roundType = roundTypeValue;
    }
    public static void setoneType(Double oneTypeValue)
    {
        oneType = oneTypeValue;
    }
    public static void setslipType(Double slipTypeValue)
    {
        slipType = slipTypeValue;
    }
    public static void setunknownType(Double unknownTypeValue)
    {
        unknownType = unknownTypeValue;
    }
    public static void setwetSurface(Double wetSurfaceValue)
    {
        wetSurface = wetSurfaceValue;
    }
    public static void setdrySurface(Double drySurfaceValue)
    {
        drySurface = drySurfaceValue;
    }
    public static void seticeSurface(Double iceSurfaceValue)
    {
        iceSurface = iceSurfaceValue;
    }
    public static void setsnowSurface(Double snowSurfaceValue)
    {
        snowSurface = snowSurfaceValue;
    }
    public static void setfloodSurface(Double floodSurfaceValue)
    {
        floodSurface = floodSurfaceValue;
    }
    public static void setunknownSurface(Double unknownSurfaceValue)
    {
        unknownSurface = unknownSurfaceValue;
    }
    public static void setdayLight(Double dayLightValue)
    {
        dayLight = dayLightValue;
    }
    public static void setnightVisibleLight(Double nightVisibleLightValue)
    {
        nightVisibleLight = nightVisibleLightValue;
    }
    public static void setnightInvisibleLight(Double nightInvisibleLightValue)
    {
        nightInvisibleLight = nightInvisibleLightValue;
    }
    public static void setdarkLight(Double darkLightValue)
    {
        darkLight = darkLightValue;
    }
    public static void setunknownLight(Double unknownLightValue)
	{
		unknownLight = unknownLightValue;
    }
    
    //Following are getter functions for attributes.
    public static Double getnormalWeather()
	{
		return normalWeather;
	}
    public static Double getrainyWeather()
    {
        return rainyWeather;
    }
    public static Double getstormyWeather()
    {
        return stormyWeather;
    }
    public static Double getsnowyWeather()
    {
        return snowyWeather;
    }
    public static Double getfoggyWeather()
    {
        return foggyWeather;
    }
    public static Double getwindyWeather()
    {
        return windyWeather;
    }
    public static Double getunknownWeather()
    {
        return unknownWeather;
    }
    public static Double getsingleType()
    {
        return singleType;
    }
    public static Double getdualType()
    {
        return dualType;
    }
    public static Double getroundType()
    {
        return roundType;
    }
    public static Double getoneType()
    {
        return oneType;
    }
    public static Double getslipType()
    {
        return slipType;
    }
    public static Double getunknownType()
    {
        return unknownType;
    }
    public static Double getwetSurface()
    {
        return wetSurface;
    }
    public static Double getdrySurface()
    {
        return drySurface;
    }
    public static Double geticeSurface()
    {
        return iceSurface;
    }
    public static Double getsnowSurface()
    {
        return snowSurface;
    }
    public static Double getfloodSurface()
    {
        return floodSurface;
    }
    public static Double getunknownSurface()
    {
        return unknownSurface;
    }
    public static Double getdayLight()
    {
        return dayLight;
    }
    public static Double getnightVisibleLight()
    {
        return nightVisibleLight;
    }
    public static Double getnightInvisibleLight()
    {
        return nightInvisibleLight;
    }
    public static Double getdarkLight()
    {
        return darkLight;
    }
    public static Double getunknownLight()
    {
        return unknownLight;
    }

    
    //Function takes the attribute and corresponding value and set the required attribute using setter function.
    public static void setValues(String attribute, Double val) {
        if (attribute.contains("Normal")) {
            setnormalWeather(val);
        } else if (attribute == "Rainy") {
            setrainyWeather(val);
        } else if (attribute == "Stormy") {
            setstormyWeather(val);
        } else if (attribute == "Windy") {
            setwindyWeather(val);
        } else if (attribute == "Snowy") {
            setsnowyWeather(val);
        } else if (attribute == "Foggy") {
            setfoggyWeather(val);
        } else if (attribute == "OtherWeather") {
            setunknownWeather(val);
        }

        else if (attribute == "Dry") {
            setdrySurface(val);
        } else if (attribute == "Wet") {
            setwetSurface(val);
        } else if (attribute == "Ice") {
            seticeSurface(val);
        } else if (attribute == "Snow") {
            setsnowSurface(val);
        }

        else if (attribute == "Day") {
            setdayLight(val);
        } else if (attribute == "Night with visibility") {
            setnightVisibleLight(val);
        } else if (attribute == "Nigh with low visibility") {
            setnightInvisibleLight(val);
        } else if (attribute == "Dark") {
            setdarkLight(val);
        } else if (attribute == "OtherLight") {
            setunknownLight(val);
        }
    }

    //Splits the text file line based on colon (:) and sends it to setValues function.
    public static void splitValues(String severityValue) {
        String[] severe;
        Double severity;
        String attribute;
        if (severityValue.contains(":")) {
            severe = severityValue.split(":");
            attribute = severe[0];
            severity = Double.parseDouble(severe[1]);
            // System.out.println(attribute);
            // System.out.println(severity);
            setValues(attribute, severity);
        }
    }




   
    //-------------------------------------------------------------------------------------------------------
    //Function to check if the serverity values are above threshold and return the
    //suggested decrement in speed by averaging on the recommended deductions for
    //each of the attributes.

    public double getRecommendation(form_sensorinput fobj)
    {
    	System.out.println("Recommend");
        Recommender recommend = new Recommender();
        
        //Invoke severity calculator for location
        
        SevCalculator sobj = new SevCalculator();
        Double locSeverity = (double) sobj.invokesevcalculator("LocSev",fobj.location);
        
        //System.out.println("Severity" + locSeverity);

        Double normalWeather = recommend.getnormalWeather();
        Double rainyWeather = recommend.getrainyWeather();
        Double stormyWeather = recommend.getstormyWeather();
        Double snowyWeather = recommend.getsnowyWeather();
        Double foggyWeather = recommend.getfoggyWeather();
        Double windyWeather = recommend.getwindyWeather();
        Double unknownWeather = recommend.getunknownWeather();

        Double singleType = recommend.getsingleType();
        Double dualType = recommend.getdualType();
        Double roundType = recommend.getroundType();
        Double oneType = recommend.getoneType();
        Double slipType = recommend.getslipType();
        Double unknownType = recommend.getunknownType();

        Double wetSurface = recommend.getwetSurface();
        Double drySurface = recommend.getdrySurface();
        Double iceSurface = recommend.geticeSurface();
        Double snowSurface = recommend.getsnowSurface();
        Double floodSurface = recommend.getfloodSurface();
        Double unknownSurface = recommend.getunknownSurface();

        Double dayLight = recommend.getdayLight();
        Double nightVisibleLight = recommend.getnightVisibleLight();
        Double nightInvisibleLight = recommend.getnightInvisibleLight();
        Double darkLight = recommend.getdarkLight();
        Double unknownLight = recommend.getunknownLight();

        double recommendation = 0.0;
        //Decided by averaging upon values.
        double threshold = 1.1;
        double sum = 0.0;
        ArrayList<Double> averages = new ArrayList<Double>();

        //The recommended deductions vary based upon attribute and are decided by following guidelines issued by government.

        if (normalWeather > threshold)
        {
            averages.add(0.25);
        }
        else if (rainyWeather > threshold)
        {
            averages.add(0.33);
        }
        else if (stormyWeather > threshold)
        {
            averages.add(0.40);
        }
        else if (snowyWeather > threshold)
        {
            averages.add(0.50);
        }
        else if (foggyWeather > threshold)
        {
            averages.add(0.40);
        }
        else if (windyWeather > threshold)
        {
            averages.add(0.25);
        }
        else if (unknownWeather > threshold)
        {
            averages.add(0.25);
        }

        else if (singleType > threshold)
        {
            averages.add(0.10);
        }
        else if (dualType > threshold)
        {
            averages.add(0.25);
        }
        else if (oneType > threshold)
        {
            averages.add(0.10);
        }
        else if (roundType > threshold)
        {
            averages.add(0.33);
        }
        else if (slipType > threshold)
        {
            averages.add(0.40);
        }
        else if (unknownType > threshold)
        {
            averages.add(0.25);
        }

        else if (wetSurface > threshold)
        {
            averages.add(0.33);
        }
        else if (drySurface > threshold)
        {
            averages.add(0.25);
        }
        else if (iceSurface > threshold)
        {
            averages.add(0.60);
        }
        else if (snowSurface > threshold)
        {
            averages.add(0.50);
        }
        else if (floodSurface > threshold)
        {
            averages.add(0.50);
        }
        else if (unknownSurface > threshold)
        {
            averages.add(0.25);
        }

        else if (dayLight > threshold)
        {
            averages.add(0.25);
        }
        else if (darkLight > threshold)
        {
            averages.add(0.40);
        }
        else if (nightInvisibleLight > threshold)
        {
            averages.add(0.50);
        }
        else if (nightVisibleLight > threshold)
        {
            averages.add(0.40);
        }
        else if (unknownLight > threshold)
        {
            averages.add(0.25);
        }
        
        else if(locSeverity > threshold)
        {
        	averages.add(0.30);
        }

        for (int i = 0; i < averages.size(); i++)
        {
            sum += averages.get(i);
        }

        recommendation = sum / (averages.size());

        return recommendation;
}

}