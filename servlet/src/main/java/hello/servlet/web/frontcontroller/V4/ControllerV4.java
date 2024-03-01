package hello.servlet.web.frontcontroller.V4;

import java.util.Map;


public interface ControllerV4 {
    /**
     *
     * @param paramMap
     * @param model
     * @return
     */
    String process(Map<String, String> paramMap, Map<String, Object> model);
}
