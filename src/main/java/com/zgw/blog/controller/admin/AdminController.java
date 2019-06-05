package com.zgw.blog.controller.admin;

import com.alibaba.fastjson.JSONObject;
import com.zgw.blog.entity.Article;
import com.zgw.blog.entity.Comment;
import com.zgw.blog.entity.User;
import com.zgw.blog.service.ArticleService;
import com.zgw.blog.service.CommentService;
import com.zgw.blog.service.UserService;
import com.zgw.blog.util.EmailUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.zgw.blog.util.Functions.getIpAddr;

/**
 * Created by Zhaogw&Lss on 2019/4/25.
 */
@Controller
public class AdminController {
    @Autowired
    private UserService userService;
    @Autowired
    private ArticleService articleService;
    @Autowired
    private CommentService commentService;
    /**
     * 后台首页
     *
     * @return
     */
    @RequestMapping("/admin")
    public String index(Model model)  {
        //文章列表
        List<Article> articleList = articleService.listRecentArticle(5);
        model.addAttribute("articleList",articleList);
        //评论列表
        List<Comment> commentList = commentService.listRecentComment(5);
        model.addAttribute("commentList",commentList);
        return "Admin/index";
    }
    @RequestMapping("/register")
    public String register(){
        return "Admin/registerPage";
    }

    @RequestMapping("/foreregister")
    @ResponseBody
    public String register(HttpServletRequest request, HttpServletResponse response){
        Map<String,Object> map = new HashMap<>();
        User user = new User();
        String name = request.getParameter("username");
        name = HtmlUtils.htmlEscape(name);         //HtmlUtils.htmlEscape(name);把账号里的特殊符号进行转义
        String pwd = request.getParameter("password");
        String nike_name = request.getParameter("nike_name");
        user.setUserName(name);
        user.setUserPass(pwd);
        user.setUserNickname(nike_name);
        boolean exist = userService.isExist(name); //判断用户是否存在

        if (exist) {
            String m = "该用户名已被使用,请重新输入用户名";
            map.put("code",0);
            map.put("msg",m);
        }else{
            map.put("code",1);
            map.put("msg","注册成功");
            userService.insertUser(user);   //插入数据库'
        }
        String result = new JSONObject(map).toString();
        return result;
    }


    /**
     * 登录页面显示
     *
     * @return
     */
    @RequestMapping("/login")
    public String loginPage() {
        return "Admin/login";
    }

    /**
     * 登录验证
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/loginVerify",method = RequestMethod.POST)
    @ResponseBody
    public String loginVerify(HttpServletRequest request, HttpServletResponse response)  {
        Map<String,Object> map = new HashMap<String,Object>();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String rememberme = request.getParameter("rememberme");
        User user = userService.getUserByNameOrEmail(username);

        if(user==null) {
            map.put("code",0);
            map.put("msg","用户名无效！");
        } else if(!user.getUserPass().equals(password)) {
            map.put("code",0);
            map.put("msg","密码错误！");
        } else {
            //登录成功
            map.put("code",1);
            map.put("msg","");

            //添加session
            request.getSession().setAttribute("user", user);
           if(1 == user.getUserRole()){
               map.put("kinds",1);
           }else {
               map.put("kinds",0);
           }


            //添加cookie
            if(rememberme!=null) {
                //创建两个Cookie对象
                Cookie nameCookie = new Cookie("username", username);
                //设置Cookie的有效期为3天
                nameCookie.setMaxAge(60 * 60 * 24 * 3);
                Cookie pwdCookie = new Cookie("password", password);
                pwdCookie.setMaxAge(60 * 60 * 24 * 3);
                response.addCookie(nameCookie);
                response.addCookie(pwdCookie);
            }
            user.setUserLastLoginTime(new Date());
            user.setUserLastLoginIp(getIpAddr(request));
            userService.updateUser(user);
        }
        String result = new JSONObject(map).toString();
        return result;

    }

    /**
     * 退出登录
     *
     * @param session
     * @return
     */
    @RequestMapping(value = "/admin/logout")
    public String logout(HttpSession session)  {
        session.removeAttribute("user");
        session.invalidate();
        return "redirect:/login";
    }

    /**
     * 发邮件
     * @return
     */
    @RequestMapping(value = "/forgetPwd")
    public String forgetPwd(){
        return "Admin/forgetPwd";
    }
    @ResponseBody
    @RequestMapping(value = "/forgetPwdCen",method = RequestMethod.POST)
    public String forgetPwdCen(HttpServletRequest request, HttpServletResponse response){
        response.setCharacterEncoding("UTF-8");
        String email = request.getParameter("user_login_mail");
        String name = request.getParameter("username");
        User user = null;
        EmailUtils mySendMail = new EmailUtils();
        Map<String,Object> map = new HashMap<String,Object>();
        try {
            user = userService.getUserByEmailAndName(email,name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (user == null) {
            map.put("code",0);
            map.put("fail", "请输入正确的用户名和邮箱");
        }
        else {
            map.put("code",1);
            map.put("success", "密码已经发送到您的邮箱，请前往查看");
            mySendMail.sendMail(email, "Solo博客提醒，您的密码为：" + user.getUserPass());

        }
        String result = new JSONObject(map).toString();
        return  result;

    }


}
