/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto_3.Repositorio;

import Reto_3.Interface.InterfaceCinema;
import Reto_3.Modelo.Cinema;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ragno
 */
@Repository
public class CinemaRepositorio {
    @Autowired
    private InterfaceCinema crud;
    public List<Cinema> getAll(){
        return (List<Cinema>) crud.findAll();       
    }
    
    public Optional <Cinema> getCinema(int id){
        return crud.findById(id);
    }
    
    public Cinema save(Cinema cinema){
        return crud.save(cinema);
    }
     public void delete(Cinema cinema){
        crud.delete(cinema);
    }
    
}
