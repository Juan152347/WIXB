package com.wixteam.barbershop.Products.Product.Infraestructure.Hibernate;

import com.wixteam.barbershop.Products.Product.Domain.Ports.ProductRepository;
import com.wixteam.barbershop.Products.Product.Domain.Product;
import com.wixteam.barbershop.Shared.Infraestructure.Hibernate.HibernateRespository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional("transactional-manager")
public class HibernateProductRepository extends HibernateRespository<Product> implements ProductRepository {

    protected HibernateProductRepository(@Qualifier("session-factory") SessionFactory sessionFactory) {
        super(sessionFactory, Product.class);
    }

    @Override
    public void save(Product product) {
        persist(product);
    }

    @Override
    public List<Product> all() {
        return getAll().get();
    }
}
