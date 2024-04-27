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
import com.example.giftshop.service.GiftService; 

import lombok.NonNull;

@RestController
@RequestMapping("/api/gifts")
public class GiftController {

    @Autowired
    private GiftService giftService; // Assuming the service name

    @PostMapping("/createGift") // Changed endpoint name
    public ResponseEntity<GiftModel> createGift(@NonNull @RequestBody GiftModel gift) {
        GiftModel createdGift = giftService.createGift(gift); // Assuming the method name
        return new ResponseEntity<>(createdGift, HttpStatus.CREATED);
    }

    @GetMapping("/readGift/{id}") 
    public ResponseEntity<?> getGiftById(@PathVariable int id) {
        Optional<GiftModel> gift = giftService.getGiftById(id); 
        return gift.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/readGifts") // Changed endpoint name
    public ResponseEntity<List<GiftModel>> getAllGifts() {
        List<GiftModel> gifts = giftService.getAllGifts(); // Assuming the method name
        return new ResponseEntity<>(gifts, HttpStatus.OK);
    }

    @PutMapping("/updateGift/{id}") // Changed endpoint name
    public ResponseEntity<GiftModel> updateGift(@NonNull @PathVariable int id, @RequestBody GiftModel updateRequest) {
        GiftModel updated = giftService.updateGift(id, updateRequest); // Assuming the method name
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @DeleteMapping("/deleteGift/{id}") // Changed endpoint name
    public ResponseEntity<Void> removeGift(@NonNull @PathVariable int id) {
        giftService.removeGift(id); // Assuming the method name
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
