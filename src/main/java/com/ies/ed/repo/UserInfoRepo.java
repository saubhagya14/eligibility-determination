package com.ies.ed.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ies.ed.entity.UserInfo;

public interface UserInfoRepo extends JpaRepository<UserInfo, Integer> {

}
