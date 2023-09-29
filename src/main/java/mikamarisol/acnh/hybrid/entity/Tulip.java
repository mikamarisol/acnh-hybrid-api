package mikamarisol.acnh.hybrid.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

// entity -> single persistent instance of a domain object for database
// model -> domain object representing real world object
@Entity
@Getter
@Setter
public class Tulip {

    @Id
    private String genotype;
    private String colour;

    // JPA requires no-arg constructor
    public Tulip() {
    }

    public Tulip(String genotype, String colour) {
        this.genotype = genotype;
        this.colour = colour;
    }
}
