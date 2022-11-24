package com.example.springaws.domain.posts;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass//JPA Entity 클래스들이 이 클래스를 상속 받을 경우 필드들도 칼럼으로 인식하도록 만듬
@EntityListeners(AuditingEntityListener.class)//Auditing 기능을 포함 시킴
public abstract class BaseTimeEntity {

    @CreatedDate//Entity 저장될때 시간이 자동 저장됨
    private LocalDateTime createdDate;

    @LastModifiedDate//Entity 값이 변경 될때 시간이 자동으로 저장됨
    private LocalDateTime modifiedDate;
}
