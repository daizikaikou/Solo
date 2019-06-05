import com.zgw.blog.entity.Options;
import com.zgw.blog.service.OptionsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by Zhaogw&Lss on 2019/4/26.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring的配置文件,需要用到的配置文件，如果是dao的话可以不用spring-service.xml
@ContextConfiguration({ "classpath:spring/spring-mybatis.xml",
        "classpath:spring/spring-service.xml","classpath:spring/spring-mvc.xml" })
@WebAppConfiguration
public class OptionsControllerTest {
    @Autowired
     private OptionsService optionsService;
    @Test
    public void OptionListTest(){
        Options option = optionsService.getOptions();
        System.out.println(option.getOptionAboutsiteAvatar()+"====网站信息为"+option.getOptionAboutsiteContent()+"====github账号"+ option.getOptionAboutsiteGithub()+"====qq信息"+option.getOptionAboutsiteQq()+"简介"+option.getOptionMetaDescrption());



    }


}
