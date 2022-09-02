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
@Table(name = "podcast", catalog = "newsportel", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Podcast.findAll", query = "SELECT p FROM Podcast p WHERE p.isActive=1"),
    @NamedQuery(name = "Podcast.findByPodcastIDPK", query = "SELECT p FROM Podcast p WHERE p.podcastIDPK = :podcastIDPK"),
    @NamedQuery(name = "Podcast.findByPodcastTitle", query = "SELECT p FROM Podcast p WHERE p.podcastTitle = :podcastTitle"),
    @NamedQuery(name = "Podcast.findByPodcastDescription", query = "SELECT p FROM Podcast p WHERE p.podcastDescription = :podcastDescription"),
    @NamedQuery(name = "Podcast.findByPodcastDate", query = "SELECT p FROM Podcast p WHERE p.podcastDate = :podcastDate"),
    @NamedQuery(name = "Podcast.findByPodcastAudio", query = "SELECT p FROM Podcast p WHERE p.podcastAudio = :podcastAudio"),
    @NamedQuery(name = "Podcast.findByIsActive", query = "SELECT p FROM Podcast p WHERE p.isActive = :isActive")})
public class Podcast implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "podcastIDPK", nullable = false)
    private Integer podcastIDPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2000)
    @Column(name = "podcastTitle", nullable = false, length = 2000)
    private String podcastTitle;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2000)
    @Column(name = "podcastDescription", nullable = false, length = 2000)
    private String podcastDescription;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "podcastDate", nullable = false, length = 200)
    private String podcastDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4000)
    @Column(name = "podcastAudio", nullable = false, length = 4000)
    private String podcastAudio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isActive", nullable = false)
    private boolean isActive;
    @JoinColumn(name = "userIDFK", referencedColumnName = "userIDPK", nullable = false)
    @ManyToOne(optional = false)
    private User userIDFK;
    @JoinColumn(name = "subCategoryIDFK", referencedColumnName = "subCategoryIDPK", nullable = false)
    @ManyToOne(optional = false)
    private Subcategory subCategoryIDFK;

    public Podcast() {
    }

    public Podcast(Integer podcastIDPK) {
        this.podcastIDPK = podcastIDPK;
    }

    public Podcast(Integer podcastIDPK, String podcastTitle, String podcastDescription, String podcastDate, String podcastAudio, boolean isActive) {
        this.podcastIDPK = podcastIDPK;
        this.podcastTitle = podcastTitle;
        this.podcastDescription = podcastDescription;
        this.podcastDate = podcastDate;
        this.podcastAudio = podcastAudio;
        this.isActive = isActive;
    }

    public Integer getPodcastIDPK() {
        return podcastIDPK;
    }

    public void setPodcastIDPK(Integer podcastIDPK) {
        this.podcastIDPK = podcastIDPK;
    }

    public String getPodcastTitle() {
        return podcastTitle;
    }

    public void setPodcastTitle(String podcastTitle) {
        this.podcastTitle = podcastTitle;
    }

    public String getPodcastDescription() {
        return podcastDescription;
    }

    public void setPodcastDescription(String podcastDescription) {
        this.podcastDescription = podcastDescription;
    }

    public String getPodcastDate() {
        return podcastDate;
    }

    public void setPodcastDate(String podcastDate) {
        this.podcastDate = podcastDate;
    }

    public String getPodcastAudio() {
        return podcastAudio;
    }

    public void setPodcastAudio(String podcastAudio) {
        this.podcastAudio = podcastAudio;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public User getUserIDFK() {
        return userIDFK;
    }

    public void setUserIDFK(User userIDFK) {
        this.userIDFK = userIDFK;
    }

    public Subcategory getSubCategoryIDFK() {
        return subCategoryIDFK;
    }

    public void setSubCategoryIDFK(Subcategory subCategoryIDFK) {
        this.subCategoryIDFK = subCategoryIDFK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (podcastIDPK != null ? podcastIDPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Podcast)) {
            return false;
        }
        Podcast other = (Podcast) object;
        if ((this.podcastIDPK == null && other.podcastIDPK != null) || (this.podcastIDPK != null && !this.podcastIDPK.equals(other.podcastIDPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Podcast[ podcastIDPK=" + podcastIDPK + " ]";
    }
    
}
