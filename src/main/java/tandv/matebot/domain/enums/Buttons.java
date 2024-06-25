package tandv.matebot.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Buttons {
    PROFILE_CHANGING("Change Profile"),
    SEND_REPORT("Send Report"),
    START_SEARCH("Start Search");

    private final String buttonName;

}
