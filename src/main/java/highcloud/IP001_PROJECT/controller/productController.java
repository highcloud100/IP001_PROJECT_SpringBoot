package highcloud.IP001_PROJECT.controller;

import highcloud.IP001_PROJECT.mapper.productMapper;
import highcloud.IP001_PROJECT.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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

    @GetMapping("/addCart")
    public String addProduct(HttpServletRequest req,HttpSession session){
        System.out.println(req.getParameter("title"));
        productService.addCart(req.getParameter("title"),session);
        //return "cart";
        return "redirect:"+req.getHeader("Referer");
    }

    @GetMapping("/cart")
    public String showCart(HttpSession session){
        return "cart";
    }

    @GetMapping("/drop") // cart에서 물건 빼기
    public String dropCart(HttpServletRequest req,HttpSession session){
        System.out.println(req.getParameter("del"));
        productService.dropCart(req.getParameter("del"), session);
        return "redirect:cart";
    }
}
