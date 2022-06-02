package com.wixteam.barbershop.Admin.Domain.Ports;

import com.wixteam.barbershop.Admin.Domain.Admin;

import java.util.List;

public interface AdminRepository {
    public void save(Admin admin);
    public List<Admin> all();
}
