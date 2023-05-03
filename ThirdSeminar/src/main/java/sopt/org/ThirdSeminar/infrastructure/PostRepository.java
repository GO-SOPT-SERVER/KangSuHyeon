package sopt.org.ThirdSeminar.infrastructure;

import org.springframework.data.repository.Repository;
import sopt.org.ThirdSeminar.domain.Post;

import java.util.List;

public interface PostRepository extends Repository<Post, Long> {
    void save(Post post);

    List<Post> findAllByUserId(Long userId);

    List<Post> findAllByTitle(String title);
}
