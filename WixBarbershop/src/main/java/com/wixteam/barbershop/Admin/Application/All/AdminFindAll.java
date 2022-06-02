package com.wixteam.barbershop.Admin.Application.All;

import com.wixteam.barbershop.Admin.Domain.Admin;
import com.wixteam.barbershop.Admin.Domain.Ports.AdminRepository;

import java.util.List;

public class AdminFindAll {
    private AdminRepository repository;
    public AdminFindAll(AdminRepository repository) { this.repository = repository; }
    public List<Admin> execute(){
        return repository.all();
    }
}
