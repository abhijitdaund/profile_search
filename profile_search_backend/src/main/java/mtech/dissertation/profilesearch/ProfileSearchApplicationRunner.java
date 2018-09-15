package mtech.dissertation.profilesearch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;

import mtech.dissertation.profilesearch.config.AppConfig;

/**
 * Spring boot main application to run HRMS application.
 * 
 * @author Abhijit.Daund
 */
@SpringBootApplication
// @EnableScheduling
@Import(AppConfig.class)
public class ProfileSearchApplicationRunner extends SpringBootServletInitializer {

    private static final Logger LOG = LoggerFactory.getLogger(ProfileSearchApplicationRunner.class);

    @Override
    protected SpringApplicationBuilder configure(final SpringApplicationBuilder application) {
        return application.sources(ProfileSearchApplicationRunner.class);
    }

    public static void main(final String[] args) {
        SpringApplication.run(ProfileSearchApplicationRunner.class, args);
        LOG.info("******************** ProfileSearch is up and Running ********************");
    }
}
