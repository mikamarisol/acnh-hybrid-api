package mikamarisol.acnh.hybrid.controller;
import mikamarisol.acnh.hybrid.entity.Tulip;
import mikamarisol.acnh.hybrid.model.Gene;
import mikamarisol.acnh.hybrid.model.Genotype;
import mikamarisol.acnh.hybrid.repository.TulipRepository;
import mikamarisol.acnh.hybrid.service.HybridService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class Controller {

    private final TulipRepository tulipRepository;
    private final HybridService hybridService;

    @Autowired
    public Controller(TulipRepository tulipRepository, HybridService hybridService) {
        this.tulipRepository = tulipRepository;
        this.hybridService = hybridService;

        this.tulipRepository.saveAll(List.of(
                new Tulip("RR", "Red"),
                new Tulip("Rr", "Red"),
                new Tulip("rr", "White")
        ));
    }

    @GetMapping("/tulips")
    Iterable<Tulip> getTulips() {
        return tulipRepository.findAll();
    }

    @GetMapping("/breed-tulips/{genotypeOne}&{genotypeTwo}")
    Iterable<Tulip> breedTulips(@PathVariable String genotypeOne, @PathVariable String genotypeTwo) {

        Genotype mother = new Genotype(
                Collections.singletonList(new Gene(
                        String.valueOf(genotypeOne.charAt(0)),
                        String.valueOf(genotypeOne.charAt(1)))));

        Genotype father = new Genotype(
                Collections.singletonList(new Gene(
                        String.valueOf(genotypeTwo.charAt(0)),
                        String.valueOf(genotypeTwo.charAt(1)))));

        List<Genotype> hybrids = hybridService.getHybrids(mother, father);
        return tulipRepository.findAllById(hybrids
                .stream()
                .map(Genotype::toString)
                .collect(Collectors.toList()));
    }

}
