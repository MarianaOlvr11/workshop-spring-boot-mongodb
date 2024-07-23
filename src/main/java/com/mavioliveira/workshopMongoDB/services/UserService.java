package com.mavioliveira.workshopMongoDB.services;


import com.mavioliveira.workshopMongoDB.domain.User;
import com.mavioliveira.workshopMongoDB.dto.UserDTO;
import com.mavioliveira.workshopMongoDB.repository.UserRepository;
import com.mavioliveira.workshopMongoDB.services.exception.ObjectNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // informa que é um serviço que pode ser injetavel em outras classes
public class UserService {

    // para implementar operação que retorna todos os usuarios o serviço tem que converesar com o repositório
    @Autowired // instancia automaticamente
    private UserRepository repository;


    public List<User> findAll(){
            return repository.findAll(); // pega os metodos do repository MongoDB
    }

    public User findById (String id){
        // procura se tem um na coleçao
        Optional<User> user = repository.findById(id);

         return user.orElseThrow(() -> new ObjectNotFound("User ID not found: " + id)); // retornar usuario caso haja, senão lança exceção
    }

    public User insert(User obj){
        return repository.insert(obj); // insere usuario
    }

    public void delete(String id){ // deleta o usuario com base no id
        repository.deleteById(id);
    }

    public User fromDTO (UserDTO objDTO){ // instanciar com base no DTO
        return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
    }
}
