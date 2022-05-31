package highcloud.IP001_PROJECT.controller;

import highcloud.IP001_PROJECT.mapper.productMapper;
import highcloud.IP001_PROJECT.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class productController {

    private ProductService productService;

    public productController(ProductService ps){
        productService = ps;
    }

    @GetMapping("/shop")
    public String getProduct(HttpServletRequest req, HttpServletResponse resp, Model model) throws IOException {
        String find =  req.getParameter("find");
        boolean is =  productService.show(find,model);

        if(!is){
            resp.getWriter().print("<script>alert(\"There' s no search result\");</script>");
            resp.getWriter().print("<script>location.href='/shop';</script>");
        }
        return "shop";
    }

    @GetMapping("/detail")
    public String getDetail(HttpServletRequest req, Model model){
        String title = req.getParameter("title");
        System.out.println(title);
        productService.find(title, model);
        return "detail";
    }
}
