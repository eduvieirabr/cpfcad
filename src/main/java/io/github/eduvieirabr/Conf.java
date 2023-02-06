package io.github.eduvieirabr;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Conf {
    @Bean(name = "applicationName")
    public String applicationName() {
        return "Cadastro de CPF";
    }
}
