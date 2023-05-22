package umc.boardcrud.controller;

import org.springframework.web.bind.annotation.*;
import umc.boardcrud.domain.BoardListResponseDto;
import umc.boardcrud.domain.BoardRequestDto;
import umc.boardcrud.domain.BoardResponseDto;
import umc.boardcrud.service.BoardService;

import java.util.List;

@RestController //JSON으로 데이터를 주고받음을 선언
public class BoardController {
    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    //게시물 등록
    @PostMapping("/boards")
    public BoardResponseDto createBoard(@RequestBody BoardRequestDto requestDto) {
        BoardResponseDto board = boardService.createdBoard(requestDto);
        return board;
    }

    //전체 목록 조회
    @GetMapping("/boards")
    public List<BoardListResponseDto> getAllBoards() {
        return boardService.findAllBoard();
    }

    //게시물 하나 조회
    @GetMapping("/boards/{id}")
    public BoardResponseDto getOneBoard(@PathVariable Long id) {
        return boardService.findOneBoard(id);
    }

    //게시물 수정
    @PutMapping("/boards/{id}")
    public Long updateBoard(@PathVariable Long id, @RequestBody BoardRequestDto requestDto) {
        return boardService.updateBoard(id, requestDto);
    }

    //게시물 삭제
    @DeleteMapping("/boards/{id}")
    public Long deleteBoard(@PathVariable Long id) {
        return boardService.deleteBoard(id);
    }

//    //비밀번호 확인
//    @GetMapping("/boards/check/{id}/{inputPassword}")
//    public boolean checkPassword(@PathVariable Long id, @PathVariable String inputPassword) {
////        return boardService.checkPassword(id, inputPassword);
//    }
}
