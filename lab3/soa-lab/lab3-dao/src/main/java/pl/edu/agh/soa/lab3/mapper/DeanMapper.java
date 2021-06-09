package pl.edu.agh.soa.lab3.mapper;

import pl.edu.agh.soa.lab3.entity.DeanEntity;
import pl.edu.agh.soa.model.Dean;

public class DeanMapper {

    public static Dean entityToModel(DeanEntity entity){
        Dean dean = new Dean();
        dean.setId(entity.getId());
        dean.setDegree(entity.getDegree());
        dean.setName(entity.getName());
        return dean;
    }

    public static DeanEntity modelToEntity(Dean dean){
        DeanEntity deanEntity = new DeanEntity();
        deanEntity.setDegree(dean.getDegree());
        deanEntity.setId(dean.getId());
        deanEntity.setName(dean.getName());
        return deanEntity;
    }
}
