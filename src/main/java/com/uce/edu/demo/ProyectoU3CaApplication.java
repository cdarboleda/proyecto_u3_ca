package com.uce.edu.demo;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Hotel;
import com.uce.edu.demo.service.IHotelService;

@SpringBootApplication
public class ProyectoU3CaApplication implements CommandLineRunner{

	private static final Logger logger = Logger.getLogger(ProyectoU3CaApplication.class);
	
	@Autowired
	private IHotelService hotelService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU3CaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		//INNER
		logger.info("INNER JOIN");
		List<Hotel> listaHotel = this.hotelService.buscarHotelInnerJoin("Individual");
		listaHotel.stream().forEach(x -> logger.info("Hotel: "+ x.getNombre()+" "+x.getDireccion()));
		
		List<Hotel> listaHotel2 = this.hotelService.buscarHotelInnerJoin();
		listaHotel2.stream().forEach(x -> logger.info("Hotel: "+ x.getNombre()+" "+x.getDireccion()));
		
		//LEFT
		logger.info("LEFT JOIN");
		List<Hotel> listaHotelLeft = this.hotelService.buscarHotelOuterLeftJoin("Individual");
		listaHotelLeft.stream().forEach(x -> logger.info("Hotel: "+ x.getNombre()+" "+x.getDireccion()));
		List<Hotel> listaHotelLeft2 = this.hotelService.buscarHotelOuterLeftJoin();
		listaHotelLeft2.stream().forEach(x -> logger.info("Hotel: "+ x.getNombre()+" "+x.getDireccion()));
		
		//RIGHT
		logger.info("RIGHT JOIN");
		List<Hotel> listaHotelRight = this.hotelService.buscarHotelOuterRightJoin("Individual");
		listaHotelRight.stream().forEach(x -> logger.info("Hotel: "+ x.getNombre()+" "+x.getDireccion()));

	}

}
