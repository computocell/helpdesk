package br.com.computocell.helpdesk.api.service.impl;

import br.com.computocell.helpdesk.api.entity.User;
import br.com.computocell.helpdesk.api.repository.UserRepository;
import br.com.computocell.helpdesk.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User findByEmail(String email) {
        return this.userRepository.findByEmail(email);
    }

    @Override
    public User createOsUpdate(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public User findById(String id) {
        Optional<User> studentOptional = this.userRepository.findById(id);
        return studentOptional.orElse(null);
    }

    @Override
    public void delete(String id) {
        this.userRepository.deleteById(id);
    }

    @Override
    public Page<User> findAll(int page, int count) {
        Pageable pages = new PageRequest(page,count);
        return this.userRepository.findAll(pages);
    }
}
