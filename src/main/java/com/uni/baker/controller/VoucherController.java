package com.uni.baker.controller;


import com.uni.baker.entity.Voucher;
import com.uni.baker.service.VoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/vouchers")
public class VoucherController {
    @Autowired
    private VoucherService voucherService;
    @GetMapping
    public String showAllvouchers(Model model) {
        List<Voucher> categories = voucherService.getAllVouchers();
        model.addAttribute("vouchers", categories);
        return "admin/voucher/list";
    }
//    @GetMapping("/add")
//    public String addCategoryForm(Model model) {
//        model.addAttribute("voucher", new Voucher());
//        model.addAttribute("vouchers", voucherService.getAllVouchers());
//        return "admin/voucher/add";
//    }
//    @PostMapping("/add")
//    public String addVoucher(@ModelAttribute("voucher") Voucher voucher, BindingResult result, Model model) {
//        if(result.hasErrors()){
//            model.addAttribute("voucher", voucher);
//            return "admin/voucher/add";
//        }
//        voucherService.addVoucher(voucher);
//        return "redirect:/admin/vouchers";
//    }

    @GetMapping("/edit/{id}")
    public String editVoucherForm(@PathVariable("id") Long id, Model model) {
        Voucher editVoucher = voucherService.getVoucherById(id);
        model.addAttribute("vouchers", voucherService.getAllVouchers());
        if(editVoucher != null) {
            model.addAttribute("voucher", editVoucher);
            return "admin/voucher/edit";
        }else{
            return "not-found";
        }
    }

    @PostMapping("/edit")
    public String editCategory(@ModelAttribute("voucehr") Voucher updatedVoucher) {
        voucherService.updateVoucher(updatedVoucher);
        return "redirect:/admin/voucher";
    }

    @GetMapping("/delete/{id}")
    public String deleteVoucherForm(@PathVariable("id") Long id, Model model) {
        voucherService.deleteVoucher(id);
        return "redirect:/admin/vouchers";
    }
}
