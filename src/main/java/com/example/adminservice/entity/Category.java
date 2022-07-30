package com.example.adminservice.entity;

import com.example.adminservice.entity.template.AbsNameEntity;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Where(clause = "deleted=false")
@SQLDelete(sql = "update category set deleted=true,status=false where id=?")
public class Category extends AbsNameEntity {

    @ManyToOne
    private Category parent;

}
