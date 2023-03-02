package mikamarisol.acnh.hybrid.controller;

import mikamarisol.acnh.hybrid.enumeration.Breed;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.EnumSet;
import java.util.HashMap;

@RestController
public class Controller {

    @GetMapping("/GET/flower-breeds")
    public ResponseEntity<String> getFlowerBreeds(){

        StringBuilder builder = new StringBuilder();
        EnumSet.allOf(Breed.class).forEach(breed -> builder.append(breed.toString() + "\n"));
        String response = builder.toString();

        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("content-type", "text/plain");

        return new ResponseEntity<>(response, headers, HttpStatusCode.valueOf(200));
    }
}
