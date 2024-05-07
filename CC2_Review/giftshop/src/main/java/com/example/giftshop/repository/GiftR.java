package main.java.com.example.giftshop.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.giftshop.model.GiftM;

@Repository
public interface GiftR extends JpaRepository<GiftM,Integer> {
    @Query("SELECT i FROM GiftM i WHERE i.username = ?1")
    Page<GiftM> findByUsername(String username, Pageable pageable);
    
}
