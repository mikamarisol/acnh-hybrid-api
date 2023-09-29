package mikamarisol.acnh.hybrid.controller;
import mikamarisol.acnh.hybrid.entity.Tulip;
import mikamarisol.acnh.hybrid.repository.TulipRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class Controller {

    private final TulipRepository tulipRepository;

    public Controller(TulipRepository tulipRepository) {
        this.tulipRepository = tulipRepository;

        this.tulipRepository.saveAll(List.of(
                new Tulip("rryyss", "White"),
                new Tulip("rryySs", "White"),
                new Tulip("rryySS", "White")
        ));
    }

    @GetMapping("/tulips")
    Iterable<Tulip> getTulips() {
        return tulipRepository.findAll();
    }
}
