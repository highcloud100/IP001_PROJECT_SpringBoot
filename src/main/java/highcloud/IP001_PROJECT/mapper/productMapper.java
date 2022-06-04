package highcloud.IP001_PROJECT.mapper;

import highcloud.IP001_PROJECT.domain.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface productMapper {
    @Select("select * from product where TITLE LIKE  '%${find}%'")
    public List<Product> getProducts(@Param("find") String find);

    @Select("select * from product where TITLE='${title}'")
    public Product find(@Param("title") String title);

    @Select("select * from product where ID=${id}")
    public Product findId(@Param("id") int id);

    @Insert("Insert into product values(NULL, '${title}',${price},'${track}','${info}','${img}' )")
    public int putLp(@Param("title") String title,@Param("price") double price, @Param("track") String track, @Param("info") String info, @Param("img") String img);

    @Delete("delete from product where ID=${id};")
    public int delLp(@Param("id")int id);
}
