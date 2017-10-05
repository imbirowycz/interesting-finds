package pl.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.spring.entity.Discovery;
import pl.spring.entity.User;
import pl.spring.repository.DiscoveryRepository;
import pl.spring.repository.UserRepository;

import java.util.List;

/**
 * @author Andrzej I.
 * copyright 02.10.17.
 **/
@Component
public class DiscoveryService {

    private DiscoveryRepository discoveryRepository;
    private UserRepository userRepository;


    @Autowired
    public DiscoveryService(DiscoveryRepository discoveryRepository, UserRepository userRepository) {
        this.discoveryRepository = discoveryRepository;
        this.userRepository = userRepository;
    }


    public void save(Discovery discovery, String email) {
        User user = userRepository.findByEmail(email);
        discovery.setUser(user);
        discoveryRepository.save(discovery);
    }

    public List<Discovery> findWszytkieDiscovery() {
        List<Discovery> discoveries = discoveryRepository.findAll();
        return discoveries;
    }
}
