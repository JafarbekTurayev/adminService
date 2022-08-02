package com.example.adminservice.entity;

import com.example.adminservice.entity.template.AbsEntity;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Where(clause = "deleted=false")
@SQLDelete(sql = "update orders set deleted=true,status=false where id=?")
//ishchilar
public class User extends AbsEntity implements UserDetails {
    //
    @Column(unique = true)
    private String phone;
    private String password;
    private String fullName;

    @OneToMany
    private List<Address> addressList;
    @ManyToOne
    private Filial filial;
    private boolean enabled = true;
    private boolean accountExpired;
    private boolean accountLocked;
    private boolean credentialsExpired;
    @ManyToOne
    private Role role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //har bir rolga tegishli permissionlar
        return this.role.getPermissionList().stream().map(permission -> new SimpleGrantedAuthority(permission.name())).collect(Collectors.toSet());
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.phone;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.accountExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.accountLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.credentialsExpired;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }
}
