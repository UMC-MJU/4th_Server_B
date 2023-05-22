package com.umcblog.Blog.repository;

import com.umcblog.Blog.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board,Long> {
}
