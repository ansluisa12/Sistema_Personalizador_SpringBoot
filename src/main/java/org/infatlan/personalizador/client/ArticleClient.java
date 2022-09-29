package org.infatlan.personalizador.client;

import com.medium.article.WebSExecute;
import com.medium.article.WebSExecuteResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class ArticleClient extends WebServiceGatewaySupport {
    public WebSExecuteResponse getArticle(
            String user,
            String password) {
        WebSExecute websExecute = new WebSExecute();
        websExecute.setVusuario(user);
        websExecute.setVpassword(password);
        return (WebSExecuteResponse) getWebServiceTemplate().marshalSendAndReceive(websExecute);
    }
}