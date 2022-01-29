package com.game.tic_tac_toe.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@ConditionalOnProperty(prefix = "spring.datasource", name = {"url"})
///@EnableJpaRepositories(
//        basePackages = "com.game.tic_tac_toe.repository",
//        entityManagerFactoryRef = "entityManager",
//        transactionManagerRef = "transactionManager"
//)
@RequiredArgsConstructor
public class DbConfiguration {
    private final DbConfig config;

    @Bean( destroyMethod = "close")
    public DataSource dataSource()
    {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl(config.getUrl());
        hikariConfig.setUsername(config.getUsername());
        hikariConfig.setPassword(config.getPassword());
        hikariConfig.setDriverClassName(config.getDriverClassName());
        return new HikariDataSource(hikariConfig);
    }
}
