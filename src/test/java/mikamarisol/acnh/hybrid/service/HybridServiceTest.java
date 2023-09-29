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
    static Gene RRGene = new Gene("R", "R");
    static Gene RrGene = new Gene("R", "r");
    static Gene rrGene = new Gene("r", "r");
    static Gene YYGene = new Gene("Y", "Y");

    static Gene YyGene = new Gene("Y", "y");
    static Gene yyGene = new Gene("y", "y");

    @Autowired
    private HybridService hybridService;

    @ParameterizedTest
    @ArgumentsSource(MonohybridArgumentsProvider.class)
    void monohybridCross(Genotype mother, Genotype father, List<Genotype> expectedHybrids) {
        List<Genotype> actualHybrids = hybridService.getHybrids(mother, father);
        assertThat(actualHybrids).containsExactlyInAnyOrderElementsOf(expectedHybrids);
    }

    @ParameterizedTest
    @ArgumentsSource(DihybridArgumentsProvider.class)
    void dihybridCross(Genotype mother, Genotype father, List<Genotype> expectedHybrids) {
        List<Genotype> actualHybrids = hybridService.getHybrids(mother, father);
        assertThat(actualHybrids).containsExactlyInAnyOrderElementsOf(expectedHybrids);
    }

    static class MonohybridArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
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

    static class DihybridArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            Genotype RRYY = new Genotype(List.of(RRGene, YYGene));
            Genotype RRYy = new Genotype(List.of(RRGene, YyGene));
            Genotype RRyy = new Genotype(List.of(RRGene, yyGene));

            Genotype RrYY = new Genotype(List.of(RrGene, YYGene));
            Genotype RrYy = new Genotype(List.of(RrGene, YyGene));
            Genotype Rryy = new Genotype(List.of(RrGene, yyGene));


            Genotype rrYY = new Genotype(List.of(rrGene, YYGene));
            Genotype rrYy = new Genotype(List.of(rrGene, YyGene));
            Genotype rryy = new Genotype(List.of(rrGene, yyGene));

            return Stream.of(
                    Arguments.of(RrYy, RrYy, Arrays.asList(
                            RRYY,
                            RRYy, RRYy,
                            RRyy,
                            RrYY, RrYY,
                            RrYy, RrYy, RrYy, RrYy,
                            Rryy, Rryy,
                            rrYY,
                            rrYy, rrYy,
                            rryy))
            );
        }
    }
}
