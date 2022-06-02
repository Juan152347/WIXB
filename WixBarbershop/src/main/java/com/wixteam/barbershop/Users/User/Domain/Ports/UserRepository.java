package com.wixteam.barbershop.Users.User.Domain.Ports;

import com.wixteam.barbershop.Users.User.Domain.User;

import java.util.HashMap;
import java.util.List;

public interface UserRepository {
    public void save(User user);
    public List<User> all();
    public List<User> allCustomer(String customer);
    public List<User> allBarber(String Barber);
    public void delete(String idUser);
    public void update(User user, String idUser);
    public HashMap<String,Object> Login(String username, String password);
}
