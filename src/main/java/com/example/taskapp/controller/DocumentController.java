package com.example.taskapp.controller;

import com.example.taskapp.entity.*;
import com.example.taskapp.service.DocumentService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/select")
public class DocumentController {

    private final DocumentService documentService;

    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @GetMapping("/getDoc/{documentId}")
    public Document getDocument(@PathVariable int documentId){
        return documentService.getDocument(documentId);
    }

    @GetMapping("/getDetail/{detailId}")
    public DocumentDetail getDetail(@PathVariable int detailId){
        return documentService.getDetail(detailId);
    }

    @GetMapping("/getMark/{markId}")
    public Mark getMark(@PathVariable int markId){
        return documentService.getMark(markId);
    }

    @PostMapping("/doc")
    @ResponseStatus(HttpStatus.CREATED)
    public void createDocument(@Validated @RequestBody DocumentRequest request) {
        documentService.createDocument(
                request.sender_code(),
                request.recipient_code()
        );
    }

    @PostMapping("/mark")
    @ResponseStatus(HttpStatus.CREATED)
    public void createMark(@RequestBody MarkRequest request) {
        documentService.createMark(
                request.id_detail(),
                request.id_doc()
        );
    }

    @PostMapping("/detail")
    @ResponseStatus(HttpStatus.CREATED)
    public void createDetail(@RequestBody DocumentDetailRequest request) {
        documentService.createDetail(
                request.product_name(),
                request.id_doc()
        );
    }

    @DeleteMapping(value = "/delDoc/{documentId}")
    public void deleteDocument(@PathVariable int documentId) {
        documentService.deleteDocument(documentId);
    }

    @DeleteMapping(value = "/delDet/{detailId}")
    public void deleteDetail(@PathVariable int detailId) {
        documentService.deleteDetail(detailId);
    }

    @DeleteMapping(value = "/delMark/{markId}")
    public void deleteMark(@PathVariable int markId) {
        documentService.deleteMark(markId);
    }
}
