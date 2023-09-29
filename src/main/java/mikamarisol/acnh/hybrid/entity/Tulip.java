package mikamarisol.acnh.hybrid.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "tulips")
public class Tulip {

    @Id
    private String genotype;
    private String colour;

    // JPA required no-arg constructor
    public Tulip() {

    }
}
