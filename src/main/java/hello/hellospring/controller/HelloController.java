package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")    //web application 에서 /hello로 호출하면 해당 메소드 호출
    public String hello(Model model){
        model.addAttribute("data", "hello");

        return "hello"; // hello.html 기본적으로 resources/templates 하위에 있는 hello를 찾음.
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody //body 부분에 이 데이터를 직접 넣어주겠다.
    public String helloString(@RequestParam("name") String name){
        return "hello " + name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;   // 이렇게 하면 json 으로 넘어감.
        // 객체가 오면 json 방식으로 데이터를 만들어서 http 응답에 반환하겠다(기본정책).
    }

    static class Hello {
        private String name;
        // private 여서 get,set 형식으로 가져옴 .
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
    }
}
