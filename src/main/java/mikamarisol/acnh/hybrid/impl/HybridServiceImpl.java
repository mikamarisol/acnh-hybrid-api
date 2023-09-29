package mikamarisol.acnh.hybrid.impl;

import mikamarisol.acnh.hybrid.model.Genotype;
import mikamarisol.acnh.hybrid.service.HybridService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HybridServiceImpl implements HybridService {
    public List<Genotype> getHybrids(Genotype genotypeOne, Genotype genotypeTwo) {



        List<String> children = new ArrayList<>();
        for (int i = 0; i < genotypeOne.length(); i++) {
            for (int j = 0; j < genotypeTwo.length(); j++) {
                List<String> child = Arrays.asList(String.valueOf(genotypeOne.charAt(i)),
                        String.valueOf(genotypeTwo.charAt(j)));
                Collections.sort(child);
                children.add(child.stream().map(Object::toString).collect(Collectors.joining()));
            }
        }
        return children;
    }
}
