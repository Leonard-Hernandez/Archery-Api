package com.TrueArchery.Archery.domain.archer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArcherRepository extends JpaRepository<Archer, String> {
}
