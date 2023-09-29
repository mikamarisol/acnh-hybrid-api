package mikamarisol.acnh.hybrid.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

// entity -> single persistent instance of a domain object
// model -> domain object representing real world object
@Entity
//@Table(name = "tulips")
public class Tulip {

    @Id
    private String genotype;
    private String colour;

    // JPA required no-arg constructor
    public Tulip() {
    }

    public Tulip(String genotype, String colour) {
        this.genotype = genotype;
        this.colour = colour;
    }
}
