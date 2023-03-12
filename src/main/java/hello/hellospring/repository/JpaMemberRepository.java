package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements MemberRepository{

    private final EntityManager em;

    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Member save(Member member) {
        em.persist(member); // persist 저장하다, 영속하다
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        Member member = em.find(Member.class, id);  // find 조회 find(타입, 식별자pk)
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByName(String name) {
        // id 가 있어야해서 jpql이라는 객체지향 쿼리 언어를 사용해야함.
        List<Member> result = em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name).getResultList();

        return result.stream().findAny();
    }

    @Override
    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class).getResultList();
        // from Member (객체 대상으로 쿼리를 날림)  ,,,  select 를 객체 자체 m을 함
    }
}
