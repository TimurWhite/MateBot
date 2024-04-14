package tandv.matebot.domain.model;

import lombok.Getter;

@Getter
public enum Messages {
    HELLO("hello");

    private final String propertyName;

    Messages(String propertyName){
        this.propertyName = propertyName;

    }
}
