/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package ManagedBean;

import Entity.Blog;
import Entity.Category;
import Entity.Subcategory;
import Entity.User;
import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.servlet.http.Part;
import sessionBean.newsPotalSessionBeanLocal;
import java.util.List;
import java.util.Random;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author maafia_fury
 */
@Named(value = "blogBean")
@ApplicationScoped
public class blogManagedBean {
    
    
       @EJB
    private newsPotalSessionBeanLocal newsPotalSessionBean;
       
   int blogIDPK , subCategoryIDFK , userIDFK,categoryIDFK,userIDPK , userStatus , cityIDFK;
    String blogTitle , blogDescription , blogDate , blogStatus , blogImage,blogAuthor , grfile, userName , userPassword , userImage , userEmail , userMobile;
      List<Category> categoryList;
    List<Subcategory> subCategoryList;
    List<User> userList;
     Part file;
    
    Blog blog = new Blog();
     User user = new User();

    public int getUserIDPK() {
        return userIDPK;
    }

    public void setUserIDPK(int userIDPK) {
        this.userIDPK = userIDPK;
    }

    public int getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(int userStatus) {
        this.userStatus = userStatus;
    }

    public int getCityIDFK() {
        return cityIDFK;
    }

    public void setCityIDFK(int cityIDFK) {
        this.cityIDFK = cityIDFK;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
     
     
     

    public String getBlogAuthor() {
        return blogAuthor;
    }

    public void setBlogAuthor(String blogAuthor) {
        this.blogAuthor = blogAuthor;
    }
    
    

    public newsPotalSessionBeanLocal getNewsPotalSessionBean() {
        return newsPotalSessionBean;
    }

    public void setNewsPotalSessionBean(newsPotalSessionBeanLocal newsPotalSessionBean) {
        this.newsPotalSessionBean = newsPotalSessionBean;
    }

    public int getCategoryIDFK() {
        return categoryIDFK;
    }

    public void setCategoryIDFK(int categoryIDFK) {
        this.categoryIDFK = categoryIDFK;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }
   

    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }

    public int getBlogIDPK() {
        return blogIDPK;
    }

    public void setBlogIDPK(int blogIDPK) {
        this.blogIDPK = blogIDPK;
    }

    public int getSubCategoryIDFK() {
        return subCategoryIDFK;
    }

    public void setSubCategoryIDFK(int subCategoryIDFK) {
        this.subCategoryIDFK = subCategoryIDFK;
    }

    public int getUserIDFK() {
        return userIDFK;
    }

    public void setUserIDFK(int userIDFK) {
        this.userIDFK = userIDFK;
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

    public String getGrfile() {
        return grfile;
    }

    public void setGrfile(String grfile) {
        this.grfile = grfile;
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

    public String getBlogImage() {
        return blogImage;
    }

    public void setBlogImage(String blogImage) {
        this.blogImage = blogImage;
    }

    public List<Subcategory> getSubCategoryList() {
        return subCategoryList;
    }

    public void setSubCategoryList(List<Subcategory> subCategoryList) {
        this.subCategoryList = subCategoryList;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }
    
    public blogManagedBean() {
    }
    
    @PostConstruct
    public void init() {
         categoryList = newsPotalSessionBean.showall_Category();
        userList = newsPotalSessionBean.showall_User();
    }
    
     public void fillSubCategory() {
        subCategoryList = newsPotalSessionBean.showall_SubcategoryByCategory(categoryIDFK);
    }
    
    public List<Blog> showall() {
        try {
            return newsPotalSessionBean.showall_Blog();
        } catch (Exception e) {
            return null;
        }
    }
    
    public String insert_click()
    {
        try {
            
             SimpleDateFormat simpleformat = new SimpleDateFormat("MM/dd/yyyy");
              String currentDate = simpleformat.format(new Date());
              
              HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();

            HttpSession userSession = request.getSession();
            
            
                InputStream input = file.getInputStream();
                String path = "F:\\project_sem8\\newsportal\\newsPortal\\newsPortal-war\\web\\upload\\blogImage\\";
                Random random = new Random();
                StringBuilder sb = new StringBuilder();
                
                sb.append(random.nextInt(9) + 1);
                for (int i = 0; i < 11; i++) {
                    sb.append(random.nextInt(10));
                }
                
                String temp = sb.toString();
                
                grfile = "IMG_"+ temp + file.getSubmittedFileName();
                Files.copy(input, new File(path, grfile).toPath());
            
                Subcategory subCategory = newsPotalSessionBean.searchSubcategory(subCategoryIDFK);
                User user = newsPotalSessionBean.searchUser(Integer.parseInt(userSession.getAttribute("userID").toString()));
                blog.setBlogIDPK(0);
                blog.setBlogTitle(blogTitle);
                blog.setBlogDescription(blogDescription);
                blog.setBlogDate(currentDate);
                blog.setBlogStatus("1");
                blog.setSubCategoryIDFK(subCategory);
                blog.setIsActive(true);
                blog.setUserIDFK(user);
                blog.setBlogImage(grfile);
                blog.setBlogAuthor(blogAuthor);
                newsPotalSessionBean.insertBlog(blog);
                  clear();
                return "/Admin/displayBlog.xhtml?faces-redirect=true";
                
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    public String update_click()
    {
        try {
            
            if(file != null) {
        
                InputStream input = file.getInputStream();
                String path = "F:\\project_sem8\\newsportal\\newsPortal\\newsPortal-war\\web\\upload\\blogImage\\";
                Random random = new Random();
                StringBuilder sb = new StringBuilder();

                sb.append(random.nextInt(9) + 1);
                for (int i = 0; i < 11; i++) {
                    sb.append(random.nextInt(10));
                }
                String temp = sb.toString();

                grfile = "IMG_"+ temp + file.getSubmittedFileName();
                Files.copy(input, new File(path, grfile).toPath());

            }
            
                Subcategory subCategory = newsPotalSessionBean.searchSubcategory(subCategoryIDFK);
                User user = newsPotalSessionBean.searchUser(userIDFK);
            
                blog.setBlogIDPK(blogIDPK);
                blog.setBlogTitle(blogTitle);
                blog.setBlogDescription(blogDescription);
                blog.setBlogDate(blogDate);
                blog.setBlogStatus(blogStatus);
                blog.setSubCategoryIDFK(subCategory);
                blog.setBlogImage(grfile);
                blog.setUserIDFK(user);
                blog.setBlogAuthor(blogAuthor);
                newsPotalSessionBean.updateBlog(blog);
                 clear();
                return "/Admin/displayBlog.xhtml?faces-redirect=true";
        } catch (Exception e) {
           return e.getMessage();
        }
    }
    
    public String delete_click(int blogIDPK)
    {
        try {
            newsPotalSessionBean.deleteBlog(blogIDPK);
                 clear();
                return "/Admin/displayBlog.xhtml?faces-redirect=true";
        } catch (Exception e) {
           return e.getMessage();
        }
    }
    
    public String search_click(int id)
    {
        try {
            blog = newsPotalSessionBean.searchBlog(id);
            blogIDPK = blog.getBlogIDPK();
            blogTitle = blog.getBlogTitle();
            blogDescription = blog.getBlogDescription();
            blogDate = blog.getBlogDate();
            blogStatus = blog.getBlogStatus();
            subCategoryIDFK = blog.getSubCategoryIDFK().getSubCategoryIDPK();
            blogImage = blog.getBlogImage();
            blogAuthor = blog.getBlogAuthor();
            userIDFK = blog.getUserIDFK().getUserIDPK();
             return "/Admin/insertBlog.xhtml?faces-redirect=true";
        } catch (Exception e) {
           return e.getMessage();
        }
    }
    
    public String search_singleBlog(int id) {
        try {
            blog = newsPotalSessionBean.searchBlog(id);
            blogIDPK = blog.getBlogIDPK();
            blogTitle = blog.getBlogTitle();
            blogDescription = blog.getBlogDescription();
            blogDate = blog.getBlogDate();
            subCategoryIDFK = blog.getSubCategoryIDFK().getSubCategoryIDPK();
            userIDFK = blog.getUserIDFK().getUserIDPK();
            blogImage = blog.getBlogImage();
            blogAuthor = blog.getBlogAuthor();
            
            
             user = newsPotalSessionBean.searchUser(userIDFK);
            userIDPK = user.getUserIDPK();
            userName = user.getUserName();
            userPassword = user.getUserPassword();
            userImage = user.getUserImage();
            userEmail = user.getUserEmail();
            userMobile = user.getUserMobile();
            userStatus = user.getUserStatus();
            cityIDFK = user.getCityIDFK().getCityIDPK();
            
            return "./blog.xhtml?faces-redirect=true";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    public void clear(){
        blogIDPK = 0;
        blogTitle = "";
        blogDescription = "";
        blogDate = "";
        blogImage = "";
        blogStatus = "";
        subCategoryIDFK = 0;
        userIDFK = 0;
    }
    
    
}
