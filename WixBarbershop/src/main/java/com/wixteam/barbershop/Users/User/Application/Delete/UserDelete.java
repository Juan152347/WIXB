package com.wixteam.barbershop.Users.User.Application.Delete;

import com.wixteam.barbershop.Users.User.Domain.Ports.UserRepository;
import com.wixteam.barbershop.Users.User.Domain.User;

public class UserDelete {
    private UserRepository repository;

    public UserDelete(UserRepository repository) {
        this.repository = repository;
    }
    public void execute(String idUser){
        repository.delete(idUser);
    }
}
