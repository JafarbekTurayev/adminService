package com.example.adminservice.entity;

import com.example.adminservice.entity.enums.Permission;
import com.example.adminservice.entity.template.AbsNameEntity;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Where(clause = "deleted=false")
@SQLDelete(sql = "update role set deleted=true,status=false where id=?")
public class Role extends AbsNameEntity {

    @ElementCollection
    @Enumerated
    private List<Permission> permissionList;

}
