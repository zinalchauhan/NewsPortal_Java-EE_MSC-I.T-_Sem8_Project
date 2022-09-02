/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package ManagedBean;

import Entity.City;
import Entity.State;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import javax.ejb.EJB;
import sessionBean.newsPotalSessionBeanLocal;

/**
 *
 * @author maafia_fury
 */
@Named(value = "cityBean")
@ApplicationScoped
public class cityManagedBean {
    
     @EJB
    private newsPotalSessionBeanLocal newsPotalSessionBean;
     
    
    int cityIDPK,stateIDFK;
    String cityName;
    List<State> stateList; 
    City city = new City();

    
    
    
    
    
    public newsPotalSessionBeanLocal getNewsPotalSessionBean() {
        return newsPotalSessionBean;
    }

    public void setNewsPotalSessionBean(newsPotalSessionBeanLocal newsPotalSessionBean) {
        this.newsPotalSessionBean = newsPotalSessionBean;
    }

    public int getCityIDPK() {
        return cityIDPK;
    }

    public void setCityIDPK(int cityIDPK) {
        this.cityIDPK = cityIDPK;
    }

    public int getStateIDFK() {
        return stateIDFK;
    }

    public void setStateIDFK(int stateIDFK) {
        this.stateIDFK = stateIDFK;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public List<State> getStateList() {
        return stateList;
    }

    public void setStateList(List<State> stateList) {
        this.stateList = stateList;
    }

    public City getCity() {
        return city;
    }

    /**
     * Creates a new instance of cityManagedBean
     */
    public void setCity(City city) {
        this.city = city;
    }
    
    
    public void init(){
       stateList = newsPotalSessionBean.showall_State();
   }
     
    public List<City> show_cityList() {
        try {
            return newsPotalSessionBean.showall_City();
        } catch (Exception e) {
            return null;
        }
    }
    
     public void insert_click()
    {
        try {
            State state = newsPotalSessionBean.searchState(stateIDFK);
            city.setCityIDPK(0);
            city.setCityName(cityName);
            city.setStateIDFK(state);
            newsPotalSessionBean.insertCity(city);
        } catch (Exception e) {
            e.getMessage();
        }
    }
     
     
      public void update_click()
    {
        try {
              State state = newsPotalSessionBean.searchState(stateIDFK);
            city.setCityIDPK(cityIDPK);
            city.setCityName(cityName);
            city.setStateIDFK(state);
            newsPotalSessionBean.updateCity(city);
        } catch (Exception e) {
            e.getMessage();
        }
    }
      
       public void delete_click(int cityIDPK)
    {
        try {
            newsPotalSessionBean.deleteCity(cityIDPK);
        } catch (Exception e) {
            e.getMessage();
        }
    }
       
        public void search_click(int id)
    {
        try {
            city = newsPotalSessionBean.searchCity(id);
            cityIDPK = city.getCityIDPK();
            cityName = city.getCityName();
            stateIDFK = city.getStateIDFK().getStateIDPK();
        } catch (Exception e) {
            e.getMessage();
        }
    }
        
        public void clear(){
        cityIDPK = 0;
        cityName = "";
        stateIDFK = 0;
    }
    

    public cityManagedBean() {
    }
    
}
