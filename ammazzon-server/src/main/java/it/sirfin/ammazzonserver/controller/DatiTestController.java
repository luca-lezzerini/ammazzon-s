/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sirfin.ammazzonserver.controller;

import it.sirfin.ammazzonserver.service.DatiTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class DatiTestController {

    @Autowired
    DatiTestService datiTestService;

    @RequestMapping("dati-test")
    public void datiTest() {
        datiTestService.datiTest();
    }

    @RequestMapping("query-test1")
    void queryTest1() {
        datiTestService.queryTest1();
    }

    @RequestMapping("query-test2")
    void queryTest2() {
        datiTestService.queryTest2();
    }

    @RequestMapping("query-test3")
    void queryTest3() {
        datiTestService.queryTest3();
    }

    @RequestMapping("query-test4")
    void queryTest4() {
        datiTestService.queryTest4();
    }

}
