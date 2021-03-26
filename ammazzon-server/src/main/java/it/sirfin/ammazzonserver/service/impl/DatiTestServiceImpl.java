package it.sirfin.ammazzonserver.service.impl;

import it.sirfin.ammazzonserver.model.ColoreTaglia;
import it.sirfin.ammazzonserver.model.Prodotto;
import it.sirfin.ammazzonserver.model.ProdottoColore;
import it.sirfin.ammazzonserver.model.UtenteRegistrato;
import it.sirfin.ammazzonserver.model.VarianteColore;
import it.sirfin.ammazzonserver.model.VarianteTaglia;
import it.sirfin.ammazzonserver.repository.ColoreTagliaRepository;
import it.sirfin.ammazzonserver.repository.OrdineRepository;
import it.sirfin.ammazzonserver.repository.ProdottoColoreRepository;
import it.sirfin.ammazzonserver.repository.ProdottoRepository;
import it.sirfin.ammazzonserver.repository.QtaOrdineVarianteRepository;
import it.sirfin.ammazzonserver.repository.UtenteAnonimoRepository;
import it.sirfin.ammazzonserver.repository.UtenteRegistratoRepository;
import it.sirfin.ammazzonserver.repository.VarianteColoreRepository;
import it.sirfin.ammazzonserver.repository.VarianteTagliaRepository;
import it.sirfin.ammazzonserver.service.DatiTestService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DatiTestServiceImpl implements DatiTestService {

    /////////////////////////////////////////////////////////////////////////
    /////////////////////////DATI TEST///////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////
    @Autowired
    UtenteRegistratoRepository utenteRegistratoRepository;
    @Autowired
    ProdottoRepository prodottoRepository;
    @Autowired
    VarianteColoreRepository varianteColoreRepository;
    @Autowired
    VarianteTagliaRepository varianteTagliaRepository;
    @Autowired
    ColoreTagliaRepository coloreTagliaRepository;
    @Autowired
    OrdineRepository ordineRepository;
    @Autowired
    ProdottoColoreRepository prodottoColoreRepository;
    @Autowired
    QtaOrdineVarianteRepository qtaOrdineVarianteRepository;
    @Autowired
    UtenteAnonimoRepository utenteAnonimoRepository;

    @Override
    public void datiTest() {

        //////////creazione utenti////////
        UtenteRegistrato ur1 = new UtenteRegistrato("Nico", "Aba", "nic", "fuck", "2345678", "jhgfds", new ArrayList<>());
        ur1 = utenteRegistratoRepository.save(ur1);
        UtenteRegistrato ur2 = new UtenteRegistrato("Franco", "Marzio", "xxx", "123", "98761234", "qw", new ArrayList<>());
        ur2 = utenteRegistratoRepository.save(ur2);
        UtenteRegistrato ur3 = new UtenteRegistrato("Pippo", "Pluto", "fff", "789", "6546546645", "za", new ArrayList<>());
        ur3 = utenteRegistratoRepository.save(ur3);

        //////////creazione colori////////
        VarianteColore vc1 = new VarianteColore("b1", "blu", new ArrayList<>());
        vc1 = varianteColoreRepository.save(vc1);
        VarianteColore vc2 = new VarianteColore("r1", "rosso", new ArrayList<>());
        vc2 = varianteColoreRepository.save(vc2);
        VarianteColore vc3 = new VarianteColore("g1", "giallo", new ArrayList<>());
        vc3 = varianteColoreRepository.save(vc3);

        //////////creazione taglia////////
        VarianteTaglia vt1 = new VarianteTaglia("S", new ArrayList<>());
        vt1 = varianteTagliaRepository.save(vt1);
        VarianteTaglia vt2 = new VarianteTaglia("M", new ArrayList<>());
        vt2 = varianteTagliaRepository.save(vt2);
        VarianteTaglia vt3 = new VarianteTaglia("L", new ArrayList<>());
        vt3 = varianteTagliaRepository.save(vt3);

        ///////////creazione 1000 prodotti////////
        int limite = 1000;
        for (int i = 0; i < limite; i++) {
            Prodotto p1 = new Prodotto("p1", "t-shirt", 21.0, new ArrayList<>());
            p1 = prodottoRepository.save(p1);
        }
        ///////////ASSOCIAZIONI//////////////////
        //////Prodotti con id % 3 == 0 -> 1 colore e 2 taglie/////////////
    private void associaProdottoColore(Prodotto p, VarianteColore vc) {
        ProdottoColore pc = new ProdottoColore(new ArrayList<ColoreTaglia>(), vc, p);
        pc.setProdotto(p);
        pc.setVarianteColore(vc);
        pc = prodottoColoreRepository.save(pc);
        p.getProdottiColori().add(pc);
        vc.getProdottiColori().add(pc);
        prodottoRepository.save(p);
        varianteColoreRepository.save(vc);
    }

}
