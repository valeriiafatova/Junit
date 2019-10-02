package com.payment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringBootConsoleApplication implements CommandLineRunner {
    App app = new App();
    private static Logger LOG = LoggerFactory
            .getLogger(SpringBootConsoleApplication.class);

    public static void main(String[] args) {
        LOG.info("STARTING THE APPLICATION");
        ConfigurableApplicationContext context = SpringApplication.run(SpringBootConsoleApplication.class, args);
        App bean = context.getBean(App.class);
        LOG.info("App : " + bean);
        bean.processPayment();
        LOG.info("APPLICATION FINISHED");
    }

    @Override
    public void run(String... args) throws Exception {
        //app.processPayment();
    }
}
