package highcloud.IP001_PROJECT.service;

import highcloud.IP001_PROJECT.domain.Product;
import highcloud.IP001_PROJECT.mapper.productMapper;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private productMapper mapper;
    public ProductService(productMapper mapper){
        this.mapper = mapper;
    }

    public boolean show(String find, Model model){
        List<Product> list =  mapper.getProduct(find);
        System.out.println(list);
        model.addAttribute("products", list);
        if(list.isEmpty()) return false;
        return true;
    }

    public boolean find(String title, Model model){
        Product product = mapper.find(title);
        System.out.println(product.getID());
        model.addAttribute("cur", product);

        String[] splitStr = product.getTRACK().split(",");

        model.addAttribute("track", splitStr);
        int i=0;
        for(String a : splitStr){
            System.out.println(i++);
            System.out.println(a);
        }

        return true;
    }
}
