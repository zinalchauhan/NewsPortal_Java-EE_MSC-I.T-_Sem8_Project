/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package ManagedBean;

import Entity.Category;
import Entity.City;
import Entity.State;
import Entity.Subcategory;
import Entity.Videonews;
import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import sessionBean.newsPotalSessionBeanLocal;
import java.util.List;
import java.util.Random;
import javax.annotation.PostConstruct;
import javax.servlet.http.Part;

/**
 *
 * @author maafia_fury
 */
@Named(value = "videoNewsBean")
@ApplicationScoped
public class videoNewsManagedBean {

    
       @EJB
    private newsPotalSessionBeanLocal newsPotalSessionBean;

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
       
       

    
   int videoNewsIDPK , subCategoryIDFK,categoryIDFK ,stateIDFK,cityIDFK;
    String videoNewsTitle , videoNewsDescription ,cityName, video , grfile , videoNewsDate , videoNewsStatus ;
    List<Subcategory> subCategoryLst;
     List<Category> categoryList;
     List<City> cityList;
     List<State> stateList;
    Part file;
    
    
    Videonews videoNews = new Videonews();
     
    public videoNewsManagedBean() {
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
    
    

    public int getStateIDFK() {
        return stateIDFK;
    }

    public void setStateIDFK(int stateIDFK) {
        this.stateIDFK = stateIDFK;
    }

    public int getCityIDFK() {
        return cityIDFK;
    }

    public void setCityIDFK(int cityIDFK) {
        this.cityIDFK = cityIDFK;
    }

    public List<City> getCityList() {
        return cityList;
    }

    public void setCityList(List<City> cityList) {
        this.cityList = cityList;
    }

    public List<State> getStateList() {
        return stateList;
    }

    public void setStateList(List<State> stateList) {
        this.stateList = stateList;
    }
    
    

    public newsPotalSessionBeanLocal getNewsPortalSessionBean() {
        return newsPotalSessionBean;
    }

    public void setNewsPortalSessionBean(newsPotalSessionBeanLocal newsPortalSessionBean) {
        this.newsPotalSessionBean = newsPortalSessionBean;
    }

    public int getVideoNewsIDPK() {
        return videoNewsIDPK;
    }

    public void setVideoNewsIDPK(int videoNewsIDPK) {
        this.videoNewsIDPK = videoNewsIDPK;
    }

    public int getSubCategoryIDFK() {
        return subCategoryIDFK;
    }

    public void setSubCategoryIDFK(int subCategoryIDFK) {
        this.subCategoryIDFK = subCategoryIDFK;
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

    public String getGrfile() {
        return grfile;
    }

    public void setGrfile(String grfile) {
        this.grfile = grfile;
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

    public List<Subcategory> getSubCategoryLst() {
        return subCategoryLst;
    }

    public void setSubCategoryLst(List<Subcategory> subCategoryLst) {
        this.subCategoryLst = subCategoryLst;
    }

    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }

    public Videonews getVideoNews() {
        return videoNews;
    }

    public void setVideoNews(Videonews videoNews) {
        this.videoNews = videoNews;
    }
    
    @PostConstruct
     public void init() {
          categoryList = newsPotalSessionBean.showall_Category();
          stateList = newsPotalSessionBean.showall_State();
    }
    
      public void fillSubCategory() {
        subCategoryLst = newsPotalSessionBean.showall_SubcategoryByCategory(categoryIDFK);
    }
      
      public void fillCity() {
        cityList = newsPotalSessionBean.showall_CityByState(stateIDFK);
    }
     
    public List<Videonews> showall() {
        try {
            return newsPotalSessionBean.showall_VideoNews();
        } catch (Exception e) {
            return null;
        }
    }
    
    public String insert_click()
    {
        try {
            
            SimpleDateFormat simpleformat = new SimpleDateFormat("MM/dd/yyyy");
              String currentDate = simpleformat.format(new Date());
            
                InputStream input = file.getInputStream();
                String path = "F:\\project_sem8\\newsportal\\newsPortal\\newsPortal-war\\web\\upload\\newsVideo\\";
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
                City city = newsPotalSessionBean.searchCity(cityIDFK);
                videoNews.setVideoNewsIDPK(0);
                videoNews.setVideoNewsTitle(videoNewsTitle);
                videoNews.setVideoNewsDescription(videoNewsDescription);
                videoNews.setVideo(grfile);
                videoNews.setCityIDFK(city);
                videoNews.setVideoNewsDate(currentDate);
                videoNews.setVideoNewsStatus("1");
                videoNews.setSubCategoryIDFK(subCategory);
                videoNews.setIsActive(true);
                newsPotalSessionBean.insertVideoNews(videoNews);
                 clear();
                 return "/Admin/displayVideoNews.xhtml?faces-redirect=true";
                
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    public String update_click()
    {
        try {
            
            if(file != null) {
        
                InputStream input = file.getInputStream();
                String path = "F:\\project_sem8\\newsportal\\newsPortal\\newsPortal-war\\web\\upload\\newsVideo\\";
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
                   City city = newsPotalSessionBean.searchCity(cityIDFK);
                videoNews.setVideoNewsIDPK(videoNewsIDPK);
                videoNews.setVideoNewsTitle(videoNewsTitle);
                videoNews.setVideoNewsDescription(videoNewsDescription);
                videoNews.setVideoNewsDate(videoNewsDate);
                videoNews.setVideoNewsStatus(videoNewsStatus);
                videoNews.setVideo(grfile);
                videoNews.setCityIDFK(city);
                videoNews.setSubCategoryIDFK(subCategory);
                newsPotalSessionBean.updateVideoNews(videoNews);
                 clear();
                 return "/Admin/displayVideoNews.xhtml?faces-redirect=true";
        } catch (Exception e) {
           return e.getMessage();
        }
    }
    
    public String delete_click(int videoNewsIDPK)
    {
        try {
            newsPotalSessionBean.deleteVideoNews(videoNewsIDPK);
             clear();
             return "/Admin/displayVideoNews.xhtml?faces-redirect=true";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    public String search_click(int id)
    {
        try {
             videoNews = newsPotalSessionBean.searchVideoNews(id);
            videoNewsIDPK = videoNews.getVideoNewsIDPK();
            videoNewsTitle = videoNews.getVideoNewsTitle();
            videoNewsDescription = videoNews.getVideoNewsDescription();
            video = videoNews.getVideo();
            videoNewsDate = videoNews.getVideoNewsDate();
           
            subCategoryIDFK = videoNews.getSubCategoryIDFK().getSubCategoryIDPK();
            videoNewsStatus = videoNews.getVideoNewsStatus(); 
            cityIDFK = videoNews.getCityIDFK().getCityIDPK();
            categoryIDFK = videoNews.getSubCategoryIDFK().getCategoryIDFK().getCategoryIDPK();
            stateIDFK = videoNews.getCityIDFK().getStateIDFK().getStateIDPK();
            
            subCategoryLst = newsPotalSessionBean.showall_SubcategoryByCategory(categoryIDFK);
            cityList = newsPotalSessionBean.showall_CityByState(stateIDFK);
           
             return "/Admin/insertVideoNews.xhtml?faces-redirect=true";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    
      public String searchUser_click(int id)
    {
        try {
             videoNews = newsPotalSessionBean.searchVideoNews(id);
            videoNewsIDPK = videoNews.getVideoNewsIDPK();
            videoNewsTitle = videoNews.getVideoNewsTitle();
            videoNewsDescription = videoNews.getVideoNewsDescription();
            video = videoNews.getVideo();
            videoNewsDate = videoNews.getVideoNewsDate();
           
            subCategoryIDFK = videoNews.getSubCategoryIDFK().getSubCategoryIDPK();
            videoNewsStatus = videoNews.getVideoNewsStatus(); 
            cityIDFK = videoNews.getCityIDFK().getCityIDPK();
              cityName = videoNews.getCityIDFK().getCityName();
            categoryIDFK = videoNews.getSubCategoryIDFK().getCategoryIDFK().getCategoryIDPK();
            stateIDFK = videoNews.getCityIDFK().getStateIDFK().getStateIDPK();
            
            subCategoryLst = newsPotalSessionBean.showall_SubcategoryByCategory(categoryIDFK);
            cityList = newsPotalSessionBean.showall_CityByState(stateIDFK);
           
             return "./newsVideo.xhtml?faces-redirect=true";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    public void clear(){
        videoNewsIDPK = 0;
        videoNewsTitle = "";
        videoNewsDescription = "";
        video = "";
        videoNewsDate = "";
        videoNewsStatus = "";
        subCategoryIDFK = 0;
        cityIDFK=0;
  
    }
    
    
}
