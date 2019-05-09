
package com.restowa.domain.repository;

import com.restowa.domain.model.Promotion;
import com.restowa.domain.model.Store;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PromotionRepository extends JpaRepository<Promotion, Integer> {
   
<<<<<<< Updated upstream
    public List<Promotion> getAllPromotions();

    public void delete(Promotion promotion);
    
=======
    //List<Promotion> getAllPromotions();
>>>>>>> Stashed changes
    
}