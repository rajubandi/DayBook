package com.aurospaces.neighbourhood.patent; 
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class TestClusterAssignment {

	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		ArrayList<unit> units=new ArrayList<unit>();
		
		
	    JSONParser parser=new JSONParser();
		JSONArray a = (JSONArray) parser.parse(new FileReader("customers.js"));
        
		  for (Object o : a)
		  {
			  
			  
			  unit u=new unit();
		    JSONObject vendor = (JSONObject) o;		   

		    String cust_addr = (String) vendor.get("address1");
		    System.out.println();
		    u.address=cust_addr;
		    u.type=1;
		    System.out.println("customer address is "+cust_addr);
		    String service = (String) vendor.get("serviceName");
		    u.service=service;
		    System.out.println("customer wants service "+service);
			
			
			units.add(u);
			
			
		  }
		  units=getVendorsList(units);
		  
		  GeoMain m=new GeoMain();
		  ArrayList<cluster>clusters = m.getCluster(units);
		  
		  
		  int p = 1;
			Iterator<unit> it;

			for (int i = 0; i < clusters.size(); i++) {
				if (clusters.get(i).size == 0)
					continue;
				System.out.println("CLUSTER " + (p) + ": center ("
						+ clusters.get(i).center_x + "," + clusters.get(i).center_y
						+ ")");
				it = clusters.get(i).members.iterator();
				while (it.hasNext()) {
					unit temp = (it).next();
					System.out.print("(" + ((temp).g.x) + "," + (temp.g.y) + ")"
							+ ", ");
				}
				System.out.println();
				p++;
			}

			System.out.println("FINAL CLUSTER WEIGHTS");

			for (int i = 0; i < clusters.size(); i++) {
				if (clusters.get(i).size == 0)
					continue;
				System.out.println(clusters.get(i).weightage);
			
			
			
			try {
				URL url = new URL("http://maps.googleapis.com/maps/api/geocode/json?latlng="+clusters.get(i).center_x+","+clusters.get(i).center_y+"&sensor=true");
				// making connection
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("GET");
				conn.setRequestProperty("Accept", "application/json");
				if (conn.getResponseCode() != 200) {
					throw new RuntimeException("Failed : HTTP error code : "
							+ conn.getResponseCode());
				}

				// Reading data's from url
			   BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));

				String output;
				String out="";
				System.out.println("Output from Server .... \n");
				while ((output = br.readLine()) != null) {
					//System.out.println(output);
					out+=output;
				}
				System.out.println("^^^^^^^^^^^^^^^");
				System.out.println("cluster center is "+clusters.get(i).center_x+"   "+clusters.get(i).center_y);
				System.out.println("radius of cluster is "+clusters.get(i).radius);
				System.out.println("out is "+out.substring(out.indexOf("formatted_address"),out.indexOf("geometry")));
				System.out.println("out is "+out.substring(out.indexOf("location"),out.indexOf("location_type")));
			
				// Converting Json formatted string into JSON object
				
				}
			catch(Exception E)
			{
				
			}
				
				
			}		
	}
	
	public static ArrayList<unit> getVendorsList(ArrayList<unit> units) throws Exception
	{
		
		JSONParser parser = new JSONParser();
		JSONArray a = (JSONArray) parser.parse(new FileReader("v1.js"));

		  for (Object o : a)
		  {
		    JSONObject vendor = (JSONObject) o;
		    unit u=new unit();
		    String name = (String) vendor.get("firstName");
		    u.name=name;
		 //   System.out.println(name);
		    String service = (String) vendor.get("serviceName");
		    u.service=service;
		  //  System.out.println(service);
		    String address = (String) vendor.get("address1");
		    u.address=address;
		   // System.out.println(address);
		   
		   
		  //  Random r =new Random();
		//    v.preference=r.nextDouble();
		    units.add(u);
		  }
		  return units;
	}
}
