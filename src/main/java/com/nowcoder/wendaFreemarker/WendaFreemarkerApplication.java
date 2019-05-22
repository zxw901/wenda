package com.nowcoder.wendaFreemarker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public abstract class WendaFreemarkerApplication {
	public static void main(String[] args) {
		SpringApplication.run(WendaFreemarkerApplication.class, args);
	}
}
