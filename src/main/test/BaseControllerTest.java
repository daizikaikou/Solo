import com.zgw.blog.dto.ArticleParam;
import com.zgw.blog.entity.Article;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * Created by Zhaogw&Lss on 2019/4/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)

@WebAppConfiguration
@ContextConfiguration(locations = {"classpath*:spring/spring-mybatis.xml",
        "classpath*:spring/spring-mvc.xml"})

public class BaseControllerTest extends AbstractJUnit4SpringContextTests {
    @Resource
    protected WebApplicationContext wac;

    protected MockMvc mockMvc;

    @Before
    public void beforeTest() {
        mockMvc = MockMvcBuilders.webAppContextSetup( wac ).build();
    }
    @Test
    public void editArticleSubmit() throws Exception {

        /*articleService.updateArticleDetail(map);*/
    }
}
