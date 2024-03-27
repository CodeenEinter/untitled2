import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import pojo.empolyee;
import pojo.student;
import pojo.studentMapper;

import java.io.IOException;
import java.io.Reader;

public class employeeText {
    private final empolyee empolyees = new empolyee();

    private SqlSession globle(){
        Reader reader = null;
        String resourse = "mybaties-config.xml";
        try {
            reader = Resources.getResourceAsReader(resourse);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        return sessionFactory.openSession();
    }
    @Test
    public void employeeByid() {
        SqlSession session = globle();
        //根据id查询员工信息
        empolyee employee = session.selectOne("employeeByid", 2);
        System.out.println("名字：" + employee.getName() + " " + "年龄：" + employee.getAge() + "" + "岗位" + employee.getPosition());
        session.close();
    }

    @Test
    public void updateEmployee() {
        SqlSession session = globle();
        //根据id修改员工信息
        empolyees.setId(0);
        empolyees.setAge(40);
        empolyees.setPosition("产品经理");
        session.selectOne("updateEmployee", empolyees);
        session.close();
    }

    @Test
    public void deleteEmployee() {
        SqlSession session = globle();
        //根据id删除员工信息
        session.selectOne("deleteEmployee", 0);
        session.close();
    }

    @Test
    public void addEmployee() {
        SqlSession session = globle();
        empolyees.setName("梁祖富");
        empolyees.setAge(23);
        empolyees.setPosition("开发工程师");
        session.selectOne("addEmployee", empolyees);
        session.close();
    }
    //二级缓存
    @Test
    public void findbook(){
        SqlSession session = MyBatisUitles.getSession();
        SqlSession session1 = MyBatisUitles.getSession();
        System.out.println(session.selectOne("employeeByid", 1));
        session.close();
        System.out.println(session1.selectOne("employeeByid", 1));
        session1.close();
    }
    @Test
    public void findbook1(){
        SqlSession session = MyBatisUitles.getSession();
        System.out.println(session.selectOne("employeeByid", 1));
        System.out.println(session.selectOne("employeeByid", 1));
        session.close();
    }
    @Test
    public void findStudent(){
        SqlSession session = null;
        try {
            session = MyBatisUitles.getSession();
            student student = new student();
            student.setPosition("rjjishu");
            System.out.println(session.selectOne("findStudent",student));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();

        }
    }
    @Test
    public void deleteStudent(){
        SqlSession session = null;
        try {
            session = MyBatisUitles.getSession();
            studentMapper mapper = session.getMapper(studentMapper.class);
            System.out.println(mapper.deleteStudent(1));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.commit();
            session.close();
        }
    }
}
