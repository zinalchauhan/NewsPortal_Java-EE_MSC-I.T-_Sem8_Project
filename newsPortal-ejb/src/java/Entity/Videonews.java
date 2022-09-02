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
@Table(name = "videonews", catalog = "newsportel", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Videonews.findAll", query = "SELECT v FROM Videonews v WHERE v.isActive =1"),
    @NamedQuery(name = "Videonews.findByVideoNewsIDPK", query = "SELECT v FROM Videonews v WHERE v.videoNewsIDPK = :videoNewsIDPK"),
    @NamedQuery(name = "Videonews.findByVideoNewsTitle", query = "SELECT v FROM Videonews v WHERE v.videoNewsTitle = :videoNewsTitle"),
    @NamedQuery(name = "Videonews.findByVideoNewsDescription", query = "SELECT v FROM Videonews v WHERE v.videoNewsDescription = :videoNewsDescription"),
    @NamedQuery(name = "Videonews.findByVideo", query = "SELECT v FROM Videonews v WHERE v.video = :video"),
    @NamedQuery(name = "Videonews.findByVideoNewsDate", query = "SELECT v FROM Videonews v WHERE v.videoNewsDate = :videoNewsDate"),
    @NamedQuery(name = "Videonews.findByVideoNewsStatus", query = "SELECT v FROM Videonews v WHERE v.videoNewsStatus = :videoNewsStatus"),
    @NamedQuery(name = "Videonews.findByIsActive", query = "SELECT v FROM Videonews v WHERE v.isActive = :isActive")})
public class Videonews implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "videoNewsIDPK", nullable = false)
    private Integer videoNewsIDPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2000)
    @Column(name = "videoNewsTitle", nullable = false, length = 2000)
    private String videoNewsTitle;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2000)
    @Column(name = "videoNewsDescription", nullable = false, length = 2000)
    private String videoNewsDescription;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2000)
    @Column(name = "video", nullable = false, length = 2000)
    private String video;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2000)
    @Column(name = "videoNewsDate", nullable = false, length = 2000)
    private String videoNewsDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "videoNewsStatus", nullable = false, length = 200)
    private String videoNewsStatus;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isActive", nullable = false)
    private boolean isActive;
    @JoinColumn(name = "subCategoryIDFK", referencedColumnName = "subCategoryIDPK", nullable = false)
    @ManyToOne(optional = false)
    private Subcategory subCategoryIDFK;
    @JoinColumn(name = "cityIDFK", referencedColumnName = "cityIDPK", nullable = false)
    @ManyToOne(optional = false)
    private City cityIDFK;

    public Videonews() {
    }

    public Videonews(Integer videoNewsIDPK) {
        this.videoNewsIDPK = videoNewsIDPK;
    }

    public Videonews(Integer videoNewsIDPK, String videoNewsTitle, String videoNewsDescription, String video, String videoNewsDate, String videoNewsStatus, boolean isActive) {
        this.videoNewsIDPK = videoNewsIDPK;
        this.videoNewsTitle = videoNewsTitle;
        this.videoNewsDescription = videoNewsDescription;
        this.video = video;
        this.videoNewsDate = videoNewsDate;
        this.videoNewsStatus = videoNewsStatus;
        this.isActive = isActive;
    }

    public Integer getVideoNewsIDPK() {
        return videoNewsIDPK;
    }

    public void setVideoNewsIDPK(Integer videoNewsIDPK) {
        this.videoNewsIDPK = videoNewsIDPK;
    }

    public String getVideoNewsTitle() {
        return videoNewsTitle;
    }

    public void setVideoNewsTitle(String videoNewsTitle) {
        this.videoNewsTitle = videoNewsTitle;
    }

    public String getVideoNewsDescription() {
        return videoNewsDescription;
    }

    public void setVideoNewsDescription(String videoNewsDescription) {
        this.videoNewsDescription = videoNewsDescription;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getVideoNewsDate() {
        return videoNewsDate;
    }

    public void setVideoNewsDate(String videoNewsDate) {
        this.videoNewsDate = videoNewsDate;
    }

    public String getVideoNewsStatus() {
        return videoNewsStatus;
    }

    public void setVideoNewsStatus(String videoNewsStatus) {
        this.videoNewsStatus = videoNewsStatus;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public Subcategory getSubCategoryIDFK() {
        return subCategoryIDFK;
    }

    public void setSubCategoryIDFK(Subcategory subCategoryIDFK) {
        this.subCategoryIDFK = subCategoryIDFK;
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
        hash += (videoNewsIDPK != null ? videoNewsIDPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Videonews)) {
            return false;
        }
        Videonews other = (Videonews) object;
        if ((this.videoNewsIDPK == null && other.videoNewsIDPK != null) || (this.videoNewsIDPK != null && !this.videoNewsIDPK.equals(other.videoNewsIDPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Videonews[ videoNewsIDPK=" + videoNewsIDPK + " ]";
    }
    
}
