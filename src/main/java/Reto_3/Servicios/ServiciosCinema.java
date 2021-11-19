/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto_3.Servicios;

import Reto_3.Modelo.Cinema;
import Reto_3.Repositorio.CinemaRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ragno
 */
@Service
public class ServiciosCinema {
    @Autowired
    private CinemaRepositorio metodosCrud;
    
    public List<Cinema> getAll(){
        return metodosCrud.getAll();
    }
    
    public Optional<Cinema> getCinema(int idCinema){
        return metodosCrud.getCinema(idCinema);
    }
    
    public Cinema save(Cinema cinema){
        if(cinema.getId()==null){
            return metodosCrud.save(cinema);
        }else{
            Optional<Cinema> evt=metodosCrud.getCinema(cinema.getId());
            if(evt.isEmpty()){
                return metodosCrud.save(cinema);
            }else{
                return cinema;
            }
        }
    }
    public Cinema update(Cinema cinema){
        if(cinema.getId()!=null){
            Optional<Cinema> e=metodosCrud.getCinema(cinema.getId());
            if(!e.isEmpty()){
                if(cinema.getName()!=null){
                    e.get().setName(cinema.getName());
                }
                if(cinema.getOwner()!=null){
                    e.get().setOwner(cinema.getOwner());
                }
                if(cinema.getCapacity()!=null){
                    e.get().setCapacity(cinema.getCapacity());
                }
                if(cinema.getDescription()!=null){
                    e.get().setDescription(cinema.getDescription());
                }
                if(cinema.getCategory()!=null){
                    e.get().setCategory(cinema.getCategory());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return cinema;
            }
        }else{
            return cinema;
        }
    }
     public boolean deleteCinema(int cinemaId) {
        Boolean aBoolean = getCinema(cinemaId).map(cinema -> {
            metodosCrud.delete(cinema);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
    
}