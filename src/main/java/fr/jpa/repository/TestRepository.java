package fr.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.jpa.model.Test;

@Repository
public interface TestRepository extends JpaRepository<Test, Integer> {

}
