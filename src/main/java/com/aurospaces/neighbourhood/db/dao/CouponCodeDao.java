
package com.aurospaces.neighbourhood.db.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.aurospaces.neighbourhood.db.model.Coupon;
import com.aurospaces.neighbourhood.db.model.CouponCode;
import com.aurospaces.neighbourhood.util.MiscUtils;
import com.aurospaces.neighbourhood.db.basedao.BaseCouponCodeDao;
import com.aurospaces.neighbourhood.db.callback.KeyValueCallbackHandler;
@Repository(value = "couponCodeDao")
public class CouponCodeDao extends BaseCouponCodeDao
{
	@Autowired
	CouponDao couponDao;
	@Autowired
	JdbcTemplate jdbcTemplate;
	public static int couponLen = 8;

	public void generateCoupons(CouponCode inCode, int numberOfCoupons) {
		

		for (int i = 0; i < numberOfCoupons; i++) {
			StringBuilder theCoupon = new StringBuilder(inCode.getBaseCode());
			theCoupon.append(MiscUtils.generateRandomString(couponLen));

			Coupon cc = new Coupon();
			cc.setCouponCodeId(inCode.getId());
			cc.setCode(theCoupon.toString());
			try {
				couponDao.save(cc);
			} catch (Exception ex) // most likely (rare) duplicate code
									// generated
			{
				i--;
				ex.printStackTrace();
			}

		}

	}

	public List<CouponCode> getAll() {
		String sql = "select * from coupon_code cd , partner_code pc, coupon c where cd.id =  pc.coupon_code_id and cd.id = c.coupon_code_id   order by cd.updated_time desc";
		List<CouponCode> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<CouponCode>(CouponCode.class));
		return list;
	}
	
	public List<CouponCode> getAll(int partnerId) {
		String sql = "select * from coupon_code cd , partner_code pc, coupon c where cd.id =  pc.coupon_code_id and cd.id = c.coupon_code_id and partner_id = "+partnerId+" order by cd.updated_time desc;";
		List<CouponCode> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<CouponCode>(CouponCode.class));
		return list;
	}
	public Map<String,String> getPartners()
	{
		String query = "select id,email from partner";
		KeyValueCallbackHandler handler = new KeyValueCallbackHandler("id","email");
    jdbcTemplate.query(query,handler);
    System.out.println(handler);
    return handler.getResult();
  }
}
