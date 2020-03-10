package FYP.FYPTracker.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the auth_role database table.
 * 
 */
@Entity
@Table(name="auth_role")
@NamedQuery(name="AuthRole.findAll", query="SELECT a FROM AuthRole a")
public class AuthRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="auth_role_id")
	private int authRoleId;

	@Column(name="role_desc")
	private String roleDesc;

	@Column(name="role_name")
	private String roleName;

	public AuthRole() {
	}

	public int getAuthRoleId() {
		return this.authRoleId;
	}

	public void setAuthRoleId(int authRoleId) {
		this.authRoleId = authRoleId;
	}

	public String getRoleDesc() {
		return this.roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}