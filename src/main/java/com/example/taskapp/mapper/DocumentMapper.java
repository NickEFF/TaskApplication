package com.example.taskapp.mapper;

import com.example.taskapp.entity.Document;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class DocumentMapper implements RowMapper<Document> {

    @Override
    public Document mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Document(
                rs.getInt("id"),
                rs.getTimestamp("data_create"),
                rs.getString("s_code"),
                rs.getString("r_code")
        );
    }
}
