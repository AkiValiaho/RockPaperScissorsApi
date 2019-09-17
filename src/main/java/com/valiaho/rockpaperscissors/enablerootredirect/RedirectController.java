package com.valiaho.rockpaperscissors.enablerootredirect;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
public class RedirectController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public void method(HttpServletResponse httpServletResponse) {
        httpServletResponse.setHeader("Location", "https://rockpaperscissorsaki.herokuapp.com/swagger-ui.html");
        httpServletResponse.setStatus(302);
    }
}
