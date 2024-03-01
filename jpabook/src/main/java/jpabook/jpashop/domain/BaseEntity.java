package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
public class BaseEntity {

        @Column(name = "INSET_MEMBER")
        private String createdBy;
        private LocalDateTime createdDate;
        @Column(name = "LAST_MEMBER")
        private String lastModifiedBy;
        private LocalDateTime lastModifiedTime;
}
