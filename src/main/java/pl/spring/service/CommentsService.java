package pl.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.spring.entity.Comments;
import pl.spring.entity.Discovery;
import pl.spring.entity.User;
import pl.spring.repository.DiscoveryRepository;
import pl.spring.repository.CommentsRepository;
import pl.spring.repository.UserRepository;

/**
 * copyright 10.10.17.
 * author Andrzej I.
 **/
@Component
public class CommentsService {

    private DiscoveryRepository discoveryRepository;
    private CommentsRepository commentsRepository;
    private UserRepository userRepository;

    @Autowired
    public CommentsService(DiscoveryRepository discoveryRepository,
                           CommentsRepository commentsRepository,
                           UserRepository userRepository)
    {
        this.discoveryRepository = discoveryRepository;
        this.commentsRepository = commentsRepository;
        this.userRepository = userRepository;
    }

    public void saveComments(Comments comments, String id_user, Long id_discovery) {

        User user = userRepository.findByEmail(id_user);
        comments.setUser(user);
        commentsRepository.save(comments);
        Discovery discovery = discoveryRepository.findById(id_discovery);
        discovery.getCommentsList().add(comments);
        discoveryRepository.save(discovery);


    }
}
