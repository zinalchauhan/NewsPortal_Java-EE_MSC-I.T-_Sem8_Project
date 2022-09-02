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
@Table(name = "ads", catalog = "newsportel", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ads.findAll", query = "SELECT a FROM Ads a WHERE a.isActive=1"),
    @NamedQuery(name = "Ads.findByAdsIDPK", query = "SELECT a FROM Ads a WHERE a.adsIDPK = :adsIDPK"),
    @NamedQuery(name = "Ads.findByAdsTitle", query = "SELECT a FROM Ads a WHERE a.adsTitle = :adsTitle"),
    @NamedQuery(name = "Ads.findByAdsDescription", query = "SELECT a FROM Ads a WHERE a.adsDescription = :adsDescription"),
    @NamedQuery(name = "Ads.findByAdsDate", query = "SELECT a FROM Ads a WHERE a.adsDate = :adsDate"),
    @NamedQuery(name = "Ads.findByAdsImage", query = "SELECT a FROM Ads a WHERE a.adsImage = :adsImage"),
    @NamedQuery(name = "Ads.findByAdsStatus", query = "SELECT a FROM Ads a WHERE a.adsStatus = :adsStatus"),
    @NamedQuery(name = "Ads.findByIsActive", query = "SELECT a FROM Ads a WHERE a.isActive = :isActive")})
public class Ads implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "adsIDPK", nullable = false)
    private Integer adsIDPK;
    @Size(max = 2000)
    @Column(name = "adsTitle", length = 2000)
    private String adsTitle;
    @Size(max = 2000)
    @Column(name = "adsDescription", length = 2000)
    private String adsDescription;
    @Size(max = 200)
    @Column(name = "adsDate", length = 200)
    private String adsDate;
    @Size(max = 2000)
    @Column(name = "adsImage", length = 2000)
    private String adsImage;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "adsStatus", nullable = false, length = 200)
    private String adsStatus;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isActive", nullable = false)
    private boolean isActive;

    public Ads() {
    }

    public Ads(Integer adsIDPK) {
        this.adsIDPK = adsIDPK;
    }

    public Ads(Integer adsIDPK, String adsStatus, boolean isActive) {
        this.adsIDPK = adsIDPK;
        this.adsStatus = adsStatus;
        this.isActive = isActive;
    }

    public Integer getAdsIDPK() {
        return adsIDPK;
    }

    public void setAdsIDPK(Integer adsIDPK) {
        this.adsIDPK = adsIDPK;
    }

    public String getAdsTitle() {
        return adsTitle;
    }

    public void setAdsTitle(String adsTitle) {
        this.adsTitle = adsTitle;
    }

    public String getAdsDescription() {
        return adsDescription;
    }

    public void setAdsDescription(String adsDescription) {
        this.adsDescription = adsDescription;
    }

    public String getAdsDate() {
        return adsDate;
    }

    public void setAdsDate(String adsDate) {
        this.adsDate = adsDate;
    }

    public String getAdsImage() {
        return adsImage;
    }

    public void setAdsImage(String adsImage) {
        this.adsImage = adsImage;
    }

    public String getAdsStatus() {
        return adsStatus;
    }

    public void setAdsStatus(String adsStatus) {
        this.adsStatus = adsStatus;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adsIDPK != null ? adsIDPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ads)) {
            return false;
        }
        Ads other = (Ads) object;
        if ((this.adsIDPK == null && other.adsIDPK != null) || (this.adsIDPK != null && !this.adsIDPK.equals(other.adsIDPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Ads[ adsIDPK=" + adsIDPK + " ]";
    }
    
}
