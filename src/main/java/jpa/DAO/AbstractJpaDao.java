package jpa.DAO;

import jpa.AbstractUser;
import jpa.Appointment;
import jpa.EntityManagerHelper;
import jpa.Prof;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.io.Serializable;
import java.util.List;


public abstract class AbstractJpaDao<K, T extends Serializable> implements IGenericDao<K, T> {

    private Class<T> clazz;

    protected EntityManager entityManager;

    public AbstractJpaDao(Class<T> classToSet) {
        this.entityManager = EntityManagerHelper.getEntityManager();
        this.clazz = classToSet ;
    }



    public void setClazz(Class<T> clazzToSet) {
        this.clazz = clazzToSet;
    }

    public T findOne(K id) {
        return entityManager.find(clazz, id);
    }

    public List<T> findAll() {
        return entityManager.createQuery("select e from " + clazz.getName() + " as e", clazz).getResultList();
    }

    public void save(T entity) {
        EntityTransaction t = this.entityManager.getTransaction();
        t.begin();
        entityManager.persist(entity);
        t.commit();

    }

    public T update(final T entity) {
        EntityTransaction t = this.entityManager.getTransaction();
        t.begin();
        T res = entityManager.merge(entity);
        t.commit();
        return res;

    }

    public void delete(T entity) {
        EntityTransaction t = this.entityManager.getTransaction();
        t.begin();
        entityManager.remove(entity);
        t.commit();

    }

    public void deleteById(K entityId) {
        T entity = findOne(entityId);
        delete(entity);
    }
}
