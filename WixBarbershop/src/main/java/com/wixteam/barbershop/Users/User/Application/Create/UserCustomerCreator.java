package com.wixteam.barbershop.Users.User.Application.Create;

import com.wixteam.barbershop.Users.User.Domain.ValueObjects.Phone;
import com.wixteam.barbershop.Users.User.Domain.Ports.UserRepository;
import com.wixteam.barbershop.Users.User.Domain.User;
import com.wixteam.barbershop.Users.User.Domain.ValueObjects.UserId;
import com.wixteam.barbershop.Users.User.Domain.ValueObjects.UserName;
import com.wixteam.barbershop.Users.User.Domain.ValueObjects.UserPassword;
import com.wixteam.barbershop.Users.User.Domain.ValueObjects.UserType;

public class UserCustomerCreator {
    private UserRepository repository;

    public UserCustomerCreator(UserRepository repository) {
        this.repository = repository;
    }

    public void execute(String userid, String username,String userPassword,String phone){
        User user = new User(new UserId(userid) , new UserName(username) , new UserPassword(userPassword) , new UserType("Customer"), new Phone(phone));
        repository.save(user);
    }
}
