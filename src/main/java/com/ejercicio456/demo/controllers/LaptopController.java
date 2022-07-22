package com.ejercicio456.demo.controllers;

import com.ejercicio456.demo.entities.Laptop;
import com.ejercicio456.demo.reporitory.LaptopRepository;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class LaptopController {
	@Autowired
	private LaptopRepository repo;

	Logger log = org.slf4j.LoggerFactory.getLogger(LaptopController.class);

	// Entrega ejercicios 7, 8 y 9
	/*
	 * Implementar los métodos CRUD en el API REST de Laptop creada en ejercicios
	 * anteriores.
	 * 
	 * Los métodos CRUD: findAll() findOneById() create() update() delete()
	 * deleteAll()
	 */
	@ApiOperation("Muestra todas las laptops en la base de datos")
	@GetMapping("/api/laptops")
	public List<Laptop> findAll() {
		return repo.findAll();
	}

	@ApiOperation("Ingrese un id para encontrar la laptop en la BD")
	@GetMapping("/api/laptops/{id}")
	public ResponseEntity<Laptop> findOneById(@ApiParam("agregue parametro tipo Integer") @PathVariable Integer id) {
		Optional<Laptop> laptop = repo.findById(id);
		if (laptop.get().getId() == null) {
			log.warn("No aparece ese Id en la Base de datos");
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(laptop.get());
	}

	@ApiOperation("agregue los atributos marca y año para agregar la nueva laptop")
	@PostMapping("/api/laptops")
	public ResponseEntity<Laptop> create(@RequestBody Laptop laptop) {
		return ResponseEntity.ok(repo.save(laptop));
	}
	@ApiOperation("actualice los datos de la laptop")
	@PutMapping("/api/laptops")
	public ResponseEntity<Laptop> update(@RequestBody Laptop laptop) {
		if (laptop.getId() == null) {
			log.warn("datos incorrectos");
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(repo.save(laptop));
	}
	@ApiOperation("especifique el id para borrar la laptop")
	@DeleteMapping("/api/laptops/{id}")
	public ResponseEntity<Laptop> delete(@PathVariable Integer id) {
		Optional<Laptop> laptop = repo.findById(id);
		if (laptop.get().getId() == null) {
			log.warn("datos incorrectos, no aparece en la BD");
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(repo.save(laptop.get()));
	}
	@ApiOperation("eliminara todas las laptops")
@DeleteMapping("/api/laptops/")
	public ResponseEntity<Laptop> deleteAll() {
		repo.deleteAll();
		return ResponseEntity.noContent().build();

	}

}
