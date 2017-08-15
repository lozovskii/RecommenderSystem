package com.recommendSystem.repository.Impl;

import com.recommendSystem.model.User;
import com.recommendSystem.repository.AbstractRepository;
import com.recommendSystem.repository.UserRepository;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class UserRepositoryImpl extends AbstractRepository implements UserRepository {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void addUser(User user) {
        persist(user);
    }

    @Override
    public User fetchUser(long imei) {
        Query query = getSession().createQuery("from User where imei=:imei");
        query.setParameter("imei", imei);
        return (User) query.uniqueResult();
    }

    @Override
    public void updateUser(User user) {
        getSession().update(user);
    }

    @Override
    public boolean isExist(User user) {
        try{
            long imei = user.getImei();
            Query query = getSession().createQuery("from User where imei=:imei");
            query.setParameter("imei", imei);
            User user1 = (User) query.uniqueResult();
            return user1.getImei() != 0;
        }catch (NullPointerException e){
            return false;
        }
    }
}