package br.com.exemploFormulario.repositories;

import java.util.List;

import br.com.exemploFormulario.utils.JPAUtils;
import jakarta.persistence.EntityManager;

public abstract class InstanceDAO<T> {

    private JPAUtils jpaUtils;

    public InstanceDAO() {
        this.jpaUtils = new JPAUtils();
    }

    //CREATE
    public void createInstance(T obj) {
        jpaUtils.executeInsideTransaction(entityManager -> entityManager.persist(obj));
    }

    //FindByID
    public T findInstance(Long id) {
        EntityManager entityManager = jpaUtils.getEntityManager();
        return entityManager.find(getEntityClass(), id);
    }

    //FindAll
    public List<T> findAllInstance() {
        EntityManager entityManager = jpaUtils.getEntityManager();
        return entityManager.createQuery("FROM " + getEntityClass().getName(), getEntityClass()).getResultList();
    }

    //Update
    public void updateInstance(T obj) {
        jpaUtils.executeInsideTransaction(entityManager -> entityManager.merge(obj));
    }

    //Delete
    public void deleteInstance(T obj) {
        jpaUtils.executeInsideTransaction(entityManager -> entityManager.remove(obj));
    }

    protected abstract Class<T> getEntityClass();

}
