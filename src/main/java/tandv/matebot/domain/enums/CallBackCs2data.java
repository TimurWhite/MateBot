package tandv.matebot.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CallBackCs2data {
    SILVER_1_2_3("Silver from 1 to 3"),
    SILVER_4_ELITE_MASTER(" Silver 4, Elite Silver, Silver Master"),
    GOLD_NOVA_1_2_3("Gold Nova from 1 to 3"),
    GOLD_NOVA_MASTER_GUARDIAN_1("Gold Nova Master and Master Guardian 1"),
    MASTER_GUARDIAN_2_ELITE("Master Guardian 2, Elite Master Guardian "),
    DISTINGUISHED_MASTER_LEGENDARY_EAGLE("Distinguished Master Guardian and Legendary Eagle"),
    EAGLE_MASTER_SUPREME("Legendary Eagle Master and Supreme Master First Class"),
    SUPREME_MASTER_GLOBAL_ELITE("Supreme Master first Class and Global Elite"),
    GLOBAL_ELITE("Global Elite Only");

    private final String rankCSName;
}
