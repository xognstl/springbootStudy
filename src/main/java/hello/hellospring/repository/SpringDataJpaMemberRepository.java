package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//extend (a,b) a = Member, b = id type
public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    //JPQL SELECT m from Member m where m.name = ?
    @Override
    Optional<Member> findByName(String name);
}
