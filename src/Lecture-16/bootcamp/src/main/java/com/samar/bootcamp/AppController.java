package com.samar.bootcamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

// rest-controller contains both response-body and controller annotation,
// so, we can use both of those configurations as replacement of each other
//@RestController
@Controller
@ResponseBody
// it is necessary to serialize response back so that it can be transmitted by HTTP
// internally it uses Jackson serializer
public class AppController {

    @Autowired
    private SmsConfig hostname;

    // if headers="key=sam", are set, then this header will be needed to reach below method
    // this can be used to write different methods for different response-body, example,
    // headers="Accept=application/json" for one method
    // headers="Accept=application/xml" for another
    // after spring 3.1 the same work can be done as produces="application/json"
    // similarly, for headers="Content-Type=application/json" we can write
    // consumes="application/json"
    @RequestMapping(method = RequestMethod.GET, path = "/{id}", produces = "application/json")
    public SmsConfig getHost(@PathVariable int id) {
        System.out.println("id: " + id);
        System.out.println("host-name: " + hostname);
        return hostname;
    }
}
