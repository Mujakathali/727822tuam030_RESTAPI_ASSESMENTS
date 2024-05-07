package com.example.giftshop.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.giftshop.model.GiftModel;
import com.example.giftshop.model.GiftM;
import com.example.giftshop.service.GiftService;
import com.example.giftshop.service.GiftS;
import lombok.NonNull;

@RestController
@RequestMapping("/api/gifts")
public class GiftController {

    @Autowired
    private GiftService giftService; 

    @PostMapping("/createGift") 
    public ResponseEntity<GiftModel> createGift(@NonNull @RequestBody GiftModel gift) {
        GiftModel createdGift = giftService.createGift(gift); 
        return new ResponseEntity<>(createdGift, HttpStatus.CREATED);
    }

    @GetMapping("/readGift/{id}") 
    public ResponseEntity<?> getGiftById(@PathVariable int id) {
        Optional<GiftModel> gift = giftService.getGiftById(id); 
        return gift.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/readGifts") 
    public ResponseEntity<List<GiftModel>> getAllGifts() {
        List<GiftModel> gifts = giftService.getAllGifts();
        return new ResponseEntity<>(gifts, HttpStatus.OK);
    }

    @PutMapping("/updateGift/{id}") 
    public ResponseEntity<GiftModel> updateGift(@NonNull @PathVariable int id, @RequestBody GiftModel updateRequest) {
        GiftModel updated = giftService.updateGift(id, updateRequest); // Assuming the method name
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @DeleteMapping("/deleteGift/{id}") 
    public ResponseEntity<Void> removeGift(@NonNull @PathVariable int id) {
        giftService.removeGift(id); 
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


// Endpoint to get users by username with pagination
@GetMapping("/user/by-username")
public ResponseEntity<Page<GiftM>> findByUsername(@RequestParam String username, Pageable pageable) {
    Page<GiftM> users = GiftS.findByUsername(username, pageable);
    return ResponseEntity.ok(users);
}
@PostMapping("/user/{userId}/product")
public ResponseEntity<Product> addProductToGiftM(@PathVariable Integer userId, @RequestBody Product product) {
    GiftM Gm = GiftS.getGiftMById(userId);
    
    if (giftm != null) {
        product.setGiftM(giftm);
        Product addedProduct = productRepo.save(product); // Save product directly
        
        if (addedProduct != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(addedProduct);
        } 
        else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    } else {
        return ResponseEntity.notFound().build();
    }
}

}
