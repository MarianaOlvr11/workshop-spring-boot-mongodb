package com.mavioliveira.workshopMongoDB.repository;

import com.mavioliveira.workshopMongoDB.domain.Post;
import com.mavioliveira.workshopMongoDB.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> { // coloca primeiro a classe que ele vai gerenciar, e em seguida, o tipo do id da classe que no caso de user é string

}
