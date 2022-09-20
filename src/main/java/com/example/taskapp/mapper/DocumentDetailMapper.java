package com.example.taskapp.mapper;

import com.example.taskapp.entity.DocumentDetail;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class DocumentDetailMapper implements RowMapper<DocumentDetail> {
    @Override
    public DocumentDetail mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new DocumentDetail(
                rs.getInt("id_detail"),
                rs.getInt("line_number"),
                rs.getString("product_name"),
                rs.getInt("id_doc")
        );
    }
}
