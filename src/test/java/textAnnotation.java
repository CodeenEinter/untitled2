import dao.userdao;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class textAnnotation {
    @Test
    public void text(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-Anno.xml");
        userdao userdao = context.getBean("userdao", userdao.class);
        userdao.insert();
        userdao.delete();
        userdao.update();
        userdao.select();
        context.close();
    }
}
