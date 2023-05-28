package umc.apidevelop.domain.Member.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.apidevelop.domain.Member.domain.Member;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByMemberId(String username);
}
