package highcloud.IP001_PROJECT.repository;
import highcloud.IP001_PROJECT.domain.Product;
import highcloud.IP001_PROJECT.mapper.productMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository {
    private productMapper mapper;
    public ProductRepository(productMapper map){
        this.mapper = map;
    }

    public List<Product> getProducts(String find){
        return mapper.getProducts(find);
    }

    public Product getProduct(String title){
        return mapper.find(title);
    }
    public Product getProduct(int id){
        return mapper.findId(id);
    }

    public int putLp(Product product) {
        return mapper.putLp(product.getTITLE(), product.getPRICE(), product.getTRACK(), product.getINFO(), product.getIMG());
    }

    public int delLp(int id){
        return mapper.delLp(id);
    }
}
