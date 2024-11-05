package tandv.matebot.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CallBackValorantRanksData {
    IRON("Iron"),
    BRONZE("Bronze"),
    SILVER("Silver"),
    GOLD("Gold"),
    PLATINUM("Platinum"),
    DIAMOND("Diamond"),
    ASCENDANT("Ascendant"),
    IMMORTAL("Immortal"),
    RADIANT("Radiant");
    private final String rankValorantName;
}
