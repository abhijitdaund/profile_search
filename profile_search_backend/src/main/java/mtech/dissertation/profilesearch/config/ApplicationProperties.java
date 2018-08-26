package mtech.dissertation.profilesearch.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Class to hold application properties.
 * 
 * @author Abhijit.Daund
 */
@Component
@PropertySource("classpath:application.properties")
public class ApplicationProperties {

    @Value("${database.username}")
    private String databaseUserName;

    @Value("${database.password}")
    private String databasePassword;

    @Value("${database.url}")
    private String databaseURL;

    @Value("${server.contextPath}")
    private String serverContextPath;

    @Value("${server.port}")
    private String serverPort;

    @Value("${profilesearch.frontend.deployed.path}")
    private String profileSearchFrontendDeployedPath;

    @Value("${profilesearch.backend.deployed.path}")
    private String profileSearchBackendDeployedPath;

    @Value("${spring.datasource.url}")
    private String springDatasourceURL;

    @Value("${spring.datasource.username}")
    private String springDatasourceUserName;

    @Value("${spring.datasource.password}")
    private String springDatasourcePassword;

    /**
     * @return the databaseUserName
     */
    public String getDatabaseUserName() {
        return databaseUserName;
    }

    /**
     * @return the databasePassword
     */
    public String getDatabasePassword() {
        return databasePassword;
    }

    /**
     * @return the databaseURL
     */
    public String getDatabaseURL() {
        return databaseURL;
    }

    /**
     * @return the serverContextPath
     */
    public String getServerContextPath() {
        return serverContextPath;
    }

    /**
     * @return the serverPort
     */
    public String getServerPort() {
        return serverPort;
    }

    /**
     * @return the profileSearchFrontendDeployedPath
     */
    public String getProfileSearchFrontendDeployedPath() {
        return profileSearchFrontendDeployedPath;
    }

    /**
     * @return the profileSearchBackendDeployedPath
     */
    public String getProfileSearchBackendDeployedPath() {
        return profileSearchBackendDeployedPath;
    }

    /**
     * @return the springDatasourceURL
     */
    public String getSpringDatasourceURL() {
        return springDatasourceURL;
    }

    /**
     * @return the springDatasourceUserName
     */
    public String getSpringDatasourceUserName() {
        return springDatasourceUserName;
    }

    /**
     * @return the springDatasourcePassword
     */
    public String getSpringDatasourcePassword() {
        return springDatasourcePassword;
    }
}
