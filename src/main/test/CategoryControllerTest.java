
import com.zgw.blog.entity.Category;
import com.zgw.blog.service.ArticleService;
import com.zgw.blog.service.CategoryService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

/**
 * Created by Zhaogw&Lss on 2019/4/18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring的配置文件,需要用到的配置文件，如果是dao的话可以不用spring-service.xml
@ContextConfiguration({ "classpath:spring/spring-mybatis.xml",
        "classpath:spring/spring-service.xml","classpath:spring/spring-mvc.xml" })
@WebAppConfiguration
public class CategoryControllerTest {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ArticleService articleService;




    /**
     * 测试分类集合
     */
    @Test
    public void testCategoryList() {
        List<Category> categoryList = categoryService.listCategoryWithCount();
        for (int i = 0; i <categoryList.size() ; i++) {
            String name = categoryList.get(i).getCategoryName();
            Integer id = categoryList.get(i).getCategoryId();
            Integer pid = categoryList.get(i).getCategoryPid();
            System.out.println("分类集合中的元素有:"+name+"------对应的分类id为:"+id+"------对应的pid为"+pid);
        }

    }

    /**
     * 测试后台添加分类提交
     *
     * @param
     * @return
     */
    @Test
    public void testCategoryInsert() {
        Category category = new Category(1,"测试增加分类1");
        categoryService.insertCategory(category);
        Category category1 = categoryService.getCategoryById(100000003);
        System.out.println(category1.getCategoryName());
        Assert.assertEquals("微服务",category1.getCategoryName());
    }
    @Test
    public void testCategoryDelete(){
        Integer id = 100000027;
        int count  = articleService.countArticleByCategoryId(id);
        if(count == 0){
            categoryService.deleteCategory(id);
        }
    }
    @Test
    public  void testCategoryEdit(){
        Integer id = 100000027;
        Category category = categoryService.getCategoryById(id);
        category.setCategoryName("测试更新分类");
        categoryService.updateCategory(category);


    }


}
