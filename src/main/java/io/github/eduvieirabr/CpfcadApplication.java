package io.github.eduvieirabr;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class CpfcadApplication {

    public static void main(String[] args) {
        SpringApplication.run(CpfcadApplication.class, args);
    }
}
