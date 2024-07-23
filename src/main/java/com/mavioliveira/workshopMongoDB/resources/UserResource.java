package com.mavioliveira.workshopMongoDB.resources;


import com.mavioliveira.workshopMongoDB.domain.User;
import com.mavioliveira.workshopMongoDB.dto.UserDTO;
import com.mavioliveira.workshopMongoDB.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController //  indica que a classe anotada é um controlador responsável por lidar com requisições HTTP (no caso o CRUD) e retornar respostas em formato JSON ou XML.
@RequestMapping(value = "/users") // caminho do endpoint
public class UserResource {


    /* Arquitetura de camadas:
    1. O controlador Rest(resource) acessa o serviço
    2. O Serviço acessa o repositorio com os metodos do Mongo DB
     */

    // injeta um serviço
    @Autowired
    private UserService service;


    //methods:

    @RequestMapping(method = RequestMethod.GET) // imforma que o method é endpoint rest, obtem informações por isso GET
    public ResponseEntity<List<UserDTO>> findAll(){ // pega todos os users
        List<User> list = service.findAll(); // coloca todos os usuarios na lista
        List<UserDTO> listDTO = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList()); // converte cada objeto para dto
        return ResponseEntity.ok().body(listDTO); // corpo da resposta é a lista
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET) // imforma que o method é endpoint rest, obtem informações por isso GET
    public ResponseEntity<UserDTO> findById(@PathVariable String  id){ // pega o id com referencia /{id}
      User obj = service.findById(id);

      return ResponseEntity.ok().body(new UserDTO(obj));

    }




}
