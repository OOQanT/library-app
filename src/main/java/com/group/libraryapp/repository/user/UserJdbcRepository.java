package com.group.libraryapp.repository.user;

import com.group.libraryapp.dto.user.response.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserJdbcRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserJdbcRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public boolean isUserNotExist(long id){
        String readSql = "select * from user where id = ?";
        boolean isUserNotExist = jdbcTemplate.query(readSql,(rs, rowNum)-> 0,id).isEmpty();
        return isUserNotExist;
    }

    public boolean isUserNotExist(String name){
        String readSql = "select * from user where name = ?";
        boolean isUserNotExist = jdbcTemplate.query(readSql,(rs, rowNum)-> 0,name).isEmpty();
        return  isUserNotExist;
    }

    public void saveUser(String name, int age){
        String sql = "insert into user(name, age) values(?, ?)";
        jdbcTemplate.update(sql,name,age);
    }

    public List<UserResponse> getUsers(){
        String sql = "select * from user";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            long id = rs.getLong("id");
            String name = rs.getString("name");
            int age = rs.getInt("age");
            return new UserResponse(id,name,age);
        });
    }

    public void updateUserName(String name, long id){
        String sql = "update user set name = ? where id = ?";
        jdbcTemplate.update(sql,name,id);
    }

    public void deleteUser(String name){
        String sql = "delete from user where name = ?";
        jdbcTemplate.update(sql,name);
    }
}
