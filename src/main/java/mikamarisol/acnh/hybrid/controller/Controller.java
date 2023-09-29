package mikamarisol.acnh.hybrid.controller;
import mikamarisol.acnh.hybrid.model.Gene;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {
    private List<Gene> genes = new ArrayList<>();

    public Controller() {
        genes.addAll(List.of(
                new Gene("R", "r"),
                new Gene("Y", "y")
        ));
    }

    @GetMapping("/genes")
    Iterable<Gene> getGenes() {
        return genes;
    }


}
