package dal;

import bo.Couleur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouleurDao extends JpaRepository<Couleur, Integer> {
}
