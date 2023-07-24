package com.example.demo.controller;

import com.example.demo.dto.request.TransactionRequest;
import com.example.demo.dto.response.TransactionResponse;
import com.example.demo.service.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/transactions")
public class TransactionController {
    private TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/get")
    public List<TransactionResponse> getAll() {
        List<TransactionResponse> list = transactionService.getTransaction();
        return list;
    }

    @PostMapping("/create")
    public ResponseEntity<TransactionResponse> create(@RequestBody TransactionRequest request) {
        return new ResponseEntity<>(transactionService.createTransaction(request), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable(name = "id") int id) {
        transactionService.deleteTransaction(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<TransactionResponse>
    update(@RequestBody TransactionRequest transaction, @PathVariable(name = "id") int id) {
        return new ResponseEntity<>(transactionService.updateTransaction(transaction, id), HttpStatus.OK);
    }
}
