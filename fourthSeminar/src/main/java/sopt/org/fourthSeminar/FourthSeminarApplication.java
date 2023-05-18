package sopt.org.fourthSeminar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing //JPA Entity 객체가 생성이 되거나 변경이 되었을 때 자동으로 값 등록
@SpringBootApplication
public class FourthSeminarApplication {

	public static void main(String[] args) {
		SpringApplication.run(FourthSeminarApplication.class, args);
	}

}
