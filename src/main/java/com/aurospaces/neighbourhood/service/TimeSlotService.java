/**
 * 
 */
package com.aurospaces.neighbourhood.service;

import java.util.List;

import com.aurospaces.neighbourhood.bean.TimeSlotBean;

/**
 * @author Amit
 *
 */
public interface TimeSlotService {
	boolean insertTimeslot(TimeSlotBean objTimeSlotBean);
	boolean updateTimeslot(TimeSlotBean objTimeSlotBean);
	List<TimeSlotBean> getTimeslots(TimeSlotBean objTimeSlotBean, String likeSearch);
	TimeSlotBean getTimeslot(TimeSlotBean objTimeSlotBean, String likeSearch);
	boolean deleteTimeslot(TimeSlotBean objTimeSlotBean);
}
