package mikamarisol.acnh.hybrid.model;

public record Gene(String alleleOne, String alleleTwo) {

    @Override
    public String toString() {
        return alleleOne + alleleTwo;
    }
}
