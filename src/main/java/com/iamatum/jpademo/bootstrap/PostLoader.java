package com.iamatum.jpademo.bootstrap;

import com.iamatum.jpademo.domain.Post;
import com.iamatum.jpademo.domain.PostComment;
import com.iamatum.jpademo.repositories.PostCommentRepository;
import com.iamatum.jpademo.repositories.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Component
public class PostLoader implements CommandLineRunner {

    private final PostRepository postRepository;
    private final PostCommentRepository postCommentRepository;

    @Override
    public void run(String... args) {

        postRepository.deleteAll();
        postCommentRepository.deleteAll();

        Post post1 = Post.builder()
                .description("post one")

                .build();
        postRepository.save(post1);

        PostComment postComment1 = PostComment.builder()
                .comment("good comment one")
                .build();
        PostComment postComment2 = PostComment.builder()
                .comment("bad comment one")
                .build();

        postCommentRepository.saveAll(List.of(postComment1, postComment2));

        post1.addComment(postComment1);
        post1.addComment(postComment2);

        postRepository.save(post1);


    }
}
