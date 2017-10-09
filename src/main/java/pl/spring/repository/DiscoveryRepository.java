package pl.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.spring.entity.Discovery;

import java.util.List;

/**
 * @author Andrzej I.
 * copyright 02.10.17.
 *
 * Klasa komunikująca się z bazą danych (Discovery).
 **/
@Repository
public interface DiscoveryRepository extends JpaRepository<Discovery, Long> {

    /*
    * Wyszukiwanie według tytułu.
    * */
    List<Discovery> findAllByTitle(String tytul);
    /*
    * Sortowanie według glosowań.
    * */
    List<Discovery> findAllByOrderByUpvoteDesc();
    /*
    * Sortowanie według rankingu.
    * */
    List<Discovery> findAllByOrderByRankingDesc();
}
