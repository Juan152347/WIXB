package com.wixteam.barbershop.Services.Date.Domain.Port;

import com.wixteam.barbershop.Services.Date.Domain.Date;
import com.wixteam.barbershop.Users.User.Domain.User;


import java.util.List;

public interface DateRepository {
    public void save(Date date);
    public List<Date> all();
    public void delete(String idDate);
    public  Date find(String idDate);
    public List<Date> allDateTypeUser(String idUser, String Type);
}
