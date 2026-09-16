package com.example.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.example.model.Merchant_Order;

@Repository
public class MerchantOrderDaoImpl implements MerchantOrderDao{
	
	private JdbcTemplate jdbcTemplate;
	
	public MerchantOrderDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate=jdbcTemplate;
	}
	
	@Override
	public void saveOrders(Merchant_Order merchant_order){
		
		String sql="INSERT INTO merchant_order(id,merchant_id,order_ref,amount,currency,status,customer_email,pg_txn_ref,created_at,updated_at) VALUES(?,?,?,?,?,?,?,?,?,?)";
		
		jdbcTemplate.update(sql,merchant_order.getId(),
				merchant_order.getMerchant_id(),
				merchant_order.getOrder_ref(),
				merchant_order.getAmount(),
				merchant_order.getCurrency(),
				merchant_order.getStatus(),
				merchant_order.getCustomer_email(),
				merchant_order.getPg_txn_ref(),
				merchant_order.getCreated_at(),
				merchant_order.getUpdated_at()
				);	
		
	}
	
	
	@Override
    public boolean existsByOrderRef(String orderRef) {

        String sql =
                "SELECT COUNT(*) FROM merchant_order WHERE order_ref = ?";

        Integer count = jdbcTemplate.queryForObject(
                sql,
                Integer.class,
                orderRef
        );

        return count != null && count > 0;
    }
	
	
	 @Override
	    public List<Merchant_Order> getMerchantOrderByMerchantId(long merchant_id) {

	        String sql =
	                "SELECT order_ref, merchant_id, amount, currency, " +
	                "status, customer_email, pg_txn_ref, " +
	                "created_at, updated_at " +
	                "FROM merchant_order " +
	                "WHERE merchant_id = ? " +
	                "ORDER BY created_at DESC";

	        return jdbcTemplate.query(
	                sql,
	                (rs, rowNum) -> {

	                    Merchant_Order order =
	                            new Merchant_Order();

	                    order.setOrder_ref(
	                            rs.getString("order_ref"));

	                    order.setMerchant_id(
	                            rs.getLong("merchant_id"));

	                    order.setAmount(
	                            rs.getDouble("amount"));

	                    order.setCurrency(
	                            rs.getString("currency"));

	                    order.setStatus(
	                            rs.getString("status"));

	                    order.setCustomer_email(
	                            rs.getString("customer_email"));

	                    order.setPg_txn_ref(
	                            rs.getString("pg_txn_ref"));

	                    if (rs.getTimestamp("created_at")
	                            != null) {

	                        order.setCreated_at(
	                                rs.getTimestamp("created_at")
	                                        .toLocalDateTime());
	                    }

	                    if (rs.getTimestamp("updated_at")
	                            != null) {

	                        order.setUpdated_at(
	                                rs.getTimestamp("updated_at")
	                                        .toLocalDateTime());
	                    }

	                    return order;
	                },
	                merchant_id
	        );
	    }
	}
