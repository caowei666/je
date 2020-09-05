package filter;

import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class AuthExceptionHandler {
    @ExceptionHandler({UnauthorizedException.class}) //验证不通过的时候才会执行
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ModelAndView processUnauthenticatedException(NativeWebRequest request,UnauthorizedException e){
        ModelAndView mv = new ModelAndView();
        mv.addObject("exception",e.getMessage());
        mv.setViewName("error");
        return mv;
    }
}
