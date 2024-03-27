package pojo;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface studentMapper {
    @Delete("delete from student where id=#{id}")
    public student deleteStudent(int id);
    @Select("select * from student where id=#{id}")
    public student findStudent(int id);
}
