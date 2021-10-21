/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto3.ciclo3;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author kika
 */
@RestController
@RequestMapping("/api/Room")
@CrossOrigin(origins = "*", methods={ RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class RoomWeb {
    @Autowired
    private RoomService roomService;
    
    @GetMapping("/all")
    public List<Room> getRooms(){
        return roomService.getAll();
        
    }
    @GetMapping("/{id}")
    public Optional<Room> getRoom(@PathVariable("id")int roomId){
        return roomService.getRoom(roomId);
          
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Room save(@RequestBody Room room){
        return roomService.save(room);
         
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Room update(@RequestBody Room room){
        return roomService.Update(room);
    
    } 
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete (@PathVariable("id")int roomId){
        return roomService.deleteRoom(roomId);
    
    }
    
}

