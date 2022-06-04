package highcloud.IP001_PROJECT.service;

import highcloud.IP001_PROJECT.domain.Member;
import highcloud.IP001_PROJECT.domain.MemberInfo;
import highcloud.IP001_PROJECT.domain.Product;
import highcloud.IP001_PROJECT.repository.MemberRepository;
import highcloud.IP001_PROJECT.repository.ProductRepository;
import highcloud.IP001_PROJECT.repository.TransactionRepository;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class AdminService {

    private MemberRepository memberRepository;
    private TransactionRepository transactionRepository;
    private ProductRepository productRepository;

    public AdminService(MemberRepository memberRepository, TransactionRepository transactionRepository, ProductRepository productRepository) {
        this.memberRepository = memberRepository;
        this.transactionRepository = transactionRepository;
        this.productRepository = productRepository;
    }

    public boolean isAdmin(HttpSession session){
        Member who = (Member) session.getAttribute("member");
        if(who.getId().equals("bbs") && who.getPwd().equals("qwerasdf")){
            return true;
        }
        else return false;
    }

    public void setList(HttpSession session, Model model){
        List<MemberInfo> memberInfoList = memberRepository.getMemInfo();
        List<MemberInfo> notBuyList = memberRepository.getNotbuy();
        model.addAttribute("memberInfoList", memberInfoList);
        model.addAttribute("memberNotBuy", notBuyList);
    }

    public void deleteUser(String id){
        memberRepository.delete(id);
    }

    public void setLPList(Model model ){
        List<Product> LPList = productRepository.getProducts("");
        model.addAttribute("LPList", LPList);
    }

    public void addNewLp(Product product){
        product.setIMG(product.getTITLE()+".png");
        productRepository.putLp(product);
    }

    public void delLp(int id){
        productRepository.delLp(id) ;
    }
}
