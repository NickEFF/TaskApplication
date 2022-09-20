package com.example.taskapp.repository;

import com.example.taskapp.entity.Document;
import com.example.taskapp.entity.DocumentDetail;
import com.example.taskapp.entity.Mark;
import com.example.taskapp.mapper.DocumentDetailMapper;
import com.example.taskapp.mapper.DocumentMapper;
import com.example.taskapp.mapper.MarkMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class DocumentsRepositoryImpl implements DocumentRepository{
    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final DocumentMapper documentMapper;
    private final DocumentDetailMapper documentDetailMapper;
    private final MarkMapper markMapper;


    public DocumentsRepositoryImpl(NamedParameterJdbcTemplate jdbcTemplate, DocumentMapper documentMapper, DocumentDetailMapper documentDetailMapper, MarkMapper markMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.documentMapper = documentMapper;
        this.documentDetailMapper = documentDetailMapper;
        this.markMapper = markMapper;
    }

    private static final String SQL_GET_DOCUMENT_BY_ID =
            "select id, data_create, s_code, r_code from t_documents where id = :id";

    private static final String SQL_GET_DETAIL_BY_ID =
            "select id_detail, line_number, product_name, id_doc from t_details where id_detail = :id_detail";

    private static final String SQL_GET_MARK_BY_ID =
            "select id_mark, id_detail, id_doc from t_marks where id_mark = :id_mark";

    private static final String SQL_INSERT_DOCUMENT =
            "insert into t_documents (data_create, s_code, r_code) values (current_timestamp, :s_code, :r_code)";

    private static final String SQL_INSERT_MARK =
            "insert into t_marks (id_detail, id_doc) values (:id_detail, :id_doc)";

    private static final String SQL_INSERT_DETAIL =
            "insert into t_details (product_name, id_doc) values (:product_name, :id_doc)";

    private static final String SQL_DELETE_DOCUMENT =
            "delete from t_documents where id =  :id";

    private static final String SQL_DELETE_DETAIL =
            "delete from t_details where id_detail =  :id_detail";

    private static final String SQL_DELETE_MARK =
            "delete from t_marks where id_mark =  :id_mark";

    @Override
    public Optional<Document> getDocumentById(int id) {
        var params = new MapSqlParameterSource();
        params.addValue("id", id);
        return jdbcTemplate.query(
                        SQL_GET_DOCUMENT_BY_ID,
                        params,
                        documentMapper
                ).stream()
                .findFirst();
    }

    @Override
    public Optional<DocumentDetail> getDetailById(int id_detail) {
        var params = new MapSqlParameterSource();
        params.addValue("id_detail", id_detail);
        return jdbcTemplate.query(
                        SQL_GET_DETAIL_BY_ID,
                        params,
                        documentDetailMapper
                ).stream()
                .findFirst();
    }

    @Override
    public Optional<Mark> getMarkById(int id_mark) {
        var params = new MapSqlParameterSource();
        params.addValue("id_mark", id_mark);
        return jdbcTemplate.query(
                        SQL_GET_MARK_BY_ID,
                        params,
                        markMapper
                ).stream()
                .findFirst();
    }


    @Override
    public void insertDocument(String sender_code, String recipient_code) {
        var params = new MapSqlParameterSource();
        params.addValue("s_code", sender_code);
        params.addValue("r_code", recipient_code);
        jdbcTemplate.update(SQL_INSERT_DOCUMENT, params);
    }

    @Override
    public void insertMark(Integer id_detail, Integer id_doc) {
        var params = new MapSqlParameterSource();
        params.addValue("id_detail", id_detail);
        params.addValue("id_doc", id_doc);
        jdbcTemplate.update(SQL_INSERT_MARK, params);
    }

    @Override
    public void insertDetail(String product_name, Integer id_doc) {
        var params = new MapSqlParameterSource();
        params.addValue("product_name", product_name);
        params.addValue("id_doc", id_doc);
        jdbcTemplate.update(SQL_INSERT_DETAIL, params);
    }

    @Override
    public void deleteDocumentById(int id) {
        var params = new MapSqlParameterSource();
        params.addValue("id", id);
        jdbcTemplate.update(SQL_DELETE_DOCUMENT, params);
    }

    @Override
    public void deleteDetailById(int id_detail) {
        var params = new MapSqlParameterSource();
        params.addValue("id_detail", id_detail);
        jdbcTemplate.update(SQL_DELETE_DETAIL, params);
    }

    @Override
    public void deleteMarkById(int id_mark) {
        var params = new MapSqlParameterSource();
        params.addValue("id_mark", id_mark);
        jdbcTemplate.update(SQL_DELETE_MARK, params);
    }
}
