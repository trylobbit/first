package com.kasia.services.products;

import com.kasia.domain.products.Adress;


public interface AdressService {
    Iterable<Adress> findAll();

    Adress addAdress(Adress adress);
}
