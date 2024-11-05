package tandv.matebot.domain.enums;

import lombok.Getter;

@Getter
public enum Messages {
    NONE("nothing"),
    HELLO("hello"),
    ONSTART("onstart"),
    NICK("nick"),
    YEARS_OLD("yearsOld"),
    DISCORD("discord"),
    GAME("game"),
    RANK("rank"),
    FIND("find");


    private final String propertyName;

    Messages(String propertyName){
        this.propertyName = propertyName;

    }
}
