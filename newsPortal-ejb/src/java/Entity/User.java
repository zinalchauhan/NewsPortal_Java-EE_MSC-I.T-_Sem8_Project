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
@Table(name = "user", catalog = "newsportel", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
     @NamedQuery(name = "User.findByUser", query = "SELECT u FROM User u WHERE u.userEmail = :userEmail AND u.userPassword = :userPassword "),
    @NamedQuery(name = "User.findByUserIDPK", query = "SELECT u FROM User u WHERE u.userIDPK = :userIDPK"),
    @NamedQuery(name = "User.findUserByType", query = "SELECT u FROM User u WHERE u.isActive = 1 AND u.userType = 'editor' OR u.userType = 'reporter' "),
    @NamedQuery(name = "User.findByUserName", query = "SELECT u FROM User u WHERE u.userName = :userName"),
    @NamedQuery(name = "User.findByUserPassword", query = "SELECT u FROM User u WHERE u.userPassword = :userPassword"),
    @NamedQuery(name = "User.findByUserImage", query = "SELECT u FROM User u WHERE u.userImage = :userImage"),
    @NamedQuery(name = "User.findByUserEmail", query = "SELECT u FROM User u WHERE u.userEmail = :userEmail"),
    @NamedQuery(name = "User.findByUserMobile", query = "SELECT u FROM User u WHERE u.userMobile = :userMobile"),
    @NamedQuery(name = "User.findByUserStatus", query = "SELECT u FROM User u WHERE u.userStatus = :userStatus"),
    @NamedQuery(name = "User.findByIsActive", query = "SELECT u FROM User u WHERE u.isActive = :isActive"),
    @NamedQuery(name = "User.findByUserType", query = "SELECT u FROM User u WHERE u.userType = :userType")})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "userIDPK", nullable = false)
    private Integer userIDPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2000)
    @Column(name = "userName", nullable = false, length = 2000)
    private String userName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "userPassword", nullable = false, length = 255)
    private String userPassword;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2000)
    @Column(name = "userImage", nullable = false, length = 2000)
    private String userImage;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2000)
    @Column(name = "userAddress", nullable = false, length = 200)
    private String userAddress;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2000)
    @Column(name = "userGender", nullable = false, length = 200)
    private String userGender;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "userEmail", nullable = false, length = 200)
    private String userEmail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "userMobile", nullable = false, length = 200)
    private String userMobile;
    @Basic(optional = false)
    @NotNull
    @Column(name = "userStatus", nullable = false)
    private int userStatus;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isActive", nullable = false)
    private boolean isActive;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2000)
    @Column(name = "userType", nullable = false, length = 2000)
    private String userType;
    
    @JoinColumn(name = "cityIDFK", referencedColumnName = "cityIDPK", nullable = false)
    @ManyToOne(optional = false)
    private City cityIDFK;

    public User() {
    }

    public User(Integer userIDPK) {
        this.userIDPK = userIDPK;
    }

    public User(Integer userIDPK, String userName, String userPassword, String userImage, String userEmail, String userMobile, int userStatus, boolean isActive, String userType,String userAddress,String userGender) {
        this.userIDPK = userIDPK;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userImage = userImage;
        this.userEmail = userEmail;
        this.userMobile = userMobile;
        this.userStatus = userStatus;
        this.isActive = isActive;
        this.userType = userType;
        this.userAddress = userAddress;
        this.userGender = userGender; 
    }

    public Integer getUserIDPK() {
        return userIDPK;
    }

    public void setUserIDPK(Integer userIDPK) {
        this.userIDPK = userIDPK;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }
    
    

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    public int getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(int userStatus) {
        this.userStatus = userStatus;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public City getCityIDFK() {
        return cityIDFK;
    }

    public void setCityIDFK(City cityIDFK) {
        this.cityIDFK = cityIDFK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userIDPK != null ? userIDPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.userIDPK == null && other.userIDPK != null) || (this.userIDPK != null && !this.userIDPK.equals(other.userIDPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.User[ userIDPK=" + userIDPK + " ]";
    }
    
}
