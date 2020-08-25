package bll;

import bo.Region;
import dal.RegionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "gestionRegion")
public class GestionRegion {

    @Autowired
    RegionDao regionDao;

    public List<Region> getRegions(){
        return regionDao.findAll();
    }

    public Region getRegionById(int id){
        return regionDao.getOne(id);
    }

    public void addRegion(Region region){
        regionDao.save(region);
    }

    public void updateRegion(Region region){
        regionDao.save(region);
    }

    public void removeRegion(Region region){
        regionDao.delete(region);
    }
}
