package com.example.adminservice.entity.template;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
@Getter
@Setter
@ToString
public class AbsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean deleted;
    private boolean status=true;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private Timestamp createdAt;

    @UpdateTimestamp
    @Column(nullable = false)
    private Timestamp updatedAt;

    //tizimga kim qo'shdi
    private Long createdBy;

    //kim o'zgartirdi
    private Long updatedBy;

}
