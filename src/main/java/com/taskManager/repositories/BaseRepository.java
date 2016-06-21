package com.taskManager.repositories;

import com.taskManager.models.BaseModel;
import com.taskManager.models.Task;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public abstract class BaseRepository<T extends BaseModel> {

    @Autowired
    protected SessionFactory sessionFactory;

    protected Class<T> classT;

    public BaseRepository(Class<T> classT) {
        this.classT = classT;
    }
    public BaseRepository() {
        this.classT = (Class<T>) Task.class;
    }

    public T getById(int id) throws InstantiationException, IllegalAccessException {
        return this.getAll().stream().filter(item -> item.getId() == id).findFirst().orElse(null);
    }

    public List<T> getAll() {
        List<T> items = new ArrayList<>();

        Session session = sessionFactory.openSession();
        Transaction tran = null;

        try {
            tran = session.beginTransaction();
            items = session.createCriteria(classT).list();
            tran.commit();
        } catch (Exception ex) {
            tran.rollback();
        } finally {
            session.close();
        }

        return items;
    }

    public void save(T item) {
        Session session = sessionFactory.openSession();
        Transaction tran = null;

        try {
            tran = session.beginTransaction();
            session.saveOrUpdate(item);
            tran.commit();
        } catch (Exception ex) {
            tran.rollback();
        } finally {
            session.close();
        }
    }

    public void delete(int id) throws IllegalAccessException, InstantiationException {
        Session session = sessionFactory.openSession();
        Transaction tran = null;

        try {
            tran = session.beginTransaction();
            session.delete(getById(id));
            tran.commit();
        } catch (Exception ex) {
            tran.rollback();
        } finally {
            session.close();
        }
    }
}