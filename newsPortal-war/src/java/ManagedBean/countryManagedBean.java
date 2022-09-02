/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package ManagedBean;

import Entity.Country;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import sessionBean.newsPotalSessionBeanLocal;

/**
 *
 * @author maafia_fury
 */
@Named(value = "countryBean")
@ApplicationScoped
public class countryManagedBean {

    @EJB
    private newsPotalSessionBeanLocal newsPotalSessionBean;

    
    int countryIDPK;
    String countryName;
    
    
    
    
    

    public newsPotalSessionBeanLocal getNewsPotalSessionBean() {
        return newsPotalSessionBean;
    }

    public void setNewsPotalSessionBean(newsPotalSessionBeanLocal newsPotalSessionBean) {
        this.newsPotalSessionBean = newsPotalSessionBean;
    }

    public int getCountryIDPK() {
        return countryIDPK;
    }

    public void setCountryIDPK(int countryIDPK) {
        this.countryIDPK = countryIDPK;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
    
    
    
    /**
     * Creates a new instance of countryManagedBean
     */
    
    
    
    
    public countryManagedBean() {
        
    }
    
    Country country= new Country(); 
    
    public void insert_click() {
        try {
            country.setCountryIDPK(0);
            country.setCountryName(countryName);
            
            newsPotalSessionBean.insertCountry(country);
        } catch (Exception e) {
            e.getMessage();
        }
    }
    
    
     public void delete_click(int id) {
        try {
            newsPotalSessionBean.deleteCountry(id);
        } catch (Exception e) {
            e.getMessage();
        }
    }
     
      public void updateCountry_click()
    {
        try {
            country.setCountryIDPK(countryIDPK);
            country.setCountryName(countryName);
        } catch (Exception e) {
            e.getMessage();
        }
    }
      
      
      public void search_click(int id) {
        try {
            country = newsPotalSessionBean.searchCountry(id);
            countryIDPK = country.getCountryIDPK();
            countryName = country.getCountryName();
        } catch (Exception e) {
            e.getMessage();
        }
    }
     
     public List<Country> showall() {
        return newsPotalSessionBean.showall_Country();
    }
     
       
    public void clear(){
        countryIDPK = 0;
        countryName = "";
        
    }
    
    
}
