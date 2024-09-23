package pe.edu.upc.tripbundle.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="Users")
public class Users implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsers;

    @Column(name = "nameUsers", nullable = false, length=50)
    private String nameUsers;

    @Column(name = "lastnameUsers", nullable = false, length=50)
    private String lastnameUsers;

    @Column(name = "addressUsers", nullable = false, length=50)
    private String addressUsers;

    @Column(name = "emailUsers", nullable = false, length=50)
    private String emailUsers;

    @Column(name = "phoneUsers", nullable = false, length=50)
    private String phoneUsers;

    @Column(name = "passwordUsers", nullable = false, length=200)
    private String passwordUsers;

    @Column(name = "birthdateUsers", nullable = false, length=50)
    private Date birthdateUsers;

    @Column(name = "username", nullable = false, length=50)
    private String username;

    @Column(name = "dniUsers", nullable = false, length=50)
    private String dniUsers;
    private Boolean enabled;
    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "idUsers")
    private List<Role> roles;


    public Users() {
    }

    public Users(int idUsers, String nameUsers, String lastnameUsers, String addressUsers, String emailUsers, String phoneUsers, String passwordUsers, Date birthdateUsers, String username, String dniUsers) {
        this.idUsers = idUsers;
        this.nameUsers = nameUsers;
        this.lastnameUsers = lastnameUsers;
        this.addressUsers = addressUsers;
        this.emailUsers = emailUsers;
        this.phoneUsers = phoneUsers;
        this.passwordUsers = passwordUsers;
        this.birthdateUsers = birthdateUsers;
        this.username = username;
        this.dniUsers = dniUsers;
    }

    public int getIdUsers() {
        return idUsers;
    }

    public void setIdUsers(int idUsers) {
        this.idUsers = idUsers;
    }

    public String getNameUsers() {
        return nameUsers;
    }

    public void setNameUsers(String nameUsers) {
        this.nameUsers = nameUsers;
    }

    public String getLastnameUsers() {
        return lastnameUsers;
    }

    public void setLastnameUsers(String lastnameUsers) {
        this.lastnameUsers = lastnameUsers;
    }

    public String getAddressUsers() {
        return addressUsers;
    }

    public void setAddressUsers(String addressUsers) {
        this.addressUsers = addressUsers;
    }

    public String getEmailUsers() {
        return emailUsers;
    }

    public void setEmailUsers(String emailUsers) {
        this.emailUsers = emailUsers;
    }

    public String getPhoneUsers() {
        return phoneUsers;
    }

    public void setPhoneUsers(String phoneUsers) {
        this.phoneUsers = phoneUsers;
    }

    public String getPasswordUsers() {
        return passwordUsers;
    }

    public void setPasswordUsers(String passwordUsers) {
        this.passwordUsers = passwordUsers;
    }

    public Date getBirthdateUsers() {
        return birthdateUsers;
    }

    public void setBirthdateUsers(Date birthdateUsers) {
        this.birthdateUsers = birthdateUsers;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDniUsers() {
        return dniUsers;
    }

    public void setDniUsers(String dniUsers) {
        this.dniUsers = dniUsers;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
