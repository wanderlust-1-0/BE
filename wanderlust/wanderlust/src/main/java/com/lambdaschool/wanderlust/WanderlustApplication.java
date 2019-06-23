package com.lambdaschool.wanderlust;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class WanderlustApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(WanderlustApplication.class, args);
    }

}
