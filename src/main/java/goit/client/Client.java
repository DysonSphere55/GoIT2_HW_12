package goit.client;

import goit.ticket.Ticket;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Table(name = "client")
@Entity
@Data
public class Client {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;

    @Column(name = "name")
    private String name;

//    @OneToMany(mappedBy="client")
//    private List<Ticket> tickets;
}
