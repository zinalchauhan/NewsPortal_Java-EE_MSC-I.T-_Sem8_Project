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
@Table(name = "blog", catalog = "newsportel", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Blog.findAll", query = "SELECT b FROM Blog b WHERE b.isActive=1"),
    @NamedQuery(name = "Blog.findByBlogIDPK", query = "SELECT b FROM Blog b WHERE b.blogIDPK = :blogIDPK"),
    @NamedQuery(name = "Blog.findByBlogTitle", query = "SELECT b FROM Blog b WHERE b.blogTitle = :blogTitle"),
    @NamedQuery(name = "Blog.findByBlogDescription", query = "SELECT b FROM Blog b WHERE b.blogDescription = :blogDescription"),
    @NamedQuery(name = "Blog.findByBlogDate", query = "SELECT b FROM Blog b WHERE b.blogDate = :blogDate"),
    @NamedQuery(name = "Blog.findByBlogStatus", query = "SELECT b FROM Blog b WHERE b.blogStatus = :blogStatus"),
    @NamedQuery(name = "Blog.findByIsActive", query = "SELECT b FROM Blog b WHERE b.isActive = :isActive"),
    @NamedQuery(name = "Blog.findByBlogImage", query = "SELECT b FROM Blog b WHERE b.blogImage = :blogImage")})
public class Blog implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "blogIDPK", nullable = false)
    private Integer blogIDPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2000)
    @Column(name = "blogTitle", nullable = false, length = 2000)
    private String blogTitle;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2000)
    @Column(name = "blogDescription", nullable = false, length = 2000)
    private String blogDescription;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2000)
    @Column(name = "blogDate", nullable = false, length = 2000)
    private String blogDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "blogStatus", nullable = false, length = 200)
    private String blogStatus;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isActive", nullable = false)
    private boolean isActive;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "blogImage", nullable = false, length = 255)
    private String blogImage;
    @JoinColumn(name = "userIDFK", referencedColumnName = "userIDPK", nullable = false)
    @ManyToOne(optional = false)
    private User userIDFK;
    @JoinColumn(name = "subCategoryIDFK", referencedColumnName = "subCategoryIDPK", nullable = false)
    @ManyToOne(optional = false)
    private Subcategory subCategoryIDFK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2000)
    @Column(name = "blogAuthor", nullable = false, length = 2000)
    private String blogAuthor;

    public Blog() {
    }

    public Blog(Integer blogIDPK) {
        this.blogIDPK = blogIDPK;
    }

    public Blog(Integer blogIDPK, String blogTitle, String blogDescription, String blogDate, String blogStatus, boolean isActive, String blogImage,String blogAuthor) {
        this.blogIDPK = blogIDPK;
        this.blogTitle = blogTitle;
        this.blogDescription = blogDescription;
        this.blogDate = blogDate;
        this.blogStatus = blogStatus;
        this.isActive = isActive;
        this.blogImage = blogImage;
        this.blogAuthor = blogAuthor;
    }

    public Integer getBlogIDPK() {
        return blogIDPK;
    }

    public void setBlogIDPK(Integer blogIDPK) {
        this.blogIDPK = blogIDPK;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    public String getBlogDescription() {
        return blogDescription;
    }

    public void setBlogDescription(String blogDescription) {
        this.blogDescription = blogDescription;
    }

    public String getBlogDate() {
        return blogDate;
    }

    public void setBlogDate(String blogDate) {
        this.blogDate = blogDate;
    }

    public String getBlogStatus() {
        return blogStatus;
    }

    public void setBlogStatus(String blogStatus) {
        this.blogStatus = blogStatus;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public String getBlogImage() {
        return blogImage;
    }

    public void setBlogImage(String blogImage) {
        this.blogImage = blogImage;
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
    
     public String getBlogAuthor() {
        return blogAuthor;
    }

    public void setBlogAuthor(String blogAuthor) {
        this.blogAuthor = blogAuthor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (blogIDPK != null ? blogIDPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Blog)) {
            return false;
        }
        Blog other = (Blog) object;
        if ((this.blogIDPK == null && other.blogIDPK != null) || (this.blogIDPK != null && !this.blogIDPK.equals(other.blogIDPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Blog[ blogIDPK=" + blogIDPK + " ]";
    }
    
}
