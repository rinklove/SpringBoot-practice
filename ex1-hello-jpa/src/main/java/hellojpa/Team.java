package hellojpa;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Team extends BaseEntity{

    @Id @GeneratedValue
    @Column(name = "TEAM_ID")
    private Long id;
    private String name;

    @OneToMany()//팀에서 멤버로가기 때문에.
    // 연관관계의 주인이 아닌 모든 칼럼은 mappedBy 사용(이 칼럼의 주인은 team입니다.)
    // 읽기만 가능
    @JoinColumn(name = "ITEM_ID")
    private List<Member> members = new ArrayList<>();



}
