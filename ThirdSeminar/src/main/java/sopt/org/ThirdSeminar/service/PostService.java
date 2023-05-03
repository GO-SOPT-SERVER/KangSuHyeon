package sopt.org.ThirdSeminar.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sopt.org.ThirdSeminar.controller.dto.request.PostRequestDto;
import sopt.org.ThirdSeminar.controller.dto.response.PostResponseDto;
import sopt.org.ThirdSeminar.domain.Post;
import sopt.org.ThirdSeminar.domain.User;
import sopt.org.ThirdSeminar.infrastructure.PostRepository;
import sopt.org.ThirdSeminar.infrastructure.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor //final이 붙거나 @NotNull 이 붙은 필드의 생성자를 자동 생성
public class PostService {

    private final UserRepository userRepository;
    private final PostRepository postRepository;

    @Transactional //일련의 작업을 하나로 묶어서 처리 -> 오류가 발생했을 때 모든 작업들을 원상태로 되돌릴 수 있음
    public PostResponseDto createPost(PostRequestDto request) {

        User user = userRepository.findById(request.getUserId());
        Post post = Post.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .user(user)
                .build();

        postRepository.save(post);

        return PostResponseDto.of(post.getId(), post.getTitle(), post.getContent());
    }

    public List<PostResponseDto> getPostByUserId(final Long userId) {
        final List<PostResponseDto> postList = new ArrayList<>();
        postRepository.findAllByUserId(userId).forEach((p) ->
                postList.add(PostResponseDto.of(p.getId(), p.getTitle(), p.getContent()))
        );
        return postList;
    }

    public List<PostResponseDto> getPostByTitle(final String title) {
        final List<PostResponseDto> postList = new ArrayList<>();
        postRepository.findAllByTitle(title).forEach((p) ->
                postList.add(PostResponseDto.of(p.getId(), p.getTitle(), p.getContent()))
        );
        return postList;
    }
}
