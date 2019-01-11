package com.aurospaces.neighbourhood.patent; 


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;
import java.util.Scanner;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.GeocodingResult;

public class GeoMain {

	static int diameter = 0;
	final static double pi = 3.1415;
	final static double earthRadiusKm = 6371.0;
	final static int UNITSIZE = 50;
	final static int CLUSTERSIZE = 10;

	//no problem
	public static int randInt(int min, int max) {

		Random rand = new Random();
		int randomNum = rand.nextInt((max - min) + 1) + min;
		return randomNum;
	}

	// decimal degrees to radians
	//no problem
	static double deg2rad(double deg) {
		return (deg * pi / 180);
	}

	// This function converts radians to decimal degrees
	//no problem
	static double rad2deg(double rad) {
		return (rad * 180 / pi);
	}

	// Using Haversine_formula
	//no problem
	static double Distance(GeoTag g1, GeoTag g2) {
		double lat1d = g1.x;
		double lon1d = g1.y;
		double lat2d = g2.x;
		double lon2d = g2.y;
		double lat1r, lon1r, lat2r, lon2r, u, v;
		lat1r = deg2rad(lat1d);
		lon1r = deg2rad(lon1d);
		lat2r = deg2rad(lat2d);
		lon2r = deg2rad(lon2d);
		u = Math.sin((lat2r - lat1r) / 2);
		v = Math.sin((lon2r - lon1r) / 2);
		return 2.0
				* earthRadiusKm
				* Math.asin(Math.sqrt(u * u + Math.cos(lat1r) * Math.cos(lat2r)
						* v * v));
	}

	//recursive function - list of units,no of cluster,?
	static ArrayList<cluster> find_neighbourhoods(ArrayList<unit> a, int k,
			Integer k_new) // k number of clusters
	{
		int asz = a.size();
		boolean[] visited = new boolean[a.size()];
		boolean change = false;
 
		 //no units visited so far
		for (int i = 0; i < asz; i++)
			visited[i] = false;

		double average = 0;
       
		//calculating average of the whole 
		for (int i = 0; i < asz; i++) {
			visited[i] = false;
			average += a.get(i).weightage;
		}

		average = average / k;

		ArrayList<cluster> clusters = new ArrayList<cluster>();// space for
																// childs

		// sort here
       
		//random center intialization - fixing k random centres choosing among units
		for (int i = 0; i < k; i++) {
			int random = randInt(0, asz - 1);
			clusters.add(new cluster());
			clusters.get(i).center_x = a.get(random).g.x;
			clusters.get(i).center_y = a.get(random).g.y;
		}

		int count = 1;
		int dynamic_bound = 1000;
		int visited_count = 0;
		int loops = 0;

		
		//now looping for 1000 times
		do {

			visited_count = 0;
			count = 1;
          //as bound on the closest distance being diamter
			while (count < diameter)// use diameter
			{
                //adding close ones to each cluster
				for (int i = 0; i < k; i++) 
				{
					int sum = 0;
					//see which among the units can be assigned to each cluster in order
					// and in increasing counts.
					//not assigning here but seeing the total sum if it was assigned
					for (int j = 0; j < asz; j++) 
					  {
						if (visited[j])
							continue;
						if (a.get(j).g.x < clusters.get(i).center_x + count
								&& a.get(j).g.y < clusters.get(i).center_y
										+ count) 
						{
							sum += a.get(j).weightage;
						}

					   }
					//here one cluster taken in order and see if sum of the possible in it
					// is less than 1.2 * average
                    //now actually add to all clusters
					if (clusters.get(i).weightage + sum <= 1.2 * average) 
					{

						for (int j = 0; j < asz - 1; j++)// improve by sorting
															// the points
						 {
							if (visited[j])
								continue;
							if ((a.get(j).g.x < (clusters.get(i).center_x + count))
									&& (a.get(j).g.y < (clusters.get(i).center_y + count))) 
							  {
								visited[j] = true;
								visited_count++;
								// update cluster fields..after inclusion of the
								// new point
								clusters.get(i).members.add(a.get(j));
								clusters.get(i).weightage += a.get(j).weightage;
								clusters.get(i).sumx += a.get(j).g.x;
								clusters.get(i).sumy += a.get(j).g.y;
								clusters.get(i).size += 1; //
							//	clusters.get(i).radius=count;
							  }

						 }

					}// if
				}//added to all clusters till here

				count++;
			}// end of while
			//NOTE till here all points are assigned to one of the random centres chosen intially and
			// the diameter of the cluster has increased throughout till earth diamter

			
			
			
			// cout<<"visited before fixing: "<<visited_count<<endl;
			
			
          //calculating min distance for each business point
		//and adding each business point to nearest cluster centre
			for (int j = 0; j < asz; j++) 
			{
				if (visited[j] == true)
					continue;
				double min = 1000000;
				int min_index = 0;
				for (int i = 0; i < k; i++) 
				{
					GeoTag tempgeo = new GeoTag();
					tempgeo.x = clusters.get(i).center_x;
					tempgeo.y = clusters.get(i).center_y;
					double x = Distance(a.get(j).g, tempgeo);
					if (x < min) 
					{
						min = x;
						min_index = i;
					}
				}
				visited[j] = true;
				visited_count++;
				
				//add each units to the nearest centre of the different clusters
				clusters.get(min_index).add(a.get(j));
				clusters.get(min_index).weightage += a.get(j).weightage;
				clusters.get(min_index).sumx += a.get(j).g.x;
				clusters.get(min_index).sumy += a.get(j).g.y;
				clusters.get(min_index).size += 1; //
			}

			//now on adding the other units to each cluster,the weight may exceed
			for (int i = 0; i < k; i++) 
			{
               //seeing if the cluster weight exceeds
				if (clusters.get(i).weightage > 1.5 * average) 
				{
					ArrayList<unit> a_new = new ArrayList<unit>();
					Iterator<unit> it = clusters.get(i).members.iterator();

					while (it.hasNext()) 
					{
						unit u = new unit();
						unit temp = it.next();
						u.g.x = temp.g.x;
						u.g.y = temp.g.y;
						u.weightage = temp.weightage;
						a_new.add(u);
					}

					Integer knew1 = 0;
					ArrayList<cluster> child_clusters;
					//find child cluster for weight exceeded ones
					child_clusters = find_neighbourhoods(a_new, 2, knew1);// check
                    //just add the basic cluster - the intial child
					if (knew1.intValue() > 1) {
						clusters.add(i, child_clusters.get(0));
					}
					//add other children clusters at end
					for (int j = 1; j < knew1; j++) {
						clusters.add(k, child_clusters.get(j));
						k++;
					}
				}

			}

			change = false;

			double centroid_x;
			double centroid_y;

			/*
			 * for(int i=0;i<CLUSTERSIZE;i++) {
			 * cout<<clusters[i].weightage<<endl; }
			 */
			
             //seeing if a cluster centre as changed after assigning to nearest random centres
			//set change to true
			for (int i = 0; i < k; i++) 
			{
				centroid_x = clusters.get(i).sumx/ (double) clusters.get(i).size;
				centroid_y = clusters.get(i).sumy/ (double) clusters.get(i).size;
				//see if centre of cluster has changed and set change to true
				if ((int) (Math.abs(centroid_x - clusters.get(i).center_x)) > 2
						|| (int) (Math.abs(centroid_x -  clusters.get(i).center_x)) > 2)
				{
					change = true;
				}
				clusters.get(i).center_x = centroid_x;
				clusters.get(i).center_y = centroid_y;
			}
			
			//loops > 3 ??

			if (change == false) // i.e no change in new centers
			{

				// see if centres are not changing and the weight is exceeding for any
				for (int i = 0; i < k; i++) 
				{
					if (clusters.get(i).weightage > 1.5 * average) 
					{
						ArrayList<unit> a_new = new ArrayList<unit>();
						Integer knew1 = 0;
						ArrayList<cluster> child_clusters;
						Iterator<unit> it = clusters.get(i).members.iterator();
						while (it.hasNext()) 
						{
							unit u = new unit();
							unit temp = it.next();
							u.g.x = temp.g.x;
							u.g.y = temp.g.y;
							u.weightage = temp.weightage;
							a_new.add(u);
						}
						child_clusters = find_neighbourhoods(a_new, 2, knew1);// check
						
						//again same thing
						if (knew1 > 1) 
						{
							clusters.add(i, child_clusters.get(0));
						}
						for (int j = 1; j < knew1; j++) 
						{
							clusters.add(k, child_clusters.get(j));
							k++;
						}
					}

				}

				k_new = k;
				break;
			}
			else 
			{

				for (int i = 0; i < k; i++) {
					clusters.get(i).sumx = 0;
					clusters.get(i).sumy = 0;
					clusters.get(i).weightage = 0;
					clusters.get(i).size = 0;
					
					clusters.get(i).clear();
					for (int j = 0; j < asz; j++)
						visited[j] = false;
				}

			}

			loops++;
		} while (loops < 100);

		return clusters;
	}

	//baapre function???
	//useless not doing


	//till here
	static ArrayList<unit> compute_distance_matrix(ArrayList<cluster> clusters,
			int index) // sets weightage for cunits as well
	{

		double[][] d = new double[ clusters.get(index).cunit_list.size()][clusters
				.get(index).bunit_list.size()];

		Iterator<unit> it;

		int min_x = 10000000;
		int max_x = -10000000;// set to double_max and double_min
		int min_y = 10000000;
		int max_y = -10000000;// set to double_max and double_min
		// { for random input
		it = clusters.get(index).members.iterator();
		while (it.hasNext()) 
		{
			unit tempunit = it.next();
			int temp = (int) tempunit.g.x;
			if (temp < min_x)
				min_x = temp;
			if (temp > max_x)
				max_x = temp;

			temp = (int) tempunit.g.y;
			if (temp < min_y)
				min_y = temp;
			if (temp > max_y)
				max_y = temp;
		}

		GeoTag tempgeo1 = new GeoTag(), tempgeo2 = new GeoTag();
		tempgeo1.x = min_x;
		tempgeo1.y = min_y;
		tempgeo2.x = max_x;
		tempgeo2.y = max_y;
		int cluster_diameter = (int) Distance(tempgeo1, tempgeo2);

		// }
		Iterator<unit> it1 = clusters.get(index).cunit_list.iterator();
		// for each customer in a cluster
		while (it1.hasNext()) 
		{
			unit temp1 = it1.next();
			Iterator<unit> it2 = clusters.get(index).bunit_list.iterator();
			
			int sum = 0;
			//for each business unit in a cluster
			while (it2.hasNext()) 
			{
				// d[it->no][it2->no]= GOOGLE_API(it->g,it2->g); Use API here or
				// collect datat from database
				unit temp2 = it2.next();
				int t = randInt(0, 1000000) % cluster_diameter;

		/**		if (temp1.subunits.size() != 0)
				{
					for (int j = 0; j < temp1.subunits.size(); j++)
					{
						temp1.subunits.get(j).weightage = temp1.subunits.get(j).no_flats
								* temp1.subunits.get(j).flat_cost;
					}
				}*/
				sum += t + temp2.weightage; // t ??
			}
			//customer weightage is all business units weight in tht cluster+flats* cost of the customer
			temp1.weightage += sum;// some function
			// sort(temp1.subunits.begin(), it1->subunits.end()
			// ,compare_weightage);
		/**	Collections.sort(temp1.subunits, new Comparator<unit>() {
				public int compare(unit a, unit b) {
					if (a.weightage <= b.weightage)
						return 0;
					else if (a.weightage > b.weightage)
						return 1;
					return 0;
				}
			});*/
		}
		
		Collections.sort((List<unit>)clusters.get(index).cunit_list,
				new Comparator<unit>() {
					public int compare(unit a, unit b) {
						if (a.weightage <= b.weightage)
							return 0;
						else if (a.weightage > b.weightage)
							return 1;
						return 0;
					}
				});
		return clusters.get(index).members;
	}

	
	
	public ArrayList<cluster> getCluster(ArrayList<unit> units) {
		ArrayList<cluster> clusters = new ArrayList<cluster>();
		

		int min_x = 1000000;
		int max_x = -1000000;// set to double_max and double_min
		int min_y = 1000000;
		int max_y = -1000000;// set to double_max and double_min
		Scanner in = new Scanner(System.in);
		
		
		for (int i = 0; i < units.size(); i++) 
		{
			
			//type
			
			GeoApiContext context = new GeoApiContext().setApiKey("AIzaSyAIOTKTSB1CAHRkjo9Tn_LcTEm-aizu0AI");
			GeocodingResult[] results=new GeocodingResult[10];
			
			
			
			
			try {
				results = GeocodingApi.geocode(context,
						units.get(i).address.substring(units.get(i).address.indexOf(",")+1)).await();


				String uloc;
				uloc=units.get(i).address.substring(units.get(i).address.indexOf(",")+1);
				int count=1;
				while(results.length==0)
				{
                    if(count>3) break;
					results= GeocodingApi.geocode(context,
							uloc.substring(uloc.indexOf(",")+1)).await();
					uloc=uloc.substring(uloc.indexOf(",")+1);
                   count++;
				}
				
				if(count>3) continue;
				if(!results[0].formattedAddress.contains("Karnataka")) continue;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//if(results.length==0) continue;
			
			units.get(i).g.x=Double.parseDouble(results[0].geometry.location.toString().split(",")[0]);
			units.get(i).g.y=Double.parseDouble(results[0].geometry.location.toString().split(",")[1]);
			
			//geographical x
		
			//if (random < min_x)
				//min_x = random;
//			if (random > max_x)
	//			max_x = random;
//
			
			//geographical y
		
			//if (random < min_y)
				//min_y = random;
		//	if (random > max_x)
			//	max_y = random;
            
			//flats,weightage,flat_cost
		//	units.get(i).weightage = 1;
			
		}
         //this function is useless
		//set_initial_weightage(a, UNITSIZE);

//		double average = 0;

	//	for (int i = 0; i < UNITSIZE; i++) {
		//	average += a.get(i).weightage;
	//	}

		//average = average / CLUSTERSIZE;

		GeoTag tempgeo1 = new GeoTag(), tempgeo2 = new GeoTag();
		tempgeo1.x = min_x;
		tempgeo1.y = min_y;
		tempgeo2.x = max_x;
		tempgeo2.y = max_y;
	//	diameter = (int) Distance(tempgeo1, tempgeo2);
		Integer final_cluster_sz = CLUSTERSIZE;
		//call here to find the differeent clusters
		clusters = find_neighbourhoods(units, CLUSTERSIZE, final_cluster_sz);

		

		int sum = 0, avg;
		int max = -1;
		int min = 1000000;
		int sz = 0;
		for (int j = 0; j < final_cluster_sz; j++) {
			if (clusters.get(j).size == 0)
				continue;
			sum += clusters.get(j).weightage;
			if (clusters.get(j).weightage > max)
				max = (int) clusters.get(j).weightage;
			if (clusters.get(j).weightage < min)
				min = (int) clusters.get(j).weightage;
			sz++;
		}

		// avg = sum/sz;
		//System.out.println("max: " + max + " avg: " + " bound: " + 1.5
			//	* average);
		System.out.println();
		int cunit_no = 0, bunit_no = 0;

		
		//till here clear!!
		Iterator<unit> it;
		for (int i = 0; i < clusters.size(); i++) {
			it = clusters.get(i).members.iterator();

			while (it.hasNext())
			{
				unit temp = it.next();
				if (temp.type == 0) 
				{
			//		temp.no = cunit_no;
					clusters.get(i).addAs_cunit(temp);
					cunit_no++;
				} else 
				{
				//	temp.no = bunit_no;
					clusters.get(i).addAs_bunit(temp);
					bunit_no++;
				}
			}
		}

		int count = 0;
	/*	for (int i = 0; i < final_cluster_sz; i++, count++) {
			System.out.println("CLUSTER " + count);
			it = clusters.get(i).cunit_list.iterator();
			while (it.hasNext()) {
				unit temp = it.next();
				System.out.println(temp.no + " " + temp.no_flats + " "
						+ temp.flat_cost);
			}
			{
				it = clusters.get(i).bunit_list.iterator();
				while (it.hasNext()) {
					unit temp = it.next();
					System.out.println(temp.no);
				}
			}
		}
   */
		Iterator<unit> tempit;
		ArrayList<unit> temp = new ArrayList<unit>();
/**
		p = 1;
	
		for (int i = 0; i <CLUSTERSIZE; i++) 
		{

			if (clusters.get(i).size == 0)
				continue;
			temp = compute_distance_matrix(clusters, i);

			System.out.println("CLUSTER " + p + ":");

			tempit = temp.iterator();

			while (tempit.hasNext()) 
			{
				unit temp1 = tempit.next();
			/**	if (temp1.subunits.size() != 0) 
				{
					System.out.println("(" + temp1.subunits.get(0).g.x + ","
							+ temp1.subunits.get(0).g.y + ")" + " "
							+ temp1.weightage);
				}
				*/
		/**
				System.out.println("(" + temp1.g.x + "," + temp1.g.y + "#"+temp1.type+")"
						+ " " + temp1.weightage);
			}

			p++;
		}
*/
		
		clusters=find_radius(clusters);
		return clusters;
	}

	private ArrayList<cluster> find_radius(ArrayList<cluster> clusters) {
		// TODO Auto-generated method stub
		
		for (int i = 0; i < clusters.size(); i++) {
			Iterator<unit> it = clusters.get(i).members.iterator();
            double min=1;
            GeoTag g=new GeoTag();
            g.x=clusters.get(i).center_x;
            g.y=clusters.get(i).center_y;
			while (it.hasNext())
			{
				unit temp = it.next();
				
				if(Distance(temp.g,g)>min)
					min=Distance(temp.g,g);
			}
			clusters.get(i).radius=min;
		}
		
		return clusters;
	}

	public GeoTag getAddr(String address)
	{
			if(address == null)
				return null;
					
			System.out.println("ADDRESS : " + address);
			GeoApiContext context = new GeoApiContext().setApiKey("AIzaSyAJHZ4losP64UC-kC7oAaHqRyH8EOuQEPY");
		
			try {
			GeocodingResult[] results =  GeocodingApi.geocode(context, address).await();

				int count=1;
				while(results.length==0)
				{
						if(count>5) break;
							int indexOf  = address.indexOf(",");
						if(indexOf == -1 ) indexOf=address.indexOf(' ');

						address = address.substring(indexOf +1 );
						results= GeocodingApi.geocode(context,
							address).await();
                   count++;
				}

		if(results.length != 0)
		{
		GeoTag geotag = new GeoTag();
		
		geotag.x = Double.parseDouble(results[0].geometry.location.toString().split(",")[0]);
			geotag.y = Double.parseDouble(results[0].geometry.location.toString().split(",")[1]);
			return geotag;
		}
	}
	catch(Exception ex)
	{
			ex.printStackTrace();
	}
		return null;
	}

}


//function to take an address and convert it to lattitude and longitude
