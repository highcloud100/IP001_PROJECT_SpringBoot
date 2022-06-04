package highcloud.IP001_PROJECT.service;

import highcloud.IP001_PROJECT.domain.Member;
import highcloud.IP001_PROJECT.domain.Product;
import highcloud.IP001_PROJECT.repository.ProductRepository;
import highcloud.IP001_PROJECT.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class TransactionService {
    private TransactionRepository repository;
    private ProductService productService;

    public TransactionService(TransactionRepository repository, ProductService productService){
        this.repository = repository;
        this.productService = productService;
    }

    public boolean putTran(HttpSession session, String addr, String list){
        if(list==null || list=="") return true;
        Member member = (Member) session.getAttribute("member");

        String[] cart = list.split(",");
        System.out.println("-----");

        for(String s : cart){
            System.out.println(s);
        }

        if(cart== null) return false;
        for(String s : cart){
            Product p = productService.getProduct(Integer.parseInt(s));
            productService.dropCart(p.getTITLE(), session);
            repository.putTran(member.getId(),Integer.parseInt(s),addr,p.getPRICE());
        }
        return true;
    }
}
