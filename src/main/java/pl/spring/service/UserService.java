package pl.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.spring.entity.User;
import pl.spring.entity.UserRole;
import pl.spring.repository.UserRepository;
import pl.spring.repository.UserRoleRepository;

import java.util.List;

/**
 * @author Andrzej I.
 * copyright 02.10.17.
 **/
@Component
public class UserService {

    private static final String DEFAULT_ROLE = "ROLE_USER";
    private UserRepository userRepository;
    private UserRoleRepository roleRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setRoleRepository(UserRoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public void addWithDefaultRole(User user) {
        UserRole defaultRole = roleRepository.findByRole(DEFAULT_ROLE);
        user.getRoles().add(defaultRole);
        userRepository.save(user);
    }

    public List<User> findAllUsers() {
        List<User> userList = userRepository.findAll();
        return userList;
    }
}
