package mikamarisol.acnh.hybrid.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HybridService {

    public List<String> getChildren(String genotypeOne, String genotpyeTwo) {

        List<String> children = new ArrayList<>();
        for (int i = 0; i < genotypeOne.length(); i++) {
            for (int j = 0; j < genotpyeTwo.length(); j++) {
                List<String> child = Arrays.asList(String.valueOf(genotypeOne.charAt(i)),
                        String.valueOf(genotpyeTwo.charAt(j)));
                Collections.sort(child);
                children.add(child.stream().map(Object::toString).collect(Collectors.joining()));
            }
        }
        return children;
    }
}
