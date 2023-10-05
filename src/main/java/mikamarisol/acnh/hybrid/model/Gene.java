package mikamarisol.acnh.hybrid.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public record Gene(Character alleleOne, Character alleleTwo) {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return this.toString().equals(o.toString());
    }

    @Override
    public String toString() {
        List<Character> alleles = Arrays.asList(alleleOne, alleleTwo);
        Collections.sort(alleles);
        return alleles.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
    }
}
