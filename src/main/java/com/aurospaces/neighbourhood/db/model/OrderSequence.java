
package com.aurospaces.neighbourhood.db.model;

import javax.persistence.Entity;
import com.aurospaces.neighbourhood.db.basemodel.BaseOrderSequence;

import java.util.List;
import java.util.ArrayList;
import com.aurospaces.neighbourhood.custommodel.OrderStatus;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Entity (name = "OrderSequence")
public class OrderSequence extends BaseOrderSequence
{


public List<OrderStatus> getSequence()
{
    ArrayList<OrderStatus> seq = new Gson().fromJson(this.getSequenceString(), new TypeToken<ArrayList<OrderStatus>>() {
		    }.getType());

	return seq;

}

}
