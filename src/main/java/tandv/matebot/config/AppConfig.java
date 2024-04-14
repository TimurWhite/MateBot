package tandv.matebot.config;

import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan("tandv")
@ConfigurationPropertiesScan
@EnableJpaRepositories
public class AppConfig {
}
