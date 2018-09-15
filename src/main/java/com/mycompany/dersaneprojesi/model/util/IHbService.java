/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dersaneprojesi.model.util;

import java.util.List;

/**
 *
 * @author vektorel
 */
public interface IHbService<T> {
    
    public boolean kaydet(T t);
    public boolean duzenle(T t);
    public boolean sil(T t);
    public List<T> listele(T t);
    public T bul(int id,T t);
    public List<T> ara(String kolonadi,String aranan,T t);
    public List<T> ara(T t);
    
}
