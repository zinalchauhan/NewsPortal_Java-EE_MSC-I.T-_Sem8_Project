/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author maafia_fury
 */
@Embeddable
public class UsergroupPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "userGroupName", nullable = false, length = 200)
    private String userGroupName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "userEmail", nullable = false, length = 200)
    private String userEmail;

    public UsergroupPK() {
    }

    public UsergroupPK(String userGroupName, String userEmail) {
        this.userGroupName = userGroupName;
        this.userEmail = userEmail;
    }

    public String getUserGroupName() {
        return userGroupName;
    }

    public void setUserGroupName(String userGroupName) {
        this.userGroupName = userGroupName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userGroupName != null ? userGroupName.hashCode() : 0);
        hash += (userEmail != null ? userEmail.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsergroupPK)) {
            return false;
        }
        UsergroupPK other = (UsergroupPK) object;
        if ((this.userGroupName == null && other.userGroupName != null) || (this.userGroupName != null && !this.userGroupName.equals(other.userGroupName))) {
            return false;
        }
        if ((this.userEmail == null && other.userEmail != null) || (this.userEmail != null && !this.userEmail.equals(other.userEmail))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.UsergroupPK[ userGroupName=" + userGroupName + ", userEmail=" + userEmail + " ]";
    }
    
}
