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
import java.text.DecimalFormat;
import java.text.NumberFormat;
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

        coloreTagliaRepository.deleteAllInBatch();
        prodottoColoreRepository.deleteAllInBatch();
        varianteTagliaRepository.deleteAllInBatch();
        varianteColoreRepository.deleteAllInBatch();
        prodottoRepository.deleteAllInBatch();

        //////////creazione utenti////////
        UtenteRegistrato ur1 = new UtenteRegistrato("Nico", "Aba", "nic", "fuck", "2345678", "jhgfds", new ArrayList<>());
        ur1 = utenteRegistratoRepository.save(ur1);
        UtenteRegistrato ur2 = new UtenteRegistrato("Franco", "Marzio", "xxx", "123", "98761234", "qw", new ArrayList<>());
        ur2 = utenteRegistratoRepository.save(ur2);
        UtenteRegistrato ur3 = new UtenteRegistrato("Pippo", "Pluto", "fff", "789", "6546546645", "za", new ArrayList<>());
        ur3 = utenteRegistratoRepository.save(ur3);

        //////////creazione colori////////
        VarianteColore vcBlu = new VarianteColore("b1", "blu", new ArrayList<>());
        vcBlu = varianteColoreRepository.save(vcBlu);
        VarianteColore vcRosso = new VarianteColore("r1", "rosso", new ArrayList<>());
        vcRosso = varianteColoreRepository.save(vcRosso);
        VarianteColore vcGiallo = new VarianteColore("g1", "giallo", new ArrayList<>());
        vcGiallo = varianteColoreRepository.save(vcGiallo);

        //////////creazione taglia////////
        VarianteTaglia vtS = new VarianteTaglia("S", new ArrayList<>());
        vtS = varianteTagliaRepository.save(vtS);
        VarianteTaglia vtM = new VarianteTaglia("M", new ArrayList<>());
        vtM = varianteTagliaRepository.save(vtM);
        VarianteTaglia vtL = new VarianteTaglia("L", new ArrayList<>());
        vtL = varianteTagliaRepository.save(vtL);

        ///////////creazione 1000 prodotti////////
        Prodotto p1 = new Prodotto();
        int limite = 100;
        NumberFormat formatter = new DecimalFormat("#0.00");
        for (int i = 0; i < limite; i++) {
            double random = Math.random() * (1000 - 10 + 1) + 10;
            String pf = formatter.format(random);
            double prezzoFormattato = Double.parseDouble("10.33");
            p1 = new Prodotto("p" + i, "t-shirt", prezzoFormattato, new ArrayList<>());
            p1 = prodottoRepository.save(p1);
        }
        associaProdottoColore(p1, vcGiallo, vtS);
        associaProdottoColore(p1, vcGiallo, vtM);
        associaProdottoColore(p1, vcRosso, vtL);
        associaProdottoColore(p1, vcBlu, vtM);
        associaProdottoColore(p1, vcBlu, vtL);
        //List<Prodotto> prodotti = prodottoRepository.cercaProdottiTagliaM();
//        prodotti.forEach(r -> {
//            System.out.println(r);
//        });

    }
    ///////////ASSOCIAZIONI//////////////////
    //////Prodotti con id % 3 == 0 -> 1 colore e 2 taglie/////////////

    private void associaProdottoColore(Prodotto p, VarianteColore vc, VarianteTaglia vt) {
        ProdottoColore pc = new ProdottoColore(new ArrayList<ColoreTaglia>(), vc, p);
        pc.setProdotto(p);
        pc.setVarianteColore(vc);
        pc = prodottoColoreRepository.save(pc);
        p.getProdottiColori().add(pc);
        vc.getProdottiColori().add(pc);
        prodottoRepository.save(p);
        varianteColoreRepository.save(vc);
        associaProdottoTaglie(pc, vt);
    }

    private void associaProdottoTaglie(ProdottoColore pc, VarianteTaglia vt) {
        ColoreTaglia ct = new ColoreTaglia();
        ct.setProdottoColore(pc);
        ct.setVarianteTaglia(vt);
        ct = coloreTagliaRepository.save(ct);
        pc.getColoriTaglie().add(ct);
        vt.getColoriTaglie().add(ct);
        pc = prodottoColoreRepository.save(pc);
        vt = varianteTagliaRepository.save(vt);

    }

}
