package com.example.security.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VodilaRepository extends JpaRepository<Vodila,Long> {

    Vodila findByUsername(String username);

}
