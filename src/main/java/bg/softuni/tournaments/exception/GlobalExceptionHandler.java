package bg.softuni.tournaments.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(IllegalArgumentException.class)
    public ModelAndView handleBusinessExceptions(IllegalArgumentException ex) {
        ModelAndView modelAndView = new ModelAndView("error-page");
        modelAndView.addObject("errorMessage", ex.getMessage());
        return modelAndView;
    }
}