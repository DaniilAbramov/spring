package hw.itsjava.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserWithPets {
    private long id;
    private  String name;
    private  String mail;
    private String pets;
}
