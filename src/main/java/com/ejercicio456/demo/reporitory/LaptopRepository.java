package com.ejercicio456.demo.reporitory;

import com.ejercicio456.demo.entities.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop,Integer> {
}
