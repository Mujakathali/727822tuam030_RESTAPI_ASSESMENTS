package com.example.giftshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.example.giftshop.model.GiftModel;
import com.example.giftshop.repository.GiftRepository;

@Service
public class GiftService {

    @Autowired
    private GiftRepository giftRepository;

    public GiftModel createGift(@NonNull GiftModel gift) {
        return giftRepository.save(gift);
    }

    public List<GiftModel> getAllGifts() {
        return giftRepository.findAll();
    }

    public Optional<GiftModel> getGiftById(int id) {
        return giftRepository.findById(id);
    }

    public GiftModel updateGift(int id, GiftModel updatedGift) {
        return giftRepository.findById(id)
                .map(existingGift -> {
                    existingGift.setGiftname(updatedGift.getGiftname());
                    existingGift.setGiftcategory(updatedGift.getGiftcategory());
                    existingGift.setGiftprice(updatedGift.getGiftprice());
                    existingGift.setGiftDecription(updatedGift.getGiftDecription());
                    return giftRepository.save(existingGift);
                })
                .orElseThrow(() -> new RuntimeException("Gift not found with ID: " + id));
    }

    public void removeGift(int id) {
        giftRepository.deleteById(id);
    }
}
