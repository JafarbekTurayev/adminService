package com.example.adminservice.entity;

import com.example.adminservice.entity.enums.PayType;
import com.example.adminservice.entity.template.AbsEntity;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Where(clause = "deleted=false")
@SQLDelete(sql = "update orders set deleted=true,status=false where id=?")
public class OrderHistory extends AbsEntity {

    @ManyToOne
    private Filial filial;

    private String address;

    @ManyToOne
    private User customer;

    @ManyToOne
    private User courier;

    private Double deliveredPrice;

    @Enumerated(EnumType.STRING)
    private PayType payType;

    @ManyToOne
    private Order order; //new open delivered

    private String description;
}
