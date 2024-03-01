package hellojpa;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@Getter @Setter
@SequenceGenerator(
        name = "MEMBER_SEQ_GENERATOR",
        sequenceName = "MEMBER_SEQ", //매핑할 데이터베이스 시퀀스 이름",
        initialValue = 1, allocationSize = 50) //DB에 50개씩 미리 올려놓고 메모리에서 하나씩 사용
public class Member extends BaseEntity{
    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;
    @Column(name = "name")
    private String username;

//    @Column(name = "team_id")
//    private Long teamId;

    //연관관계 매핑 --> 누가 1이고 누가 n인가?
    @ManyToOne(fetch = FetchType.EAGER) //멤버 입장에서는 다수의 Member가
    @JoinColumn(name = "TEAM_ID", insertable = false, updatable = false/*일대다 양방향 경우에만*/)
    private Team team;
    @OneToOne
    @JoinColumn(name = "LOCKER_ID")
    private Locker locker;

    @Embedded //임베디드 관계는 즉시로딩
    private Address address;

    @ElementCollection
    @CollectionTable(name = "FAVORITE_FOODS", joinColumns =
    @JoinColumn(name = "MEMBER_ID"))
    @Column(name = "FOOD_NAME")
    //컬렉션은 지연로딩
    private Set<String> favoriteFoods = new HashSet<>();

//    @ElementCollection
//    @CollectionTable(name = "ADDRESS", joinColumns =
//    @JoinColumn(name = "MEMBER_ID"))
//    //컬렉션은 지연로딩
//    private List<Address> addressHistory = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "MEMBER_ID")
    private List<AddressEntity> addressHistory = new ArrayList<>();

    public Member() {}

//    public void changeTeam(Team team) {
//        this.team = team;
//        team.getMembers().add(this);
//    }
}
//
