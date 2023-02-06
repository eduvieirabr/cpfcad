package io.github.eduvieirabr.domain.repository;
import io.github.eduvieirabr.domain.entity.Cpf;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Cpfs extends JpaRepository<Cpf, Integer> {
    @Query(value = "select c from Cpf c where c.cpf = :cpf")
    List<Cpf> findByCpf (@Param("cpf") String cpf);
    boolean existsByCpf(String cpf);

}
