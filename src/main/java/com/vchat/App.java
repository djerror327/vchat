package com.vchat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author tjayasekara on 11/4/2019
 * @project applicationpropertiesdemo
 **/

//@ComponentScan("com.vchat.cat_controller")
//@ComponentScan("com.vchat.chat_model")
//@ComponentScan("com.vchat.config")
@SpringBootApplication
public class App {
    public static void main(String[] args) {

        SpringApplication.run(App.class, args);
    }
}
