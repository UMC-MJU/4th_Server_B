package umc.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.blog.dto.PostDto;
import umc.blog.dto.PostEditDto;
import umc.blog.entity.Post;
import umc.blog.exception.InputValidateException;
import umc.blog.exception.TargetNotFoundException;
import umc.blog.repository.PostRepository;

@Service
public class PostService {
    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    // 특정 글 조회 (id)
    public Post findOne(Long id) {
        return postRepository.findById(id).orElseThrow(() -> new TargetNotFoundException("target not found"));
    }

    // 글 생성
    @Transactional
    public Post write(PostDto postDto) {
        validatePostDtoInput(postDto);

        Post newPost = Post.builder().
                writer("익명"). // 원래 FK이기 때문에 숫자를 정의하는 게 좋지만 익명임을 나타내기 위해 이렇게 설정
                        title(postDto.getTitle()).
                content(postDto.getContent()).
                build();

        postRepository.save(newPost);

        return newPost;
    }

    // 글 수정
    @Transactional
    public Post edit(Long id, PostEditDto editDto) {
        validatePostEditDtoInput(editDto);

        Post targetPost = postRepository.findById(id).orElseThrow(
                () -> new TargetNotFoundException("target not found")
        );

        targetPost.setTitle(editDto.getTitle());
        targetPost.setContent(editDto.getContent());

        return targetPost;
    }

    // 글 삭제
    @Transactional
    public void delete(Long id) {
        postRepository.findById(id).orElseThrow(() -> new TargetNotFoundException("target not found"));
        postRepository.deleteById(id);
    }

    public void validatePostEditDtoInput(PostEditDto editDto) {
        if (editDto.getTitle() == null || editDto.getContent() == null)
            throw new InputValidateException("validation error");
    }

    public void validatePostDtoInput(PostDto postDto) {
        if (postDto.getTitle() == null || postDto.getContent() == null)
            throw new InputValidateException("validation error");
    }
}