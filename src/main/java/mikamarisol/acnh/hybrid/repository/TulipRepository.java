package mikamarisol.acnh.hybrid.repository;

import mikamarisol.acnh.hybrid.entity.Tulip;
import org.springframework.data.repository.CrudRepository;

// placeholder for object stored in database (tulip) + its unique ID (genotype)
// crud -> Create, Read, Update, Delete
public interface TulipRepository extends CrudRepository<Tulip, String> {
}
