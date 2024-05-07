package main.java.com.example.giftshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.rail3.model.GiftM;
import com.example.rail3.repository.GiftR;

@Service
public class GiftS {
    @Autowired
    private GiftR giftR;

    public GiftM addGift(GiftM gift) {
        return giftR.save(gift);
    }

    public Page<GiftM> getAllGifts(Pageable pageable) {
        return giftR.findAll(pageable);
    }

    public GiftM getGiftById(Integer id) {
        return giftR.findById(id).orElse(null);
    }

    public GiftM updateGift(GiftM gift) {
        return giftR.save(gift);
    }

    public void deleteGiftById(Integer id) {
        giftR.deleteById(id);
    }

    public Page<GiftM> findBySomeCriteria(String username, Pageable pageable) {
        return giftR.findBySomeCriteria(username, pageable);
    }
}
