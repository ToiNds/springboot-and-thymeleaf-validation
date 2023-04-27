package com.toindph26899.springbootandthymeleaf.controller;

import com.toindph26899.springbootandthymeleaf.request.ProductRequest;
import com.toindph26899.springbootandthymeleaf.response.CategoryResponse;
import com.toindph26899.springbootandthymeleaf.response.CompanyResponse;
import com.toindph26899.springbootandthymeleaf.response.ProductResponse;
import com.toindph26899.springbootandthymeleaf.service.CategoryService;
import com.toindph26899.springbootandthymeleaf.service.CompanyService;
import com.toindph26899.springbootandthymeleaf.service.ProductService;
import com.toindph26899.springbootandthymeleaf.service.StatusService;
import com.toindph26899.springbootandthymeleaf.service.impl.ProductServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;
    private CategoryService categoryService;
    private CompanyService companyService;
    private StatusService statusService;

    @Autowired
    public ProductController(ProductService productService, CategoryService categoryService,
                             CompanyService companyService, StatusService statusService) {
        this.productService = productService;
        this.categoryService = categoryService;
        this.companyService = companyService;
        this.statusService = statusService;
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        // neu chuoi equal("") --> null
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/list")
    public String findAll(Model model) {

        List<ProductResponse> findAllProduct = productService.findAll();


        model.addAttribute("products", findAllProduct);


        return "product/product-list";
    }

    @GetMapping("/form-add")
    public String showFormAdd(Model model) {

        ProductRequest productRequest = null;

        // kiem tra xem productRequest co trong model hay chua --> neu chua se khoi tao 1
        // productRequest va them no vao model
        if (!model.containsAttribute("productRequest")) {
            productRequest = new ProductRequest();
            model.addAttribute("productRequest", productRequest);
        }

        List<CategoryResponse> findAllCategory = categoryService.findAll();
        List<CompanyResponse> findAllCompany = companyService.findAll();

        model.addAttribute("categorys", findAllCategory);
        model.addAttribute("companys", findAllCompany);

        return "product/form-save";
    }

    @PostMapping("/save")
    public String addProduct(@Valid @ModelAttribute("productRequest") ProductRequest productRequest,
                             BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        // RedirectAttributes la 1 interface ke thua tu model --> cung cap cac thuoc tinh chuyen huong
        // `redirect` --> huu ich trong viec truyen du lieu hoac thong diep sang view ma khong con su dung session

        // Flash attributes la 1 tinh nang cua `RedirectAttributes` cho phep luu tru cac thuoc tinh tam
        // thoi giua cac request.
        // Flash attributes duoc luu trong session va tu dong xoa sau 1 luot chuyen huong
        // co nghia la no chi ton tai trong request tiep theo va sau do no se bi xoa
        productService.isCheckPrice(productRequest.getSellPrice(), productRequest.getOriginPrice(), bindingResult);

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute
                    ("org.springframework.validation.BindingResult.productRequest", bindingResult);
            // truyen loi ma doi tuong minh dang validation sang view
            redirectAttributes.addFlashAttribute("productRequest", productRequest);
            // truyen doi tuong da nhap vao form ben view
            return "redirect:/products/form-add";
        } else {
            productService.save(productRequest);
            return "redirect:/products/list";
        }
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("productId") Long productId) {
        productService.delete(productId);
        return "redirect:/products/list";
    }

    @GetMapping("/form-update")
    public String viewUpdate(Model model, @RequestParam("productId") Long productId) {

        ProductRequest productRequest = null;

        // kiem tra xem productRequest co trong model hay chua --> neu chua se khoi tao 1
        // productRequest va them no vao model
        if (!model.containsAttribute("productRequest")) {
            productRequest = productService.findById(productId);
            model.addAttribute("productRequest", productRequest);
        }

        List<CategoryResponse> findAllCategory = categoryService.findAll();
        List<CompanyResponse> findAllCompany = companyService.findAll();

        System.out.println("List Category 1: " + findAllCategory);
        System.out.println("List Company 1: " + findAllCompany);

        model.addAttribute("categorys", findAllCategory);
        model.addAttribute("companys", findAllCompany);

        return "product/form-save";
    }

}
