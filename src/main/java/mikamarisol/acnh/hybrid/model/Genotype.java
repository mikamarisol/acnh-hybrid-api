package mikamarisol.acnh.hybrid.model;

import java.util.List;
import java.util.stream.Collectors;

public record Genotype(List<Gene> genes) {

    @Override
    public String toString() {
        return genes.stream()
                .map(Record::toString)
                .collect(Collectors.joining("-"));
    }
}
