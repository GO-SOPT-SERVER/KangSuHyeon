package sopt.org.SecondSeminar.controller.post;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sopt.org.SecondSeminar.controller.post.dto.CreatePostDTO;
import sopt.org.SecondSeminar.controller.post.dto.UpdatePostDTO;
import sopt.org.SecondSeminar.domain.post.Post;
import sopt.org.SecondSeminar.service.post.PostService;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping("/post")
    public String createPost(@RequestBody final CreatePostDTO post) {
        Long postId = postService.createPost(post);
        return postId + "번 게시물이 등록되었습니다.";
    }

    @GetMapping("/post/{postId}")
    public String getPostById(@PathVariable final int postId) {
        Optional<Post> post = postService.getPostById(postId);
        if (post.isEmpty())
            return "조회된 게시물이 없습니다.";
        return post.get().toString();
    }

    @GetMapping("/post")
    public String getPostByTitle(@RequestParam final String title) {
        String postList = postService.getPostByTitle(title);
        if (postList.isEmpty())
            return "조회된 게시물이 없습니다.";
        return postList;
    }

    @PutMapping("/post/{postId}")
    public String updatePost(@PathVariable final int postId, @RequestBody final UpdatePostDTO post) {
        Optional<String> updateResult = postService.updatePost(postId, post);
        return updateResult.orElse("게시물 업데이트를 실패했습니다.");
    }

    @DeleteMapping("/post/{postId}")
    public String deletePost(@PathVariable final int postId) {
        Optional<Integer> deletePostId = postService.deletePost(postId);
        return deletePostId.map(id -> id + "번 게시물이 삭제되었습니다.").orElse("게시물 삭제를 실패했습니다.");
    }
}
