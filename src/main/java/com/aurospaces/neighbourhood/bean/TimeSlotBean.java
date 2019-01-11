/**
 * 
 */
package com.aurospaces.neighbourhood.bean;

import org.springframework.stereotype.Component;

/**
 * @author kanojia
 *
 */
@Component
public class TimeSlotBean {
	private String slotId;
	private String slotLabel;
	private String slotDesc;
	private String sMsg;
	private String hour;
	
	
	public String getHour() {
		return hour;
	}
	public void setHour(String hour) {
		this.hour = hour;
	}
	public String getsMsg() {
		return sMsg;
	}
	public void setsMsg(String sMsg) {
		this.sMsg = sMsg;
	}
	public String getSlotId() {
		return slotId;
	}
	public void setSlotId(String slotId) {
		this.slotId = slotId;
	}
	public String getSlotLabel() {
		return slotLabel;
	}
	public void setSlotLabel(String slotLabel) {
		this.slotLabel = slotLabel;
	}
	public String getSlotDesc() {
		return slotDesc;
	}
	public void setSlotDesc(String slotDesc) {
		this.slotDesc = slotDesc;
	}
	
	

}
