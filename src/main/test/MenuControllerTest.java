import com.zgw.blog.entity.Menu;
import com.zgw.blog.service.MenuService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

/**
 * Created by Zhaogw&Lss on 2019/4/24.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring的配置文件,需要用到的配置文件，如果是dao的话可以不用spring-service.xml
@ContextConfiguration({ "classpath:spring/spring-mybatis.xml",
        "classpath:spring/spring-service.xml","classpath:spring/spring-mvc.xml" })
@WebAppConfiguration
public class MenuControllerTest {
    @Autowired
    private MenuService menuService;

    @Test
    public void testMenuList(){
        List<Menu> menuList = menuService.listMenu();
        for (int i = 0; i <menuList.size() ; i++) {
            System.out.println(menuList.get(i).getMenuName());
            System.out.println(menuList.get(i).getMenuUrl());
        }
    }

    @Test
    public void testMenuInsert(){
        Menu menu = new Menu();
        menu.setMenuUrl("http://test.com");

    }
}
