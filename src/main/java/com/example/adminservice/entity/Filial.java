package com.example.adminservice.entity;

import com.example.adminservice.entity.template.AbsNameEntity;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Where(clause = "deleted=false")
@SQLDelete(sql = "update category set deleted=true,status=false where id=?")
public class Filial extends AbsNameEntity {

    @Temporal(TemporalType.TIME)
    private Date startTime;

    @Temporal(TemporalType.TIME)
    private Date endTime;

    @OneToOne
    private Address address;
}
