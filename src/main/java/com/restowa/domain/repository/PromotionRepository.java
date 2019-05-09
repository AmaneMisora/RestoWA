
package com.restowa.domain.repository;

import com.restowa.domain.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PromotionRepository extends JpaRepository<Store, Integer> {
    

    
}