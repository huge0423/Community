package com.example.community.controller;

import com.example.community.entity.DiscussPost;
import com.example.community.entity.User;
import com.example.community.service.DiscussPostService;
import com.example.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

    @Autowired
    private DiscussPostService discussPostService;

    @Autowired
    private UserService userService;

    @RequestMapping(path = "/index", method = RequestMethod.GET)
    public String getIndexPage(Model model){
        //通过model携带数据

        List<DiscussPost> list = discussPostService.findDiscussPosts(0, 0, 10);
        //将帖子和user对应
        List<Map<String, Object>> discussPost = new ArrayList<>();
        if (list != null) {
            for (DiscussPost post : list) {
                Map<String, Object> map = new HashMap<>();
                //将帖子装到map中
                map.put("post",post);
                User user = userService.findUserById(post.getUserId());
                map.put("user",user);
                discussPost.add(map);
            }
        }
        //将需要展示的结果装到model中，页面才能得到对应的值
        model.addAttribute("discussPost",discussPost);
        //返回模板的路径，即templates下的index.html
        return "index";
    }
}
