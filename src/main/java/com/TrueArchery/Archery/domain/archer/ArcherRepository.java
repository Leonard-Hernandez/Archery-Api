package com.TrueArchery.Archery.domain.archer;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArcherRepository extends JpaRepository<Archer, Long> {
    Page<Archer> findByActiveTrue(Pageable pageable);
}
