package mikamarisol.acnh.hybrid.service;

import mikamarisol.acnh.hybrid.model.Gene;
import mikamarisol.acnh.hybrid.model.Genotype;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class HybridServiceTest {

    @Autowired
    private HybridService hybridService;

    @ParameterizedTest
    @ArgumentsSource(HybridArgumentsProvider.class)
    void monohybridCross(Genotype mother, Genotype father, List<Genotype> expectedHybrids) {
        List<Genotype> actualHybrids = hybridService.getHybrids(mother, father);
        assertThat(actualHybrids).containsExactlyInAnyOrderElementsOf(expectedHybrids);
    }

    static class HybridArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            Gene RRGene = new Gene("R", "R");
            Gene RrGene = new Gene("R", "r");
            Gene rrGene = new Gene("r", "r");

            Genotype RR = new Genotype(List.of(RRGene));
            Genotype Rr = new Genotype(List.of(RrGene));
            Genotype rr = new Genotype(List.of(rrGene));

            return Stream.of(
                    Arguments.of(RR, RR, Arrays.asList(RR, RR, RR, RR)),
                    Arguments.of(Rr, RR, Arrays.asList(RR, RR, Rr, Rr)),
                    Arguments.of(rr, RR, Arrays.asList(Rr, Rr, Rr, Rr)),
                    Arguments.of(rr, Rr, Arrays.asList(Rr, Rr ,rr, rr)),
                    Arguments.of(rr, rr, Arrays.asList(rr, rr, rr, rr))
            );
        }
    }
}
