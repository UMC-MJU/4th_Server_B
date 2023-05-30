package com.umcblog.Blog.service;


        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;
        import org.springframework.transaction.annotation.Transactional;

    @Service
public classPostService {
private finalPostRepository postRepository;

@Autowired
publicPostService(PostRepository postRepository) {
        this.postRepository = postRepository;
        }

//특정 글 조회 (id)
        publicPostDto findOne(Long id) {
        Post targetPost = postRepository.findById(id).orElseThrow(() ->newTargetNotFoundException("target not found"));
        return newPostDto(targetPost.getTitle(), targetPost.getWriter().getUsername(), targetPost.getContent());
        }

//글 생성
@Transactional
publicPostDto write(PostDto postDto, User user) {
        validatePostDtoInput(postDto);

        Post newPost = Post.builder().
        writer(user).
        title(postDto.getTitle()).
        content(postDto.getContent()).
        build();

        postRepository.save(newPost);

        return newPostDto(postDto.getTitle(), user.getUsername(), postDto.getContent());
        }

//글 수정
@Transactional
publicPostDto edit(Long id, PostEditDto editDto, User user) {
        validatePostEditDtoInput(editDto);

        Post targetPost = postRepository.findById(id).orElseThrow(
        () ->newTargetNotFoundException("target not found")
        );

        validatePostAuth(targetPost, user);

        targetPost.setTitle(editDto.getTitle());
        targetPost.setContent(editDto.getContent());

        return newPostDto(targetPost.getTitle(), user.getUsername(), targetPost.getContent());
        }

//글 삭제
@Transactional
public voiddelete(Long id, User user) {
        Post targetPost = postRepository.findById(id).orElseThrow(() ->newTargetNotFoundException("target not found"));

        validatePostAuth(targetPost, user);

        postRepository.deleteById(id);
        }

private voidvalidatePostEditDtoInput(PostEditDto editDto) {
        if(editDto.getTitle() ==null|| editDto.getContent() ==null)
        throw newInputValidateException("validation error");
        }

private voidvalidatePostDtoInput(PostDto postDto) {
        if(postDto.getTitle() ==null|| postDto.getContent() ==null)
        throw newInputValidateException("validation error");
        }

private voidvalidatePostAuth(Post post, User user) {
        if(!post.getWriter().equals(user))
        throw newPermissionException("권한이 없습니다.");
        }
        }