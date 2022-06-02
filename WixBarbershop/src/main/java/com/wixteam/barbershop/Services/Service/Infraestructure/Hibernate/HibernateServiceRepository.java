package com.wixteam.barbershop.Services.Service.Infraestructure.Hibernate;

import com.wixteam.barbershop.Services.Service.Domain.Ports.ServiceRepository;
import com.wixteam.barbershop.Services.Service.Domain.Service;
import com.wixteam.barbershop.Services.Service.Domain.ValueObjects.ServiceId;
import com.wixteam.barbershop.Shared.Infraestructure.Hibernate.HibernateRespository;
import com.wixteam.barbershop.Users.User.Domain.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional("transactional-manager")
public class HibernateServiceRepository extends HibernateRespository<Service> implements ServiceRepository {
    protected HibernateServiceRepository(@Qualifier("session-factory") SessionFactory sessionFactor) {
        super(sessionFactor, Service.class);
    }

    @Override
    public void save(Service service) {
        persist(service);
    }

    @Override
    public List<Service> all() {
        return getAll().get();
    }

    @Override
    public void delete(String idService) {
        Service service = byId(new ServiceId(idService)).get();
        deleteEntity(service);
    }

    @Override
    public void update(Service pService, String idService) {
        Service service = byId(new ServiceId(idService)).get();
        if(pService.getServiceDetails().value()!=null)
            service.setServiceDetails(pService.getServiceDetails());
        if(pService.getServicePrice().value()!=0)
            service.setServicePrice(pService.getServicePrice());
        updateEntity(service);
    }
}
