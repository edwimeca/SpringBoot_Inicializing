package com.fundamentos.SpringBoot.fundamentosV11.repository;

import com.fundamentos.SpringBoot.fundamentosV11.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
