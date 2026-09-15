package com.example.dao;

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
}
