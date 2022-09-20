package com.techmind.project_enterprise.controller;

import com.techmind.project_enterprise.dto.TransactionDTO;
import com.techmind.project_enterprise.exeptions.ModelNotFoundException;
import com.techmind.project_enterprise.model.Transaction;
import com.techmind.project_enterprise.service.ITransactionService;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Data
@RestController
@RequestMapping("/transactions")
public class TransactionController {
    @Autowired
    private ITransactionService service;

    @Autowired
    @Qualifier("transactionMapper")
    private ModelMapper mapper;


    @GetMapping
    public ResponseEntity<List<TransactionDTO>> readAll() throws Exception{
        List<TransactionDTO>list=service.readAll().stream()
                .map(c->mapper.map(c,TransactionDTO.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TransactionDTO> create(@Valid @RequestBody TransactionDTO transactionDto) throws Exception{
        Transaction tra = service.create(mapper.map(transactionDto, Transaction.class));
        TransactionDTO dto = mapper.map(tra,TransactionDTO.class);
        return new ResponseEntity<>(dto,HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransactionDTO> readById(@PathVariable("id")Long id) throws Exception {
        Transaction tra =service.readById(id);
        if (tra==null){
            throw new ModelNotFoundException("ID N° " + id + "No fue encontrado");
        }
        TransactionDTO dto = mapper.map(tra, TransactionDTO.class);
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }
    @PutMapping
    public ResponseEntity<TransactionDTO> update(@Valid @RequestBody TransactionDTO transactionDto) throws Exception{
        Transaction tra= service.readById(transactionDto.getIdTransaction());
        if (tra==null){
            throw new ModelNotFoundException("Id no encontrado: " + transactionDto.getIdTransaction());

        }
        Transaction transaction = service.update(mapper.map(transactionDto, Transaction.class));
        TransactionDTO dto = mapper.map(transaction,TransactionDTO.class);
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) throws Exception{
        Transaction transaction = service.readById(id);
        if(transaction==null){
            throw new ModelNotFoundException("Id no encontrado: "  + id);
        }
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
