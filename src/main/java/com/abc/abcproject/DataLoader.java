package com.abc.abcproject;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.abc.abcproject.dao.FlightDetailsRepository;
import com.abc.abcproject.domain.FlightDetails;

@Configuration
public class DataLoader {
	
	private static final Logger log = LoggerFactory.getLogger(DataLoader.class);

	@Bean
	CommandLineRunner initDatabase(FlightDetailsRepository repository) {

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat tf = new SimpleDateFormat("HH:mm:ss");

		return args -> {
			log.info("Preloading " + repository.save(new FlightDetails("EK400", "MNL", "CMB", df.parse("2021-08-06"), tf.parse("01:30:00"), df.parse("2021-08-06"), tf.parse("10:50:00"))));
			log.info("Preloading " + repository.save(new FlightDetails("EK400", "MNL", "CMB", df.parse("2021-08-08"), tf.parse("01:30:00"), df.parse("2021-08-08"), tf.parse("10:50:00"))));
			log.info("Preloading " + repository.save(new FlightDetails("EK400", "CMB", "MNL", df.parse("2021-08-07"), tf.parse("06:30:00"), df.parse("2021-08-07"), tf.parse("4:50:00"))));
			log.info("Preloading " + repository.save(new FlightDetails("EK400", "CMB", "MNL", df.parse("2021-08-08"), tf.parse("01:30:00"), df.parse("2021-08-08"), tf.parse("4:50:00"))));
			log.info("Preloading " + repository.save(new FlightDetails("EK450", "SYD", "MNL", df.parse("2021-08-07"), tf.parse("00:30:00"), df.parse("2021-08-07"), tf.parse("12:30:00"))));
			log.info("Preloading " + repository.save(new FlightDetails("EK450", "SYD", "MNL", df.parse("2021-08-08"), tf.parse("00:30:00"), df.parse("2021-08-08"), tf.parse("12:30:00"))));
			log.info("Preloading " + repository.save(new FlightDetails("EK450", "MNL", "SYD", df.parse("2021-08-07"), tf.parse("04:30:00"), df.parse("2021-08-07"), tf.parse("02:50:00"))));
			log.info("Preloading " + repository.save(new FlightDetails("EK450", "MNL", "SYD", df.parse("2021-08-08"), tf.parse("04:30:00"), df.parse("2021-08-08"), tf.parse("02:50:00"))));
			log.info("Preloading " + repository.save(new FlightDetails("QF200", "MNL", "BNE", df.parse("2021-08-07"), tf.parse("03:40:00"), df.parse("2021-08-07"), tf.parse("06:00:00"))));
			log.info("Preloading " + repository.save(new FlightDetails("QF200", "MNL", "BNE", df.parse("2021-08-08"), tf.parse("03:40:00"), df.parse("2021-08-08"), tf.parse("06:00:00"))));
			log.info("Preloading " + repository.save(new FlightDetails("CX212", "CMB", "MNL", df.parse("2021-08-07"), tf.parse("06:30:00"), df.parse("2021-08-07"), tf.parse("04:50:00"))));
			log.info("Preloading " + repository.save(new FlightDetails("CX212", "CMB", "MNL", df.parse("2021-08-08"), tf.parse("06:30:00"), df.parse("2021-08-08"), tf.parse("04:50:00"))));
			log.info("Preloading " + repository.save(new FlightDetails("CX450", "SYD", "PER", df.parse("2021-08-07"), tf.parse("00:30:00"), df.parse("2021-08-07"), tf.parse("12:30:00"))));
			log.info("Preloading " + repository.save(new FlightDetails("CX450", "SYD", "PER", df.parse("2021-08-08"), tf.parse("00:30:00"), df.parse("2021-08-08"), tf.parse("12:30:00"))));

		};
	}

}
