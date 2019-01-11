
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

import com.aurospaces.neighbourhood.db.model.Vendor1;


public class BaseVendor1Dao{

@Autowired public JdbcTemplate jdbcTemplate;

 
	public final String INSERT_SQL = "INSERT INTO vendor1( created_time, updated_time, old_id, first_name, last_name, father_name, gender, date_of_birth, education, languages_known, address, city, pin, state, land_mark, pan_number, mobile_number, reference_number, email, native_state, photograph, id_proof, address_proof, parent_category1, parent_category2, sub_category1, sub_category2, qualification, certifications, company, employees, portfolio_files, video_files, mou, commercials, serving_country, serving_state, serving_city, serving_location, accholder_name, account_number, bank_name, ifsc_code, branch_name, latitude, longitude, cluster_id, map_icon, weightage, preference, password) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"; 





	/* this should be conditional based on whether the id is present or not */
	@Transactional
	public void save(final Vendor1 vendor1) 
	{
	if(vendor1.getId() == 0)	{

	KeyHolder keyHolder = new GeneratedKeyHolder();
	int update = jdbcTemplate.update(
			new PreparedStatementCreator() {
					public PreparedStatement 
					createPreparedStatement(Connection connection) throws SQLException {
	
					if(vendor1.getCreatedTime() == null)
					{
					vendor1.setCreatedTime( new Date());
					}
					java.sql.Timestamp createdTime = 
						new java.sql.Timestamp(vendor1.getCreatedTime().getTime()); 
							
					if(vendor1.getUpdatedTime() == null)
					{
					vendor1.setUpdatedTime( new Date());
					}
					java.sql.Timestamp updatedTime = 
						new java.sql.Timestamp(vendor1.getUpdatedTime().getTime()); 
							
					if(vendor1.getDateOfBirth() == null)
					{
					vendor1.setDateOfBirth( new Date());
					}
					java.sql.Timestamp dateOfBirth = 
						new java.sql.Timestamp(vendor1.getDateOfBirth().getTime()); 
							
					PreparedStatement ps =
									connection.prepareStatement(INSERT_SQL,new String[]{"id"});
	ps.setTimestamp(1, createdTime);
ps.setTimestamp(2, updatedTime);
ps.setString(3, vendor1.getOldId());
ps.setString(4, vendor1.getFirstName());
ps.setString(5, vendor1.getLastName());
ps.setString(6, vendor1.getFatherName());
ps.setString(7, vendor1.getGender());
ps.setTimestamp(8, dateOfBirth);
ps.setString(9, vendor1.getEducation());
ps.setString(10, vendor1.getLanguagesKnown());
ps.setString(11, vendor1.getAddress());
ps.setString(12, vendor1.getCity());
ps.setString(13, vendor1.getPin());
ps.setString(14, vendor1.getState());
ps.setString(15, vendor1.getLandMark());
ps.setString(16, vendor1.getPanNumber());
ps.setString(17, vendor1.getMobileNumber());
ps.setString(18, vendor1.getReferenceNumber());
ps.setString(19, vendor1.getEmail());
ps.setString(20, vendor1.getNativeState());
ps.setString(21, vendor1.getPhotograph());
ps.setString(22, vendor1.getIdProof());
ps.setString(23, vendor1.getAddressProof());
ps.setString(24, vendor1.getParentCategory1());
ps.setString(25, vendor1.getParentCategory2());
ps.setString(26, vendor1.getSubCategory1());
ps.setString(27, vendor1.getSubCategory2());
ps.setString(28, vendor1.getQualification());
ps.setString(29, vendor1.getCertifications());
ps.setString(30, vendor1.getCompany());
ps.setString(31, vendor1.getEmployees());
ps.setString(32, vendor1.getPortfolioFiles());
ps.setString(33, vendor1.getVideoFiles());
ps.setString(34, vendor1.getMou());
ps.setString(35, vendor1.getCommercials());
ps.setString(36, vendor1.getServingCountry());
ps.setString(37, vendor1.getServingState());
ps.setInt(38, vendor1.getServingCity());
ps.setString(39, vendor1.getServingLocation());
ps.setString(40, vendor1.getAccholderName());
ps.setString(41, vendor1.getAccountNumber());
ps.setString(42, vendor1.getBankName());
ps.setString(43, vendor1.getIfscCode());
ps.setString(44, vendor1.getBranchName());
ps.setDouble(45, vendor1.getLatitude());
ps.setDouble(46, vendor1.getLongitude());
ps.setInt(47, vendor1.getClusterId());
ps.setString(48, vendor1.getMapIcon());
ps.setDouble(49, vendor1.getWeightage());
ps.setDouble(50, vendor1.getPreference());
ps.setString(51, vendor1.getPassword());

							return ps;
						}
				},
				keyHolder);
				
				Number unId = keyHolder.getKey();
				vendor1.setId(unId.intValue());
				System.out.println("vendor sucess save");
		}
		else
		{

			String sql = "UPDATE vendor1  set old_id = ? ,first_name = ? ,last_name = ? ,father_name = ? ,gender = ? ,date_of_birth = ? ,education = ? ,languages_known = ? ,address = ? ,city = ? ,pin = ? ,state = ? ,land_mark = ? ,pan_number = ? ,mobile_number = ? ,reference_number = ? ,email = ? ,native_state = ? ,photograph = ? ,id_proof = ? ,address_proof = ? ,parent_category1 = ? ,parent_category2 = ? ,sub_category1 = ? ,sub_category2 = ? ,qualification = ? ,certifications = ? ,company = ? ,employees = ? ,portfolio_files = ? ,video_files = ? ,mou = ? ,commercials = ? ,serving_country = ? ,serving_state = ? ,serving_city = ? ,serving_location = ? ,accholder_name = ? ,account_number = ? ,bank_name = ? ,ifsc_code = ? ,branch_name = ? ,latitude = ? ,longitude = ? ,cluster_id = ? ,map_icon = ? ,weightage = ? ,preference = ? ,password = ?  where id = ? ";
	
			jdbcTemplate.update(sql, new Object[]{vendor1.getOldId(),vendor1.getFirstName(),vendor1.getLastName(),vendor1.getFatherName(),vendor1.getGender(),vendor1.getDateOfBirth(),vendor1.getEducation(),vendor1.getLanguagesKnown(),vendor1.getAddress(),vendor1.getCity(),vendor1.getPin(),vendor1.getState(),vendor1.getLandMark(),vendor1.getPanNumber(),vendor1.getMobileNumber(),vendor1.getReferenceNumber(),vendor1.getEmail(),vendor1.getNativeState(),vendor1.getPhotograph(),vendor1.getIdProof(),vendor1.getAddressProof(),vendor1.getParentCategory1(),vendor1.getParentCategory2(),vendor1.getSubCategory1(),vendor1.getSubCategory2(),vendor1.getQualification(),vendor1.getCertifications(),vendor1.getCompany(),vendor1.getEmployees(),vendor1.getPortfolioFiles(),vendor1.getVideoFiles(),vendor1.getMou(),vendor1.getCommercials(),vendor1.getServingCountry(),vendor1.getServingState(),vendor1.getServingCity(),vendor1.getServingLocation(),vendor1.getAccholderName(),vendor1.getAccountNumber(),vendor1.getBankName(),vendor1.getIfscCode(),vendor1.getBranchName(),vendor1.getLatitude(),vendor1.getLongitude(),vendor1.getClusterId(),vendor1.getMapIcon(),vendor1.getWeightage(),vendor1.getPreference(),vendor1.getPassword(),vendor1.getId()});
		}
	}
		
		@Transactional
		public void delete(int id) {
			String sql = "DELETE FROM vendor1 WHERE id=?";
			jdbcTemplate.update(sql, new Object[]{id});
		}
		

	 public Vendor1 getById(int id) {
			String sql = "SELECT * from vendor1 where id = ? ";
			List<Vendor1> retlist = jdbcTemplate.query(sql,
			new Object[]{id},
			ParameterizedBeanPropertyRowMapper.newInstance(Vendor1.class));
			if(retlist.size() > 0)
				return retlist.get(0);
			return null;
		}

	

}
