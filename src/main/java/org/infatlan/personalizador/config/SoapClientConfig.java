package org.infatlan.personalizador.config;
import org.infatlan.personalizador.client.ArticleClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class SoapClientConfig {
	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
		jaxb2Marshaller.setContextPath("com.medium.article");
		return jaxb2Marshaller;
	}

	@Bean
	public ArticleClient articleClient(Jaxb2Marshaller jaxb2Marshaller) {
		ArticleClient articleClient = new ArticleClient();
		articleClient.setDefaultUri("http://150.150.6.221:8081/Autenticacion/webs.aspx?");
		articleClient.setMarshaller(jaxb2Marshaller);
		articleClient.setUnmarshaller(jaxb2Marshaller);
		return articleClient;
	}
}