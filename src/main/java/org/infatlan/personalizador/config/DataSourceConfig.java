package org.infatlan.personalizador.config;

import javax.sql.DataSource;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfig {

@Bean
public DataSource getDataSource(MyPropertiesConfig myProp) {
DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
dataSourceBuilder.driverClassName(myProp.getDriver().trim());
dataSourceBuilder.url(myProp.getUrl().trim());
dataSourceBuilder.username(myProp.getUser().trim());
dataSourceBuilder.password(myProp.getPassword().trim());
return dataSourceBuilder.build();
}
}