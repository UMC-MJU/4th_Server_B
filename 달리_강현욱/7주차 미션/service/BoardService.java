package com.umcblog.Blog.service;

import com.umcblog.Blog.dto.BoardDto;
import com.umcblog.Blog.dto.BoardModifyDto;
import com.umcblog.Blog.entity.Board;
import com.umcblog.Blog.repository.BoardRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BoardService {
    private final BoardRepository boardRepository;
    @Autowired
    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    //ID 로 찾기
    public Board findBoardById(Long id){
        return boardRepository.findById(id).orElseThrow(()-> new RuntimeException("target not found"));
    }
    //글 생성
    @Transactional
    public Board write(BoardDto boardDto){
        Board newBoard = Board.builder()
                .writer("default")
                .title(boardDto.getTitle())
                .content(boardDto.getContent())
                .build();
        boardRepository.save(newBoard);
        return newBoard;
    }
    //글 수정
    @Transactional
    public Board modify(Long id, BoardModifyDto boardModifyDto){
        Board destBoard = boardRepository.findById(id).orElseThrow(() -> new RuntimeException("not found"));
        destBoard.setTitle(boardModifyDto.getTitle());
        destBoard.setContent(boardModifyDto.getContent());
        return destBoard;
    }
    //글 삭제
    @Transactional
    public void Delete(Long id){
        boardRepository.findById(id).orElseThrow(() -> new RuntimeException("target not found"));
        boardRepository.deleteById(id);
    }
}
