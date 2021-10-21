/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto3.ciclo3;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReservationRepository {
    @Autowired
    private ReservationInterface reservationCrud;
    
    public List<Reservation> getAll(){
       return (List<Reservation>) reservationCrud.findAll();
    
    }
    public Optional<Reservation> getReservation(int id){
        return reservationCrud.findById(id);
    
    }
    public Reservation save (Reservation reservation){
        return reservationCrud.save(reservation);
    
    }
    public void delete (Reservation reservation){
        reservationCrud.delete(reservation);
        
    
    }
    
}

