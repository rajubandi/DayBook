
package com.aurospaces.neighbourhood.db.basedao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.transaction.annotation.Transactional;

import com.aurospaces.neighbourhood.bean.ClassBean;


public class BaseClassCreationDao{

@Autowired public JdbcTemplate jdbcTemplate;

 
	public final String INSERT_SQL = "INSERT INTO classcreation( created_time, updated_time, boardId, mediamId, className,section,admissionFee,tutionFee,transportationFee,hostelFee,stationaryFee ,fee,termOne,termTwo,termThree) values (?, ?, ?, ?,?, ?, ?, ?, ?,?,?,?,?,?,?)"; 





	/* this should be conditional based on whether the id is present or not */
	@Transactional
	public void save(final ClassBean objClassBean) 
	{
	if(objClassBean.getId() == 0)	{

	KeyHolder keyHolder = new GeneratedKeyHolder();
	int update = jdbcTemplate.update(
			new PreparedStatementCreator() {
					public PreparedStatement 
					createPreparedStatement(Connection connection) throws SQLException {
	
					if(objClassBean.getCreatedTime() == null)
					{
					objClassBean.setCreatedTime( new Date());
					}
					java.sql.Timestamp createdTime = 
						new java.sql.Timestamp(objClassBean.getCreatedTime().getTime()); 
							
					if(objClassBean.getUpdatedTime() == null)
					{
					objClassBean.setUpdatedTime( new Date());
					}
					java.sql.Timestamp updatedTime = 
						new java.sql.Timestamp(objClassBean.getUpdatedTime().getTime()); 
							
					PreparedStatement ps =
									connection.prepareStatement(INSERT_SQL,new String[]{"id"});
									ps.setTimestamp(1, createdTime);
									ps.setTimestamp(2, updatedTime);
									ps.setString(3, objClassBean.getBoardId());
									ps.setString(4, objClassBean.getMediumId());
									ps.setString(5, objClassBean.getClassName());
									ps.setString(6, objClassBean.getSection());
									ps.setDouble(7, objClassBean.getAdmissionFee());
									ps.setDouble(8, objClassBean.getTutionFee());
									ps.setDouble(9, objClassBean.getTransportationFee());
									ps.setDouble(10, objClassBean.getHostelFee());
									ps.setDouble(11, objClassBean.getStationaryFee());
									ps.setDouble(12, objClassBean.getFee());
									ps.setDouble(13, objClassBean.getTermOne());
									ps.setDouble(14, objClassBean.getTermTwo());
									ps.setDouble(15, objClassBean.getTermThree());

							return ps;
						}
				},
				keyHolder);
				
				Number unId = keyHolder.getKey();
				objClassBean.setId(unId.intValue());
				

		}
		else
		{

			String sql = "UPDATE classcreation  set boardId = ? ,mediamId = ? ,className = ?,section=?, admissionFee = ?, tutionFee = ?, transportationFee = ?, hostelFee= ?, stationaryFee = ?,fee=?,termOne=?,termTwo=?,termThree=?  where id = ? ";
	
			jdbcTemplate.update(sql, new Object[]{objClassBean.getBoardId(),objClassBean.getMediumId(),objClassBean.getClassName(),objClassBean.getSection(),objClassBean.getAdmissionFee(),objClassBean.getTutionFee(),objClassBean.getTransportationFee(),objClassBean.getHostelFee(),objClassBean.getStationaryFee(),objClassBean.getFee(),objClassBean.getTermOne(),objClassBean.getTermTwo(),objClassBean.getTermThree(),objClassBean.getId()});
		}
	}
		
		@Transactional
		public void delete(int id) {
			String sql = "DELETE FROM classcreation WHERE id=?";
			jdbcTemplate.update(sql, new Object[]{id});
		}
		

	/* public AdminDiscount getById(int id) {
			String sql = "SELECT * from classcreation where id = ? ";
			List<AdminDiscount> retlist = jdbcTemplate.query(sql,
			new Object[]{id},
			ParameterizedBeanPropertyRowMapper.newInstance(AdminDiscount.class));
			if(retlist.size() > 0)
				return retlist.get(0);
			return null;
		}
*/
	

}
