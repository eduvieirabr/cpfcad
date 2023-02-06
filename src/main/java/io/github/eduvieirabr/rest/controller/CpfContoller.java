package io.github.eduvieirabr.rest.controller;

import io.github.eduvieirabr.domain.entity.Cpf;
import io.github.eduvieirabr.domain.repository.Cpfs;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/cpf")
public class CpfContoller {

    private Cpfs cpfs;

    public CpfContoller( Cpfs cpfs) {
        this.cpfs = cpfs;
    }

    @GetMapping("{cpf}")
    public ResponseEntity getCpfById(@PathVariable String cpf) {
        List<Cpf> result = cpfs.findByCpf(cpf);

        if (!result.isEmpty() ) {
            return  ResponseEntity.ok( result );
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cpf save(@RequestBody Cpf cpf ) {
        List<Cpf> result = cpfs.findByCpf(cpf.getCpf());
        if (result.size() == 0) {
            return cpfs.save(cpf);
        }
        return result.get(0);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete( @PathVariable Integer id ){
        cpfs.findById(id)
                .map( cpf -> {
                    cpfs.delete(cpf);
                    return cpf;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "CPF não encontrado") );
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update( @PathVariable Integer id,
                        @RequestBody Cpf cpf ){
                 cpfs
                .findById(id)
                .map( cpfExists -> {
                    cpf.setId(cpfExists.getId());
                    cpfs.save(cpf);
                    return cpfExists;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "CPF não encontrado") );
    }
}
