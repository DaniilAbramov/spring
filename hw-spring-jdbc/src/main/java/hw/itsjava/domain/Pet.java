package hw.itsjava.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Pet {
    private long id;
    private final String nickname;

}
