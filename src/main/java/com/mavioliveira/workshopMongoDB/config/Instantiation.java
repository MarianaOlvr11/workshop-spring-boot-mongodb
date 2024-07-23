package com.mavioliveira.workshopMongoDB.config;

import com.mavioliveira.workshopMongoDB.domain.User;
import com.mavioliveira.workshopMongoDB.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.w3c.dom.Comment;

import java.util.Arrays;

@Configuration // spring saber que é configuração
public class Instantiation implements CommandLineRunner {


    @Autowired
    private UserRepository repository;


    @Override
    public void run(String... args) throws Exception {

        repository.deleteAll(); // limpa a coleção


        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        repository.saveAll(Arrays.asList(maria, alex, bob)); // cria lista de usuários


    }
}
