package com.example.adminservice.entity;

import com.example.adminservice.entity.enums.OrderStatus;
import com.example.adminservice.entity.template.AbsEntity;
import com.example.adminservice.entity.template.AbsNameEntity;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import java.sql.Timestamp;
import java.util.List;

@Entity(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Where(clause = "deleted=false")
@SQLDelete(sql = "update orders set deleted=true,status=false where id=?")
public class Order extends AbsEntity {

    //kimga tegishli ekani qo'shish kk

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @OneToMany(mappedBy = "detail")
    private List<Detail> detailList;

    //summa
}
