/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Reto_3.Interface;

import Reto_3.Modelo.Categoria;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author ragno
 */
public interface InterfaceCategoria extends CrudRepository<Categoria,Integer> {
    
}
