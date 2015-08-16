package com.oliver.common;

import com.oliver.girl.util.entity.Girl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by oliver on 08/08/15.
 */
public abstract class AbstractDao<T, PK> implements Dao<T, PK> {

    private String pu = "FacemashProjectPU";

    protected Class<T> type;

    public EntityManager getEntityManager(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(pu);
        EntityManager em = emf.createEntityManager();
        return em;
    }

    public void setType(){
        //lines to add when using generic Class<T>
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        type = (Class) pt.getActualTypeArguments()[0];
    }

    @Override
    public boolean create(T obj) {
        EntityManager em = getEntityManager();
        EntityTransaction t = em.getTransaction();
        boolean persisted = false;

        try{
            t.begin();
            em.persist(obj);
            em.flush();
            t.commit();
            persisted = true;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (t.isActive()){
                t.rollback();
                em.close();
            }
        }
        return persisted;
    }

    @Override
    public T read(PK id) {

        EntityManager em = getEntityManager();
        EntityTransaction t = em.getTransaction();
        T obj = null;
        setType();  //line to add when using generic Class<T>

        try{
            t.begin();
            obj = em.find(type,id);
            t.commit();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            if (t.isActive()){
                t.rollback();
                em.close();
            }
        }
        return obj;
    }


    @Override
    public void update(T obj) {

        EntityManager em = getEntityManager();
        EntityTransaction t = em.getTransaction();

        try {
            t.begin();
            em.merge(obj);
            t.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (t.isActive()) {
                t.rollback();
                em.close();
            }
        }
    }

    @Override
    public void delete(PK id) {

    }
}