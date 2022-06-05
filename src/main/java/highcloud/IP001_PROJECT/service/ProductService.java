package highcloud.IP001_PROJECT.service;

import highcloud.IP001_PROJECT.domain.Member;
import highcloud.IP001_PROJECT.domain.Product;
import highcloud.IP001_PROJECT.domain.Transaction;
import highcloud.IP001_PROJECT.mapper.productMapper;
import highcloud.IP001_PROJECT.repository.ProductRepository;
import highcloud.IP001_PROJECT.repository.TransactionRepository;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class ProductService {
    private ProductRepository repository;
    private TransactionRepository transactionRepository;
    public ProductService(ProductRepository repository, TransactionRepository transactionRepository){
        this.repository = repository;
        this.transactionRepository = transactionRepository;
    }

    public boolean show(String find, Model model){
        List<Product> list =  repository.getProducts(find);
        System.out.println(list);
        model.addAttribute("products", list);
        if(list.isEmpty()) return false;
        return true;
    }
    public void setTran(HttpSession session){
        Member member = (Member) session.getAttribute("member");
        List<Transaction> llist = transactionRepository.getTransaction(member.getId());
        session.setAttribute("trlist", llist);
    }
    public boolean find(String title, Model model){
        Product product = repository.getProduct(title);
        System.out.println(product.getTITLE());

        model.addAttribute("cur", product);

        String[] splitStr = product.getTRACK().split(",");
        model.addAttribute("track", splitStr);

        return true;
    }

    public void addCart(String title, HttpSession session){
        List<Product> cart = (List<Product>) session.getAttribute("cart");
        if(cart==null) cart = new ArrayList<>();

        Product p = repository.getProduct(title);
        if(p!=null){
            cart.add(p);
            session.setAttribute("cart", cart);
        }


    }

    public void dropCart(String title, HttpSession session){
        List<Product> cart = (List<Product>) session.getAttribute("cart");
        if(cart==null) return;

        Iterator it = cart.iterator();
        while(it.hasNext()){
            Product p = (Product) it.next();
            if(p.getTITLE().equals(title)){
                it.remove();
                break;
            }
        }

        session.setAttribute("cart", cart);

    }

    public Product getProduct(int id){
        return repository.getProduct(id);
    }

}
