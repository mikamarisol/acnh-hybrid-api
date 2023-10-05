package mikamarisol.acnh.hybrid.impl;

import mikamarisol.acnh.hybrid.model.Gene;
import mikamarisol.acnh.hybrid.model.Genotype;
import mikamarisol.acnh.hybrid.service.HybridService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Service
public class HybridServiceImpl implements HybridService {

    @Override
    public List<Genotype> getHybrids(Genotype mother, Genotype father) {

        List<List<Genotype>> monohybridCrosses = new ArrayList<>();

        for (int i  = 0; i < mother.genes().size(); i++) {
            monohybridCrosses.add(monohybridCross(mother.genes().get(i), father.genes().get(i)));
        }

        return monohybridCrosses.get(0).stream()
                .flatMap(t1 -> monohybridCrosses.get(1).stream().map(t2 -> combineTraits(t1, t2)))
                .collect(Collectors.toList());
    }

    private Genotype combineTraits(Genotype traitOne, Genotype traitTwo) {
        return new Genotype(
                Stream.concat(traitOne.genes().stream(), traitTwo.genes().stream())
                        .collect(Collectors.toList()));
    }

    private List<Genotype> monohybridCross(Gene m, Gene f) {

        List<Genotype> hyrbrids = new ArrayList<>();

        for (String maleAllele : List.of(m.alleleOne(), m.alleleTwo())) {
            for (String femaleAllele : List.of(f.alleleOne(), f.alleleTwo())) {
                hyrbrids.add(new Genotype(List.of(new Gene(maleAllele, femaleAllele))));
            }
        }
        return hyrbrids;
    }
}
