package com.application.Dictionar.controller;

import com.application.Dictionar.entity.Dictionar;
import com.application.Dictionar.service.DictionarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
public class DictionarController {

    @Autowired
    private DictionarService dictionarService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ApiIgnore
    public void redirectToSwagger(HttpServletResponse response) {
        try {
            response.sendRedirect("/swagger-ui/index.html");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "info", method = RequestMethod.GET)
    public String info(){
        return "Aplicatia functioneaza";
    }

    @RequestMapping(value = "createDictionar", method = RequestMethod.POST)
    public String createDictionar(@RequestBody Dictionar dictionar){
        return dictionarService.createDictionar(dictionar);
    }

    @RequestMapping(value = "readDictionar", method = RequestMethod.GET)
    public List<Dictionar> readDictionar(){
        return dictionarService.readDictionar();
    }

    @RequestMapping(value = "updateDictionar", method = RequestMethod.PUT)
    public String updateDictionar(@RequestBody Dictionar dictionar){
        return dictionarService.updateDictionar(dictionar);
    }

    @RequestMapping(value = "deleteDictionar", method = RequestMethod.DELETE)
    public String deleteDictionar(@RequestBody Dictionar dictionar){
        return dictionarService.deleteDictionar(dictionar);
    }
}
