package mtech.dissertation.profilesearch.config;

import javax.sql.DataSource;

import org.h2.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Class containing all development profiles and configurations.
 * 
 * @author Abhijit.Daund
 */
@Configuration
public class DevConfig {

    @Autowired
    private ApplicationProperties applicationProperties;

    // @Bean
    // @Profile("dev-h2")
    // public DataSource dataSource1() {
    // return DataSourceBuilder.create().driverClassName(Driver.class.getName())
    // .url("jdbc:h2:mem:profilesearch-apps;INIT=create schema if not exists
    // profilesearch;").build();
    // }

    @Bean
    @Profile("dev-h2")
    public DataSource dataSource1() {
        return DataSourceBuilder.create().driverClassName(Driver.class.getName())
                .url(applicationProperties.getSpringDatasourceURL())
                .username(applicationProperties.getSpringDatasourceUserName())
                .password(applicationProperties.getSpringDatasourcePassword()).build();
    }

    @Bean
    @Profile("dev-postgres-profilesearch")
    public DataSource dataSource2() {
        return DataSourceBuilder.create().driverClassName(org.postgresql.Driver.class.getName())
                .username(applicationProperties.getDatabaseUserName())
                .password(applicationProperties.getDatabasePassword()).url(applicationProperties.getDatabaseURL())
                .build();
    }
}
