/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author maafia_fury
 */
@Entity
@Table(name = "usergroup", catalog = "newsportel", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usergroup.findAll", query = "SELECT u FROM Usergroup u"),
    @NamedQuery(name = "Usergroup.findByUserGroupName", query = "SELECT u FROM Usergroup u WHERE u.usergroupPK.userGroupName = :userGroupName"),
    @NamedQuery(name = "Usergroup.findByUserEmail", query = "SELECT u FROM Usergroup u WHERE u.usergroupPK.userEmail = :userEmail")})
public class Usergroup implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UsergroupPK usergroupPK;
    @JoinColumn(name = "userEmail", referencedColumnName = "userEmail", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private User user;

    public Usergroup() {
    }

    public Usergroup(UsergroupPK usergroupPK) {
        this.usergroupPK = usergroupPK;
    }

    public Usergroup(String userGroupName, String userEmail) {
        this.usergroupPK = new UsergroupPK(userGroupName, userEmail);
    }

    public UsergroupPK getUsergroupPK() {
        return usergroupPK;
    }

    public void setUsergroupPK(UsergroupPK usergroupPK) {
        this.usergroupPK = usergroupPK;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usergroupPK != null ? usergroupPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usergroup)) {
            return false;
        }
        Usergroup other = (Usergroup) object;
        if ((this.usergroupPK == null && other.usergroupPK != null) || (this.usergroupPK != null && !this.usergroupPK.equals(other.usergroupPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Usergroup[ usergroupPK=" + usergroupPK + " ]";
    }
    
}
