/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package ManagedBean;

import Entity.Ads;
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

/**
 *
 * @author maafia_fury
 */
@Named(value = "adsBean")
@ApplicationScoped
public class adsManagedBean {

    
       @EJB
    private newsPotalSessionBeanLocal newsPotalSessionBean;
    
    

    
    int adsIDPK;
    String adstitle , adsDescription , adsDate , adsImage , adsStatus ;
    Part file;
    
    Ads ads = new Ads();

    public newsPotalSessionBeanLocal getNewsPortalSessionBean() {
        return newsPotalSessionBean;
    }

    public void setNewsPortalSessionBean(newsPotalSessionBeanLocal newsPortalSessionBean) {
        this.newsPotalSessionBean = newsPortalSessionBean;
    }

    public int getAdsIDPK() {
        return adsIDPK;
    }

    public void setAdsIDPK(int adsIDPK) {
        this.adsIDPK = adsIDPK;
    }

    public String getAdstitle() {
        return adstitle;
    }

    public void setAdstitle(String adstitle) {
        this.adstitle = adstitle;
    }

    public String getAdsDescription() {
        return adsDescription;
    }

    public void setAdsDescription(String adsDescription) {
        this.adsDescription = adsDescription;
    }

    public String getAdsDate() {
        return adsDate;
    }

    public void setAdsDate(String adsDate) {
        this.adsDate = adsDate;
    }

    public String getAdsImage() {
        return adsImage;
    }

    public void setAdsImage(String adsImage) {
        this.adsImage = adsImage;
    }

    public String getAdsStatus() {
        return adsStatus;
    }

    public void setAdsStatus(String adsStatus) {
        this.adsStatus = adsStatus;
    }


    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }

    public Ads getAds() {
        return ads;
    }

    public void setAds(Ads ads) {
        this.ads = ads;
    }
    
    public adsManagedBean() {
    }
    
    public List<Ads> showall() {
        try {
            return newsPotalSessionBean.showall_Ads();
        } catch (Exception e) {
            return null;
        }
    }
    
    public String insert_click()
    {
        try {
            
                SimpleDateFormat simpleformat = new SimpleDateFormat("MM/dd/yyyy");
              String currentDate = simpleformat.format(new Date());
              Date today = simpleformat.parse(currentDate);
            
            
                InputStream input = file.getInputStream();
                String path = "F:\\project_sem8\\newsportal\\newsPortal\\newsPortal-war\\web\\upload\\adsImage\\";
                Random random = new Random();
                StringBuilder sb = new StringBuilder();
                
                sb.append(random.nextInt(9) + 1);
                for (int i = 0; i < 11; i++) {
                    sb.append(random.nextInt(10));
                }
                
                String temp = sb.toString();
                
                adsImage = "IMG_"+ temp + file.getSubmittedFileName();
                Files.copy(input, new File(path, adsImage).toPath());
            
                ads.setAdsIDPK(0);
                ads.setAdsTitle(adstitle);
                ads.setAdsDescription(adsDescription);
                ads.setAdsDate(currentDate);
                ads.setAdsImage(adsImage);
                ads.setAdsStatus("1");
                ads.setIsActive(true);
                newsPotalSessionBean.insertAds(ads);
                 clear();
                 return "/Admin/displayAdvertisement.xhtml?faces-redirect=true";
                
        } catch (Exception e) {
           return e.getMessage();
        }
    }
    
    public String update_click()
    {
        try {
            
            if(file != null) {
        
                InputStream input = file.getInputStream();
                String path = "F:\\project_sem8\\newsportal\\newsPortal\\newsPortal-war\\web\\upload\\adsImage\\";
                Random random = new Random();
                StringBuilder sb = new StringBuilder();

                sb.append(random.nextInt(9) + 1);
                for (int i = 0; i < 11; i++) {
                    sb.append(random.nextInt(10));
                }
                String temp = sb.toString();

                adsImage = "IMG_"+ temp + file.getSubmittedFileName();
                Files.copy(input, new File(path, adsImage).toPath());

            }
               
                ads.setAdsIDPK(adsIDPK);
                ads.setAdsTitle(adstitle);
                ads.setAdsDescription(adsDescription);
                ads.setAdsDate(adsDate);
                ads.setAdsImage(adsImage);
                ads.setAdsStatus("1");
                newsPotalSessionBean.updateAds(ads);
                 clear();
                 return "/Admin/displayAdvertisement.xhtml?faces-redirect=true";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    public String delete_click(int adsIDPK)
    {
        try {
            newsPotalSessionBean.deleteAds(adsIDPK);
            return "/Admin/displayAdvertisement.xhtml?faces-redirect=true";
        } catch (Exception e) {
            return  e.getMessage();
        }
    }
    
    public String search_click(int id)
    {
        try {
            ads = newsPotalSessionBean.searchAds(id);
            adsIDPK = ads.getAdsIDPK();
            adstitle = ads.getAdsTitle();
            adsDescription = ads.getAdsDescription();
            adsDate = ads.getAdsDate();
            adsImage = ads.getAdsImage();
            adsStatus = ads.getAdsStatus();
            return "/Admin/insertAdvertisement.xhtml?faces-redirect=true";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    public void clear(){
        adsIDPK = 0;
        adstitle = "";
        adsDescription = "";
        adsDate = "";
        adsImage = "";
        adsStatus = "";
    }
    
    
}
