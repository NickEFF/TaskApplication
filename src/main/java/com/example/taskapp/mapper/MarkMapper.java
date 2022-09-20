package com.example.taskapp.mapper;

import com.example.taskapp.entity.Document;
import com.example.taskapp.entity.Mark;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class MarkMapper implements RowMapper<Mark> {
    @Override
    public Mark mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Mark(
                rs.getInt("id_mark"),
                rs.getInt("id_detail"),
                rs.getInt("id_doc")
        );
    }
}
