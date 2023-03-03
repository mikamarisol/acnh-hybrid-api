package mikamarisol.acnh.hybrid.repository;

import mikamarisol.acnh.hybrid.entity.Rose;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoseRepository extends JpaRepository<Rose, Integer> {
}
