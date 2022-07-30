package com.example.adminservice.entity;

import com.example.adminservice.entity.template.AbsNameEntity;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Where(clause = "deleted=false")
@SQLDelete(sql = "update discount set deleted=true,status=false where id=?")
public class Discount extends AbsNameEntity {

    private Double percentage;
}
