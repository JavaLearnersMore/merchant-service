package com.example.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.model.WebhookConfig;

@Repository
public class WebhookConfigDaoImpl implements WebhookConfigDao {

    private final JdbcTemplate jdbcTemplate;

    public WebhookConfigDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public WebhookConfig findByMerchantId(Long merchantId) {

        String sql =
                "SELECT id, merchant_id, url, secret, active " +
                "FROM webhook_config " +
                "WHERE merchant_id = ?";

        List<WebhookConfig> configs = jdbcTemplate.query(
                sql,
                (rs, rowNum) -> {

                    WebhookConfig config = new WebhookConfig();

                    config.setId(rs.getLong("id"));
                    config.setMerchantId(rs.getLong("merchant_id"));
                    config.setUrl(rs.getString("url"));
                    config.setSecret(rs.getString("secret"));
                    config.setActive(rs.getBoolean("active"));
                    return config;
                },
                merchantId
        );

        return configs.isEmpty() ? null : configs.get(0);
    }

    @Override
    public void save(WebhookConfig webhookConfig) {

        String sql =
                "INSERT INTO webhook_config " +
                "(merchant_id, url, secret, active) " +
                "VALUES (?, ?, ?, ?)";

        jdbcTemplate.update(
                sql,
                webhookConfig.getMerchantId(),
                webhookConfig.getUrl(),
                webhookConfig.getSecret(),
                webhookConfig.isActive()
        );
    }

    @Override
    public void update(WebhookConfig webhookConfig) {

        String sql =
                "UPDATE webhook_config " +
                "SET url = ?, active = ? " +
                "WHERE merchant_id = ?";

        jdbcTemplate.update(
                sql,
                webhookConfig.getUrl(),
                webhookConfig.isActive(),
                webhookConfig.getMerchantId()
        );
    }
}