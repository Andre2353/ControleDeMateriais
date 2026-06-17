package com.biolab.controledemateriasis.Repository;

import com.biolab.controledemateriasis.entities.Materiais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MateriaisRepository extends JpaRepository<Materiais, Long> {

}
