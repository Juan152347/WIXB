package com.wixteam.barbershop.Admin.Infraestructure.Hibernate;

import com.wixteam.barbershop.Admin.Domain.Admin;
import com.wixteam.barbershop.Admin.Domain.Ports.AdminRepository;
import com.wixteam.barbershop.Shared.Infraestructure.Hibernate.HibernateRespository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional("transactional-manager")
public class HibernateAdminRepository extends HibernateRespository<Admin> implements AdminRepository {

    protected HibernateAdminRepository(@Qualifier("session-factory") SessionFactory sessionFactory) {
        super(sessionFactory, Admin.class);
    }

    @Override
    public void save(Admin admin) {
        persist(admin);
    }

    @Override
    public List<Admin> all() {
        return getAll().get();
    }
}
