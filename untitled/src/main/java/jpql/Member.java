package jpql;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter @Setter
@ToString
//@NamedQuery(
//        name = "Member.findByUsername",
//        query = "select m from Member m where m.username = :username")
public class Member {

    @Id @GeneratedValue
    private Long id;
    private String username;
    private int age;

    @Enumerated(EnumType.STRING)
    private MemberType memberType;

    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Team team;

}
