package com.example.adminservice.entity;

import com.example.adminservice.entity.template.AbsNameEntity;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.sql.Timestamp;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Where(clause = "deleted=false")
@SQLDelete(sql = "update category set deleted=true,status=false where id=?")
public class Detail extends AbsNameEntity {

    //kimga tegishli ekanligi

    @ManyToOne
    @JoinColumn(name = "ord_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "pr_id")
    private Product product;

    @Column(nullable = false)
    private short quantity; //1000X2
}
