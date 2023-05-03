package com.rouvsen.repository;

import com.rouvsen.model.Content;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

//@Repository
public class ContentJdbcTemplateRepository {

    private final JdbcTemplate jdbcTemplate;

    public ContentJdbcTemplateRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

//    public static Content mapRow(ResultSet rs, int rowNum) throws SQLException {
//        return
//                new Content(
//                        rs.getInt("id"),
//                        rs.getString("title"),
//                        rs.getString("desc"),
//                        rs.getString("status"),
//                        rs.getString("content_type"),
//                        rs.getTimestamp("data_created"),
//                        rs.getTimestamp("data_updated"),
//                        rs.getString("url")
//
//                );
//    }

//    public List<Content> getAllContent(){
//        String sql = "select * from content";
//        List<Content> contents = jdbcTemplate.query(sql, ContentJdbcTemplateRepository::mapRow);
//        return contents;
//    }

    //other operations
}
