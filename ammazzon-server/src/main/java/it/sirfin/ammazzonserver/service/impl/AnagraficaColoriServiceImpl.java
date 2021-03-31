/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sirfin.ammazzonserver.service.impl;

import it.sirfin.ammazzonserver.dto.ColoreDto;
import it.sirfin.ammazzonserver.dto.ListaPagineDto;
import it.sirfin.ammazzonserver.model.VarianteColore;
import it.sirfin.ammazzonserver.repository.VarianteColoreRepository;
import it.sirfin.ammazzonserver.service.AnagraficaColoriService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 *
 * @author manue
 */
@Service
public class AnagraficaColoriServiceImpl implements AnagraficaColoriService {

    static final Logger logger = LoggerFactory.getLogger(AnagraficaColoriServiceImpl.class);

    @Autowired
    VarianteColoreRepository varianteColoreRepository;

    @Override
    public ListaPagineDto<VarianteColore> aggiungiColore(VarianteColore vc, int pagina) {
        varianteColoreRepository.save(vc);
        logger.info("---------------------");
        logger.info("Sono qui" + pagina);
        logger.info("---------------------");
        PageRequest pg = PageRequest.of(pagina, 5);
        Page<VarianteColore> lista = varianteColoreRepository.findAll(pg);
        logger.info("-------------Listtttt--------------");
        logger.info("Sono qui" + lista);
        logger.info("Sono qui" + lista.getContent());
        logger.info("---------------------------");
        return new ListaPagineDto(lista.getContent(), lista.getPageable().getPageNumber(), lista.getTotalPages());

    }

    @Override
    public ListaPagineDto<VarianteColore> aggiornaColori(int pagina) {
        PageRequest pg = PageRequest.of(pagina, 5);
        Page<VarianteColore> colori = varianteColoreRepository.findAll(pg);
//        colori.forEach(c -> {
//            c.setProdottiColori(new ArrayList<>());
//        });
        logger.info("---------------------");
        logger.info("Sono qui" + new ListaPagineDto(colori.getContent(), colori.getPageable().getPageNumber(), colori.getTotalPages()));
        logger.info("---------------------");
        return new ListaPagineDto(colori.getContent(), colori.getPageable().getPageNumber(), colori.getTotalPages());
    }

    @Override
    public ListaPagineDto<VarianteColore> modificaColore(VarianteColore vc, int pagina) {
        varianteColoreRepository.save(vc);
        return aggiornaColori(pagina);
    }

    @Override
    public ListaPagineDto<VarianteColore> ricercaColore(String c, int pagina) {
        if (c.isBlank()) {
            return aggiornaColori(pagina);
        }
        PageRequest pg = PageRequest.of(pagina, 5);
        Page<VarianteColore> lista = varianteColoreRepository.trovaCodice(c, pg);
        return new ListaPagineDto(lista.getContent(), lista.getPageable().getPageNumber(), lista.getTotalPages());
    }

    @Override
    public ListaPagineDto<VarianteColore> rimuoviColore(VarianteColore vc, int pagina) {
        varianteColoreRepository.delete(vc);
        return aggiornaColori(pagina);
    }

    @Override
    public ColoreDto ritornaColore(VarianteColore vc, Integer pageNum, Integer totalPages) {
        return new ColoreDto(vc, pageNum, totalPages);
    }

    @Override
    public ListaPagineDto ritornaRecordPaginati(int pagina) {
        PageRequest pg = PageRequest.of(pagina, 5);
        Page<VarianteColore> lista = varianteColoreRepository.findAll(pg);
        return new ListaPagineDto(lista.getContent(), lista.getPageable().getPageNumber(), lista.getTotalPages());
    }
}
