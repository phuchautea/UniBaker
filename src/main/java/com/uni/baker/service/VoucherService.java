package com.uni.baker.service;


import com.uni.baker.entity.Voucher;
import com.uni.baker.repository.IVoucherRepository;
import com.uni.baker.utils.SlugUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoucherService {
    @Autowired
    private IVoucherRepository voucherRepository;

    public List<Voucher> getAllVouchers()
    {
        return voucherRepository.findAll();
    }
    public Voucher getVoucherById(Long id)
    {
        return voucherRepository.findById(id).orElse(null);
    }
    public Voucher save(Voucher voucher)
    {
        return voucherRepository.save(voucher);
    }

//    public void addVoucher(Voucher voucher)
//    {
//        String slug = SlugUtils.createSlug(voucher.getName());
//        voucher.setSlug(slug);
//        save(voucher);
//    }
    public void deleteVoucher(Long id)
    {
        voucherRepository.deleteById(id);
    }
    public void updateVoucher(Voucher voucher)
    {
        save(voucher);
    }
}

