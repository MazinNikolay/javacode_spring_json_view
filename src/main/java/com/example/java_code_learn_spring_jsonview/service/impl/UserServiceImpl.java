package com.example.java_code_learn_spring_jsonview.service.impl;

import com.example.java_code_learn_spring_jsonview.dto.UserDto;
import com.example.java_code_learn_spring_jsonview.mapper.UserMapper;
import com.example.java_code_learn_spring_jsonview.model.User;
import com.example.java_code_learn_spring_jsonview.repository.UserRepository;
import com.example.java_code_learn_spring_jsonview.service.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    private final UserMapper mapper;
    private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User createUser(UserDto dto) {
        logger.info("was invoked user create method in service");
        checkNotExistEntity(dto);
        return repository.save(mapper.mapDtoToEntity(dto));
    }

    @Override
    public User updateUser(Long id, UserDto dto) {
        logger.info("was invoked user update method in service");
        checkExistEntity(dto);
        return repository.save(mapper.mapDtoToEntity(dto));
    }

    @Override
    public void deleteUser(Long id) {
        logger.info("was invoked user delete method in service");
        repository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
        repository.deleteById(id);
    }

    @Override
    public List<User> getAllUsers() {
        logger.info("was invoked get all users method in service");
        return repository.findAll();
    }

    @Override
    public User getUserData(Long id) {
        logger.info("was invoked get user data method in service");
        repository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
        return repository.findById(id).get();
    }

    private void checkExistEntity(UserDto dto) {
        User user = repository.findByNameAndEmail(dto.getUserName(), dto.getEmail());
        if (user == null) {
            throw new RuntimeException("Not found");
        }
    }

    private void checkNotExistEntity(UserDto dto) {
        User user = repository.findByNameAndEmail(dto.getUserName(), dto.getEmail());
        if (user != null) {
            throw new RuntimeException("Not found");
        }
    }
}
