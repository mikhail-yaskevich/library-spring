package by.it.training.library.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    @Enumerated(value = EnumType.STRING)
    private RoleType roleType;

    public Role() {
    }

    public Role(RoleType roleType) {
        this.roleType = roleType;
    }

    public Long getId() {
        return id;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return id.equals(role.id) &&
                roleType == role.roleType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, roleType);
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roleType=" + roleType +
                '}';
    }
}
