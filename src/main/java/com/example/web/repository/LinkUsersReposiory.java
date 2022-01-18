package com.example.web.repository;

import com.example.web.entity.User;
import com.example.web.more.LinkUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LinkUsersReposiory extends JpaRepository<LinkUsers,Integer> {

    public LinkUsers findLinkUsersByFollowerAndFollowed(User follower, User followed);
}
