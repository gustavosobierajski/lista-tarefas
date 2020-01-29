package br.com.desafiojava;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
 
import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.models.dto.ApiInfo;
import com.mangofactory.swagger.plugin.EnableSwagger;
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;
 
@Configuration // Define a classe como classe de configuração
@EnableAutoConfiguration // Habilita a autoconfiguração
@EnableSwagger //Habilita o Swagger
@ComponentScan(basePackages = {"br.com.desafiojava"}) //Escaneia todos os pacotes com o padrão br.com.desafiojava
public class Application {
     
    //Injeta uma instancia de SpringSwaggerConfig
    @Autowired
    private SpringSwaggerConfig swaggerConfig;
     
    public static void main(String[] args) {
           //Troque esta linha SpringApplication.run(Application.class, args); pela linha abaixo
           new SpringApplicationBuilder(Application.class).web(true).run(args);
    }
     
    @Bean
    public SwaggerSpringMvcPlugin groupOnePlugin() {
       return new SwaggerSpringMvcPlugin(swaggerConfig)
            //Adiciona as configurações do Swagger ao SwaggerSpringMvcPlugin 
           .apiInfo(apiInfo()) //Adiciona as propriedades de configuração
           .includePatterns("/tarefa.*?") //Habilita o Swagger para o endpoints
           .swaggerGroup("admin");
    }
     
    private ApiInfo apiInfo() {
       ApiInfo apiInfo = new ApiInfo( //Configurações de contato, licença etc não nescessáriamente precisa ser definida
             "Swagger With Spring Boot",
             "Desafio Java - Task List ",
             "Free to use",
             "gustavosobierajski@gmail.com",
             "Open Licence",
             "gustavosobierajski@gmail.com"
       );
       return apiInfo;
    }
}