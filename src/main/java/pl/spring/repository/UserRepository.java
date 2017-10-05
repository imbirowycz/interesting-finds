package pl.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.spring.entity.User;

/**
 * @author Andrzej I.
 * copyright 02.10.17.
 **/
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String username);
}
