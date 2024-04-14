package tandv.matebot.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ConfigurationProperties("bot")
@Data

public class BotConfig {
    @Value("${bot.name}")
    String botName;
    @Value("${bot.token}")
    String token;
}
