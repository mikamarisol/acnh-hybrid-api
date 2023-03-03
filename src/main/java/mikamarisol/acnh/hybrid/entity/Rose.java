package mikamarisol.acnh.hybrid.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@Table(name = "roses")
public class Rose {

    @Id
    @Column(name = "genotype")
    private String genotype;

    @Column(name = "colour")
    private String colour;

    @Override
    public String toString() {
        String format = "genotype: " + this.genotype + ", colour: " + this.colour;
        return format;
    }
}
