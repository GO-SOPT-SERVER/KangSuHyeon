package sopt.org.fourthSeminar.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sopt.org.fourthSeminar.controller.request.dto.BoardImageListRequestDto;
import sopt.org.fourthSeminar.controller.request.dto.BoardRequestDto;
import sopt.org.fourthSeminar.domain.Board;
import sopt.org.fourthSeminar.domain.Image;
import sopt.org.fourthSeminar.domain.User;
import sopt.org.fourthSeminar.exception.Error;
import sopt.org.fourthSeminar.exception.model.NotFoundException;
import sopt.org.fourthSeminar.infrastructure.BoardRepository;
import sopt.org.fourthSeminar.infrastructure.ImageRepository;
import sopt.org.fourthSeminar.infrastructure.UserRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final UserRepository userRepository;
    private final BoardRepository boardRepository;
    private final ImageRepository imageRepository;

    @Transactional
    public void create(Long userId, String boardThumbnailImageUrl, BoardRequestDto request) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException(Error.NOT_FOUND_USER_EXCEPTION, Error.NOT_FOUND_USER_EXCEPTION.getMessage()));

        Board newBoard = Board.newInstance(
                user,
                boardThumbnailImageUrl,
                request.getTitle(),
                request.getContent(),
                request.getIsPublic()
        );

        boardRepository.save(newBoard);
    }

    @Transactional
    public void create(Long userId, List<String> boardImageUrlList, BoardImageListRequestDto request) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException(Error.NOT_FOUND_USER_EXCEPTION, Error.NOT_FOUND_USER_EXCEPTION.getMessage()));

        // 게시글 생성
        Board newBoard = Board.newInstance(
                user,
                request.getTitle(),
                request.getContent(),
                request.getIsPublic()
        );

        boardRepository.save(newBoard);

        // 이미지 생성
        for (String boardImageUrl : boardImageUrlList) {
            imageRepository.save(Image.newInstance(newBoard, boardImageUrl));
        }
    }
}
