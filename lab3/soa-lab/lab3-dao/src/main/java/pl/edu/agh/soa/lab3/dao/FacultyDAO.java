package pl.edu.agh.soa.lab3.dao;

import pl.edu.agh.soa.lab3.entity.FacultyEntity;
import pl.edu.agh.soa.lab3.mapper.FacultyMapper;
import pl.edu.agh.soa.model.Faculty;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class FacultyDAO {

    @PersistenceContext(unitName = "students")
    EntityManager em;

    public List<Faculty> getAllFaculties() {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<FacultyEntity> criteriaQuery = builder.createQuery(FacultyEntity.class);
        Root<FacultyEntity> root = criteriaQuery.from(FacultyEntity.class);
        criteriaQuery.select(root);
        TypedQuery<FacultyEntity> query = em.createQuery(criteriaQuery);
        List<FacultyEntity> resultList = query.getResultList();
        if(resultList == null)
            return null;
        return resultList.stream().map(FacultyMapper::entityToModel).collect(Collectors.toList());
    }

}
