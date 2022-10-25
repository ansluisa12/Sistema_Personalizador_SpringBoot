package org.infatlan.personalizador.config;

import javax.sql.DataSource;

import org.infatlan.personalizador.security.EncriptacionKeyIvAES;
import org.infatlan.personalizador.security.util.UtilidadesSeguridad;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.infatlan.personalizador.security.dto.EncriptacionControlDto;

@Configuration

public class DataSourceConfig {
    @Value(value = "${support.retrivial.service1.v1}")
    private String srs1v1;

    @Value(value = "${support.retrivial.service1.v2}")
    private String srs1v2;

    @Value(value = "${support.retrivial.service1.v3}")
    private String srs1v3;

    @Value(value = "${support.retrivial.service1.v4}")
    private String srs1v4;

    @Bean
    public DataSource getDataSource(MyPropertiesConfig myProp, UtilidadesSeguridad us) {
        EncriptacionKeyIvAES enc = new EncriptacionKeyIvAES(new EncriptacionControlDto(us.base64DecodeR(srs1v1),
                us.base64DecodeR(srs1v2), us.base64DecodeR(srs1v3), us.base64DecodeR(srs1v4)));
        DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName(myProp.getDriver().trim());
        dataSourceBuilder.url(enc.decrypt(myProp.getUrl().trim()));
        dataSourceBuilder.username(enc.decrypt(myProp.getUser().trim()));
        dataSourceBuilder.password(enc.decrypt(myProp.getPassword().trim()));
        return dataSourceBuilder.build();
    }
}