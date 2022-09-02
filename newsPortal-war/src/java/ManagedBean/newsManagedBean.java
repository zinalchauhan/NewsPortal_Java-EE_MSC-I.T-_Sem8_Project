/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package ManagedBean;

import Entity.Category;
import Entity.City;
import Entity.News;
import Entity.Newsimage;
import Entity.State;
import Entity.Subcategory;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import sessionBean.newsPotalSessionBeanLocal;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.servlet.http.Part;
import java.util.Random;
import java.util.Collection;
import java.util.Date;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.util.stream.Collectors;
import javax.servlet.http.HttpSession;

/**
 *
 * @author maafia_fury
 */
@Named(value = "newsBean")
@ApplicationScoped
public class newsManagedBean {
    
    @EJB
    private newsPotalSessionBeanLocal newsPotalSessionBean;
    
    int newsIDPK,subCategoryIDFK,categoryIDFK,stateIDFK,cityIDFK;
        String newsTitle,newssubTitle,subCategoryName,newsDescription,newsDate,newsStatus,newsImage,newsType,cityName,stateName;
              Part file;
     News news = new News();
     List<Subcategory> subCategoryList; 
     List<Category> categoryList;
      List<State> stateList;
      List<City> cityList;
       List<News> newsList;
      
      
      HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();

            HttpSession userSession = request.getSession();

    public String getSubCategoryName() {
        return subCategoryName;
    }

    public void setSubCategoryName(String subCategoryName) {
        this.subCategoryName = subCategoryName;
    }

            
            
    public List<News> getNewsList() {
        return newsList;
    }

    public void setNewsList(List<News> newsList) {
        this.newsList = newsList;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

     
            
    public String getNewsType() {
        return newsType;
    }

    public void setNewsType(String newsType) {
        this.newsType = newsType;
    }
      

      
      
    public int getCategoryIDFK() {
        return categoryIDFK;
    }

    public List<City> getCityList() {
        return cityList;
    }

    public void setCityList(List<City> cityList) {
        this.cityList = cityList;
    }

    public int getCityIDFK() {
        return cityIDFK;
    }

    public void setCityIDFK(int cityIDFK) {
        this.cityIDFK = cityIDFK;
    }

    public void setCategoryIDFK(int categoryIDFK) {
        this.categoryIDFK = categoryIDFK;
    }


    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }


    public String getNewsImage() {
        return newsImage;
    }

    public void setNewsImage(String newsImage) {
        this.newsImage = newsImage;
    }
   

    public int getStateIDFK() {
        return stateIDFK;
    }

    public void setStateIDFK(int stateIDFK) {
        this.stateIDFK = stateIDFK;
    }

    public List<State> getStateList() {
        return stateList;
    }

    public void setStateList(List<State> stateList) {
        this.stateList = stateList;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public newsPotalSessionBeanLocal getNewsPotalSessionBean() {
        return newsPotalSessionBean;
    }

    public void setNewsPotalSessionBean(newsPotalSessionBeanLocal newsPotalSessionBean) {
        this.newsPotalSessionBean = newsPotalSessionBean;
    }

    public int getNewsIDPK() {
        return newsIDPK;
    }

    public void setNewsIDPK(int newsIDPK) {
        this.newsIDPK = newsIDPK;
    }

    public int getSubCategoryIDFK() {
        return subCategoryIDFK;
    }

    public void setSubCategoryIDFK(int subCategoryIDFK) {
        this.subCategoryIDFK = subCategoryIDFK;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getNewssubTitle() {
        return newssubTitle;
    }

    public void setNewssubTitle(String newssubTitle) {
        this.newssubTitle = newssubTitle;
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

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }

    public List<Subcategory> getSubCategoryList() {
        return subCategoryList;
    }

    public void setSubCategoryList(List<Subcategory> subCategoryList) {
        this.subCategoryList = subCategoryList;
    }
    
      public void addcityIDFK(int id) {
        cityIDFK = id;
    }
    
     
   
     
    @PostConstruct
    public void init(){
        
       categoryList = newsPotalSessionBean.showall_Category();
        stateList = newsPotalSessionBean.showall_State();
        newsList = newsPotalSessionBean.showall_News();
        
   }
    
    public void fillSubCategory() {
        subCategoryList = newsPotalSessionBean.showall_SubcategoryByCategory(categoryIDFK);
    }
    
    public void fillCity() {
        cityList = newsPotalSessionBean.showall_CityByState(stateIDFK);
    }
    
    
    public void searchNewsByCity() {
        newsList = newsPotalSessionBean.showall_NewsByCity(cityIDFK);
    }
    
     public List<News>  showAllsearchNewsByCity(){
       
        newsList = newsPotalSessionBean.showall_NewsByCity(cityIDFK);
        
        return newsList;
        
            }
    
    
    public List<News> show_all() {
        try {
            return newsPotalSessionBean.showall_News();
        } catch (Exception e) {
            return null;
        }
    }
    
    
//      public String insert_click()
//    {
//        try {
//            Subcategory subcategory = newsPotalSessionBean.searchSubcategory(subCategoryIDFK);
//            City city = newsPotalSessionBean.searchCity(cityIDFK);
//            news.setNewsIDPK(0);
//            news.setNewsTitle(newsTitle);
//            news.setNewsSubtitle(newssubTitle);
//            news.setNewsDescription(newsDescription);
//            news.setNewsDate(newsDate);
//            news.setNewsStatus("1");
//            news.setSubCategoryIDFK(subcategory);
//            news.setCityIDFK(city);
//            news.setIsActive(true);
//          int newsId = newsPotalSessionBean.insertNews(news);
//            System.err.println("News ID :: "+ newsId);
//            News insertNews = newsPotalSessionBean.searchNews(newsId);
//
//            String path = "F:\\project_sem8\\newsportal\\newsPortal\\newsPortal-war\\web\\upload\\newsImage\\";
//
//            Collection<Part> allParts = getAllParts(file);
//            allParts.stream().forEach((f) -> {
//                try (InputStream input = f.getInputStream()) {
//                    Random rndom = new Random();
//                    StringBuilder sb = new StringBuilder();
//
//                    sb.append(rndom.nextInt(9) + 1);
//                    for (int i = 0; i < 11; i++) {
//                        sb.append(rndom.nextInt(10));
//                    }
//                    String imgno = sb.toString();
//                    newsImage = imgno + f.getSubmittedFileName();
//                    Files.copy(input, new File(path, newsImage).toPath());
//
//                    Newsimage newsImageData = new Newsimage();
//
//                    newsImageData.setImageIDPK(0);
//                    newsImageData.setImage(newsImage);
//                    newsImageData.setNewsIDFK(insertNews);
//                    newsImageData.setIsActive(true);
//                    newsPotalSessionBean.insertNewsImage(newsImageData);
//                } catch (IOException ex) {
//                    ex.getMessage();
//                }
//
//            });
//            return "/Admin/displayNews.xhtml?faces-redirect=true";
//    
//                       
//
//        } catch (Exception e) {
//            return e.getMessage();
//        }
//    }
//      
    
     public String insert_click() {
        try {
            
              SimpleDateFormat simpleformat = new SimpleDateFormat("MM/dd/yyyy");
              String currentDate = simpleformat.format(new Date());
              
            
            Subcategory subcategory = newsPotalSessionBean.searchSubcategory(subCategoryIDFK);
            City city = newsPotalSessionBean.searchCity(cityIDFK);
            news.setNewsIDPK(0);
            news.setNewsTitle(newsTitle);
            news.setNewsSubtitle(newssubTitle);
            news.setNewsDescription(newsDescription);
            news.setNewsDate(currentDate);
            news.setNewsStatus("0");
            news.setCityIDFK(city);
            news.setSubCategoryIDFK(subcategory);
            news.setIsActive(true);
            news.setNewsType(newsType);
            
            int newsId = newsPotalSessionBean.insertNews(news);
            System.err.println("News ID :: "+ newsId);
            News insertNews = newsPotalSessionBean.searchNews(newsId);

            String path = "F:\\project_sem8\\newsportal\\newsPortal\\newsPortal-war\\web\\upload\\newsImage\\";

            Collection<Part> allParts = getAllParts(file);
            allParts.stream().forEach((f) -> {
                try (InputStream input = f.getInputStream()) {
                    Random rndom = new Random();
                    StringBuilder sb = new StringBuilder();

                    sb.append(rndom.nextInt(9) + 1);
                    for (int i = 0; i < 11; i++) {
                        sb.append(rndom.nextInt(10));
                    }
                    String imgno = sb.toString();
                    newsImage = imgno + f.getSubmittedFileName();
                    Files.copy(input, new File(path, newsImage).toPath());

                    Newsimage newsImageData = new Newsimage();

                    newsImageData.setImageIDPK(0);
                    newsImageData.setImage(newsImage);
                    newsImageData.setNewsIDFK(insertNews);
                    newsImageData.setIsActive(true);
                    newsPotalSessionBean.insertNewsImage(newsImageData);
                } catch (IOException ex) {
                    ex.getMessage();
                }

            });
             clear();
            return "/Admin/displayNews.xhtml?faces-redirect=true";
           //  FacesContext.getCurrentInstance().getExternalContext().redirect("./displayNews.xhtml?faces-redirect=true");
           
        } catch (IOException | ServletException e) {
            return e.getMessage();
        }
    }
      
    
    
    
       public String update_click()
    {
        try {
               Subcategory subcategory = newsPotalSessionBean.searchSubcategory(subCategoryIDFK);
                City city = newsPotalSessionBean.searchCity(cityIDFK);
             news.setNewsIDPK(newsIDPK);
            news.setNewsTitle(newsTitle);
            news.setNewsSubtitle(newssubTitle);
            news.setNewsDescription(newsDescription);
            news.setNewsDate(newsDate);
            news.setNewsStatus(newsStatus);
            news.setSubCategoryIDFK(subcategory);
            news.setCityIDFK(city);
            news.setNewsType(newsType);
            newsPotalSessionBean.updateNews(news);
               clear();
                return "/Admin/displayNews.xhtml";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
       
       public String delete_click(int newsIDPK)
    {
        try {
            newsPotalSessionBean.deleteNews(newsIDPK);
               clear();
                return "/Admin/displayNews.xhtml?faces-redirect=true";
            
        } catch (Exception e) {
            return e.getMessage();
        }
    }
       
        public String search_click(int id)
    {
        try {
            news = newsPotalSessionBean.searchNews(id);
            newsIDPK = news.getNewsIDPK();
            newsTitle = news.getNewsTitle();
            newssubTitle = news.getNewsSubtitle();
            newsDescription = news.getNewsDescription();
            newsDate = news.getNewsDate();
            newsStatus = news.getNewsStatus();
            cityIDFK = news.getCityIDFK().getCityIDPK();
            subCategoryIDFK = news.getSubCategoryIDFK().getSubCategoryIDPK();
            categoryIDFK = news.getSubCategoryIDFK().getCategoryIDFK().getCategoryIDPK();
            stateIDFK = news.getCityIDFK().getStateIDFK().getStateIDPK();
            newsType = news.getNewsType();
            
            subCategoryList = newsPotalSessionBean.showall_SubcategoryByCategory(categoryIDFK);
            cityList = newsPotalSessionBean.showall_CityByState(stateIDFK);
           
                return "/Admin/insertNews.xhtml?faces-redirect=true";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
        
   public String searchUser_click(int id)
    {
        try {
            news = newsPotalSessionBean.searchNews(id);
            newsIDPK = news.getNewsIDPK();
            newsTitle = news.getNewsTitle();
            newssubTitle = news.getNewsSubtitle();
            newsDescription = news.getNewsDescription();
            newsDate = news.getNewsDate();
            newsStatus = news.getNewsStatus();
            cityIDFK = news.getCityIDFK().getCityIDPK();
            subCategoryIDFK = news.getSubCategoryIDFK().getSubCategoryIDPK();
            categoryIDFK = news.getSubCategoryIDFK().getCategoryIDFK().getCategoryIDPK();
            stateIDFK = news.getCityIDFK().getStateIDFK().getStateIDPK();
            newsType = news.getNewsType();
                  cityName = news.getCityIDFK().getCityName();
            stateName = news.getCityIDFK().getStateIDFK().getStateName();
            subCategoryName = news.getSubCategoryIDFK().getSubCategoryName();
           
            
            subCategoryList = newsPotalSessionBean.showall_SubcategoryByCategory(categoryIDFK);
            cityList = newsPotalSessionBean.showall_CityByState(stateIDFK);
           
                return "./news.xhtml?faces-redirect=true";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
        
        
         public String update_status(int id)
    {
        try {
            news = newsPotalSessionBean.searchNews(id);
            
            newsIDPK = news.getNewsIDPK();
                newsStatus = news.getNewsStatus();
     
//            newsStatus = news.getNewsStatus();
//            
//            news.setNewsStatus("2");
//            newsPotalSessionBean.updateNews(news);
            
            
          
            
           
                return newsStatus;
        } catch (Exception e) {
            return e.getMessage();
        }
    }
         
         public String isAvailable_Click(int newsIDPK, String newsStatus) {
        try {
            //System.out.println("managedBean.propertyManagedBean.isAvailable_Click()" + newsStatus);
            newsPotalSessionBean.isAvailableStatus(newsIDPK, newsStatus);
            return "/Admin/displayNews.xhtml?faces-redirect=true";
        } catch (Exception e) {
            return e.getMessage();
        }
    }



         
         
        
      public void clear(){
        newsIDPK = 0;
        newsTitle = "";
        newssubTitle = "";
        newsDescription = "";
        newsDate = "";
        newsStatus = "";
        subCategoryIDFK = 0;
    }
      
      
      private Collection<Part> getAllParts(Part part) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        return request.getParts().stream().filter(p -> part.getName().equals(p.getName())).collect(Collectors.toList());

    }

    /**
     * Creates a new instance of NewsManagedBean
     */
    public newsManagedBean() {
    }
    
}
