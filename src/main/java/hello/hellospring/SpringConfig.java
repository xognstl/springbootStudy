package hello.hellospring;

import hello.hellospring.aop.TimeTraceAop;
import hello.hellospring.repository.*;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    //jdbc사용시
//    private DataSource dataSource;
//
//    @Autowired
//    public SpringConfig(DataSource dataSource){
//        this.dataSource = dataSource;
//    }
    //jpa 사용시
//    private EntityManager em;
//
//    @Autowired
//    public SpringConfig(EntityManager em){
//        this.em = em;
//    }
    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    @Bean
    public MemberService memberService() {
//        return new MemberService(memberRepository());
        //spring data jpa 사용시만
        return new MemberService(memberRepository);
    }

//    @Bean
//    public MemberRepository memberRepository(){
//        //memory
////        return new MemoryMemberRepository();
//        //jdbc
////        return new JdbcMemberRepository(dataSource);
//        //jdbcTemplate
////        return new JdbcTemplateMemberRepository(dataSource);
//        //jpa
////        return new JpaMemberRepository(em);
//        // spring data jpa  사용시 함수 전체 주석
//    }
    //aop 등록 할때 이렇게 아니면 @Component
//    @Bean
//    public TimeTraceAop timeTraceAop() {
//        return new TimeTraceAop();
//    }

}
