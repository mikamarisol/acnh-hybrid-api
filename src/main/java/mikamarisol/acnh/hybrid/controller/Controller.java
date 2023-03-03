package mikamarisol.acnh.hybrid.controller;

import mikamarisol.acnh.hybrid.entity.Rose;
import mikamarisol.acnh.hybrid.enumeration.Breed;
import mikamarisol.acnh.hybrid.repository.RoseRepository;
import mikamarisol.acnh.hybrid.service.RoseService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
public class Controller {

    private RoseService roseService;

    @Autowired
    public Controller(RoseService roseService) {
        this.roseService = roseService;
    }

    @GetMapping("/flower-breeds")
    public ResponseEntity<String> getFlowerBreeds(){

        StringBuilder builder = new StringBuilder();
        EnumSet.allOf(Breed.class).forEach(breed -> builder.append(breed.toString() + "\n"));
        String response = builder.toString();

        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("content-type", "text/plain");

        return new ResponseEntity<>(response, headers, HttpStatusCode.valueOf(200));
    }

    @GetMapping("/roses")
    public ResponseEntity<String> getRoses() {

        List<Rose> roses = roseService.getAllRoses();
        StringBuilder builder = new StringBuilder();
        roses.stream().forEach(rose -> builder.append(rose.toString() + "\n"));
        String response = builder.toString();

        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("content-type", "text/plain");

        return new ResponseEntity<>(response, headers, HttpStatusCode.valueOf(200));
    }
}
