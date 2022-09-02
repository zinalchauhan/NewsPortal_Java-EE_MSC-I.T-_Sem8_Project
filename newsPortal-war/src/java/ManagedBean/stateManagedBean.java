/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package ManagedBean;

import Entity.Country;
import Entity.State;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import sessionBean.newsPotalSessionBeanLocal;
import java.util.List;

/**
 *
 * @author maafia_fury
 */
@Named(value = "stateBean")
@ApplicationScoped
public class stateManagedBean {

     @EJB
    private newsPotalSessionBeanLocal newsPotalSessionBean;
     
      int stateIDPK,countryIDFK;
    String stateName;
     List<Country> countryList; 
    State state = new State();

    public newsPotalSessionBeanLocal getNewsPotalSessionBean() {
        return newsPotalSessionBean;
    }

    public void setNewsPotalSessionBean(newsPotalSessionBeanLocal newsPotalSessionBean) {
        this.newsPotalSessionBean = newsPotalSessionBean;
    }

    public int getStateIDPK() {
        return stateIDPK;
    }

    public void setStateIDPK(int stateIDPK) {
        this.stateIDPK = stateIDPK;
    }

    public int getCountryIDFK() {
        return countryIDFK;
    }

    public void setCountryIDFK(int countryIDFK) {
        this.countryIDFK = countryIDFK;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public List<Country> getCountryList() {
        return countryList;
    }

    public void setCountryList(List<Country> countryList) {
        this.countryList = countryList;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
    
    
   public void init(){
       countryList = newsPotalSessionBean.showall_Country();
   }
    
    public List<State> show_stateList() {
        try {
            return newsPotalSessionBean.showall_State();
        } catch (Exception e) {
            return null;
        }
    }
    
    
    public void insert_click()
    {
        try {
            Country country = newsPotalSessionBean.searchCountry(countryIDFK);
            state.setStateIDPK(0);
            state.setStateName(stateName);
            state.setCountryIDFK(country);
            newsPotalSessionBean.insertState(state);
        } catch (Exception e) {
            e.getMessage();
        }
    }
    
    public void update_click()
    {
        try {
              Country country = newsPotalSessionBean.searchCountry(countryIDFK);
            state.setStateIDPK(stateIDPK);
            state.setStateName(stateName);
            state.setCountryIDFK(country);
             newsPotalSessionBean.updateState(state);
        } catch (Exception e) {
            e.getMessage();
        }
    }
    
    public void delete_click(int stateIDPK)
    {
        try {
            newsPotalSessionBean.deleteState(stateIDPK);
        } catch (Exception e) {
            e.getMessage();
        }
    }
    
    public void searchState_click(int id)
    {
        try {
            state = newsPotalSessionBean.searchState(id);
            stateIDPK = state.getStateIDPK();
            stateName = state.getStateName();
            countryIDFK = state.getCountryIDFK().getCountryIDPK();
        } catch (Exception e) {
            e.getMessage();
        }
    }
    
    public void clear(){
        stateIDPK = 0;
        stateName = "";
        countryIDFK = 0;
    }


    
    
    
    
    /**
     * Creates a new instance of stateManagedBean
     */
    public stateManagedBean() {
    }
    
}
