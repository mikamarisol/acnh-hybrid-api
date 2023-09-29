package mikamarisol.acnh.hybrid.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public record Gene(String alleleOne, String alleleTwo) {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Gene)) return false;
        return this.toString().equals(o.toString());
    }

    @Override
    public String toString() {
        List<String> alleles = new ArrayList<>(List.of(alleleOne, alleleTwo));
        Collections.sort(alleles);
        return String.join("", alleles);
    }
}
