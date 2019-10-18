package by.it.training.library.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "users")
@NamedQueries({
        @NamedQuery(name = "get_count_users", query = "select count(*) from User"),
        @NamedQuery(name = "get_users", query = "from User")
})
@NamedNativeQuery(name = "get_user", query = "select * from users where removed = 0 and login = :login and password = SHA2(:password, 256)", resultClass = User.class)
@NamedNativeQueries({
        @NamedNativeQuery(name = "get_count_users_not_removed", query = "select count(1) from users where removed = 0"),
        @NamedNativeQuery(name = "get_users_not_removed", query = "select * from users where removed = 0", resultClass = User.class)
})
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "role_id", foreignKey = @ForeignKey(name = "fk_users_roles"))
    private Role role;

    @Column(name = "login", nullable = false)
    private String login;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "beginning", nullable = false)
    private Timestamp beginning;

    @Column(name = "ending")
    private Timestamp ending;

    @Column(name = "email")
    private String email;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    public User() {
    }

    public User(Role role, String login, String password, Timestamp beginning, Timestamp ending, String email, String firstName, String lastName) {
        this.role = role;
        this.login = login;
        this.password = password;
        this.beginning = beginning;
        this.ending = ending;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getBeginning() {
        return beginning;
    }

    public void setBeginning(Timestamp beginning) {
        this.beginning = beginning;
    }

    public Timestamp getEnding() {
        return ending;
    }

    public void setEnding(Timestamp ending) {
        this.ending = ending;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id) &&
                role.equals(user.role) &&
                login.equals(user.login) &&
                password.equals(user.password) &&
                beginning.equals(user.beginning) &&
                ending.equals(user.ending) &&
                email.equals(user.email) &&
                firstName.equals(user.firstName) &&
                lastName.equals(user.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, role, login, password, beginning, ending, email);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", role=" + role +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", beginning=" + beginning +
                ", ending=" + ending +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
