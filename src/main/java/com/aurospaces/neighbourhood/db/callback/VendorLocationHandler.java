package com.aurospaces.neighbourhood.db.callback;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import org.springframework.jdbc.core.RowCallbackHandler;

import com.aurospaces.neighbourhood.custommodel.VendorLocation;



public class VendorLocationHandler implements RowCallbackHandler
{

	public List<VendorLocation> returnlist;


	public VendorLocationHandler()
	{
		returnlist = new ArrayList<VendorLocation>();
	}	


	public List<VendorLocation> getList() {

	return returnlist;

	}



public void processRow(ResultSet rs) throws SQLException 
{
	
	VendorLocation vl = new VendorLocation();

	vl.id = rs.getInt("id");
	vl.name = rs.getString("name");
	vl.latitude = rs.getDouble("latitude");
	vl.longitude = rs.getDouble("longitude");
	returnlist.add(vl);

}
	
}
