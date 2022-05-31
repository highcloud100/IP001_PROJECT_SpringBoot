package highcloud.IP001_PROJECT.mapper;

import highcloud.IP001_PROJECT.domain.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface productMapper {
    @Select("select * from product where TITLE LIKE  '%${find}%'")
    public List<Product> getProduct(@Param("find") String find);

    @Select("select * from product where TITLE='${title}'")
    public Product find(@Param("title") String title);
}
