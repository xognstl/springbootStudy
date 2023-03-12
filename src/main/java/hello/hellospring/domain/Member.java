package hello.hellospring.domain;

import javax.persistence.*;

@Entity
public class Member {
    // pk 와 pk자동생성 하는걸 밑에 처럼
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    @Column(name = "username")    // column에 이름이 다를때는 이런어노테이션을 만듬.
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
