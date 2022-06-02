package com.wixteam.barbershop.Services.Date.Infraestructure.Hibernate;

import com.wixteam.barbershop.Services.Date.Domain.Date;
import com.wixteam.barbershop.Services.Date.Domain.Port.DateRepository;
import com.wixteam.barbershop.Services.Date.Domain.ValueObjects.DateId;
import com.wixteam.barbershop.Shared.Infraestructure.Hibernate.HibernateRespository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional("transactional-manager")
public class HibernateDateRepository extends HibernateRespository<Date> implements DateRepository {
    protected HibernateDateRepository(@Qualifier("session-factory") SessionFactory sessionFactory) {
        super(sessionFactory, Date.class);
    }

    @Override
    public void save(Date date) {
        persist(date);
    }

    @Override
    public List<Date> all() {
        return getAll().get();
    }

    @Override
    public void delete(String idDate) {
        Date date = byId( new DateId(idDate)).get();
        deleteEntity(date);
    }

    @Override
    public Date find(String idDate) {
        return byId( new DateId(idDate)).get();
    }

    @Override
    public List<Date> allDateTypeUser(String idUser, String type) {
        List<Date> dates = getAll().get();
        List<Date> respons = new ArrayList<>();
        for (Date d:dates) {
            if(type.equals("Barber")){
                if(d.data().get("barberId").equals(idUser)){
                    respons.add(d);
                }
            }else if (type.equals("Customer")){
                if(d.data().get("userId").equals(idUser)){
                    respons.add(d);
                }
            }
        }
        return respons;
    }
}
