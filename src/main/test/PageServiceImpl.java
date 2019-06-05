import com.zgw.blog.entity.Page;
import com.zgw.blog.enums.PageStatus;
import com.zgw.blog.service.PageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Date;
import java.util.List;

/**
 * Created by Zhaogw&Lss on 2019/4/19.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring的配置文件,需要用到的配置文件，如果是dao的话可以不用spring-service.xml
@ContextConfiguration({ "classpath:spring/spring-mybatis.xml",
        "classpath:spring/spring-service.xml","classpath:spring/spring-mvc.xml" })
@WebAppConfiguration
public class PageServiceImpl {
    @Autowired
    private PageService pageService;
    /**
     * 测试查询页面集合
     */
    @Test
    public void testPageList() {
        List<Page> pageList = pageService.listPage(null);
        for (int i = 0; i <pageList.size() ; i++) {
           Integer id =  pageList.get(i).getPageId();
           Integer status = pageList.get(i).getPageStatus();
           Date createTime = pageList.get(i).getPageCreateTime();
           String title = pageList.get(i).getPageTitle();
           Date updateTime =  pageList.get(i).getPageUpdateTime();
           Integer viewCount = pageList.get(i).getPageViewCount();
           String content = pageList.get(i).getPageContent();
           System.out.println("===页面id为:"+id+"===状态为:"+status+"===创建时间为"+createTime+"===标题为:"+title+"===更新时间为:"+updateTime+"===查阅数为:"+viewCount+"===内容为"+content);
        }

    }

    /**
     * 测试新增页面
     */
    @Test
    public void testPageInsert() {

        Page page = new Page();
        page.setPageKey("测试一");
        page.setPageTitle("测试");
        page.setPageContent("test");
        page.setPageCreateTime(new Date());
        page.setPageUpdateTime(new Date());
        page.setPageStatus(PageStatus.NORMAL.getValue());
        pageService.insertPage(page);
    }

    /**
     * 测试删除页面
     */
    @Test
    public void testPageDelete(){
        pageService.deletePage(8);
    }
    /**
     * 测试修改页面信息
     */
    @Test
    public void testPageEdit(){
    Page page = pageService.getPageById(7);
    page.setPageTitle("测试是否能修改");
    page.setPageContent("测试是否能修改");
    pageService.updatePage(page);
    }
}
