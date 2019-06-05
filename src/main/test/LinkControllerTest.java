import com.zgw.blog.entity.Link;
import com.zgw.blog.service.LinkService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Date;
import java.util.List;

/**
 * Created by Zhaogw&Lss on 2019/4/21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring的配置文件,需要用到的配置文件，如果是dao的话可以不用spring-service.xml
@ContextConfiguration({ "classpath:spring/spring-mybatis.xml",
        "classpath:spring/spring-service.xml","classpath:spring/spring-mvc.xml" })
@WebAppConfiguration
public class LinkControllerTest {
    @Autowired
    private LinkService linkService;


    /**
     * 测试链接集合
     */
    @Test
    public void testLinkList() {
        List<Link> linkList = linkService.listLink(null);
        for (int i = 0; i < linkList.size(); i++) {
           String name = linkList.get(i).getLinkName();
           String linkUrl = linkList.get(i).getLinkUrl();
           String desc = linkList.get(i).getLinkDescription();
           Integer order = linkList.get(i).getLinkOrder();
           Integer status =  linkList.get(i).getLinkStatus();
            System.out.println("链接名字为"+name+"====链接的地址为"+linkUrl+"====链接描述为"+desc+"====链接优先级为"+order+"====状态为"+status);

        }

    }

    /**
     * 测试插入链接
     */
    @Test
    public void testLinkInsert() {
        Link link = new Link();
        link.setLinkCreateTime(new Date());
        link.setLinkDescription("这是我的博客网站");
        link.setLinkName("个人博客");
        link.setLinkStatus(1);
        link.setLinkUrl("zhaoguowei.cn");
        link.setLinkOrder(1);
        linkService.insertLink(link);

    }


    /**
     * 测试编辑并提交链接
     */
    @Test
    public void testLinkEdit() {

        Link link = linkService.getLinkById(10);
        link.setLinkUpdateTime(new Date());
        link.setLinkDescription("博客网站");
        link.setLinkName("博客");
        link.setLinkStatus(1);
        link.setLinkUrl("zhaoguowei.com");
        link.setLinkOrder(1);
        linkService.updateLink(link);

    }

}
