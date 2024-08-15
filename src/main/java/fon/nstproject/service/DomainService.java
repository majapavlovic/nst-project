/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package fon.nstproject.service;

import java.util.List;

/**
 *
 * @author User
 */
public interface DomainService <T, ID>{
    T save(T t) throws Exception;
    T getById(ID id) throws Exception;
    T update(T t) throws Exception;
    void deleteById(ID id) throws Exception;  
    List<T> getAll();
}