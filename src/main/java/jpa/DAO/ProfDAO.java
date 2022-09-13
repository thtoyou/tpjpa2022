package jpa.DAO;

import jpa.*;

import javax.persistence.EntityManager;

import java.util.List;


public class ProfDAO extends AbstractJpaDao<Long, Prof> {
    Prof prof;
    static EntityManager em = EntityManagerHelper.getEntityManager();

    public ProfDAO(User user) {


        super(Prof.class);
    }


    public static List<Prof> getProfByName(String name) {

        return em.createQuery("select p from Prof as p where p.name =:name", Prof.class)
                .setParameter("name", name).getResultList();
    }

    /*
    public Prof getProfById(long id){
       return em.createQuery(query).setParameter(id).getSingleResult();
    }*/
}
