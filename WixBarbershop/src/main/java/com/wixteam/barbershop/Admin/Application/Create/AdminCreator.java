package com.wixteam.barbershop.Admin.Application.Create;

import com.wixteam.barbershop.Admin.Domain.Admin;
import com.wixteam.barbershop.Admin.Domain.Ports.AdminRepository;
import com.wixteam.barbershop.Admin.Domain.ValueObjects.AdminId;
import com.wixteam.barbershop.Admin.Domain.ValueObjects.AdminName;
import com.wixteam.barbershop.Admin.Domain.ValueObjects.AdminPassword;

public class AdminCreator {
    private AdminRepository repository;
    public AdminCreator(AdminRepository repository){this.repository = repository;}
    public void execute(String adminId, String adminName, String adminPass){
        Admin admin = new Admin(new AdminId(adminId),new AdminName(adminName),new AdminPassword(adminPass));
        repository.save(admin);
    }
}
