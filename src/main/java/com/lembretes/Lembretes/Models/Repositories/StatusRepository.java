package com.lembretes.Lembretes.Models.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.lembretes.Lembretes.Models.Entities.Status;

@Repository
public interface StatusRepository extends JpaRepository <Status,Long> {

}
