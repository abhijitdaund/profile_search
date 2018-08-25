package mtech.dissertation.profilesearch.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Class containing all application configuration.
 * 
 * @author Abhijit.Daund
 */
@Configuration
@ComponentScan(basePackageClasses = { mtech.dissertation.profilesearch.exception.PackageInfo.class,
        mtech.dissertation.profilesearch.rest.PackageInfo.class,
        mtech.dissertation.profilesearch.config.PackageInfo.class,
        mtech.dissertation.profilesearch.dto.mapper.PackageInfo.class })
@EnableJpaRepositories(basePackageClasses = { mtech.dissertation.profilesearch.repository.PackageInfo.class })
@EntityScan(basePackageClasses = { mtech.dissertation.profilesearch.entity.PackageInfo.class })
@PropertySource("classpath:application.properties")
public class AppConfig {

}
