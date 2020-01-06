package com.cpe.springbootvue;

import com.cpe.springbootvue.Referral.Entity.*;
import com.cpe.springbootvue.Referral.Repository.*;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Bean
	ApplicationRunner init(ReferralRepository referralRepository, DeliverRepository deliverRepository,
			ForwardTypeRepository forwardTypeRepository, ForwardToRepository forwardToRepository) {
		return args -> {

                       
                        Stream.of("ส่งจาก CUP", "ส่งในจังหวัด", "ส่งนอกจังหวัด").forEach(forwardType -> {
						ForwardType f = new ForwardType();
						f.setForwardType(forwardType);
						forwardTypeRepository.save(f);
					});
			forwardTypeRepository.findAll().forEach(System.out::println);


                        Stream.of("โรงพยาบาลเทคโนโลยีสุรนารี", "โรงพยาบาลมหาราชนครราชสีมา", "โรงพยาบาลค่ายสุรนารี", "โรงพยาบาลป.แพทย์2", "โรงพยาบาลกรุงเทพราชสีมา").forEach(forwardTo -> {
						ForwardTo t = new ForwardTo();
						t.setForwardTo(forwardTo);
						forwardToRepository.save(t);
					});
			forwardToRepository.findAll().forEach(System.out::println);


                        Stream.of("รับไว้รักษาต่อ", "เกิดภาวะแทรกซ้อน", "ไม่สามารถรักษาได้").forEach(deliver -> {
						Deliver d = new Deliver();
						d.setDeliver(deliver);
						deliverRepository.save(d);
					});
			deliverRepository.findAll().forEach(System.out::println);


		};

	}
}

