package com.wlc.controller;

import com.wlc.pojo.Product;
import com.wlc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
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
@RefreshScope //配置文件自动刷新
public class ProductController {
    @Value("${version}")
    String version;

    @Autowired
    ProductService productService;

    @RequestMapping("/products")
    public Object products(Model model){
        List<Product> productList = productService.listProducts();
        model.addAttribute("ps",productList);
        model.addAttribute("version",version);
        return "products";
    }
}
