package bll;

import bo.Bouteille;
import dal.BouteilleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "gestionBouteille")
public class GestionBouteille {
    @Autowired
    BouteilleDao bouteilleDao;

    public List<Bouteille> getBouteilles(){
        return bouteilleDao.findAll();
    }

    public Bouteille getBouteilleById(int id){
        return bouteilleDao.getOne(id);
    }

    public void addBouteille(Bouteille bouteille){
        bouteilleDao.save(bouteille);
    }

    public void updateBouteille(Bouteille bouteille){
        bouteilleDao.save(bouteille);
    }

    public void removeBouteille(Bouteille bouteille){
        bouteilleDao.delete(bouteille);
    }
}
