package pl.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.spring.entity.Comments;

/**
 * copyright 10.10.17.
 * author Andrzej I.
 **/
@Repository
public interface CommentsRepository extends JpaRepository<Comments, Long>{
}
