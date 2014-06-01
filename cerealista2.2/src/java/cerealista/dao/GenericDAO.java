/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cerealista.dao;

import hibernate.HibernateUtil;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Eder
 */
public abstract class GenericDAO {

    public GenericDAO(){

    }
    protected Session getSession(){
        return HibernateUtil.getInstace().getSession();
    }
    protected void saveOrUpdatePojo(Serializable pojo){
        Session ses = getSession();
        ses.saveOrUpdate(pojo);
        ses.getTransaction().commit();
        ses.close();
    }
    protected <T extends Serializable> T getPojo(Class classToSearch, Serializable key){
        Session ses = getSession();
        Object toReturn = (Object) ses.get(classToSearch, key);
        ses.getTransaction().commit();
        ses.close();
        return (T) toReturn;
    }
   
    protected void removePojo(Serializable pojo){
        Session ses = getSession();
        ses.delete(pojo);
        ses.getTransaction().commit();
        ses.close();
    }
    
    protected <T extends Serializable> List<T> getPureList(Class<T> classtoCast, String query,Object... params){
        Session ses = getSession();
        Query qr = ses.createQuery(query);
        for(int i = 1; i <= params.length; i++){
            qr.setParameter(i, params[i-1]);
        }
        List<T> toReturn = qr.list();
        ses.getTransaction().commit();
        ses.close();

        return toReturn;
    }
    
   

}
