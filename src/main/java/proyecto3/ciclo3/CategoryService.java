/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto3.ciclo3;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author kika
 */
@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    
    public List<Category> getAll(){
        return categoryRepository.getAll();
        
    }
    public Optional<Category> getCategory(int Categoryid){
        return categoryRepository.getCategory(Categoryid);
    
    }
    public Category save(Category category){
        if(category.getId()==null){
            return categoryRepository.save(category);  
        }else{
            Optional<Category> paux=categoryRepository.getCategory(category.getId());
            if(paux.isEmpty()){
                return categoryRepository.save(category);
                
            }else{
                return category;
            
            }
        }
    
    }
    public Category update(Category category){
        if(category.getId()!=null){
            Optional<Category>g=categoryRepository.getCategory(category.getId());
            if(!g.isEmpty()){
                if(category.getDescription()!=null){
                    g.get().setDescription(category.getDescription());
                }
                if(category.getName()!=null){
                    g.get().setName(category.getName());
                }
                return categoryRepository.save(g.get());
            }
        }
        return category;
        
    }
    public boolean deletecategory(int categoryId){
        Boolean dBoolean=getCategory(categoryId).map(category -> {
            categoryRepository.delete(category);
            return true;
        }).orElse(false);
        return dBoolean;
    }
    
    
}

