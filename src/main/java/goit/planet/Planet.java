package goit.planet;

import goit.ticket.Ticket;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Table(name = "planet")
@Entity
@Data
public class Planet {

    @Id
    private String id;

    @Column(name = "name")
    private String name;

//    @OneToMany(mappedBy="planetFrom")
//    private Set<Ticket> ticketsFromPlanet;

//    @OneToMany(mappedBy="planetTo")
//    private Set<Ticket> ticketsToPlanet;
}
