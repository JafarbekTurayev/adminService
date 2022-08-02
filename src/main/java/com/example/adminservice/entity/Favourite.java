package com.example.adminservice.entity;

import com.example.adminservice.entity.template.AbsEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Favourite extends AbsEntity {

    @OneToOne
    private User user;
    @OneToMany
    private List<Product> productList;
}
