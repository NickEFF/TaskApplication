package com.example.taskapp.repository;

import com.example.taskapp.entity.Document;
import com.example.taskapp.entity.DocumentDetail;
import com.example.taskapp.entity.Mark;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface DocumentRepository {
    Optional<Document> getDocumentById(int id);

    Optional<DocumentDetail> getDetailById(int id_detail);

    Optional<Mark> getMarkById(int id_mark);

    void insertDocument(String sender_code, String recipient_code);

    void insertMark(Integer id_detail, Integer id_doc);

    void insertDetail(String product_name, Integer id_doc);

    void deleteDocumentById(int id);

    void deleteDetailById(int id_detail);

    void deleteMarkById(int id_mark);
}
