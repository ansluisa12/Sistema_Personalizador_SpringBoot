package org.infatlan.personalizador.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
@Configuration
@PropertySource(value = { "file:C:\\PersonalizadorConfig\\PersonalizadorConfig.properties" })
public class MyPropertiesConfig {

	@Value("${jdbc.driver}")
	String driver;

	@Value("${url}")
	String url;

	@Value("${userdb}")
	String user;

	@Value("${password}")
	String password;
}
