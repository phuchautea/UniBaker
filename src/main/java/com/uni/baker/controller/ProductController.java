package com.uni.baker.controller;

import com.uni.baker.entity.Category;
import com.uni.baker.entity.Product;
import com.uni.baker.service.CategoryService;
import com.uni.baker.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/products")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;
    @GetMapping
    public String showAllProducts(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "admin/product/list";
    }
    @GetMapping("/add")
    public String addProductForm(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("categories", categoryService.getAllCategories());
        return "admin/product/add";
    }
    @PostMapping("/add")
    public String addProduct(@ModelAttribute("product") Product product, BindingResult result, Model model) {
        if(result.hasErrors()){
            model.addAttribute("product", product);
            return "admin/product/add";
        }
        productService.addProduct(product);
        return "redirect:/admin/products";
    }

    @GetMapping("/edit/{id}")
    public String editProductForm(@PathVariable("id") Long id, Model model) {
        Product editProduct = productService.getProductById(id);
        model.addAttribute("categories", categoryService.getAllCategories());
        if(editProduct != null) {
            model.addAttribute("product", editProduct);
            return "admin/product/edit";
        }else{
            return "not-found";
        }
    }

    @PostMapping("/edit")
    public String editProduct(@ModelAttribute("product") Product updatedProduct, @RequestParam Long category) {
        productService.updateProduct(updatedProduct, category);
        return "redirect:/admin/products";
    }

    @GetMapping("/delete/{id}")
    public String deleteProductForm(@PathVariable("id") Long id, Model model) {
        productService.deleteCProduct(id);
        return "redirect:/admin/products";
    }
}
