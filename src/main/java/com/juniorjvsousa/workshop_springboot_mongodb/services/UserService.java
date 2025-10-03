package com.juniorjvsousa.workshop_springboot_mongodb.services;

import com.juniorjvsousa.workshop_springboot_mongodb.domain.User;
import com.juniorjvsousa.workshop_springboot_mongodb.repository.UserRepository;
import com.juniorjvsousa.workshop_springboot_mongodb.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> findAll() {
        return repo.findAll();

    }

    public User findById(String id) {
        Optional<User> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }
}
