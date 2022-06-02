package com.wixteam.barbershop.Users.Address.Infraestructure.Hibernate;

import com.wixteam.barbershop.Shared.Infraestructure.Hibernate.HibernateRespository;
import com.wixteam.barbershop.Users.Address.Domain.Address;
import com.wixteam.barbershop.Users.Address.Domain.Ports.AddressRepository;
import com.wixteam.barbershop.Users.User.Domain.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional("transactional-manager")
public class HibernateAddressRepository extends HibernateRespository<Address> implements AddressRepository {
    protected HibernateAddressRepository(@Qualifier("session-factory") SessionFactory sessionFactory) {
        super(sessionFactory, Address.class);
    }

    @Override
    public void save(Address address) {
        persist(address);
    }

    @Override
    public List<Address> all() {
        return getAll().get();
    }
}
