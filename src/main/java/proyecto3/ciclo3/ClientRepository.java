/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto3.ciclo3;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author kika
 */
@Repository
public class ClientRepository {
     @Autowired
    private ClientInterface clientCrud;
    
    public List<Client> getAll(){
       return (List<Client>)clientCrud.findAll();
    
    }
    public Optional<Client> getclient(int id){
        return clientCrud.findById(id);
    
    }
    public Client save (Client client){
        return clientCrud.save(client);
    
    }
    public void delete (Client client){
        clientCrud.delete(client);
        
    }
    
}
