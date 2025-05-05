package com.RMI.Subcription.configurations;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        Server ngrokServer=new Server();
        ngrokServer.setUrl("https://827e-129-0-60-43.ngrok-free.app/");
        return new OpenAPI()
                .info(new Info()
                        .title("Subscription Management API")
                        .version("1.0")
                        .description("API for managing subscriptions and payments")
                        .contact(new Contact()
                                .name("Yann BIKO")
                                .email("yannbiko@gmail.com"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://www.apache.org/licenses/LICENSE-2.0.html")))
                        .addServersItem(ngrokServer);
    }
}
