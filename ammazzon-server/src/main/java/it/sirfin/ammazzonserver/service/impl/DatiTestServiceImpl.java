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

import java.util.ArrayList;
import java.util.List;
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
        UtenteRegistrato ur1 = new UtenteRegistrato("Felice", "Capponi", "fc", "dskjfhk", "dfskjh", "374s");
        ur1 = utenteRegistratoRepository.save(ur1);
        UtenteRegistrato ur2 = new UtenteRegistrato("Marco", "Antoniolo", "ma", "dhsjjy", "uyrurt", "3655s");
        ur2 = utenteRegistratoRepository.save(ur2);
        UtenteRegistrato ur3 = new UtenteRegistrato("Antonio", "Rossi", "ar", "lpklpjk", "khnkhj", "678s");
        ur3 = utenteRegistratoRepository.save(ur3);

        //////////creazione colori////////
        VarianteColore vcBlu = new VarianteColore("b1", "blu");
        vcBlu = varianteColoreRepository.save(vcBlu);
        VarianteColore vcRosso = new VarianteColore("r1", "rosso");
        vcRosso = varianteColoreRepository.save(vcRosso);
        VarianteColore vcGiallo = new VarianteColore("g1", "giallo");
        vcGiallo = varianteColoreRepository.save(vcGiallo);

        //////////creazione taglia////////
        VarianteTaglia tagliaS = new VarianteTaglia("S");
        tagliaS = varianteTagliaRepository.save(tagliaS);
        VarianteTaglia tagliaM = new VarianteTaglia("M");
        tagliaM = varianteTagliaRepository.save(tagliaM);
        VarianteTaglia tagliaL = new VarianteTaglia("L");
        tagliaL = varianteTagliaRepository.save(tagliaL);

        ///////////creazione 1000 prodotti////////
        Prodotto p = new Prodotto();
        int limite = 10;
        int contatore1 = 0;
        int contatore2 = 0;
        int contatore3 = 0;
        for (int i = 0; i < limite; i++) {

            //Generazione prezzo casuale per prodotto con formattatore
            DecimalFormat formatter = new DecimalFormat("###,##");
            Double random = Math.random() * (1000 - 10 + 1) + 10;
            String pf = formatter.format(random);
            Double prezzoFormattato = Double.valueOf(pf);

            p = new Prodotto("p" + i, "t-shirt", prezzoFormattato);
            p = prodottoRepository.save(p);
            System.out.println("id " + p.getCodice() + " = " + p.getId());
            //Prodotti con id % 3 == 0 -> 1 colore e 2 taglie
            if (i % 3 == 0) {
                contatore1++;
                p.setDescrizione("PANTALONE");
                //Ottengo un pantalone Blu
                ProdottoColore pantaloneBlu = associaProdottoColore(p, vcBlu);
                //pantalone/blu/S
                associaProdottoColoreTaglia(pantaloneBlu, tagliaS);
                //pantalone/blu/M
                associaProdottoColoreTaglia(pantaloneBlu, tagliaM);
                //Prodotti con id % 3 == 1 -> 1 colore e tre taglie 
            }

            //Prodotti con id % 3 == 1 -> 1 colore e tre taglie
            if (i % 3 == 1) {
                contatore2++;
                p.setDescrizione("T-SHIRT");
                //Ottengo una t-shirt gialla
                ProdottoColore tShirtGialla = associaProdottoColore(p, vcGiallo);
                //t-shirt/gialla/S
                associaProdottoColoreTaglia(tShirtGialla, tagliaS);
                //t-shirt/gialla/M
                associaProdottoColoreTaglia(tShirtGialla, tagliaM);
                //t-shirt/gialla/L
                associaProdottoColoreTaglia(tShirtGialla, tagliaL);
            }

            if (i % 3 == 2) {
                contatore3++;
                p.setDescrizione("CAPPELLO");
                //Ottengo un cappello rosso
                ProdottoColore cappelloRosso = associaProdottoColore(p, vcRosso);
                //cappello/rosso/S
                associaProdottoColoreTaglia(cappelloRosso, tagliaS);
                //cappello/rosso/M
                associaProdottoColoreTaglia(cappelloRosso, tagliaM);
                //cappello/rosso/L
                associaProdottoColoreTaglia(cappelloRosso, tagliaL);

                //Ottengo un cappello giallo
                ProdottoColore cappelloGiallo = associaProdottoColore(p, vcGiallo);
                //cappello/Giallo/S
                associaProdottoColoreTaglia(cappelloGiallo, tagliaS);
                //cappello/Giallo/M
                associaProdottoColoreTaglia(cappelloGiallo, tagliaM);
                //cappello/Giallo/L
                associaProdottoColoreTaglia(cappelloGiallo, tagliaL);
            }
        }
        System.out.println("numero Pantaloni creati = " + contatore1);
        System.out.println("numero t-shirt create = " + contatore2);
        System.out.println("numero cappelli creati = " + contatore3);
        System.out.println("totale prodotti creati su DB = " + prodottoRepository.findAll().size());
    }

    @Override
    public void queryTest1() {
        List<ProdottoColore> lista = prodottoColoreRepository.ProdottiGialli();
        lista.forEach(l -> System.out.println(l));
    }

    @Override
    public void queryTest2() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void queryTest3() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void queryTest4() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    

    ///////////ASSOCIAZIONI//////////////////
    /*
    1) Far ritornare al primo metodo(associaProdottoColore) un ProdottoColore; 
    successivamente associare un ProdottoColore a una varianteTaglia. 
   
    Prodotti con id % 3 == 0 -> 1 colore e 2 taglie     => PANTALONE
            pantalone/blu{
                pantalone/blu/S
                pantalone/blu/M
            }
    
    Prodotti con id % 3 == 1 -> 1 colore e tre taglie   => T-SHIRT
    t-shirt/gialla{
                t-shirt/gialla/S
                t-shirt/gialla/M
                t-shirt/gialla/L
            }
    Prodotti con id % 3 == 2 -> 2 colori e tre taglie per colore   =>  CAPPELLO
            cappello/rosso{
                cappello/rosso/S
                cappello/rosso/M
                cappello/rosso/L
            }
            cappello/giallo{
                cappello/giallo/S
                cappello/giallo/M
                cappello/giallo/L
    }
     */
    private ProdottoColore associaProdottoColore(Prodotto p, VarianteColore vc) {
        ProdottoColore pc = new ProdottoColore(vc, p);
        pc.setProdotto(p);
        pc.setVarianteColore(vc);
        pc = prodottoColoreRepository.save(pc);
        p.getProdottiColori().add(pc);
        vc.getProdottiColori().add(pc);
        prodottoRepository.save(p);
        varianteColoreRepository.save(vc);
        return pc;
    }

    private ColoreTaglia associaProdottoColoreTaglia(ProdottoColore pc, VarianteTaglia vt) {
        ColoreTaglia ct = new ColoreTaglia();
        ct.setProdottoColore(pc);
        ct.setVarianteTaglia(vt);
        ct = coloreTagliaRepository.save(ct);
        pc.getColoriTaglie().add(ct);
        vt.getColoriTaglie().add(ct);
        pc = prodottoColoreRepository.save(pc);
        vt = varianteTagliaRepository.save(vt);
        return ct;
    }

}
