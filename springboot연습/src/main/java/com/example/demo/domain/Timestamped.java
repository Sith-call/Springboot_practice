package com.example.demo.domain;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass // 상속했을 때, 컬럼으로 인식하게 합니다. 이 어노테이션이 있어야 단순 데이터멤버가 아닌 컬럼으로 인식하여 데이터베이스에 반영함.
@EntityListeners(AuditingEntityListener.class) // 생성/수정 시간을 자동으로 반영하도록 설정
public class Timestamped {

    @CreatedDate // 생성일자임을 나타냅니다.
    private LocalDateTime createdAt;

    @LastModifiedDate // 마지막 수정일자임을 나타냅니다.
    private LocalDateTime modifiedAt;
}

// 타임 스탬프를 도메인으로 만들면 이 클래스를 상속시켜서 일관되게 타임 데이터를 관리할 수 있다.
// 즉 테이블이 10개가 있는데 모두 타임 데이터를 갖고 있다면 이걸 모든 테이블에서
// 타임 컬럼을 만드는게 아니라 타임스탬프 클래스를 상속시켜서 타임 데이터를 일관되게 관리할 수 있다.