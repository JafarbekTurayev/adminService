package com.example.adminservice.entity;

import com.example.adminservice.entity.enums.OrderStatus;
import com.example.adminservice.entity.template.AbsEntity;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Where(clause = "deleted=false")
@SQLDelete(sql = "update orders set deleted=true,status=false where id=?")
public class BasketOrder extends AbsEntity {




}
