package CatalogoDeBandas.Repository;

import CatalogoDeBandas.Entity.BandEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BandRepository extends JpaRepository<BandEntity, Long> {
}
