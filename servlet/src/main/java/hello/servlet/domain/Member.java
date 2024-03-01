package hello.servlet.domain;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Member {

    private long id; //회원 저장 레퍼지토리
    private String username;
    private int age;

    public Member() {
    }

    public Member(String username, int age) {
        this.username = username;
        this.age = age;
    }
}
