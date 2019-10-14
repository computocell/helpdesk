package br.com.computocell.helpdesk.api.repository;

import br.com.computocell.helpdesk.api.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User,String> {
    User findByEmail(String email);


}
