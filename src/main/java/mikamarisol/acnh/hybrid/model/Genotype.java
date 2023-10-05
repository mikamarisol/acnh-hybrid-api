package mikamarisol.acnh.hybrid.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public record Genotype(List<Gene> genes) {

    @Override
    public String toString() {
        return genes.stream()
                .map(Record::toString)
                .collect(Collectors.joining("-"));
    }

    public Genotype add(Genotype other) {
        List<Gene> combinedGenes = Stream.concat(this.genes().stream(), other.genes().stream()).toList();
        return new Genotype(combinedGenes);
    }
}
