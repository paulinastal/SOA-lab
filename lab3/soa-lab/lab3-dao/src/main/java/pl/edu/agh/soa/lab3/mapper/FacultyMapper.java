package pl.edu.agh.soa.lab3.mapper;

import pl.edu.agh.soa.lab3.entity.FacultyEntity;
import pl.edu.agh.soa.model.Faculty;

public class FacultyMapper {

    public static Faculty entityToModel(FacultyEntity entity){
        Faculty model = new Faculty();
        model.setId(entity.getId());
        model.setName(entity.getName());
        model.setDean(DeanMapper.entityToModel(entity.getDean()));
        return model;
    }

    public static FacultyEntity modelToEntity(Faculty model){
        FacultyEntity entity = new FacultyEntity();
        entity.setDean(DeanMapper.modelToEntity(model.getDean()));
        entity.setId(model.getId());
        entity.setName(model.getName());
        return entity;
    }
}
