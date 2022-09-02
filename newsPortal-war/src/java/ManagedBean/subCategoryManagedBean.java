/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package ManagedBean;

import Entity.Category;
import Entity.Subcategory;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import sessionBean.newsPotalSessionBeanLocal;

/**
 *
 * @author Zinal
 */
@Named(value = "subCategoryBean")
@ApplicationScoped
public class subCategoryManagedBean {
    
    @EJB
    private newsPotalSessionBeanLocal newsPortalSessionBean;
    
    int subCategoryIDPK , categoryIDFK;
    String subCategoryName;
    Subcategory subCategory = new Subcategory();
    List<Category> categoryList;

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }
    
    public newsPotalSessionBeanLocal getNewsPortalSessionBean() {
        return newsPortalSessionBean;
    }

    public void setNewsPortalSessionBean(newsPotalSessionBeanLocal newsPortalSessionBean) {
        this.newsPortalSessionBean = newsPortalSessionBean;
    }

    public int getSubCategoryIDPK() {
        return subCategoryIDPK;
    }

    public void setSubCategoryIDPK(int subCategoryIDPK) {
        this.subCategoryIDPK = subCategoryIDPK;
    }

    public int getCategoryIDFK() {
        return categoryIDFK;
    }

    public void setCategoryIDFK(int categoryIDFK) {
        this.categoryIDFK = categoryIDFK;
    }

    public String getSubCategoryName() {
        return subCategoryName;
    }

    public void setSubCategoryName(String subCategoryName) {
        this.subCategoryName = subCategoryName;
    }

    public subCategoryManagedBean() {
    }
    
     @PostConstruct
    public void init() {
        subCategoryIDPK = 0;
        categoryList = newsPortalSessionBean.showall_Category();
    }
    
    public List<Subcategory> showall() {
        try {
            return newsPortalSessionBean.showall_Subcategory();
        } catch (Exception e) {
            return null;
        }
    }
    
    public String insert_click()
    {
        try {
            Category category = newsPortalSessionBean.searchCategory(categoryIDFK);
            subCategory.setSubCategoryIDPK(0);
            subCategory.setSubCategoryName(subCategoryName);
            subCategory.setCategoryIDFK(category);
            subCategory.setIsActive(true);
            newsPortalSessionBean.insertSubcategory(subCategory);
            clear();
            return "/Admin/displaySubCategory.xhtml?faces-redirect=true";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    public String update_click()
    {
        try {
            Category category = newsPortalSessionBean.searchCategory(categoryIDFK);
            subCategory.setSubCategoryIDPK(subCategoryIDPK);
            subCategory.setSubCategoryName(subCategoryName);
            subCategory.setCategoryIDFK(category);
            newsPortalSessionBean.updateSubcategory(subCategory);
            clear();
            return "/Admin/displaySubCategory.xhtml?faces-redirect=true";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    public String delete_click(int subCategoryIDPK)
    {
        try {
            newsPortalSessionBean.deleteSubcategory(subCategoryIDPK);
            return "/Admin/displaySubCategory.xhtml?faces-redirect=true";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    public String search_click(int id)
    {
        try {
            subCategory = newsPortalSessionBean.searchSubcategory(id);
            subCategoryIDPK = subCategory.getSubCategoryIDPK();
            subCategoryName = subCategory.getSubCategoryName();
            categoryIDFK = subCategory.getCategoryIDFK().getCategoryIDPK();
            return "/Admin/insertSubCategory.xhtml?faces-redirect=true";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    public void clear(){
        subCategoryIDPK = 0;
        subCategoryName = "";
        categoryIDFK = 0;
    }
    
}
