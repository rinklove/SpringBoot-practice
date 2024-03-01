package hello.servlet.web.frontcontroller.V5;

import hello.servlet.web.frontcontroller.ModelView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface MyHandlerAdapter {

    /**
     * handler는 컨트롤러를 말한다.
     * 어댑터가 해당 컨트롤러를 처리할 수 있는지 판단하는 메서드다.
     * @param handler
     * @return
     */
    boolean supports(Object handler);

    /**
     * 어댑터는 실제 컨트롤러를 호출하고,
     * 그 결과로 ModelView를 반환해야 한다.
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException;
}
