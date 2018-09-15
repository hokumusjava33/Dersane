/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dersaneprojesi.model.util;

import java.lang.reflect.Field;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author vektorel
 */
public class DbServiceBase<T> implements IHbService<T> {
     Session ss;
    Transaction tt;
    
    public void ac(){
       ss = MyHbUtil.getSessionFactory().openSession();
       tt = ss.beginTransaction();
    }
    
    public void kapat(){
        tt.commit();
        ss.close();
    }
    
    @Override
    public boolean kaydet(T t) {
        try{
        ac();
        ss.save(t);
        kapat();
          return true;
        }catch(Exception ex){           
        return false;
        }
             
    }

    @Override
    public boolean duzenle(T t) {
        try{
        ac();
        ss.update(t);
        kapat();
         return true;
          }catch(Exception ex){         
        return false;
        }
    }

    @Override
    public boolean sil(T t) {
        try{
        ac();
        ss.delete(t);
        kapat();
        return true;
         }catch(Exception ex){         
        return false;
        }
    }

    @Override
    public List<T> listele(T t) {
       try{
       List<T> liste;
       ac();
       Criteria cr = ss.createCriteria(t.getClass());
       liste = cr.list();
       kapat();
       return liste;
        }catch(Exception ex){            
        return null;
        }
        
    }

    @Override
    public T bul(int id, T t) {
       try{
        T result=null;
       ac();
       Criteria cr = ss.createCriteria(t.getClass());
       cr.add(Restrictions.eq("id", id));
       if(cr.list().size()>0)
       result = (T) cr.list().get(0);
       kapat();
       return result; 
        }catch(Exception ex){           
        return null;
        }
    }

    @Override
    public List<T> ara(String kolonadi, String aranan, T t) {
       try{
        List<T> result;
       ac();
       Criteria cr = ss.createCriteria(t.getClass());
       cr.add(Restrictions.ilike(kolonadi, "%"+aranan+"%"));
       result = cr.list();
       kapat();
       return result;  
        }catch(Exception ex){           
        return null;
        }
    }

    @Override
    public List<T> ara(T t) {
       try{        List<T> listem=null;
        
        Class cl = t.getClass();
        Field[] fl = cl.getDeclaredFields();
       try{ 
        ac();
        Criteria cr = ss.createCriteria(t.getClass());
        for (int i = 0; i < fl.length; i++) {
            fl[i].setAccessible(true);
            if(fl[i].get(t)!=null && !fl[i].get(t).toString().equals("0") ){
               
                cr.add(Restrictions.ilike(fl[i].getName(), "%"+fl[i].get(t)+"%"));
                
            }
            }
        listem = cr.list();
        kapat();
       }catch(Exception ex){
           System.out.println("Hata.....: "+ex.toString());
       }
       
        return listem;
         }catch(Exception ex){           
        return null;
        }
    }
    
}
