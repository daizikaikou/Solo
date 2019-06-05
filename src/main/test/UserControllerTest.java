import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zgw.blog.entity.User;
import com.zgw.blog.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Date;
import java.util.List;

/**
 * Created by Zhaogw&Lss on 2019/4/23.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring的配置文件,需要用到的配置文件，如果是dao的话可以不用spring-service.xml
@ContextConfiguration({ "classpath:spring/spring-mybatis.xml",
        "classpath:spring/spring-service.xml","classpath:spring/spring-mvc.xml" })
@WebAppConfiguration
@Slf4j
public class UserControllerTest {
    @Autowired
    private UserService userService;

    @Test
    public void testUserList(){
        List<User> userList = userService.listUser();
        for (int i = 0; i < userList.size(); i++) {
          String username = userList.get(i).getUserName();
          Integer status= userList.get(i).getUserStatus();
          System.out.println("用户名为"+username+"状态为"+status);
            
        }

    }


    @Test
    public void testUserInsert(){
        User user = new User();
        user.setUserName("zgw");
        user.setUserNickname("zgw");
        user.setUserEmail("zgw@123.com");
        user.setUserPass("zgw");
        user.setUserRegisterTime(new Date());
        user.setUserUrl("http://zhaoguowei.cn");
        userService.insertUser(user);
    }

    @Test
    public void testGetUser(){
        User user = userService.getUserByEmail("zgw@123.com");
        Object jsonObject= JSONObject.toJSON(user);
        System.out.println(jsonObject.toString());


        User user1 = userService.getUserById(4);
        Object jsonObject1= JSONObject.toJSON(user1);
        System.out.println(jsonObject1.toString());


    }


    @Test
    public void testEditUser(){
        User user = userService.getUserByEmail("zgw@123.com");
        user.setUserNickname("test");
        userService.updateUser(user);

    }
}
