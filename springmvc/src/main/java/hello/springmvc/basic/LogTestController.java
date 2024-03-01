package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


//데이터가 반환
//@Controller는 ok라는 이름의 viewName이 반환
@RestController
@Slf4j //16번째 라인 자동 생성
public class LogTestController {

//    private final Logger log = LoggerFactory.getLogger(getClass());

    @GetMapping("/log-test")
    public String logTest() {
        String name = "Spring";

        //개발 단계에서는 debug or trace로, 운영단계에서는 info 단계로 설정
        //상위 범위는 하위 범위를 포함함
        //ex) logging.level을 info로 설정하면 info 아래 log만 남음
        //default는 info단계임
        //절대 + 연산으로 하지 말것, 자원 사용됨
        log.trace("trace log = {}", name);
        log.debug("debug log = {}", name);
        log.info(" info log = {}", name);
        log.warn("warn log = {}", name);
        log.error("error log = {}", name);
        return  "ok";
    }
}
