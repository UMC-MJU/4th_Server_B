package umc.boardcrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.boardcrud.domain.Board;
import umc.boardcrud.domain.BoardListResponseDto;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {
    //사용할 Entity Board, 타입 Long
    List<BoardListResponseDto> findAllByOrderByModifiedAtDesc();
}
