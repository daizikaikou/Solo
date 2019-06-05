import com.github.pagehelper.PageInfo;
import com.zgw.blog.entity.Article;
import com.zgw.blog.entity.Comment;
import com.zgw.blog.service.ArticleService;
import com.zgw.blog.service.CommentService;
import com.zgw.blog.util.Functions;
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
public class CommentTest {
    @Autowired
    private CommentService commentService;

    @Autowired
    private ArticleService articleService;

    @Test
    public void testCommentList(){
        Integer pageIndex = 0;
        Integer pageSize = 30;
        PageInfo<Comment> commentPageInfo = commentService.listCommentByPage(pageIndex, pageSize);
        System.out.println( commentPageInfo.getSize());
        for (int i = 0; i <commentPageInfo.getSize() ; i++) {
            System.out.println(commentPageInfo.getList().get(i).getCommentContent());

        }

    }

    @Test
    public void testCommentInsert(){
        Comment comment = new Comment();
        comment.setCommentContent("测试一次增加");
        comment.setCommentCreateTime(new Date());
        commentService.insertComment(comment);
        Article article = articleService.getArticleByStatusAndId(null, comment.getCommentArticleId());
        articleService.updateCommentCount(article.getArticleId());
    }

    @Test
    public void testCommentDelete(){
        Integer id = 2;
        commentService.deleteComment(id);
        List<Comment> childCommentList = commentService.listChildComment(id);
        for (int i = 0; i < childCommentList.size(); i++) {
            commentService.deleteComment(childCommentList.get(i).getCommentId());
        }
    }

    @Test
    public void testCommentEdit(){
        Comment comment = commentService.getCommentById(29);
        comment.setCommentPname("zhaoguowei");

        commentService.updateComment(comment);
    }


}
