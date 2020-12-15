package com.mysocketio.Controller;

import com.mysocketio.Message.PushMessage;
import com.mysocketio.Service.SocketIOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: panyusheng
 * @Date: 2020/12/14
 * @Version 1.0
 */
@Controller
public class TestController {

    @Autowired
    private SocketIOService socketIOService;

    @GetMapping("/index")
    public String index(HttpServletRequest req) {
        String username = req.getParameter("username");
        req.setAttribute("username", username);
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/start")
    @ResponseBody
    public void start(HttpServletRequest req) {
        String content = req.getParameter("content");
        String uname = req.getParameter("uname");
        PushMessage pushMessage = new PushMessage();
        pushMessage.setContent(content);
        pushMessage.setLoginUserName(uname);
        socketIOService.pushMessageToUser(pushMessage);
    }

}
