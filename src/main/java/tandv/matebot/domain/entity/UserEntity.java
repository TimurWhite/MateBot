package tandv.matebot.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.DefaultValue;
import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;
import tandv.matebot.domain.enums.CallBackGameData;
import tandv.matebot.domain.enums.CallBackYearsData;
import tandv.matebot.domain.enums.Language;

@Entity(name = "Users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    @NotNull
    String nickName;

    @NotNull
    String discordTag;

    @NotNull
    @Enumerated(EnumType.STRING)
    CallBackGameData gameData;

    @NotNull
    @Enumerated(EnumType.STRING)
    CallBackYearsData yearsData;

    @DefaultValue("EN")
    Language language;

    @NotNull
    String ChatId;
}
