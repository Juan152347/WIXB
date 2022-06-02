package com.wixteam.barbershop.Admin.Application.All;

import com.wixteam.barbershop.Admin.Domain.Admin;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class AllAdmins {
    private List<Admin> admins;

    public AllAdmins(List<Admin> admins){
        this.admins = admins;
    }

    public List<HashMap<String,Object>> response(){
        return admins.stream().map(admin -> admin.data()).collect(Collectors.toList());
    }
}
