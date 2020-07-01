package ru.sb.api.accumulation;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccumulationRepository extends JpaRepository<Accumulation, Integer> {

    Page<Accumulation> findByOwnerId(int ownerId, Pageable pageable);

}
