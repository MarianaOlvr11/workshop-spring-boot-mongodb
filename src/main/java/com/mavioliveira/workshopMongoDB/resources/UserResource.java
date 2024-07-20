package com.mavioliveira.workshopMongoDB.resources;


import com.mavioliveira.workshopMongoDB.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController //  indica que a classe anotada é um controlador responsável por lidar com requisições HTTP (no caso o CRUD) e retornar respostas em formato JSON ou XML.
@RequestMapping(value = "/users") // caminho do endpoint
public class UserResource {

    //methods:

    @RequestMapping(method = RequestMethod.GET) // imforma que o method é endpoint rest, obtem informações por isso GET
    public ResponseEntity<List<User>> findAll(){ // pega todos os users
        User maria = new User("1", "Maria Brown", "maria@gmail.com");
        User alex = new User("2", "Alex Green", "alex@gmail.com");

        List<User> list = new ArrayList<>();
        list.addAll(Arrays.asList(maria,alex));

        return ResponseEntity.ok().body(list); // corpo da resposta é a lista
    }


}
