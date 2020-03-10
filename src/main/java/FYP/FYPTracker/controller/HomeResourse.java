package FYP.FYPTracker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeResourse {

//    @RequestMapping("/login")
//    public String home() {
//        return "/login";
//    }

    @GetMapping("/user")
    public String player() {
        return ("<h1>Welcome User</h1>");
    }

    @GetMapping("/coach")
    public String coach() {
        return ("<h1>Welcome Coach</h1>");
    }

    @GetMapping("/admin")
    public String admin() {
        return ("<h1>Welcome Admin</h1>");
    }
}
