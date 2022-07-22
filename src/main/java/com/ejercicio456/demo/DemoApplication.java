package com.ejercicio456.demo;

import com.ejercicio456.demo.entities.Laptop;
import com.ejercicio456.demo.reporitory.LaptopRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

	ApplicationContext context= SpringApplication.run(DemoApplication.class, args);
		LaptopRepository repo=context.getBean(LaptopRepository.class);

		//creo laptop
		Laptop laptop=new Laptop(null,"asus",2022);
		Laptop laptop2=new Laptop(2,"lenovo",2022);

		repo.save(laptop);
		repo.save(laptop2);

	}

}
