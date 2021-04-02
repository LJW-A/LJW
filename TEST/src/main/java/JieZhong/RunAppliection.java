package JieZhong;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan(value="JieZhong.dao")
@ComponentScan(basePackages = {"JieZhong.*"})
public class RunAppliection {
    public static void main(String[] args) {
        SpringApplication.run(RunAppliection.class);

    }
}
