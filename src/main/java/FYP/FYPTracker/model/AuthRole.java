/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FYP.FYPTracker.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author cooke
 */
@Entity
@Table(name = "auth_role")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AuthRole.findAll", query = "SELECT a FROM AuthRole a"),
    @NamedQuery(name = "AuthRole.findByAuthRoleId", query = "SELECT a FROM AuthRole a WHERE a.authRoleId = :authRoleId"),
    @NamedQuery(name = "AuthRole.findByRoleName", query = "SELECT a FROM AuthRole a WHERE a.roleName = :roleName"),
    @NamedQuery(name = "AuthRole.findByRoleDesc", query = "SELECT a FROM AuthRole a WHERE a.roleDesc = :roleDesc")})
public class AuthRole implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "auth_role_id")
    private Integer authRoleId;
    @Size(max = 255)
    @Column(name = "role_name")
    private String roleName;
    @Size(max = 255)
    @Column(name = "role_desc")
    private String roleDesc;
    @ManyToMany(mappedBy = "authRoleCollection")
    private Collection<AuthUser> authUserCollection;

    public AuthRole() {
    }

    public AuthRole(Integer authRoleId) {
        this.authRoleId = authRoleId;
    }

    public Integer getAuthRoleId() {
        return authRoleId;
    }

    public void setAuthRoleId(Integer authRoleId) {
        this.authRoleId = authRoleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    @XmlTransient
    public Collection<AuthUser> getAuthUserCollection() {
        return authUserCollection;
    }

    public void setAuthUserCollection(Collection<AuthUser> authUserCollection) {
        this.authUserCollection = authUserCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (authRoleId != null ? authRoleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AuthRole)) {
            return false;
        }
        AuthRole other = (AuthRole) object;
        if ((this.authRoleId == null && other.authRoleId != null) || (this.authRoleId != null && !this.authRoleId.equals(other.authRoleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "FYP.FYPTracker.model.AuthRole[ authRoleId=" + authRoleId + " ]";
    }
    
}
