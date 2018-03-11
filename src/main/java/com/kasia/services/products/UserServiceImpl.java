package com.kasia.services.products;

import com.kasia.domain.products.User;
import com.kasia.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public boolean userFormComplete(User user) {
        String emptyField = "";
        if (user.getName().equals(emptyField) || user.getPassword().equals(emptyField) || user.getLastName().equals(emptyField) || user.getMailAdress().equals(emptyField))
            return false;
        else
            return true;
    }

    public User getByMail(String mail) {
        return userRepository.getUserByMailAdress(mail);
    }


}
