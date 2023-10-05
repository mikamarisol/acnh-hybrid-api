package mikamarisol.acnh.hybrid.model;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public record Gene(String alleleOne, String alleleTwo) {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return this.toString().equals(o.toString());
    }

    @Override
    public String toString() {
        List<String> alleles = Arrays.asList(alleleOne, alleleTwo);
        alleles.sort(Comparator.naturalOrder());
        return String.join("", alleles);
    }
}
