/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package ManagedBean;

import Entity.Category;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.List;
import java.util.Random;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import sessionBean.newsPotalSessionBeanLocal;

/**
 *
 * @author Zinal
 */
@Named(value = "categoryBean")
@ApplicationScoped
public class categoryManagedBean {

    @EJB
    private newsPotalSessionBeanLocal newsPortalSessionBean;
    
    int categoryIDPK;
    String categoryName , categoryIcon , grfile;
    Category category = new Category();
    
    Part file;
    
    
     HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();

        HttpSession userSession = request.getSession(false);
    
    @PostConstruct
    public void init(){
        categoryIDPK =0 ;
    }

    public newsPotalSessionBeanLocal getNewsPortalSessionBean() {
        return newsPortalSessionBean;
    }

    public void setNewsPortalSessionBean(newsPotalSessionBeanLocal newsPortalSessionBean) {
        this.newsPortalSessionBean = newsPortalSessionBean;
    }

    public int getCategoryIDPK() {
        return categoryIDPK;
    }

    public void setCategoryIDPK(int categoryIDPK) {
        this.categoryIDPK = categoryIDPK;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryIcon() {
        return categoryIcon;
    }

    public void setCategoryIcon(String categoryIcon) {
        this.categoryIcon = categoryIcon;
    }

    public String getGrfile() {
        return grfile;
    }

    public void setGrfile(String grfile) {
        this.grfile = grfile;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }
    
    

    public categoryManagedBean() {
    }
   
    
     public String insert_click() {
         
                      
                            
                             try {


                                            InputStream input = file.getInputStream();
                                               String path = "F:\\project_sem8\\newsportal\\newsPortal\\newsPortal-war\\web\\upload\\categoryImage\\";
                                               Random random = new Random();
                                               StringBuilder sb = new StringBuilder();

                                               sb.append(random.nextInt(9) + 1);
                                               for (int i = 0; i < 11; i++) {
                                                   sb.append(random.nextInt(10));
                                               }

                                               String temp = sb.toString();

                                               grfile = "IMG_"+ temp + file.getSubmittedFileName();
                                               Files.copy(input, new File(path, grfile).toPath());


                                           category.setCategoryIDPK(0);
                                           category.setCategoryName(categoryName);
                                           category.setCategoryIcon(grfile);
                                           category.setIsActive(true);
                                           newsPortalSessionBean.insertCategory(category);
                                           clear();
                                           return "/Admin/displayCategory.xhtml?faces-redirect=true";
                                         // FacesContext.getCurrentInstance().getExternalContext().redirect("./displayCategory.xhtml");
                                       } catch (Exception e) {
                                          return   e.getMessage();
                                       }
                            
                        
       
     }
     
     public String delete_click(int categoryIDPK) {
        System.out.println("Category id :: " + categoryIDPK);
        try {
            newsPortalSessionBean.deleteCategory(categoryIDPK);
            return "/Admin/displayCategory.xhtml?faces-redirect=true";
        } catch (Exception ex) {
           return  ex.getMessage();
        }
    }
     
    public String search_click(int id) {
        try {
            category = newsPortalSessionBean.searchCategory(id);
            categoryIDPK = category.getCategoryIDPK();
            categoryName = category.getCategoryName();
            return "/Admin/insertCategory.xhtml?faces-redirect=true";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
     
    public String update_click()
    {
        try {
            
            if(file != null) {
        
                InputStream input = file.getInputStream();
                String path = "F:\\project_sem8\\newsportal\\newsPortal\\newsPortal-war\\web\\upload\\categoryImage\\";
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
          
            
            category.setCategoryIDPK(categoryIDPK);
            category.setCategoryName(categoryName);
            category.setCategoryIcon(grfile);
            newsPortalSessionBean.updateCategory(category);
            clear();
            return "/Admin/displayCategory.xhtml?faces-redirect=true";
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    public List<Category> showall() {
        try {
        return newsPortalSessionBean.showall_Category();
        } catch (Exception e) {
            return null;
        }
    }
    
    public void clear(){
        categoryIDPK = 0;
        categoryName = "";
    }
    
}
