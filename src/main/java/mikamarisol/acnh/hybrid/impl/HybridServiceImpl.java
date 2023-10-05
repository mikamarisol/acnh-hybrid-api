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

        // check that mother and father can breed

        // for each gene, find monohybrid cross

        // forked line method to combine traits


        List<List<Genotype>> monohybridCrosses = new ArrayList<>();
        for (int i  = 0; i < mother.genes().size(); i++) {
            monohybridCrosses.add(monohybridCross(mother.genes().get(i), father.genes().get(i)));
        }

        return combineTraits(monohybridCrosses);

    }

    private List<Genotype> combineTraits(List<List<Genotype>> monohybridCrosses) {
        while (monohybridCrosses.size() > 1) {
            List<Genotype> crossOne = monohybridCrosses.remove(0);
            List<Genotype> crossTwo = monohybridCrosses.remove(0);
            monohybridCrosses.add(applyForkedLine(crossOne, crossTwo));
        }
        return monohybridCrosses.get(0);
    }

    private List<Genotype> applyForkedLine(List<Genotype> crossOne, List<Genotype> crossTwo) {

        List<Genotype> combinedGenotypes = new ArrayList<>();

        for (Genotype hybridTraitOne: crossOne) {
            for (Genotype hybridTraitTwo: crossTwo) {
                combinedGenotypes.add(hybridTraitOne.add(hybridTraitTwo));
            }
        }
        return combinedGenotypes;
    }

    private List<Genotype> monohybridCross(Gene m, Gene f) {

        List<Genotype> hybrids = new ArrayList<>();

        for (Character motherAllele : List.of(m.alleleOne(), m.alleleTwo())) {
            for (Character fatherAllele : List.of(f.alleleOne(), f.alleleTwo())) {
                hybrids.add(new Genotype(List.of(new Gene(motherAllele, fatherAllele))));
            }
        }
        return hybrids;
    }

//    private boolean canBreed(Genotype mother, Genotype father) {
//
//        if (mother.genes().size() == father.genes().size()) {
//            for (int i = 0; i < mother.genes().size()) {
//                if
//            }
//        }
//
//    }
}
