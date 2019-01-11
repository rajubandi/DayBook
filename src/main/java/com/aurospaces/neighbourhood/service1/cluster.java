package com.aurospaces.neighbourhood.service1;

import java.util.ArrayList;

import com.aurospaces.neighbourhood.db.model.Vendor1;


public class cluster {

	double center_x;
	double center_y;
	double sumx;
	double sumy;
	double radius;
	int size;
	double weightage;

        int default_pest_control_id=-1;
	int default_plumber_id=-1;
	int default_electrician_id=-1;
	int default_carpenter_id=-1;
	int default_pathology_id=-1;
	int default_physio_id=-1;
	int default_petcare_id=-1;
	int default_nursing_id=-1;
	int core_category_count=0;

	ArrayList<Vendor1> members;
	ArrayList<Vendor1> cunit_list;
	ArrayList<Vendor1> bunit_list; 
    cluster()
    {
    	center_x = 0;
    	center_y = 0;
    	sumx=0;sumy=0;size=0;
    	members= new ArrayList<Vendor1>();
    	cunit_list= new ArrayList<Vendor1>();
    	bunit_list= new ArrayList<Vendor1>();
    }
	void add(Vendor1 a)
	{
		members.add(a);
		return;
	}	

	void addAs_cunit(Vendor1 a)
	{
	//	cunit_list.add(a);
	//return;
	}

	void addAs_bunit(Vendor1 a)
	{
	bunit_list.add(a);
	return;
	}

	void clear()
	{
		members.clear();
		return;
	}
}

