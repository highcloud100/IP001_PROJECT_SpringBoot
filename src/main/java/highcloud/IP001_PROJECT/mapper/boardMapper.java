package highcloud.IP001_PROJECT.mapper;

import highcloud.IP001_PROJECT.domain.answer;
import highcloud.IP001_PROJECT.domain.question;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface boardMapper {
    @Select("select * from question  order by date desc") // 글 최신글이 위로 올라오게
    public List<question> getQuesions();

    @Select("select * from question where id=${id}")
    public question getQuestion(@Param("id") int id);

    @Insert("insert into question values(NULL,'${head}','${body}',default,'${who}')")
    public int putQuestion(@Param("head") String head, @Param("body") String body, @Param("who") String who);

    @Select("select * from answer where question=${qid}")
    public List<answer> getAnswers(@Param("qid") int qid);

    @Select("select * from answer where id=${qid}")
    public answer getAnswer(@Param("qid") int qid);

    @Insert("insert into answer values(NULL,${qid},'${body}',default,'${who}')")
    public int putAnswer(@Param("qid") int qid, @Param("body") String body, @Param("who") String who);

    @Delete("delete from answer where id=${id}")
    public int delAnswer(@Param("id") int aid);

    @Delete("delete from answer where question=${qid};")
    public int delAnswers(@Param("qid") int qid);

    @Delete("delete from question where id=${qid};")
    public int delQuestion(@Param("qid") int qid);
}
