package org.example.persist.entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.constants.TaskStatus;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;

import java.sql.Date;
import java.sql.Timestamp;

@Getter
@Setter
@ToString
@Builder //파라미터가 많은경우 인스턴스 초기화를 편하게 하기 위해서
@DynamicInsert
@DynamicUpdate //createdAt, updatedAt  생성 편하게 하기 위함
@Entity(name="TASK")
@NoArgsConstructor
@AllArgsConstructor
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    @Enumerated(value = EnumType.STRING)
    private TaskStatus status;
    private Date dueDate;
    @CreationTimestamp
    @Column(insertable = false,updatable = false)
    private Timestamp createdAt;
    @CreationTimestamp
    @Column(insertable = false,updatable = false)
    private Timestamp updatedAt;
}
