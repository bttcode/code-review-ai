package vn.bow.petprj.codereview;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class CodeReviewAiApplication {

    public static void main(String[] args) {
        SpringApplication.run(CodeReviewAiApplication.class, args);
    }
}