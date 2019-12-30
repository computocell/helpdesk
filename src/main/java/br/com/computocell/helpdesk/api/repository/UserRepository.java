package br.com.computocell.helpdesk.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.computocell.helpdesk.api.entity.User;

public interface UserRepository extends MongoRepository<User,String> {
    User findByEmail(String email);


}
