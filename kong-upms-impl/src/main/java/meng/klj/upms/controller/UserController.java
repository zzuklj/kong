package meng.klj.upms.controller;


import meng.klj.upms.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.*;

import meng.klj.upms.service.IUserService;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author klj
 * @since 2020-01-10
 */
@Api(tags = {"接口"})
@Controller
public class UserController{

  @Autowired
  private IUserService userService;

    @Autowired
    private HttpSession httpSession;

    /**
     * 登录跳转
     *
     * @param model
     * @return
     */
    @GetMapping("/user/login")
    public String loginGet(Model model) {
        return "login";
    }

    /**
     * 登录
     *
     * @param
     * @param model
     * @param
     * @return
     */
    @PostMapping("/user/login")
    public String loginPost(User user, Model model) {
        User user1 = userService.selectByNameAndPwd(user);
        if (user1 != null) {
            httpSession.setAttribute("user", user1);
            User name = (User) httpSession.getAttribute("user");
            return "redirect:dashboard";
        } else {
            model.addAttribute("error", "用户名或密码错误，请重新登录！");
            return "login";
        }
    }

    /**
     * 注册
     *
     * @param model
     * @return
     */
    @GetMapping("/user/register")
    public String register(Model model) {
        return "register";
    }

    /**
     * 注册
     *
     * @param model
     * @return
     */
    @PostMapping("/user/register")
    public String registerPost(User user, Model model) {
        System.out.println("用户名" + user.getUserName());
        try {
            userService.selectIsName(user);
            model.addAttribute("error", "该账号已存在！");
        } catch (Exception e) {
            user.setAddDate(LocalDate.now());
            user.setUpdateDate(LocalDate.now());
            userService.save(user);
            System.out.println("注册成功");
            model.addAttribute("error", "恭喜您，注册成功！");
            return "login";
        }

        return "register";
    }

    /**
     * 登录跳转
     *
     * @param model
     * @return
     */
    @GetMapping("/user/forget")
    public String forgetGet(Model model) {
        return "forget";
    }

    /**
     * 登录
     *
     * @param
     * @param model
     * @param
     * @return
     */
   /* @PostMapping("/user/forget")
    public String forgetPost(User user, Model model) {
        String password = userMapper.selectPasswordByName(user);
        if (password == null) {
            model.addAttribute("error", "帐号不存在或邮箱不正确！");
        } else {
            String email = user.getEmail();
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(Sender);
            message.setTo(email); //接收者邮箱
            message.setSubject("YX后台信息管理系统-密码找回");
            StringBuilder sb = new StringBuilder();
            sb.append(user.getUserName() + "用户您好！您的注册密码是：" + password + "。感谢您使用YX信息管理系统！");
            message.setText(sb.toString());
            mailSender.send(message);
            model.addAttribute("error", "密码已发到您的邮箱,请查收！");
        }
        return "forget";

    }*/

    @GetMapping("/user/userManage")
    public String userManageGet(Model model) {
        User user = (User) httpSession.getAttribute("user");
        User user1 = userService.selectByNameAndPwd(user);
        model.addAttribute("user", user1);
        return "user/userManage";
    }

    @PostMapping("/user/userManage")
    public String userManagePost(Model model, User user, HttpSession httpSession) {
        user.setUpdateDate(LocalDate.now());
        userService.updateById(user);
        httpSession.setAttribute("user",user);
        return "redirect:userManage";
    }

}
