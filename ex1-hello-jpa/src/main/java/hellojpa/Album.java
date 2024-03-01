package hellojpa;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Getter @Setter
//@DiscriminatorValue dtype의 이름을 변경할 수 있음. 기본값은 클래스명
public class Album extends Item{

    private String artist;
}
