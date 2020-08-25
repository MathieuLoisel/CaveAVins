package bll;

import bo.Couleur;
import dal.CouleurDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "gestionCouleur")
public class GestionCouleur {
    @Autowired
    CouleurDao couleurDao;

    public List<Couleur> getCouleurs(){
        return couleurDao.findAll();
    }

    public Couleur getCouleurById(int id){
        return couleurDao.getOne(id);
    }

    public void addCouleur(Couleur couleur){
        couleurDao.save(couleur);
    }

    public void updateCouleur(Couleur couleur){
        couleurDao.save(couleur);
    }

    public void removeCouleur(Couleur couleur){
        couleurDao.delete(couleur);
    }
}
