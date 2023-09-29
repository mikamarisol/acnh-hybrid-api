package mikamarisol.acnh.hybrid.service;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class HybridServiceTest {

    private HybridService hybridService = new HybridService();
    @ParameterizedTest
    @ArgumentsSource(FlowerBreedingArgumentsProvider.class)
    void breedSingleTrait(String parentOne, String parentTwo, List<String> expectedChildren) {
        List<String> actualChildren = hybridService.getChildren(parentOne, parentTwo);
        assertThat(actualChildren).containsExactlyInAnyOrderElementsOf(expectedChildren);
    }

    static class FlowerBreedingArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            return Stream.of(
                    Arguments.of("RR", "RR", Arrays.asList("RR", "RR", "RR", "RR")),
                    Arguments.of("Rr", "RR", Arrays.asList("RR", "RR", "Rr", "Rr")),
                    Arguments.of("rr", "RR", Arrays.asList("Rr", "Rr", "Rr", "Rr")),
                    Arguments.of("rr", "Rr", Arrays.asList("Rr", "Rr", "rr", "rr")),
                    Arguments.of("rr", "rr", Arrays.asList("rr", "rr", "rr", "rr"))
            );
        }
    }
}
