package com.wlc.controller;

import com.wlc.pojo.Product;
import com.wlc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * describe:
 *
 *
 *
 *                                     ********
 *                                   **        **
 *                                  *            *
 *                                 **            **
 *                                 **            **
 *                                  **          **
 *                                   **        **
 *                                     ********
 *                                       ****
 *                                       ****
 *         ****                          ****
 *      ******                           ****                                 ***
 *   ****************************************************************************
 *     *******                           ****                                 ***
 *         ****                          ****
 *                                        **
 *                                        **
 *
 *
 *              *****      **     *****     ** **       **     **   **
 *                **       **     **  *     ***         **     **** **
 *               **        **     *****     ****        **     **  ***
 *              ******     **     **        **  **      **     **   **
 *
 *               *******
 *                  *
 *              **********
 *                  *
 *                  *
 *            **************
 *
 *
 * @author 王立朝
 * @date 2019/10/16
 */
@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping("/products")
    public Object products(Model model){
        System.out.println("到达 feign");
        List<Product> productList = productService.listProducts();
        model.addAttribute("ps",productList);
        return "products";
    }
}
