/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sirfin.ammazzonserver.service.impl;

import it.sirfin.ammazzonserver.dto.ColoreDto;
import it.sirfin.ammazzonserver.dto.ListaColoriDto;
import it.sirfin.ammazzonserver.dto.ListaPagineDto;
import it.sirfin.ammazzonserver.model.VarianteColore;
import it.sirfin.ammazzonserver.repository.VarianteColoreRepository;
import it.sirfin.ammazzonserver.service.AnagraficaColoriService;
import java.util.ArrayList;
import java.util.List;
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

    @Autowired
    VarianteColoreRepository varianteColoreRepository;

    @Override
    public ListaColoriDto aggiungiColore(VarianteColore vc) {
        varianteColoreRepository.save(vc);
        return aggiornaColori();

    }

    @Override
    public ListaColoriDto aggiornaColori() {
        List<VarianteColore> colori = varianteColoreRepository.findAll();
        colori.forEach(c -> {
            c.setProdottiColori(new ArrayList<>());
        });
        return new ListaColoriDto(colori);
    }

    @Override
    public ListaColoriDto modificaColore(VarianteColore vc) {
        varianteColoreRepository.save(vc);
        return aggiornaColori();
    }

    @Override
    public ListaColoriDto ricercaColore(String c) {
        if (c.isBlank()) {
            return aggiornaColori();
        }
        return new ListaColoriDto(varianteColoreRepository.trovaCodice(c));
    }

    @Override
    public ListaColoriDto rimuoviColore(VarianteColore vc) {
        varianteColoreRepository.delete(vc);
        return aggiornaColori();
    }

    @Override
    public ColoreDto ritornaColore(VarianteColore vc) {
        return new ColoreDto(vc);
    }

    @Override
    public ListaPagineDto ritornaRecordPaginati(int pagina) {
        PageRequest pg = PageRequest.of(pagina, 5);
        Page<VarianteColore> lista = varianteColoreRepository.findAll(pg);
        return new ListaPagineDto(lista.getContent(), lista.getPageable().getPageNumber(), lista.getTotalPages());
    }
}
