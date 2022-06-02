package com.wixteam.barbershop.Admin.Domain;

import com.wixteam.barbershop.Admin.Domain.ValueObjects.AdminId;
import com.wixteam.barbershop.Admin.Domain.ValueObjects.AdminName;
import com.wixteam.barbershop.Admin.Domain.ValueObjects.AdminPassword;

import java.util.HashMap;

public class Admin {
    private AdminId adminId;
    private AdminName adminName;
    private AdminPassword adminPassword;

    public Admin(){}

    public Admin(AdminId adminId, AdminName adminName, AdminPassword adminPassword) {
        this.adminId = adminId;
        this.adminName = adminName;
        this.adminPassword = adminPassword;
    }

    public static Admin create(AdminId adminId,AdminName adminName, AdminPassword adminPassword){
        Admin admin = new Admin(adminId,adminName,adminPassword);
        return admin;
    }
    public HashMap<String,Object> data(){
        HashMap<String,Object> data = new HashMap<>(){
            {
                put("id",adminId.value());
                put("name",adminName.value());
                put("pass",adminPassword.value());
            }

        };
        return data;
    }
}
