package goit.planet;

import jakarta.persistence.*;
import lombok.Data;

@Table(name = "planet")
@Entity
@Data
public class Planet {

    @Id
    private String id;

    @Column(name = "name")
    private String name;
}
