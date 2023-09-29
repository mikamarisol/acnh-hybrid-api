package mikamarisol.acnh.hybrid.impl;

import mikamarisol.acnh.hybrid.model.Gene;
import mikamarisol.acnh.hybrid.model.Genotype;
import mikamarisol.acnh.hybrid.service.HybridService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class HybridServiceImpl implements HybridService {

    @Override
    public List<Genotype> getHybrids(Genotype mother, Genotype father) {

        List<Genotype> hybrids = new ArrayList<>();

        for (Gene maternalGene: mother.genes()) {
            for (Gene paternalGene: father.genes()) {
                hybrids = monohybridCross(maternalGene, paternalGene);
            }
        }
        return hybrids;
    }

    private List<Genotype> monohybridCross(Gene m, Gene f) {
        Genotype first = new Genotype((List.of(new Gene(m.alleleOne(), f.alleleOne()))));
        Genotype second = new Genotype((List.of(new Gene(m.alleleOne(), f.alleleTwo()))));
        Genotype third = new Genotype((List.of(new Gene(m.alleleTwo(), f.alleleOne()))));
        Genotype fourth = new Genotype((List.of(new Gene(m.alleleTwo(), f.alleleTwo()))));

        return List.of(first, second, third, fourth);
    }
}
