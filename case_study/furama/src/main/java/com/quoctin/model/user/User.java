package com.quoctin.model.user;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "user")
public class User {

    @Id
    private String username;
    private String password;

    @ManyToMany
    @JoinTable(name = "user_role",joinColumns = @JoinColumn(name = "username"),inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roleSet;

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoleSet() {
        return roleSet;
    }

    public void setRoleSet(Set<Role> roleSet) {
        this.roleSet = roleSet;
    }
}
