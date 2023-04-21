package sopt.org.SecondSeminar.service.post;

import org.springframework.stereotype.Service;
import sopt.org.SecondSeminar.controller.post.dto.CreatePostDTO;
import sopt.org.SecondSeminar.domain.post.Post;

import java.util.Optional;

import static sopt.org.SecondSeminar.SecondSeminarApplication.postList;

@Service
public class PostService {

    public Long createPost(CreatePostDTO post) {
        Post newPost = new Post(
                post.getWriter(),
                post.getTitle(),
                post.getContent(),
                post.getLike()
        );

        postList.add(newPost);
        newPost.setId((long) postList.size());

        return newPost.getId();
    }

    public Optional<Post> getPostById(Integer postId) { //코틀린 nullable ? 대신 자바는 Optional
        if (postList.size() >= postId) {
            return Optional.of(postList.get(postId)); //코틀린 !! -> 무조건 null이 아님
        } else {
            return Optional.empty(); //null 객체
        }
    }

    public String getPostByTitle(String title) {
        StringBuilder resultPostList = new StringBuilder();
        postList.forEach((post) -> {
                    if (title.equals(post.getTitle())) {
                        resultPostList.append(post);
                        resultPostList.append("\n");
                    }
                }
        );

        return resultPostList.toString();
    }
}
