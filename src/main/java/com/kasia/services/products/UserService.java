package com.kasia.services.products;

import com.kasia.domain.products.User;


public interface UserService {


    Iterable<User> findAll();

    User addUser(User user);

    boolean userFormComplete(User user);

    User getByMail(String mail);


}
