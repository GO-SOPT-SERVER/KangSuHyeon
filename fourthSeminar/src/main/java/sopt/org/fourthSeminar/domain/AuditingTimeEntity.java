package sopt.org.fourthSeminar.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass
//객체의 입장에서 공통 매핑 정보가 필요할 때 사용 -> 자식은 해당 클래스의 필드를 칼럼으로 인식
//엔티티 x(테이블과 매핑 x)-> 자식 클래스에 매핑 정보만 재공
//JPA에서 @Entity클래스는 @Entity나 @MappedSuperclass만 상속 가능
@EntityListeners(AuditingEntityListener.class)
//Entity를 DB에 적용하기 이전, 이후에 커스텀 콜백을 요청할 수 있는 어노테이션
//-> JPA Entity에서 이벤트가 발생할 때마다 특정 로직을 실행
//AuditingEntityListener -> Entity 영속성 및 업데이트에 대한 Auditing 정보를 캡처하는 JPA Entity Listener
//Auditing 정보 -> @CreatedBy(작성자) , @CreatedDate(작성일) @LastModifiedDate(수정일) @LastModifiedBy(수정자)
public abstract class AuditingTimeEntity {
    @CreatedDate //Entity가 생성되어 저장될 때 시간이 자동 저장
    private LocalDateTime createdAt;

    @LastModifiedDate //Entity의 값을 변경할 때 시간이 자동 저장
    private LocalDateTime updatedAt;
}
