package com.seia.brewergestao.config;


import com.seia.brewergestao.Controller.CervejasController;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring6.ISpringTemplateEngine;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;

@Configuration
@ComponentScan(basePackageClasses = {CervejasController.class}) 
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer, ApplicationContextAware {

    private ApplicationContext applicationContext;



    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
    @Bean
    public ViewResolver viewResolver(){
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setTemplateEngine( templateEngine());
        resolver.setCharacterEncoding("UTF-8");
        return resolver;
    }
    @Bean
    public ISpringTemplateEngine templateEngine(){
        SpringTemplateEngine engine = new SpringTemplateEngine();
        engine.setEnableSpringELCompiler(true);
        engine.setTemplateResolver(templateResolver());
        return engine;
    }

    private ITemplateResolver templateResolver(){
        SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
        resolver.setApplicationContext(applicationContext);
        resolver.setPrefix("classpath:/templates/");
        resolver.setTemplateMode(TemplateMode.HTML);
        resolver.setSuffix(".html");
        return resolver;
    }



}
