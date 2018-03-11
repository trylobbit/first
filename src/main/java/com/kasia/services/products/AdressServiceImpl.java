package com.kasia.services.products;

import com.kasia.domain.products.Adress;
import com.kasia.repositories.AdressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdressServiceImpl implements AdressService {

    @Autowired
    private AdressRepository adressRepository;

    public Iterable<Adress> findAll() {
        return adressRepository.findAll();
    }

    public Adress addAdress(Adress adress) {
        return adressRepository.save(adress);
    }
}
