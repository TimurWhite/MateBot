package tandv.matebot.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CallBackPubgRanksData {
    BRONZE("Bronze"),
    SILVER("Silver"),
    GOLD("Gold"),
    PLATINUM("Platinum"),
    DIAMOND("Diamond"),
    MASTER("Master");
    private final String rankPUBGName;
}
