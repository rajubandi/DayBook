package com.aurospaces.neighbourhood.util;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.GeocodingResult;

public class AddressValidation {
	
	////to work with
	String address;//done //done
	int validity;
	double coordinates[];//done //done
	String locationType;//done //done
	String localaddress;//done 
	double score=0.0;
public int getValidity()

{
	return this.validity;
}
	public void process(String addr,ServletContext objServletContext )
	{
		this.address=addr;

		try {
			String path =objServletContext.getRealPath("Resources"+File.separator);
			System.out.println("path===="+path);
			//String address_check=address.substring(address.indexOf(",")+1);
			String address_check=address;
			//fill this with api key
			GeoApiContext context = new GeoApiContext().setApiKey("AIzaSyAJHZ4losP64UC-kC7oAaHqRyH8EOuQEPY");
			GeocodingResult[] results;
			
			String addr_copy=address_check;
			results = GeocodingApi.geocode(context,
					addr_copy).await();

			//System.out.println("results length is "+results.length);
			int count=1;
			while(results.length==0)
			{

				if(count>3) break;
				addr_copy=addr_copy.substring(addr_copy.indexOf(",")+1);
				results = GeocodingApi.geocode(context,
						addr_copy).await();
				count++;

			}
			
			//System.out.println("processing address"+address);
				
			if(results.length>=1 )
			{
				 if(results[0].formattedAddress!=null && results[0].formattedAddress.toString().contains("India")  )
				{
					this.validity=1;
					if((results[0].geometry.locationType.toString()).equals("GEOMETRIC_CENTER"))
						this.localaddress=results[0].formattedAddress;
					else
						this.localaddress=this.address;

				}
				if((results[0].geometry.location)!=null)
				{
					//	System.out.println("coodinates in this are"+results[0].geometry.location);
					this.coordinates=new double[2];
					this.coordinates[0]=Double.parseDouble(results[0].geometry.location.toString().split(",")[0]);
					this.coordinates[1]=Double.parseDouble(results[0].geometry.location.toString().split(",")[1]);
				}
				if((results[0].geometry.locationType.toString()).length()!=0)
				{
					//System.out.println("type in this are"+results[0].geometry.locationType);
					this.locationType=results[0].geometry.locationType.toString();
				}
				this.score=1.0;
				if(results[0].addressComponents[0].types[0].toString().toLowerCase().equals("locality"))
				{
					this.validity=0;
				}
				if(results[0].addressComponents[0].types[0].toString().toLowerCase().equals("administrative_area_level_2"))
				{
					this.validity=0;
				}
				if(results[0].addressComponents[0].types[0].toString().toLowerCase().equals("administrative_area_level_1"))
				{
					this.validity=0;
				}
				if(results[0].addressComponents[0].types[0].toString().toLowerCase().equals("country"))
				{
					this.validity=0;
				}
				if(address_check.contains(",")&&address_check.split("[\\s,;\\n\\t]+").length<=2)
					this.validity=0;
				else if(address_check.split("\\s+").length<=2)
						this.validity=0;
			}

			else
			{
				this.localaddress=address;



				String csvFile = path+File.separator+"all_india_PO_list_without_APS_offices_ver2.csv";
				System.out.println("csvFile---"+csvFile);
				BufferedReader br = null;
				String line = "";
				String cvsSplitBy = ",";
				Map<String, ArrayList<String>> pincodemapping = new HashMap<String, ArrayList<String>>();
				Map<String, ArrayList<String>> districtmapping = new HashMap<String, ArrayList<String>>();

				try {

					br = new BufferedReader(new FileReader(csvFile));

					while ((line = br.readLine()) != null) {
						line=line.toLowerCase();
						// use comma as separator
						String[] country = line.split(cvsSplitBy);
						String pincode=country[1];
						// String division=country[4];
						String district=country[8];
						String state=country[9];

						// String 
						ArrayList<String> div_district_state = new ArrayList<String>();
						//  div_district_state.add(division);
						div_district_state.add(district);
						div_district_state.add(state);
						//   if(pincode=="382022" ) System.out.println(div_district_state);
						pincodemapping.put(pincode, div_district_state);
						//System.out.println(country[1] 
						//                +";"+ country[4] + ";"+country[8]+";"+country[9]);

					}



					// deciding between 0 and 2

					address = address.toLowerCase();
					Pattern zipPattern = Pattern.compile("(\\d{6})");
					Matcher zipMatcher = zipPattern.matcher(address);
					if (zipMatcher.find()) {
						score+=0.25;
						String zip = zipMatcher.group(1);
						ArrayList<String> div_district_state1=pincodemapping.get(zip);

						String district=div_district_state1.get(0);
						String state=div_district_state1.get(1);



						address = address.replaceAll("\\.", "");
						address=address.replaceAll("(?<=[a-z])-","");

						//  if(address.contains(state)) score+=0.1;
						if(address.contains(district)) score+=0.2;


						String [] addressparts;
						if(address.contains(","))
						addressparts=address.split(",");
						else
							addressparts=address.split("\\s+");	


						String regex = "(.)*(\\d)(.)*";   
						zipPattern = Pattern.compile(regex);
						Matcher matcher1 = zipPattern.matcher(addressparts[0]);
						Matcher matcher2 = zipPattern.matcher(addressparts[1]);
						boolean isMatched1 = matcher1.matches();
						boolean isMatched2 = matcher2.matches();


						if(isMatched1==true)
						{
							this.score+=0.2;
							// houseno=addressparts[0];
							//  address=address.replace(houseno, "");
							//   houseno = houseno.replace("no","");
							// houseno = houseno.replace("plot","");
							// houseno = houseno.replace("house","");
						}
						else if(isMatched2==true)
						{
							this.score+=0.2;
							//   houseno=addressparts[1];
							//address=address.replace(houseno, "");
							//   houseno = houseno.replace("no","");
							// houseno = houseno.replace("plot","");
							// houseno = houseno.replace("house","");
						}



						//checking for main ,sector
						int i;

						for(i=1;i<addressparts.length;i++)
						{

							address = address.replaceAll(",{2,}", ",");
							///////////take care of && matching
							if((addressparts[i].contains("block")||addressparts[i].contains("blk")))
							{

								this.score+=0.1;
							}


							else  if(addressparts[i].contains("sector"))
							{
								this.score+=0.1;
							}

							else  if(addressparts[i].contains(" road"))
							{
								this.score+=0.1;
							}
							else  if(addressparts[i].contains(" main"))
							{
								this.score+=0.1;
							}
							else  if(addressparts[i].contains(" cross"))
							{
								this.score+=0.1;
							}
							else  if(addressparts[i].contains("quarter")||addressparts[i].contains("qtr"))
							{
								this.score+=0.1;

							}
							else  if((addressparts[i].contains("plaza")||addressparts[i].contains("building")||addressparts[i].contains("school")||addressparts[i].contains("bhavan")||addressparts[i].contains("park")||addressparts[i].contains("tower")))
							{
								this.score+=0.1;

							}
							else if((addressparts[i].contains("nagar") ||addressparts[i].contains("lane")||addressparts[i].contains("street")))
							{
								if(addressparts[i].contains("nagar"))
								{
									int index=addressparts[i].indexOf("nagar");
									if( index-1 >= 0 && Character.isLetter(addressparts[i].charAt(index-1) ))
									{

									}
									else  if ( index+5 < addressparts[i].length() && Character.isLetter(addressparts[i].charAt(index+5) ))
									{

									}
									else
									{
										this.score+=0.1; 
									}

								}
								else
								{
									this.score+=0.1;  
								}

							}

							else if(addressparts[i].contains("po")||addressparts[i].contains("postoffice")||addressparts[i].contains("post"))
							{
								boolean matched=false;
								if(addressparts[i].contains("po")&&!addressparts[i].contains("post"))
								{
									String[] parts=addressparts[i].split("\\s+");
									int j;
									for(j=0;j<parts.length;j++)
									{
										if(parts[j].equals("po")||parts[j].equals("pobox"))
											matched=true;
									}


								}
								else
								{
									matched=true;
									score+=0.1;
								}
								if(matched==true)
								{

									this.score+=0.1;
								}
							}	   


							else if(addressparts[i].contains("area") ||addressparts[i].contains("layout") ||addressparts[i].contains("colony") ||addressparts[i].contains("avenue")||addressparts[i].contains("region"))
							{

								this.score+=0.1;
							}  	   
							else
							{

							}
						}///here


					}

					//	System.out.println(results[0].postcodeLocalities);
					//	System.out.println(results[0].addressComponents.);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(this.score>0.7)
					this.validity=2;
				else 
					this.validity=0;
			}//match else
			System.out.println("processed");
		}
		catch(Exception E)
		{
			E.printStackTrace();
		}
	}
}
