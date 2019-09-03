package com.example.demo.repository;

import com.example.demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByUId(Integer uId);
    User findByUName(String uName);

    @Query(value = "SELECT user FROM User user WHERE user.uName LIKE %?1%")
    List<User> findByNameLike(String uName);

    //修改密码
    @Transactional
    @Modifying
    @Query(value = "UPDATE User user SET user.uPwd=?1 WHERE user.uId=?2")
    void UpdatePwd(String uPwd,Integer uId);

    //修改个人信息
    @Transactional
    @Modifying
    @Query(value = "UPDATE User user SET user.uPhone=?1,user.uSex=?2 WHERE user.uId=?3")
    void UpdateUser(String uPhone,String uSex,Integer uId);

    //修改头像
    @Transactional
    @Modifying
    @Query(value = "UPDATE User user Set user.potrait=?1 WHERE user.uId=?2")
    void UpdatePotrait(String potrait,Integer uId);

}
