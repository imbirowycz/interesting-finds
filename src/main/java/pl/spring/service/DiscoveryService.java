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
        return discoveryRepository.findAll();
    }

    /*
    * Wyszukiwanie wekług podanego tytułu.
    *
    * */

    public List<Discovery> wyszukaj(String tytul) {
        return  discoveryRepository.findAllByTitle(tytul);
    }

    /*
    * Sortowanie według podanego kryterium
    * (param) - kryterium.
    *
    * mast be implements a param-(komenty).!!!!
    *
    * */

    public List<Discovery> sortujWedlug(String param) {
        List<Discovery> discoveryList = null;
        if (param.equals("ocena")) discoveryList = discoveryRepository.findAllByOrderByUpvoteDesc();
        if (param.equals("ranking")) discoveryList = discoveryRepository.findAllByOrderByRankingDesc();
        if (param.equals("komenty")) discoveryList = discoveryRepository.findAllByOrderByUpvoteDesc();
        return discoveryList;
    }
}
