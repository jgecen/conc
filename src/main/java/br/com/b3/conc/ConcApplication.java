package br.com.b3.conc;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

@SpringBootApplication
public class ConcApplication {

	@Value("${datasource.username}")
	String username;

	@Value("${datasource.password}")
	String password;

	@Value("${datasource.jdbcUrl}")
	String jdbcUrl;

	public static void main(String[] args) {
		SpringApplication.run(ConcApplication.class, args);
	}

	@Bean
	@Primary
	public DataSource dataSource() {
		System.out.println("username: " + username);
		System.out.println("password: " + password);
		System.out.println("jdbcUrl: " + jdbcUrl);
		return DataSourceBuilder.create().password(password + "gres").url(jdbcUrl).username(username + "gres").build();
	}

}
