package com.example.demo;

import com.example.demo.bean.Guy;
import com.example.demo.inters.GuyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class GuyController {
    @Autowired
    private GuyRepository guyRepository;

    /**
     * 查找所有用户
     * @return 查找的列表
     */
    @GetMapping(value = "/fff")
    public List<Guy> findAll(){
        return guyRepository.findAll();
    }

    /**
     * 数据库新增
     * @param name
     * @param height
     * @return
     */
    @PostMapping(value = "/fff")
    public Guy addGuy(@RequestParam("name") String name,
                      @RequestParam("height") String height){
        Guy guy = new Guy();
        guy.setName(name);
        guy.setHeight(height);
        return guyRepository.saveAndFlush(guy);
    }

    /**
     * 通过id号来找用户
     * @url http://localhost:8081/memeda/findById/3
     * @param id 用户的id
     * @return 整个用户
     */
    @GetMapping(value = "/findById/{id}")
    public Optional<Guy> findById(@PathVariable("id") int id){
        return guyRepository.findById(id);
    }

    /**
     * 通过id号删除一个用户
     * @url http://localhost:8081/memeda/deleteById/2   注意：要用delete
     * @param id 用户的id
     * @return 一句话
     */
    @DeleteMapping(value = "/deleteById/{id}")
    public String deleteById(@PathVariable("id") int id){
        guyRepository.deleteById(id);
        return "deleteDown";
    }

    /**
     * 更新一个用户信息，通过id
     * 注意：注意提交数据的格式 当数据库没有这个id时，就会新增这个用户，而不会执行更新操作
     * @param id 用户id
     * @param name 更新后的名字
     * @param height 更新后的身高
     * @return 更新后的那个用户
     */
    @PutMapping(value = "/update/{id}")
    public Guy updateGuy(@PathVariable("id") int id,
                         @RequestParam(value = "name", required = false) String name,
                         @RequestParam(value = "height", required = false) String height){
        Guy guy = new Guy();
        guy.setId(id);
        guy.setName(name);
        guy.setHeight(height);
        return guyRepository.save(guy);
    }

    /**
     * 通过身高来查询所有用户
     * @url http://localhost:8081/memeda/getByHeight?height=178cm
     * @param height 身高
     * @return 用户
     */
    @GetMapping(value = "getByHeight")
    public List<Guy> findByHeight(@RequestParam("height") String height){
        return guyRepository.findByHeight(height);
    }
}
