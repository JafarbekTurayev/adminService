package com.example.adminservice.entity;

import com.example.adminservice.entity.enums.SupportType;
import com.example.adminservice.entity.template.AbsNameEntity;
import lombok.*;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Support extends AbsNameEntity {

    @Enumerated(EnumType.STRING)
    private SupportType supportType;

    @ElementCollection
    private Set<String> phoneList;

    private String title;
    private String description;
    private String photo;
}
