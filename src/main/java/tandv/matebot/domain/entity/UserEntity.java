package tandv.matebot.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.DefaultValue;
import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;
import tandv.matebot.domain.enums.Language;

@Entity(name = "Users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotNull
    private String nickName;

    @NotNull
    private Long userId;

    @DefaultValue("EN")
    private Language language;

    @NotNull
    private String ChatId;
}
