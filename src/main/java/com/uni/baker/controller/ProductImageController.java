package com.uni.baker.controller;

import com.uni.baker.entity.ProductImage;
import com.uni.baker.service.ProductImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/product-Image")
public class ProductImageController {
        @Autowired
        private ProductImageService productImageService;

//        @Autowired
//        private ProductService productService;

        @GetMapping
        public String showAllBooks(Model model) {
            List<ProductImage> proImgs = productImageService.getAll();
            model.addAttribute("proImgs", proImgs);
            return "admin/productImage/list";
        }

//        @GetMapping("/add")
//        public String addBookForm(Model model) {
//            model.addAttribute("book", new Book());
//            model.addAttribute("categories", categoryService.getAllCategories());
//            return "book/add";
//        }

//        @PostMapping("/add")
//        public String addBook(@ModelAttribute("book") Book book) {
//            bookService.addBook(book);
//            return "redirect:/books";
//        }
//
        @GetMapping("/delete/{id}")
        public String deleteBook (@PathVariable("id") Long id) {
            ProductImage productImage = productImageService.getById(id);
            productImageService.delete(id);
            return "redirect:/product-Image";
        }
//
//        @GetMapping("/edit/{id}")
//        public String editBookForm (@PathVariable("id") Long id, Model model) {
//            Book editBook = bookService.getBookById(id);
//            Category cateid = bookService.getBookById(id).getCategory();
//            model.addAttribute("categories",categoryService.getAllCategories());
//            if (editBook != null) {
//                model.addAttribute("book", editBook);
//                return "book/edit";
//            } else {
//                return "not-found";
//            }
//        }
//
//        @PostMapping("/edit")
//        public String editBook (@ModelAttribute("book") Book book) {
//            bookService.updateBook(book);
//            return "redirect:/books";
//        }
//


}
