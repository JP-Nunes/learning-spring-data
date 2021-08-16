package com.alura.spring.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.alura.spring.data.orm.Cargo;

@Repository
public interface CargoRepository extends CrudRepository<Cargo, Integer> {

}
