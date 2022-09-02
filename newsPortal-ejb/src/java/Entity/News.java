/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author maafia_fury
 */
@Entity
@Table(name = "news", catalog = "newsportel", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "News.findAll", query = "SELECT n FROM News n WHERE n.isActive=1"),
     @NamedQuery(name = "News.findLast", query = "SELECT n FROM News n WHERE n.isActive=1 ORDER BY n.newsIDPK DESC"),
    @NamedQuery(name = "News.findByNewsIDPK", query = "SELECT n FROM News n WHERE n.newsIDPK = :newsIDPK"),
    @NamedQuery(name = "News.findByNewsTitle", query = "SELECT n FROM News n WHERE n.newsTitle = :newsTitle"),
    @NamedQuery(name = "News.findByNewsSubtitle", query = "SELECT n FROM News n WHERE n.newsSubtitle = :newsSubtitle"),
    @NamedQuery(name = "News.findByNewsDescription", query = "SELECT n FROM News n WHERE n.newsDescription = :newsDescription"),
    @NamedQuery(name = "News.findByNewsDate", query = "SELECT n FROM News n WHERE n.newsDate = :newsDate"),
    @NamedQuery(name = "News.findByNewsStatus", query = "SELECT n FROM News n WHERE n.newsStatus = :newsStatus"),
    @NamedQuery(name = "News.findNewsByCity", query = "SELECT n FROM News n WHERE n.isActive=1 and n.cityIDFK.cityIDPK=:cityIDFK"),
    @NamedQuery(name = "News.findByIsActive", query = "SELECT n FROM News n WHERE n.isActive = :isActive")})
public class News implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "newsIDPK", nullable = false)
    private Integer newsIDPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2000)
    @Column(name = "newsTitle", nullable = false, length = 2000)
    private String newsTitle;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2000)
    @Column(name = "newsSubtitle", nullable = false, length = 2000)
    private String newsSubtitle;
    @Basic(optional = false)
    @NotNull
     @Lob
    @Size(min = 1, max = 16777215)
    @Column(name = "newsDescription", nullable = false, length = 16777215)
    private String newsDescription;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2000)
    @Column(name = "newsDate", nullable = false, length = 2000)
    private String newsDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "newsStatus", nullable = false, length = 200)
    private String newsStatus;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2000)
    @Column(name = "newsType", nullable = false, length = 2000)
    private String newsType;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "newsIDFK")
    private Collection<Notification> notificationCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "newsIDFK")
    private Collection<Newsimage> newsimageCollection;
    

    public News() {
    }

    public News(Integer newsIDPK) {
        this.newsIDPK = newsIDPK;
    }

    public News(Integer newsIDPK, String newsTitle, String newsSubtitle, String newsDescription, String newsDate, String newsStatus, boolean isActive,String newsType) {
        this.newsIDPK = newsIDPK;
        this.newsTitle = newsTitle;
        this.newsSubtitle = newsSubtitle;
        this.newsDescription = newsDescription;
        this.newsDate = newsDate;
        this.newsStatus = newsStatus;
        this.isActive = isActive;
        this.newsType=newsType;
    }

    public Integer getNewsIDPK() {
        return newsIDPK;
    }

    public void setNewsIDPK(Integer newsIDPK) {
        this.newsIDPK = newsIDPK;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }
    
     public String getNewsType() {
        return newsType;
    }

    public void setNewsType(String newsType) {
        this.newsType = newsType;
    }

    public String getNewsSubtitle() {
        return newsSubtitle;
    }

    public void setNewsSubtitle(String newsSubtitle) {
        this.newsSubtitle = newsSubtitle;
    }

    public String getNewsDescription() {
        return newsDescription;
    }

    public void setNewsDescription(String newsDescription) {
        this.newsDescription = newsDescription;
    }

    public String getNewsDate() {
        return newsDate;
    }

    public void setNewsDate(String newsDate) {
        this.newsDate = newsDate;
    }

    public String getNewsStatus() {
        return newsStatus;
    }

    public void setNewsStatus(String newsStatus) {
        this.newsStatus = newsStatus;
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

    @XmlTransient
    public Collection<Notification> getNotificationCollection() {
        return notificationCollection;
    }

    public void setNotificationCollection(Collection<Notification> notificationCollection) {
        this.notificationCollection = notificationCollection;
    }

    @XmlTransient
    public Collection<Newsimage> getNewsimageCollection() {
        return newsimageCollection;
    }

    public void setNewsimageCollection(Collection<Newsimage> newsimageCollection) {
        this.newsimageCollection = newsimageCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (newsIDPK != null ? newsIDPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof News)) {
            return false;
        }
        News other = (News) object;
        if ((this.newsIDPK == null && other.newsIDPK != null) || (this.newsIDPK != null && !this.newsIDPK.equals(other.newsIDPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.News[ newsIDPK=" + newsIDPK + " ]";
    }
    
}
