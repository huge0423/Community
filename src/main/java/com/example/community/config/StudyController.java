//package com.example.community.config;
//
//import com.example.community.entity.DiscussPost;
//import com.example.community.entity.User;
//import com.example.community.service.DiscussPostService;
//import com.example.community.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@Controller
//public class StudyController {
//
//    @Autowired
//    private DiscussPostService discussPostService;
//
//    @Autowired
//    private UserService userService;
//
//    @RequestMapping(path = "/index1", method = RequestMethod.GET)
//    public String getIndexPage(Model model) {
//        List<DiscussPost> list = discussPostService.findDiscussPosts(0,0,10);
//        List<Map<String,Object>> discussPosts = new ArrayList<>();
//        if (list != null){
//            for (DiscussPost post: list) {
//                //需要将结果装到Map中，先将Map实例化
//                Map<String, Object> map = new HashMap<>();
//                map.put("post", post);
//                User user = userService.findUserById(post.getUserId());
//                map.put("user",user);
//                discussPosts.add(map);
//            }
//        }
//        //数据处理好后，将到model中
//        model.addAttribute("discussPost",discussPosts);
//        //templates下的index.html
//        return "/index";
//    }
//}
