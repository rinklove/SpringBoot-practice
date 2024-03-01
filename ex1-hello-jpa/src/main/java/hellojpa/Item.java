package hellojpa;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn //dtype칼럼이 생김. 웬만하면 넣어주는 게 좋음.
public class Item {

    @Id @GeneratedValue
    private Long id;

    private String name;
    private int price;
}
