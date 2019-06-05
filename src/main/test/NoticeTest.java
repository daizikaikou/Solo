import com.zgw.blog.entity.Notice;
import com.zgw.blog.service.NoticeService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Date;
import java.util.List;

/**
 * Created by Zhaogw&Lss on 2019/4/22.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring的配置文件,需要用到的配置文件，如果是dao的话可以不用spring-service.xml
@ContextConfiguration({ "classpath:spring/spring-mybatis.xml",
        "classpath:spring/spring-service.xml","classpath:spring/spring-mvc.xml" })
@WebAppConfiguration
@Slf4j
public class NoticeTest {
    @Autowired
    private NoticeService noticeService;

    @Test
    public void testNoticeList(){
        List<Notice> noticeList = noticeService.listNotice(null);
        for (int i = 0; i < noticeList.size(); i++) {
           String title = noticeList.get(i).getNoticeTitle();
           String content = noticeList. get(i).getNoticeContent();
           Integer status = noticeList.get(i).getNoticeStatus();

            System.out.println("公告标题为:"+title+"公告内容为"+content+"公告状态为"+status);
        }

    }
    @Test
    public void testNoticeInsert(){
        Notice notice = new Notice();
        notice.setNoticeContent("测试");
        notice.setNoticeTitle("测试");
        notice.setNoticeCreateTime(new Date());
        notice.setNoticeUpdateTime(new Date());
        noticeService.insertNotice(notice);
    }

    @Test
    public void testNoticeDelete(){
        noticeService.deleteNotice(5);
    }

    @Test
    public void testNoticeEdit(){
        Notice notice = noticeService.getNoticeById(4);
        System.out.println("notice标题为："+notice.getNoticeTitle()+"===notice内容为："+notice.getNoticeContent());
        notice.setNoticeContent("测试");
        noticeService.updateNotice(notice);

    }


}
