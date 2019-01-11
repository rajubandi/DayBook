
package com.aurospaces.neighbourhood.db.basedao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aurospaces.neighbourhood.db.model.ServiceUnitVendor;


public class BaseServiceUnitVendorDao{

@Autowired public JdbcTemplate jdbcTemplate;

 
	public final String INSERT_SQL = "INSERT INTO service_unit_vendor( created_time, updated_time, service_unit_id, vendor_id, price, discount, label, discount_price, final_price, coupon_discount) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"; 





	/* this should be conditional based on whether the id is present or not */
	@Transactional
	public void save(final ServiceUnitVendor serviceUnitVendor) 
	{
	if(serviceUnitVendor.getId() == 0)	{

	KeyHolder keyHolder = new GeneratedKeyHolder();
	int update = jdbcTemplate.update(
			new PreparedStatementCreator() {
					public PreparedStatement 
					createPreparedStatement(Connection connection) throws SQLException {
	
					if(serviceUnitVendor.getCreatedTime() == null)
					{
					serviceUnitVendor.setCreatedTime( new Date());
					}
					java.sql.Timestamp createdTime = 
						new java.sql.Timestamp(serviceUnitVendor.getCreatedTime().getTime()); 
							
					if(serviceUnitVendor.getUpdatedTime() == null)
					{
					serviceUnitVendor.setUpdatedTime( new Date());
					}
					java.sql.Timestamp updatedTime = 
						new java.sql.Timestamp(serviceUnitVendor.getUpdatedTime().getTime()); 
							
					PreparedStatement ps =
									connection.prepareStatement(INSERT_SQL,new String[]{"id"});
	ps.setTimestamp(1, createdTime);
ps.setTimestamp(2, updatedTime);
ps.setInt(3, serviceUnitVendor.getServiceUnitId());
ps.setInt(4, serviceUnitVendor.getVendorId());
ps.setBigDecimal(5, serviceUnitVendor.getPrice());
ps.setBigDecimal(6, serviceUnitVendor.getDiscount());
ps.setString(7, serviceUnitVendor.getLabel());
ps.setBigDecimal(8, serviceUnitVendor.getDiscountPrice());
ps.setBigDecimal(9, serviceUnitVendor.getFinalPrice());
ps.setInt(10, serviceUnitVendor.getCouponDiscount());

							return ps;
						}
				},
				keyHolder);
				
				Number unId = keyHolder.getKey();
				serviceUnitVendor.setId(unId.intValue());
				

		}
		else
		{

			String sql = "UPDATE service_unit_vendor  set service_unit_id = ? ,vendor_id = ? ,price = ? ,discount = ? ,label = ? ,discount_price = ? ,final_price = ? ,coupon_discount = ?  where id = ? ";
	
			jdbcTemplate.update(sql, new Object[]{serviceUnitVendor.getServiceUnitId(),serviceUnitVendor.getVendorId(),serviceUnitVendor.getPrice(),serviceUnitVendor.getDiscount(),serviceUnitVendor.getLabel(),serviceUnitVendor.getDiscountPrice(),serviceUnitVendor.getFinalPrice(),serviceUnitVendor.getCouponDiscount(),serviceUnitVendor.getId()});
		}
	}
		
		@Transactional
		public void delete(int id) {
			String sql = "DELETE FROM service_unit_vendor WHERE id=?";
			jdbcTemplate.update(sql, new Object[]{id});
		}
		

	 public ServiceUnitVendor getById(int id) {
			String sql = "SELECT * from service_unit_vendor where id = ? ";
			List<ServiceUnitVendor> retlist = jdbcTemplate.query(sql,
			new Object[]{id},
			ParameterizedBeanPropertyRowMapper.newInstance(ServiceUnitVendor.class));
			if(retlist.size() > 0)
				return retlist.get(0);
			return null;
		}

	

}
