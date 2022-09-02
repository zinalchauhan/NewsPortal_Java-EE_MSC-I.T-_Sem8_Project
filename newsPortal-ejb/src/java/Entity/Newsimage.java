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
@Table(name = "newsimage", catalog = "newsportel", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Newsimage.findAll", query = "SELECT n FROM Newsimage n WHERE n.isActive=1"),
    @NamedQuery(name = "Newsimage.findByNewsIDFK", query = "SELECT n FROM Newsimage n WHERE n.isActive=1 and n.newsIDFK.newsIDPK = :newsIDFK"),
    @NamedQuery(name = "Newsimage.findByImageIDPK", query = "SELECT n FROM Newsimage n WHERE n.imageIDPK = :imageIDPK"),
    @NamedQuery(name = "Newsimage.findByImage", query = "SELECT n FROM Newsimage n WHERE n.image = :image"),
    @NamedQuery(name = "Newsimage.findByIsActive", query = "SELECT n FROM Newsimage n WHERE n.isActive = :isActive")})
public class Newsimage implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "imageIDPK", nullable = false)
    private Integer imageIDPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2000)
    @Column(name = "image", nullable = false, length = 2000)
    private String image;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isActive", nullable = false)
    private boolean isActive;
    @JoinColumn(name = "newsIDFK", referencedColumnName = "newsIDPK", nullable = false)
    @ManyToOne(optional = false)
    private News newsIDFK;

    public Newsimage() {
    }

    public Newsimage(Integer imageIDPK) {
        this.imageIDPK = imageIDPK;
    }

    public Newsimage(Integer imageIDPK, String image, boolean isActive) {
        this.imageIDPK = imageIDPK;
        this.image = image;
        this.isActive = isActive;
    }

    public Integer getImageIDPK() {
        return imageIDPK;
    }

    public void setImageIDPK(Integer imageIDPK) {
        this.imageIDPK = imageIDPK;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (imageIDPK != null ? imageIDPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Newsimage)) {
            return false;
        }
        Newsimage other = (Newsimage) object;
        if ((this.imageIDPK == null && other.imageIDPK != null) || (this.imageIDPK != null && !this.imageIDPK.equals(other.imageIDPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Newsimage[ imageIDPK=" + imageIDPK + " ]";
    }
    
}
