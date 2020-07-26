package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
    @RequestMapping(value = "/")
    public String Index() {
        return "index";
    }

    @GetMapping(value = "/hi")
    @ResponseBody
    public String Index2() {
        return "index";
    }
}
