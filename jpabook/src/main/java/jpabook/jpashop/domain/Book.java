package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Getter @Setter
@DiscriminatorValue("BB") //DTYPE 설정 어노테이션 - 엔티티의 상속관계
public class Book extends Item{

    private String author;
    private String isbn;
}
