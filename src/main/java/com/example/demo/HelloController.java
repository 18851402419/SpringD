package com.example.demo;

import com.example.demo.bean.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;


@RestController
public class HelloController {
    @Value("${height}")
    private String height;

    @Value("${name}")
    private String name;

    @Value("${age}")
    private String age;

    @Autowired
    private People people;

    @RequestMapping(value = "/hello/{id}", method = RequestMethod.GET)
//    public String say(){
////        return "hello " + name + "，你的身高是：" + height
////                + "，并且你已经" + age + "岁了";
//        return people.getName() + "     " + name;
//    }

    /**
     * 此函数测试的是获取url的值
     * @RequestMapping(value = "/hello/{id}", method = RequestMethod.GET)
     * 只需要"http://localhost:8081/memeda/hello/3"即可
     */
    public String say2(@PathVariable("id") int id){
        return "He's name is " + people.getName() +
                " and I got the id is " + id;
    }

    /**
     * 传统方法
     * @param id url中的id
     * @return 输出语句
     */
//    public String say3(@PathParam("id") int id){
//        return "He's name is " + people.getName() +
//                " and I got the id is " + id;
//    }

    /**
     * required表示参数是否必传，defaultValue代表默认值（String）
     * @param id url中的id
     * @return 输出语句
     */
    //    @GetMapping(value = "/hello")   // 组合注解@GetMapping
//    public String say4(@RequestParam(value = "id",required =
//    false, defaultValue = "0") int id){
//        return "He's name is " + people.getName() +
//                " and I got the id is " + id;
//    }
}
