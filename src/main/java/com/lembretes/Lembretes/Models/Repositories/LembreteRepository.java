package com.lembretes.Lembretes.Models.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lembretes.Lembretes.Models.Entities.Lembretes;

@Repository
public interface LembreteRepository extends JpaRepository<Lembretes, Long> {
    
    @Query("SELECT p FROM Lembretes p WHERE p.titulo LIKE %:titulo%")
    Iterable<Lembretes> findBytitulo(@Param("titulo") String titulo);
}
