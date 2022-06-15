package com.iamatum.jpademo.repositories;

import com.iamatum.jpademo.domain.PostComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostCommentRepository extends JpaRepository<PostComment, Integer> {
}
