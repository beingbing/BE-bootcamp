package com.samar.bootcamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AppController {

    @Autowired
    private SmsConfig hostname;

    @RequestMapping(method = RequestMethod.GET, path = "/{id}", produces = "application/json")
    public SmsConfig getHost(@PathVariable int id) {
        return hostname;
    }
}
