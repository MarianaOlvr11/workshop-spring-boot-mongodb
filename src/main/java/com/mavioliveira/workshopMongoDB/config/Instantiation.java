package com.mavioliveira.workshopMongoDB.config;

import com.mavioliveira.workshopMongoDB.domain.Post;
import com.mavioliveira.workshopMongoDB.domain.User;
import com.mavioliveira.workshopMongoDB.dto.AuthorDTO;
import com.mavioliveira.workshopMongoDB.repository.PostRepository;
import com.mavioliveira.workshopMongoDB.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.w3c.dom.Comment;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration // spring saber que é configuração
public class Instantiation implements CommandLineRunner {


    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;


    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll(); // limpa a coleção de user
        postRepository.deleteAll(); // limpa a coleção de post


        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, bob)); // cria lista de usuários e salva antes do post para gerar id

        Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem!","Vou viajar para São Paulo. Abraços!", new AuthorDTO(maria) );
        Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia.","Acordei feliz hoje!", new AuthorDTO(maria)  );


        postRepository.saveAll(Arrays.asList(post1,post2));


    }
}
