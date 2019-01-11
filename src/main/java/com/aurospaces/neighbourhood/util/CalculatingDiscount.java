/**
 * 
 */
package com.aurospaces.neighbourhood.util;

import com.aurospaces.neighbourhood.bean.OrderBean;

/**
 * @author YOGI
 *
 */
public class CalculatingDiscount {
	private double getNetAmount(OrderBean objOrderBean){
		double totalDisc = 0.0;
		double totalAmt = 0.0;
		double totalNetAmt =0.0;
		try{
			if(objOrderBean != null){
				totalAmt =Double.parseDouble(objOrderBean.getTotalPrice());
				totalDisc = Double.parseDouble(objOrderBean.getTotalDiscount());
				if(totalAmt >0.0 && totalDisc >0.0){
					totalNetAmt = totalAmt - totalAmt * (totalDisc/100);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
		}
		return totalNetAmt;
	}
	public static void main(String k[]){
		OrderBean objBean = new OrderBean();
		objBean.setTotalPrice("1200");
		objBean.setTotalDiscount("10");
		CalculatingDiscount objCalculatingDiscount = new CalculatingDiscount();
		System.out.println(objCalculatingDiscount.getNetAmount(objBean));;
	}
}
