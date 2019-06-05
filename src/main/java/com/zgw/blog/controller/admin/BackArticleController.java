package com.zgw.blog.controller.admin;

import com.github.pagehelper.PageInfo;
import com.zgw.blog.dto.ArticleParam;
import com.zgw.blog.entity.Article;
import com.zgw.blog.entity.Category;
import com.zgw.blog.entity.Tag;
import com.zgw.blog.entity.User;
import com.zgw.blog.service.ArticleService;
import com.zgw.blog.service.CategoryService;
import com.zgw.blog.service.TagService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Zhaogw&Lss on 2019/4/13.
 */
@Controller
@RequestMapping("/admin/article")
public class  BackArticleController {
   @Autowired
    private ArticleService articleService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private TagService tagService;

    /**
     * 后台文章列表显示
     *
     * @return modelAndView
     */
    @RequestMapping(value = "")
    public String index(@RequestParam(required = false,defaultValue = "1" )Integer pageIndex,
                        @RequestParam(required = false,defaultValue = "10" )Integer pageSize,
                        @RequestParam(required = false) String status, Model model){
        HashMap<String,Object> criteria = new HashMap<>();
        if (status == null) {
            model.addAttribute("pageUrlPrefix", "/admin/article?pageIndex");
        } else {
            criteria.put("status", status);
            model.addAttribute("pageUrlPrefix", "/admin/article?status=" + status + "&pageIndex");
        }
        PageInfo<Article> articlePageInfo = articleService.pageArticle(pageIndex, pageSize, criteria);
        model.addAttribute("pageInfo", articlePageInfo);
        return "Admin/Article/index";
    }

    @RequestMapping(value = "/delete/{id}")
    public void deleteArticle(@PathVariable("id") Integer id){articleService.deleteArticle(id);}
    /**
     * 编辑文章页面显示
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/edit/{id}")
    public ModelAndView editArticleView(@PathVariable("id") Integer id){
        ModelAndView modelAndView = new ModelAndView();

        Article article = articleService.getArticleByStatusAndId(null,id);
        modelAndView.addObject("article",article);

        List<Category> categoryList = categoryService.listCategory();
        modelAndView.addObject("categoryList", categoryList);

        List<Tag> tagList = tagService.listTag();
        modelAndView.addObject("tagList", tagList);

        modelAndView.setViewName("Admin/Article/edit");
        return modelAndView;

    }
    /**
     * 编辑文章提交
     *
     * @param articleParam
     * @return
     */
    @RequestMapping(value = "/editSubmit", method = RequestMethod.POST)
    public String editArticleSubmit(ArticleParam articleParam){
        Article article = new Article();

        article.setArticleId(articleParam.getArticleId());

        article.setArticleTitle(articleParam.getArticleTitle());

        article.setArticleContent(articleParam.getArticleContent());

        article.setArticleOrder(articleParam.getArticleOrder());

        article.setArticleStatus(articleParam.getArticleStatus());

        //填充分类
        List<Category> categoryList = new ArrayList<>();
        if (articleParam.getArticleChildCategoryId() != null){
            categoryList.add(new Category(articleParam.getArticleParentCategoryId()));

        }  if (articleParam.getArticleChildCategoryId() != null) {
            categoryList.add(new Category(articleParam.getArticleChildCategoryId()));
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
        articleService.updateArticleDetail(article);
        return "redirect:/admin/article";
    }

    /**
     * 后台添加文章界面
     * @param model
     * @return
     */
    @RequestMapping(value = "/insert")
    public String insertArticleView(Model model){
        List<Category> categoryList = categoryService.listCategory();
        List<Tag> tagList = tagService.listTag();
        model.addAttribute("categoryList",categoryList);
        model.addAttribute("tagList",tagList);
        return "Admin/Article/insert";
    }
    /**
     * 后台添加文章提交操作
     *
     * @param articleParam
     * @return
     */
    @RequestMapping(value =     "/insertSubmit", method = RequestMethod.POST)
    public String insertArticleSubmit(HttpSession session,ArticleParam articleParam){
        Article article = new Article();
        //用户id
        User user = (User)session.getAttribute("user");
        if (user != null){
            article.setArticleUserId(user.getUserId());
        }
        article.setArticleTitle(articleParam.getArticleTitle());
        article.setArticleContent(articleParam.getArticleContent());
        article.setArticleStatus(articleParam.getArticleStatus());
        //填充分类
        List<Category> categoryList = new ArrayList<>();
        if (articleParam.getArticleChildCategoryId() != null){
            categoryList.add(new Category(articleParam.getArticleParentCategoryId()));

        }  if (articleParam.getArticleChildCategoryId() != null) {
            categoryList.add(new Category(articleParam.getArticleChildCategoryId()));
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
        return "redirect:/admin/article";
    }




}
