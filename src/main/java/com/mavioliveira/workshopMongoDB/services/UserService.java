package com.mavioliveira.workshopMongoDB.services;


import com.mavioliveira.workshopMongoDB.domain.User;
import com.mavioliveira.workshopMongoDB.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // informa que é um serviço que pode ser injetavel em outras classes
public class UserService {

    // para implementar operação que retorna todos os usuarios o serviço tem que converesar com o repositório
    @Autowired // instancia automaticamente
    private UserRepository repository;


    public List<User> findAll(){
            return repository.findAll(); // pega os metodos do repository MongoDB
    }
}
