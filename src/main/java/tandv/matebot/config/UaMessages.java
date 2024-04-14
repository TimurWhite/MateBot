package tandv.matebot.config;

import lombok.AllArgsConstructor;
import lombok.Data;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

import java.util.Map;
@Data
@AllArgsConstructor
@ConfigurationProperties("ukrainian")

public class UaMessages {
    private Map<String, String> messages;
}
