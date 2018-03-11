package com.kasia.repositories;

import com.kasia.domain.products.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User getUserByMailAdress(String mail);

}
