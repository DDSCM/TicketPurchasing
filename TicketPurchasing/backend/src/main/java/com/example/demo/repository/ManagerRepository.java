package com.example.demo.repository;

import com.example.demo.domain.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface ManagerRepository extends JpaRepository<Manager,Integer> {
    Manager findByMId(Integer mId);
    Manager findByMName(String mName);

    @Transactional
    @Modifying
    @Query(value = "UPDATE Manager m SET m.mName=?1,m.mPhone=?2 where m.mId=?3")
    void UpdateManager(String mName,String mPhone,Integer mId);

}
