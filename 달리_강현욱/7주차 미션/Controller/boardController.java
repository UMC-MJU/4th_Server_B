package com.umcblog.Blog.Controller;

import com.umcblog.Blog.dto.BoardDto;
import com.umcblog.Blog.dto.BoardModifyDto;
import com.umcblog.Blog.entity.Board;
import com.umcblog.Blog.exception.ExceptionResponse;
import com.umcblog.Blog.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.*;
import static org.springframework.http.ResponseEntity.status;

@RestController
public class boardController {
    @Autowired

    private BoardService boardService;

    @GetMapping("/board/{id}") //localhost:8081/board/{id}
    public Board findBoard(@PathVariable Long id){
        Board board = boardService.findBoardById(id);
        return board;
    }

    @PostMapping("/board/write")//localhost:8081/board/write
    public Board boardwriteForm(@RequestBody BoardDto boardDto) {
        Board newBoard = boardService.write(boardDto);
        return newBoard;
    }

    @PutMapping("/board/write")//localhost:8081/board/write
    public Board boardmodify(@RequestHeader Long id,@RequestBody BoardModifyDto boardModifyDto){
        Board target = boardService.modify(id , boardModifyDto);
        return target;
    }

    @DeleteMapping("/{id}")//localhost:8081/{id}
    public ResponseEntity<?> boardDelete(@PathVariable Long id){
        try{
            boardService.Delete(id);
            return status(HttpStatus.OK).body("글 삭제 완료");
        }catch(RuntimeException e){
            return errorMessage(e.getMessage());
        }
    }
    public static ResponseEntity<ExceptionResponse> errorMessage(String e){
        ExceptionResponse exceptionResponse = new ExceptionResponse(e);
        return status(HttpStatus.BAD_REQUEST)
                .body(exceptionResponse);
    }
}