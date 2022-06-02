package com.wixteam.barbershop.Users.User.Infraestructure.Hibernate;


import com.wixteam.barbershop.Shared.Infraestructure.Hibernate.HibernateRespository;
import com.wixteam.barbershop.Users.User.Domain.Ports.UserRepository;
import com.wixteam.barbershop.Users.User.Domain.User;
import com.wixteam.barbershop.Users.User.Domain.ValueObjects.UserId;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

@Transactional("transactional-manager")
public class HibernateUserRepository extends HibernateRespository<User> implements UserRepository {
    protected HibernateUserRepository(@Qualifier("session-factory") SessionFactory sessionFactory) {
        super(sessionFactory, User.class);
    }

    @Override
    public void save(User user) {
        persist(user);
    }

    @Override
    public List<User> all() {
        return getAll().get();
    }

    @Override
    public List<User> allCustomer(String customer) {
        return null;
    }

    @Override
    public List<User> allBarber(String Barber) {
        return null;
    }

    @Override
    public void delete(String idUser) {
        User user = byId( new UserId(idUser)).get();
        deleteEntity(user);
    }

    @Override
    public void update(User userN, String idUser) {
        User use = byId( new UserId(idUser)).get();
        if(userN.getUserPassword().value() != null)
            use.setUserPassword(userN.getUserPassword());
        if(userN.getUsername().value()  != null)
            use.setUsername(userN.getUsername());
        if(userN.getPhone().value()  != null)
            use.setPhone(userN.getPhone());
        updateEntity(use);
    }

    @Override
    public HashMap<String,Object> Login(String username, String password) {
        List<User> users = getAll().get();
        for (User u: users ) {
            if(u.getUsername().value().equals(username) && u.getUserPassword().value().equals(password)){
                return u.data();
            }
        }
        assert User.create() != null;
        return User.create().data();
    }

}
