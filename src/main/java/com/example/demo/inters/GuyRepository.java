package com.example.demo.inters;

import com.example.demo.bean.Guy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * spring - boot curd的基本操作
 */
public interface GuyRepository extends JpaRepository<Guy, Integer> {
    /**
     * 通过给出身高，查
     * @param height 身高
     * @return 用户
     */
    List<Guy> findByHeight(String height);
}
