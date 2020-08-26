package dal;

import bo.Bouteille;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BouteilleDao extends JpaRepository<Bouteille, Integer> {
    List<Bouteille> findByNomContaining(String nom);
}
