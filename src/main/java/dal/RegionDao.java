package dal;

import bo.Region;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionDao extends JpaRepository<Region, Integer> {
}
