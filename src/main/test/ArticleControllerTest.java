import com.github.pagehelper.PageInfo;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import com.zgw.blog.dto.ArticleParam;
import com.zgw.blog.entity.*;
import com.zgw.blog.mapper.ArticleCategoryRefMapper;
import com.zgw.blog.mapper.ArticleMapper;
import com.zgw.blog.mapper.ArticleTagRefMapper;
import com.zgw.blog.service.ArticleService;
import com.zgw.blog.service.CategoryService;
import com.zgw.blog.service.TagService;
import com.zgw.blog.util.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Zhaogw&Lss on 2019/4/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring的配置文件,需要用到的配置文件，如果是dao的话可以不用spring-service.xml
    @ContextConfiguration({ "classpath:spring/spring-mybatis.xml",
            "classpath:spring/spring-service.xml","classpath:spring/spring-mvc.xml" })
@WebAppConfiguration
    public class ArticleControllerTest {

        @Autowired
        private ArticleService articleService ;
        @Autowired
        private ArticleMapper articleMapper;
        @Autowired
        private CategoryService categoryService;

        @Autowired
        private TagService tagService;
        @Autowired
        private ArticleTagRefMapper articleTagRefMapper;
        @Autowired
        private ArticleCategoryRefMapper articleCategoryRefMapper;


        private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 查询article大小
     */
        @Test
        public void testArticleServiceList() {
            HashMap<String,Object> map = new HashMap<>();
            PageInfo<Article> articlePageInfo = articleService.pageArticle(1,100,null);
            System.out.println("articlePageInfo的大小为:"+articlePageInfo.getSize());
    }
    /**
     *查询文章编辑
     */
    @Test
    public void testeditArticleView(){
        /**
         * 查询文章详情页面
         */
        Article article = articleService.getArticleByStatusAndId(1, 1);
        System.out.println(article.getArticleContent().toString());
        System.out.println(article.getCategoryList());
        System.out.println(article.getTagList());

        /**
         *查询所有分类
         */
        List<Category> categoryList = categoryService.listCategory();
        for (int i = 0; i <categoryList.size() ; i++) {
            System.out.println(categoryList.get(i).getCategoryName());

        }
        System.out.println("==============================");
        /**
         * 查询所有标签
         */
        List<Tag> tagList = tagService.listTag();
        for (int i = 0; i <tagList.size() ; i++) {
            System.out.println(tagList.get(i).getTagName());
        }


    }

    /**
     * 编辑文章提交
     */
    @Test
    public void editArticleSubmit(){
        Article article = new Article();
        article.setArticleId(28);
        article.setArticleTitle("SpringCloud 中使用 Eureka 和 Feign 实现增删改查");
        article.setArticleContent("articleContent");
        List<Tag> tagList = new ArrayList<>();
        Tag tagList1 = new Tag();
        tagList1.setTagId(1);
        Tag tagList2 = new Tag();
        tagList2.setTagId(8);
        Tag tagList3 = new Tag();
        tagList3.setTagId(21);
        Tag tagList4 = new Tag();
        tagList4.setTagId(32);
        tagList.add(tagList1);
        tagList.add(tagList2);
        tagList.add(tagList3);
        tagList.add(tagList4);
        article.setTagList(tagList);
        /*articleService.updateArticleDetail(article);*/
        articleMapper.update(article);
        //删除标签和文章关联 select * from article_tag_ref       where  article_id=28
        articleTagRefMapper.deleteByArticleId(article.getArticleId());
        List<Tag> tagL = articleTagRefMapper.listTagByArticleId(28);
        System.out.println("删除标签和文章关联标签大小:"+tagL.size());
      //添加标签和文章关联
        for (int i = 0; i < article.getTagList().size(); i++) {
        ArticleTagRef articleTagRef = new ArticleTagRef(article.getArticleId(),article.getTagList().get(i).getTagId());
        articleTagRefMapper.insert(articleTagRef);
        }
        System.out.println("添加文章编号28关联的标签后大小:"+article.getTagList().size());


        //根据文章ID删除记录

        articleCategoryRefMapper.deleteByArticleId(article.getArticleId());
        List<Category> categoryList = articleCategoryRefMapper.listCategoryByArticleId(28);
        System.out.println("根据文章ID为28删除记录后大小为:"+categoryList.size());

        // 增加分类和文章关联
        Article article1 = new Article();
        List<Category> categoryList1 = new ArrayList<>();

        Category category = new Category(1);
        categoryList1.add(category);
        article1.setArticleId(28);
        article1.setCategoryList(categoryList1);
        for (int i = 0;i<article1.getCategoryList().size(); i++) {
            ArticleCategoryRef articleCategoryRef = new ArticleCategoryRef(article1.getArticleId(),article1.getCategoryList().get(i).getCategoryId());
            articleCategoryRefMapper.insert(articleCategoryRef);
        }
        System.out.println("增加分类为28和文章关联后的大小为"+article1.getCategoryList().size());

    }

    /**
     * 新增文章
     */
    @Test
    public void ArticleInsert(){
        List<Category> categoryList = categoryService.listCategory();
        for (int i = 0; i < categoryList.size(); i++) {
            System.out.println(categoryList.get(i).getCategoryName());

        }
        System.out.println("=========================");
        List<Tag> tagList = tagService.listTag();
        for (int i = 0; i <tagList.size() ; i++) {
            System.out.println(tagList.get(i).getTagName());
        }



    }

    /**
     * 新增文章提交
     */
    @Test
    public void ArticleInsertSub(){
        ArticleParam articleParam = new ArticleParam();
        articleParam.setArticleContent("测试文章添加");
        articleParam.setArticleTitle("测试文章添加");
        articleParam.setArticleStatus(1);
        Article article = new Article();
        article.setArticleTitle(articleParam.getArticleTitle());
        article.setArticleContent(articleParam.getArticleContent());
        article.setArticleStatus(articleParam.getArticleStatus());
        //填充分类
        List<Category> categoryList = new ArrayList<>();
        if (articleParam.getArticleChildCategoryId() != null){
            categoryList.add(new Category(articleParam.getArticleParentCategoryId()));

        }  if (articleParam.getArticleChildCategoryId() != null) {
            categoryList.add(   new Category(articleParam.getArticleChildCategoryId()));
        }
        article.setCategoryList(categoryList);

        //填充标签
        List<Tag> tagList = new ArrayList<>();
        if(articleParam.getArticleTagIds() != null){
            for (int i = 0; i < articleParam.getArticleTagIds().size(); i++) {
                Tag tag = new Tag(articleParam.getArticleTagIds().get(i));
                tagList.add(tag);
            }
        }
        article.setTagList(tagList);
        articleService.insertArticle(article);
    }

}

