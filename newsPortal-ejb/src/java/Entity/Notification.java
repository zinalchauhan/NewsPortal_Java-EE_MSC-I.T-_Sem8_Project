/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author maafia_fury
 */
@Entity
@Table(name = "notification", catalog = "newsportel", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Notification.findAll", query = "SELECT n FROM Notification n"),
    @NamedQuery(name = "Notification.findByNotificationIDPK", query = "SELECT n FROM Notification n WHERE n.notificationIDPK = :notificationIDPK"),
    @NamedQuery(name = "Notification.findByNotificationStatus", query = "SELECT n FROM Notification n WHERE n.notificationStatus = :notificationStatus"),
    @NamedQuery(name = "Notification.findByIsActive", query = "SELECT n FROM Notification n WHERE n.isActive = :isActive")})
public class Notification implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "notificationIDPK", nullable = false)
    private Integer notificationIDPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "notificationStatus", nullable = false, length = 255)
    private String notificationStatus;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isActive", nullable = false)
    private boolean isActive;
    @JoinColumn(name = "newsIDFK", referencedColumnName = "newsIDPK", nullable = false)
    @ManyToOne(optional = false)
    private News newsIDFK;
    @JoinColumn(name = "userIDFK", referencedColumnName = "userIDPK", nullable = false)
    @ManyToOne(optional = false)
    private User userIDFK;

    public Notification() {
    }

    public Notification(Integer notificationIDPK) {
        this.notificationIDPK = notificationIDPK;
    }

    public Notification(Integer notificationIDPK, String notificationStatus, boolean isActive) {
        this.notificationIDPK = notificationIDPK;
        this.notificationStatus = notificationStatus;
        this.isActive = isActive;
    }

    public Integer getNotificationIDPK() {
        return notificationIDPK;
    }

    public void setNotificationIDPK(Integer notificationIDPK) {
        this.notificationIDPK = notificationIDPK;
    }

    public String getNotificationStatus() {
        return notificationStatus;
    }

    public void setNotificationStatus(String notificationStatus) {
        this.notificationStatus = notificationStatus;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public News getNewsIDFK() {
        return newsIDFK;
    }

    public void setNewsIDFK(News newsIDFK) {
        this.newsIDFK = newsIDFK;
    }

    public User getUserIDFK() {
        return userIDFK;
    }

    public void setUserIDFK(User userIDFK) {
        this.userIDFK = userIDFK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (notificationIDPK != null ? notificationIDPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Notification)) {
            return false;
        }
        Notification other = (Notification) object;
        if ((this.notificationIDPK == null && other.notificationIDPK != null) || (this.notificationIDPK != null && !this.notificationIDPK.equals(other.notificationIDPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Notification[ notificationIDPK=" + notificationIDPK + " ]";
    }
    
}
