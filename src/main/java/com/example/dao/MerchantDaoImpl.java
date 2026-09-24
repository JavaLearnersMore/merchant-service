package com.example.dao;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.example.model.Merchant;
import com.example.model.MerchantUser;

@Repository
public class MerchantDaoImpl implements MerchantDao {

    private final JdbcTemplate jdbcTemplate;

    public MerchantDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Long saveMerchant(Merchant merchant) {

        String sql = "INSERT INTO merchant(legal_name,email,phone,pan_number,gst_number,settlement_account_id,kyc_status,status)VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
        PreparedStatement ps = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, merchant.getLegalName());
            ps.setString(2, merchant.getEmail());
            ps.setString(3, merchant.getPhone());
            ps.setString(4, merchant.getPanNumber());
            ps.setString(5, merchant.getGstNumber());
            ps.setString(6, merchant.getSettlementAccountId());
            ps.setString(7, "PENDING");
            ps.setString(8, "INACTIVE");

            return ps;

        }, keyHolder);

        return keyHolder.getKey().longValue();
    }

    @Override
    public void saveMerchantUser(MerchantUser user) {

        String sql = "INSERT INTO merchant_user(merchant_id,username,password_hash,role,active)VALUES (?, ?, ?, ?, ?) ";

        jdbcTemplate.update(sql,
                user.getMerchantId(),
                user.getUsername(),
                user.getPasswordHash(),
                user.getRole(),
                user.isActive()
        );
    }

    @Override
    public Merchant findById(Long id) {

        String sql = "SELECT id, legal_name, email, phone, pan_number, " +
                     "gst_number, settlement_account_id, kyc_status, status " +
                     "FROM merchant WHERE id = ?";

        List<Merchant> merchants = jdbcTemplate.query(
                sql,
                (rs, rowNum) -> {

                  Merchant merchant = new Merchant();
                  merchant.setId(rs.getLong("id"));
                  merchant.setLegalName(rs.getString("legal_name"));
                  merchant.setEmail(rs.getString("email"));
                  merchant.setPhone(rs.getString("phone"));
                  merchant.setPanNumber(rs.getString("pan_number"));
                  merchant.setGstNumber(rs.getString("gst_number"));
                  merchant.setSettlementAccountId(rs.getString("settlement_account_id"));
                  merchant.setKycStatus(rs.getString("kyc_status"));
                  merchant.setStatus(rs.getString("status"));

                    return merchant;
                },
                id
        );

        return merchants.isEmpty() ? null : merchants.get(0);
    }

    @Override
    public MerchantUser findUserByUsername(String username) {

        String sql = " SELECT id,merchant_id,username, password_hash, role, active FROM merchant_user WHERE username = ?";

        return jdbcTemplate.queryForObject(
                sql,
                (rs, rowNum) -> {

                    MerchantUser user = new MerchantUser();

                    user.setId(rs.getLong("id"));
                    user.setMerchantId(rs.getLong("merchant_id"));
                    user.setUsername(rs.getString("username"));
                    user.setPasswordHash(rs.getString("password_hash"));
                    user.setRole(rs.getString("role"));
                    user.setActive(rs.getBoolean("active"));

                    return user;
                },
                username
        );
    }
    
    
    @Override
    public void UpdatekycStatus(long merchantId,String kycStatus) {
    	
    	String sql="UPDATE merchant SET kyc_status = ? WHERE id =? ";
    	
    	jdbcTemplate.update(sql,kycStatus,merchantId);	
    	
    }
    
    @Override
    public void UpdateStatus(long merchantId,String status) {
    	
    	String sql="UPDATE merchant SET status =? WHERE id =?";
    	
    	jdbcTemplate.update(sql,status ,merchantId);
    	
    }
    
    @Override
    public void deleteMerchant(long merchantId) {
    	
    	String sql="DELETE FROM merchant WHERE id = ?";
    	
    	jdbcTemplate.update(sql,merchantId);
    }
    

}