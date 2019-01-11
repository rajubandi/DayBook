package com.aurospaces.neighbourhood.db.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.aurospaces.neighbourhood.db.basedao.BaseClientTransactionsDao;
import com.aurospaces.neighbourhood.db.callback.RowValueCallbackHandler;

@Repository(value = "clientTransactionsDao")
public class ClientTransactionsDao extends BaseClientTransactionsDao {

	public List<Map<String, String>> getClientTransaction() {
		String query = "SELECT DATE(ct.transaction_date) as transactionDate, ct.id as id,ct.`ac_number` as acountNumber,ct.`client_id` as achountHolderName,ct.`bank_name` as bankName,ct.`branch_name` as branchName,ct.`ifsc_code` as ifscCode,ct.`amount` as amount,u.name as clientName FROM `client_transactions` ct ,users u where ct.client_id=u.id";
		RowValueCallbackHandler handler = new RowValueCallbackHandler(
				new String[] { "transactionDate", "id", "acountNumber",
						"achountHolderName", "bankName", "branchName",
						"ifscCode", "amount", "clientName" });
		jdbcTemplate.query(query, handler);
		return handler.getResult();
	}
}
