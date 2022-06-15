package com.iamatum.jpademo;

import com.iamatum.jpademo.domain.Post;
import com.iamatum.jpademo.domain.PostComment;
import com.iamatum.jpademo.repositories.PostCommentRepository;
import com.iamatum.jpademo.repositories.PostRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class JpaEntityTest {

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private PostCommentRepository postCommentRepository;


    @Test
    void shouldPersistAPost() {
        Post post = Post.builder().description("My first post").build();
        postRepository.save(post);

        List<Post> posts = postRepository.findAll();
        assertEquals(1, posts.size());

        PostComment postComment = PostComment.builder()
                .comment("This is the first one")
                .build();

        postCommentRepository.save(postComment);

        List<PostComment> postComments = postCommentRepository.findAll();
        assertEquals(1, postComments.size());


    }

}
