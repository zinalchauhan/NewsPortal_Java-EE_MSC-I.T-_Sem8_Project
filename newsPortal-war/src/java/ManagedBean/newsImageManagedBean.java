/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package ManagedBean;

import Entity.News;
import Entity.Newsimage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.Random;
import java.util.Collection;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import sessionBean.newsPotalSessionBeanLocal;

/**
 *
 * @author maafia_fury
 */
@Named(value = "newsImageBean")
@ApplicationScoped
public class newsImageManagedBean {
    
      @EJB
    private newsPotalSessionBeanLocal newsPotalSessionBean;


     int imageIDPK , newsIDFK;
    String image , grfile;
    List<News> newsList;
    List<Newsimage>newsImageList;
  Part file;
    
       Newsimage newsImage = new Newsimage();
       
    public newsPotalSessionBeanLocal getNewsPotalSessionBean() {
        return newsPotalSessionBean;
    }

    public void setNewsPotalSessionBean(newsPotalSessionBeanLocal newsPotalSessionBean) {
        this.newsPotalSessionBean = newsPotalSessionBean;
    }

    public List<Newsimage> getNewsImageList() {
        return newsImageList;
    }

    public void setNewsImageList(List<Newsimage> newsImageList) {
        this.newsImageList = newsImageList;
    }

    public Newsimage getNewsImage() {
        return newsImage;
    }

    public void setNewsImage(Newsimage newsImage) {
        this.newsImage = newsImage;
    }
    
    public void addNewsIDFK(int id) {
        newsIDFK = id;
    }
    
  
    
 

    public newsImageManagedBean() {
    }

    public newsPotalSessionBeanLocal getNewsPortalSessionBean() {
        return newsPotalSessionBean;
    }

    public void setNewsPortalSessionBean(newsPotalSessionBeanLocal newsPortalSessionBean) {
        this.newsPotalSessionBean = newsPortalSessionBean;
    }

    public int getImageIDPK() {
        return imageIDPK;
    }

    public void setImageIDPK(int imageIDPK) {
        this.imageIDPK = imageIDPK;
    }

    public int getNewsIDFK() {
        return newsIDFK;
    }

    public void setNewsIDFK(int newsIDFK) {
        this.newsIDFK = newsIDFK;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getGrfile() {
        return grfile;
    }

    public void setGrfile(String grfile) {
        this.grfile = grfile;
    }

    public List<News> getNewsList() {
        return newsList;
    }

    public void setNewsList(List<News> newsList) {
        this.newsList = newsList;
    }

    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }
    
    @PostConstruct
    public void init() {
        newsList = newsPotalSessionBean.showall_News();
    }
    
    public List<Newsimage> showall() {
        try {
            return newsPotalSessionBean.showall_NewsImage();
        } catch (Exception e) {
            return null;
        }
    }
    
//    public void insert_click()
//    {
//        try {
//            
//                InputStream input = file.getInputStream();
//                String path = "F:\\project_sem8\\newsportal\\newsPortal\\newsPortal-war\\web\\upload\\newsImage\\";
//                Random random = new Random();
//                StringBuilder sb = new StringBuilder();
//                
//                sb.append(random.nextInt(9) + 1);
//                for (int i = 0; i < 11; i++) {
//                    sb.append(random.nextInt(10));
//                }
//                
//                String temp = sb.toString();
//                
//                grfile = "IMG_"+ temp + file.getSubmittedFileName();
//                Files.copy(input, new File(path, grfile).toPath());
//            
//                News news = newsPotalSessionBean.searchNews(newsIDFK);
//                newsImage.setImageIDPK(0);
//                newsImage.setImage(grfile);
//                newsImage.setNewsIDFK(news);
//                newsImage.setIsActive(true);
//                newsPotalSessionBean.insertNewsImage(newsImage);
//                
//        } catch (Exception e) {
//            e.getMessage();
//        }
//    }
    
    
    public String insert_click() {
        
        try {
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
                    grfile = imgno + f.getSubmittedFileName();
                    Files.copy(input, new File(path, grfile).toPath());

                    News news = newsPotalSessionBean.searchNews(newsIDFK);
                    newsImage.setImageIDPK(0);
                    newsImage.setImage(grfile);
                    newsImage.setNewsIDFK(news);
                    newsImage.setIsActive(true);
                    newsPotalSessionBean.insertNewsImage(newsImage);
                    } catch (IOException ex) {
                    ex.getMessage();
                }

            });
             clear();
            return "/Admin/displayNewsImage.xhtml?faces-redirect=true";


        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    public void update_click()
    {
        try {
            
            if(file != null) {
        
                InputStream input = file.getInputStream();
                String path = "D:\\Project IT-8\\newsPortal\\newsPortal-war\\web\\upload\\newsImage\\";
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
            
                News news = newsPotalSessionBean.searchNews(newsIDFK);
                newsImage.setImageIDPK(0);
                newsImage.setImage(grfile);
                newsImage.setNewsIDFK(news);
                newsPotalSessionBean.updateNewsImage(newsImage);
                
        } catch (Exception e) {
            e.getMessage();
        }
    }
    
    public String delete_click(int imageIDPK)
    {
        try {
            newsPotalSessionBean.deleteNewsImage(imageIDPK);
            clear();
            return "/Admin/displayNewsImage.xhtml?faces-redirect=true";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    public void search_click(int id)
    {
        try {
            newsImage = newsPotalSessionBean.searchNewsImage(id);
            imageIDPK = newsImage.getImageIDPK();
            newsIDFK = newsImage.getNewsIDFK().getNewsIDPK();
            image = newsImage.getImage();
        } catch (Exception e) {
            e.getMessage();
        }
    }
    
    public List<Newsimage>  showAllNewsImage(){
       
        newsImageList = newsPotalSessionBean.showImageByNews(newsIDFK);
        
        return newsImageList;
        
            }
    
    
    
    private Collection<Part> getAllParts(Part part) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        return request.getParts().stream().filter(p -> part.getName().equals(p.getName())).collect(Collectors.toList());

    }
    
    public void clear(){
        imageIDPK = 0;
       // newsIDFK = 0;
        image = "";
    }
    
}
