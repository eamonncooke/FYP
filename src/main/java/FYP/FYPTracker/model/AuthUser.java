/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FYP.FYPTracker.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author cooke
 */
@Entity
@Table(name = "auth_user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AuthUser.findAll", query = "SELECT a FROM AuthUser a"),
    @NamedQuery(name = "AuthUser.findByAuthUserId", query = "SELECT a FROM AuthUser a WHERE a.authUserId = :authUserId"),
    @NamedQuery(name = "AuthUser.findByFirstName", query = "SELECT a FROM AuthUser a WHERE a.firstName = :firstName"),
    @NamedQuery(name = "AuthUser.findBySurname", query = "SELECT a FROM AuthUser a WHERE a.surname = :surname"),
    @NamedQuery(name = "AuthUser.findByEmail", query = "SELECT a FROM AuthUser a WHERE a.email = :email"),
    @NamedQuery(name = "AuthUser.findByPassword", query = "SELECT a FROM AuthUser a WHERE a.password = :password"),
    @NamedQuery(name = "AuthUser.findByStatus", query = "SELECT a FROM AuthUser a WHERE a.status = :status")})
public class AuthUser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "authUserId")
    private Integer authUserId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "firstName")
    private String firstName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "surname")
    private String surname;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "password")
    private String password;
    @Size(max = 30)
    @Column(name = "status")
    private String status;
    @JoinTable(name = "authuserrole", joinColumns = {
        @JoinColumn(name = "authUserId", referencedColumnName = "authUserId")}, inverseJoinColumns = {
        @JoinColumn(name = "authRoleId", referencedColumnName = "auth_role_id")})
    @ManyToMany
    private Collection<AuthRole> authRoleCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "authUserId")
    private Collection<Coach> coachCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "authUserId")
    private Collection<Player> playerCollection;

    public AuthUser() {
    }

    public AuthUser(Integer authUserId) {
        this.authUserId = authUserId;
    }

    public AuthUser(Integer authUserId, String firstName, String surname, String email, String password) {
        this.authUserId = authUserId;
        this.firstName = firstName;
        this.surname = surname;
        this.email = email;
        this.password = password;
    }

    public Integer getAuthUserId() {
        return authUserId;
    }

    public void setAuthUserId(Integer authUserId) {
        this.authUserId = authUserId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @XmlTransient
    public Collection<AuthRole> getAuthRoleCollection() {
        return authRoleCollection;
    }

    public void setAuthRoleCollection(Collection<AuthRole> authRoleCollection) {
        this.authRoleCollection = authRoleCollection;
    }

    @XmlTransient
    public Collection<Coach> getCoachCollection() {
        return coachCollection;
    }

    public void setCoachCollection(Collection<Coach> coachCollection) {
        this.coachCollection = coachCollection;
    }

    @XmlTransient
    public Collection<Player> getPlayerCollection() {
        return playerCollection;
    }

    public void setPlayerCollection(Collection<Player> playerCollection) {
        this.playerCollection = playerCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (authUserId != null ? authUserId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AuthUser)) {
            return false;
        }
        AuthUser other = (AuthUser) object;
        if ((this.authUserId == null && other.authUserId != null) || (this.authUserId != null && !this.authUserId.equals(other.authUserId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "FYP.FYPTracker.model.AuthUser[ authUserId=" + authUserId + " ]";
    }
    
}
