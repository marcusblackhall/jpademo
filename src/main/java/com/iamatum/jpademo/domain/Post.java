package com.iamatum.jpademo.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Post {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;
    private String description;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "post", orphanRemoval = true)
    private List<PostComment> postComments = new ArrayList<>();

    public void addComment(PostComment postComment) {
        if (postComments == null) postComments = new ArrayList<>();
        postComments.add(postComment);
        postComment.setPost(this);

    }


}
