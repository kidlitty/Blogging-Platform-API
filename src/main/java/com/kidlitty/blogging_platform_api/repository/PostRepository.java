package com.kidlitty.blogging_platform_api.repository;

import com.kidlitty.blogging_platform_api.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
