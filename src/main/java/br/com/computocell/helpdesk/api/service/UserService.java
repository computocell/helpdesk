package br.com.computocell.helpdesk.api.service;

import org.springframework.data.domain.Page;

import br.com.computocell.helpdesk.api.security.entity.User;

public interface UserService {

    User findByEmail(String email);

    User createOsUpdate(User user);

    User findById(String id);

    void delete(String id);

    Page<User> findAll(int page, int count);
}
