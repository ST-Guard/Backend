package school.sptech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackages = "school.sptech")
@EnableScheduling
public class SmartDataApp {
    public static void main(String[] args) {
        SpringApplication.run(SmartDataApp.class, args);
    }
}