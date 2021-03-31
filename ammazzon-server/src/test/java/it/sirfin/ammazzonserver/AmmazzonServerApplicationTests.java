package it.sirfin.ammazzonserver;

import it.sirfin.ammazzonserver.model.Prodotto;
import it.sirfin.ammazzonserver.repository.ProdottoRepository;
import it.sirfin.ammazzonserver.service.AnagraficaProdottoService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;

@SpringBootTest
class AmmazzonServerApplicationTests {
    
    static final Logger logger = LoggerFactory.getLogger(AmmazzonServerApplicationTests.class);

    @Autowired
    AnagraficaProdottoService anagraficaProdottoService;

    @Autowired
    ProdottoRepository prodottoRepository;

    @BeforeAll
    static void setupIniziale() {
        System.out.println("Siamo in setupIniziale");
        logger.debug("Siamo in setupIniziale");
    }

    @BeforeEach
    void init() {
        System.out.println("Siamo in init");
        logger.info("Siamo in init");
    }

    @AfterAll
    static void housekeepingFinale() {
        System.out.println("Siamo in housekeepingFinale");
        logger.warn("Siamo in housekeepingFinale");
    }

    @AfterEach
    void clean() {
        System.out.println("Siamo in clean");
        logger.error("Siamo in clean");
    }

    @Test
    void contextLoads() {
        System.out.println("Siamo in contextLoads");
    }

    @Test
    void test1() {
        var p1 = new Prodotto();
        p1.setCodice("p1");

        var prod1 = prodottoRepository.findAll(Example.of(p1));
        var result = prodottoRepository.findById(prod1.get(0).getId());

//        var result2 = prodottoRepository.count(Example.of(p1));

        // verifico il criterio di accettazione
        Assertions.assertEquals(result.get().getId(), prod1.get(0).getId());
    }

    @Test
    void test2() {
        System.out.println("Siamo in test2");
    }
}
