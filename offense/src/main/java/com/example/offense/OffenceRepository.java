package com.example.offense;

import com.example.offense.model.Offence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OffenceRepository extends JpaRepository<Offence,Long> {
    List<Offence> findAllByUserId(Long id);
}