package umc.carrot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.carrot.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByEmail(String email);

    List<User> findAllByEmail(String email);

}
