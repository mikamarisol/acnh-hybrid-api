package mikamarisol.acnh.hybrid.service;

import mikamarisol.acnh.hybrid.model.Genotype;

import java.util.List;

public interface HybridService {
    List<Genotype> getHybrids(Genotype mother, Genotype father);

}
