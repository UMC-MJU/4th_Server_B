package umc.boardcrud.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.boardcrud.domain.Board;
import umc.boardcrud.domain.BoardListResponseDto;
import umc.boardcrud.domain.BoardRequestDto;
import umc.boardcrud.domain.BoardResponseDto;
import umc.boardcrud.repository.BoardRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    //게시물 생성
    public BoardResponseDto createdBoard(BoardRequestDto requestDto) {
        Board board = new Board(requestDto);
        boardRepository.save(board);
        return new BoardResponseDto(board);
    }

    //모든 게시물 가져오기
    public List<BoardListResponseDto> findAllBoard() {
        try {
            List<Board> boardList = boardRepository.findAll();

            List<BoardListResponseDto> responseDtoList = new ArrayList<>();

            for(Board board : boardList) {
                responseDtoList.add(
                        new BoardListResponseDto(board)
                );
            }
            return responseDtoList;
        } catch (Exception e) {
//            throw new DBEmptyDataException("a");
        }
        return null;
    }

    //게시물 하나 가져오기
    public BoardResponseDto findOneBoard(Long id) {
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("조회실패")
        );
        return new BoardResponseDto(board);
    }

    //게시물 수정
    @Transactional
    public Long updateBoard(Long id, BoardRequestDto requestDto) {
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다.")
        );
        board.update(requestDto);
        return board.getId();
    }

    //게시물 삭제
    @Transactional
    public Long deleteBoard(Long id) {
        boardRepository.deleteById(id);
        return id;
    }

}
