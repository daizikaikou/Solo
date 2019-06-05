import com.zgw.blog.entity.Tag;
import com.zgw.blog.service.TagService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;
import java.util.logging.Logger;

/**
 * Created by Zhaogw&Lss on 2019/4/19.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring的配置文件,需要用到的配置文件，如果是dao的话可以不用spring-service.xml
@ContextConfiguration({ "classpath:spring/spring-mybatis.xml",
        "classpath:spring/spring-service.xml","classpath:spring/spring-mvc.xml" })
@WebAppConfiguration
public class TagControllerTest {
    @Autowired
    private TagService tagService;

    @Test
    public void testTagList() {
        List<Tag> tagList = tagService.listTagWithCount();
        for (int i = 0; i <tagList.size() ; i++) {
       Integer id =  tagList.get(i).getTagId();
       String name = tagList.get(i).getTagName();
       String desc = tagList.get(i).getTagDescription();
            System.out.println("标签id为："+id+"====标签名为"+name+"====标签描述为："+desc);

        }
    }
    @Test
    public void testTagInsert(){
        Tag tag = new Tag();
        tag.setTagDescription("测试标签增加1");
        tag.setTagName("测试标签增加1");
        tagService.insertTag(tag);

    }
    @Test
    public void testTagUpdate(){
       Tag tag =  tagService.getTagById(42);
        tag.setTagName("测试更新标签");
        tag.setTagDescription("测试更新标签");
        tagService.updateTag(tag);
    }
    @Test
    public void testTagGet(){
        Integer id = 43;
        Tag tag = tagService.getTagById(id);
        System.out.println(tag.getTagName());
    }

}
