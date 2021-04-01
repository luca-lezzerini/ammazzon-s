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
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

@Service
public class DatiTestServiceImpl implements DatiTestService {
    
    static final Logger logger = LoggerFactory.getLogger(DatiTestServiceImpl.class);

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
        
        Instant i1 = Instant.now();
        
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
        VarianteColore vcVerde = new VarianteColore("v1", "verde");
        vcVerde = varianteColoreRepository.save(vcVerde);
        VarianteColore vcBianco = new VarianteColore("g1", "bianco");
        vcBianco = varianteColoreRepository.save(vcBianco);

        //////////creazione taglia////////
        VarianteTaglia tagliaS = new VarianteTaglia("S");
        tagliaS = varianteTagliaRepository.save(tagliaS);
        VarianteTaglia tagliaM = new VarianteTaglia("M");
        tagliaM = varianteTagliaRepository.save(tagliaM);
        VarianteTaglia tagliaL = new VarianteTaglia("L");
        tagliaL = varianteTagliaRepository.save(tagliaL);
        VarianteTaglia tagliaXL = new VarianteTaglia("XL");
        tagliaL = varianteTagliaRepository.save(tagliaXL);

        ///////////creazione 1000 prodotti////////
        Prodotto p = new Prodotto();
        int prodottiDaGenerare = 1000;
        //i contatori contano quanti prodotti sono stati creati per ogni categoria
        int contatore1 = 0;
        int contatore2 = 0;
        int contatore3 = 0;
        for (int i = 0; i < prodottiDaGenerare; i++) {

            //Generazione prezzo casuale per prodotto con formattatore
            DecimalFormat formatter = new DecimalFormat("###,##");
            Double random = Math.random() * (1000 - 10 + 1) + 10;
            String pf = formatter.format(random);
            Double prezzoFormattato = Double.valueOf(pf);

            p = new Prodotto("p" + i, "t-shirt", prezzoFormattato);
            p = prodottoRepository.save(p);
            logger.info("id " + p.getCodice() + " = " + p.getId());
            //Prodotti con id % 3 == 0 -> 1 colore e 2 taglie
            //genera 34 pantaloni con colore casuale con taglie disponibili S o M
            if (i % 3 == 0) {
                contatore1++;
                p.setDescrizione("PANTALONE");
                //Ottengo un pantalone con colore casuale
                ProdottoColore pantaloneColoreCasuale = associaProdottoColore(p, ColoreCasuale());

                //Genero 2 taglie casuali
                List<VarianteTaglia> taglieCasuali = generaTaglieCasuali(2);
                //prendo la prima taglia casuale, la associo e la consumo(cancello
                //nell'arraylist)
                VarianteTaglia tagliaCasuale = taglieCasuali.get(0);
                associaProdottoColoreTaglia(pantaloneColoreCasuale, tagliaCasuale);
                taglieCasuali.remove(tagliaCasuale);

                //prendo la prima taglia casuale, la associo e la consumo(cancello
                //nell'arraylist)
                tagliaCasuale = taglieCasuali.get(0);
                associaProdottoColoreTaglia(pantaloneColoreCasuale, tagliaCasuale);
                taglieCasuali.remove(tagliaCasuale);
            }

            //Prodotti con id % 3 == 1 -> 1 colore e tre taglie
            //Genera 33 T-shirt gialle con taglie disponibili S, M, L
            if (i % 3 == 1) {
                contatore2++;
                p.setDescrizione("T-SHIRT");
                //Ottengo una t-shirt con colore casuale
                ProdottoColore tShirtColoreCasuale = associaProdottoColore(p, ColoreCasuale());
                //Genero 3 taglie casuali
                List<VarianteTaglia> taglieCasuali = generaTaglieCasuali(3);
                //prendo la prima taglia casuale, la associo e la consumo(cancello
                //nell'arraylist)
                VarianteTaglia tagliaCasuale = taglieCasuali.get(0);
                associaProdottoColoreTaglia(tShirtColoreCasuale, tagliaCasuale);
                taglieCasuali.remove(tagliaCasuale);

                tagliaCasuale = taglieCasuali.get(0);
                associaProdottoColoreTaglia(tShirtColoreCasuale, tagliaCasuale);
                taglieCasuali.remove(tagliaCasuale);

                tagliaCasuale = taglieCasuali.get(0);
                associaProdottoColoreTaglia(tShirtColoreCasuale, tagliaCasuale);
                taglieCasuali.remove(tagliaCasuale);
            }

            //Prodotti con id % 3 == 2 -> 2 colori e tre taglie per colore
            //Genera 33 Cappelli con colori rosso o giallo, ognuno disponibile
            // in 3 taglie (S, M, L)
            if (i % 3 == 2) {
                contatore3++;
                p.setDescrizione("CAPPELLO");
                //Genero 2 colori casuali
                List<VarianteColore> coloriCasuali = generaColoriCasuali(2);
                //prendo il primo colore casuale, lo associo e lo consumo(cancello
                //nell'arraylist)
                VarianteColore coloreCasuale = coloriCasuali.get(0);
                ProdottoColore cappellocoloreCasuale = associaProdottoColore(p, coloreCasuale);
                coloriCasuali.remove(coloreCasuale);

                //genero 3 taglie casuali
                List<VarianteTaglia> taglieCasuali = generaTaglieCasuali(3);
                //prendo la prima taglia casuale, la associo e la consumo(cancello
                //nell'arraylist)
                VarianteTaglia tagliaCasuale = taglieCasuali.get(0);
                associaProdottoColoreTaglia(cappellocoloreCasuale, tagliaCasuale);
                taglieCasuali.remove(tagliaCasuale);

                tagliaCasuale = taglieCasuali.get(0);
                associaProdottoColoreTaglia(cappellocoloreCasuale, tagliaCasuale);
                taglieCasuali.remove(tagliaCasuale);

                tagliaCasuale = taglieCasuali.get(0);
                associaProdottoColoreTaglia(cappellocoloreCasuale, tagliaCasuale);
                taglieCasuali.remove(tagliaCasuale);

                //prendo il primo colore casuale, lo associo e lo consumo(cancello
                //nell'arraylist)
                coloreCasuale = coloriCasuali.get(0);
                ProdottoColore cappellocoloreCasuale2 = associaProdottoColore(p, coloreCasuale);
                coloriCasuali.remove(coloreCasuale);

                //genero 3 taglie casuali
                List<VarianteTaglia> taglieCasuali2 = generaTaglieCasuali(3);
                //prendo la prima taglia casuale, la associo e la consumo(cancello
                //nell'arraylist)
                //cappello/Giallo/S
                VarianteTaglia tagliaCasuale2 = taglieCasuali2.get(0);
                associaProdottoColoreTaglia(cappellocoloreCasuale2, tagliaCasuale2);
                taglieCasuali2.remove(tagliaCasuale2);

                tagliaCasuale2 = taglieCasuali2.get(0);
                associaProdottoColoreTaglia(cappellocoloreCasuale2, tagliaCasuale2);
                taglieCasuali2.remove(tagliaCasuale2);

                tagliaCasuale2 = taglieCasuali2.get(0);
                associaProdottoColoreTaglia(cappellocoloreCasuale2, tagliaCasuale2);
                taglieCasuali2.remove(tagliaCasuale2);
            }
        }
        //Queries per numero di prodotti/colore trovati
        int pantaloniRossi = prodottoColoreRepository.prodottoColore("rosso", "pantalone").size();
        int pantaloniBlu = prodottoColoreRepository.prodottoColore("blu", "pantalone").size();
        int pantaloniGialli = prodottoColoreRepository.prodottoColore("giallo", "pantalone").size();
        int pantaloniVerdi = prodottoColoreRepository.prodottoColore("verde", "pantalone").size();
        int pantaloniBianchi = prodottoColoreRepository.prodottoColore("bianco", "pantalone").size();
        
        int tShirtRosse = prodottoColoreRepository.prodottoColore("rosso", "t-shirt").size();
        int tShirtBlu = prodottoColoreRepository.prodottoColore("blu", "t-shirt").size();
        int tShirtGiallo = prodottoColoreRepository.prodottoColore("giallo", "t-shirt").size();
        int tShirtVerde = prodottoColoreRepository.prodottoColore("verde", "t-shirt").size();
        int tShirtBianco = prodottoColoreRepository.prodottoColore("bianco", "t-shirt").size();
        
        int cappelliRossi = prodottoColoreRepository.prodottoColore("rosso", "cappello").size();
        int cappelliBlu = prodottoColoreRepository.prodottoColore("blu", "cappello").size();
        int cappelliGialli = prodottoColoreRepository.prodottoColore("giallo", "cappello").size();
        int cappelliVerdi = prodottoColoreRepository.prodottoColore("verde", "cappello").size();
        int cappelliBianchi = prodottoColoreRepository.prodottoColore("bianco", "cappello").size();
        
        System.out.println("numero Pantaloni creati = " + contatore1);
        System.out.println("\t numero Pantaloni rossi: " + pantaloniRossi);
        System.out.println("\t numero Pantaloni blu: " + pantaloniBlu);
        System.out.println("\t numero Pantaloni gialli: " + pantaloniGialli);
        System.out.println("\t numero Pantaloni verdi: " + pantaloniVerdi);
        System.out.println("\t numero Pantaloni bianchi: " + pantaloniBianchi);

        System.out.println("numero t-shirt create = " + contatore2);
        System.out.println("\t numero t-shirt rossi: " + tShirtRosse);
        System.out.println("\t numero t-shirt blu: " + tShirtBlu);
        System.out.println("\t numero t-shirt gialli: " + tShirtGiallo);
        System.out.println("\t numero t-shirt verdi: " + tShirtVerde);
        System.out.println("\t numero t-shirt bianchi: " + tShirtBianco);
        
        System.out.println("numero cappelli creati = " + contatore3);
        System.out.println("\t numero cappelli rossi: " + cappelliRossi);
        System.out.println("\t numero cappelli blu: " + cappelliBlu);
        System.out.println("\t numero cappelli gialli: " + cappelliGialli);
        System.out.println("\t numero cappelli verdi: " + cappelliVerdi);
        System.out.println("\t numero cappelli bianchi: " + cappelliBianchi);
        
        System.out.println("totale prodotti creati su DB = " + prodottoRepository.findAll().size());
        
        // Query by example
        Prodotto ppp = new Prodotto();
        ppp.setCodice("p1");
        List<Prodotto> listaPPP = prodottoRepository.findAll(Example.of(ppp));
        System.out.println("\n\n\n Lista prodotto con query by example " + listaPPP);
        
        Instant i2 = Instant.now();
        
        System.out.println("TEMPO DATI TEST = "+Duration.between(i1, i2).toMinutes());
        
    }

    @Override
    public void queryTest1() {
        //query per trovare tutti i pantaloni blu
        List<ProdottoColore> pantaloniGialli = prodottoColoreRepository.pantaloniGialli();
        System.out.println("numero pantaloni gialli trovati = " + pantaloniGialli.size());
        pantaloniGialli.forEach(l -> {
            System.out.println(l);
            System.out.println(
                    "\nCodice prodotto = " + l.getProdotto().getCodice() + "\n"
                    + "Descrizione prodotto = " + l.getProdotto().getDescrizione() + "\n"
                    + "Colore = " + l.getVarianteColore().getDescrizione() + "\n"
            );
        });
        //query per trovare tutti i pantaloni gialli
        List<ProdottoColore> pantaloniBlu = prodottoColoreRepository.pantaloniBlu();
        System.out.println("\nnumero pantaloni blu trovati = " + pantaloniBlu.size());
        pantaloniBlu.forEach(l -> {
            System.out.println(l);
            System.out.println(
                    "\nCodice prodotto = " + l.getProdotto().getCodice() + "\n"
                    + "Descrizione prodotto = " + l.getProdotto().getDescrizione() + "\n"
                    + "Colore = " + l.getVarianteColore().getDescrizione() + "\n"
            );
        });
        //query per trovare tutti i cappelli rossi
        List<ProdottoColore> cappelliRossi = prodottoColoreRepository.CappelliRossi();
        System.out.println("\nnumero cappelli Rossi trovati = " + cappelliRossi.size());
        cappelliRossi.forEach(l -> {
            System.out.println(l);
            System.out.println(
                    "\nCodice prodotto = " + l.getProdotto().getCodice() + "\n"
                    + "Descrizione prodotto = " + l.getProdotto().getDescrizione() + "\n"
                    + "Colore = " + l.getVarianteColore().getDescrizione() + "\n"
            );
        });
    }

    @Override
    public void queryTest2() {
        //taglie disponibili cappelli rossi
        List<ColoreTaglia> taglieCappelliRossi = coloreTagliaRepository.taglieCappelloRosso();
        System.out.println("\nnumero taglie associate a cappelli Rossi trovati = "
                + taglieCappelliRossi.size());
        taglieCappelliRossi.forEach(l -> {
            System.out.println(l);
            System.out.println(
                    "\nCodice prodotto = " + l.getProdottoColore().getProdotto().getCodice() + "\n"
                    + "Descrizione prodotto = " + l.getProdottoColore().getProdotto().getDescrizione() + "\n"
                    + "Colore = " + l.getProdottoColore().getVarianteColore().getDescrizione() + "\n"
                    + "Taglia = " + l.getVarianteTaglia().getCodice() + "\n"
            );
        });
    }

    @Override
    public void queryTest3() {
        System.out.println("GENERO 2 COLORI CASUALI");
        List<VarianteColore> coloriCasuali = generaColoriCasuali(2);
        coloriCasuali.forEach(cc -> {
            System.out.println(cc.getDescrizione());
        });
        System.out.println("GENERO 1 COLORI CASUALI");
        List<VarianteColore> coloriCasuali1 = generaColoriCasuali(1);
        coloriCasuali1.forEach(cc -> {
            System.out.println(cc.getDescrizione());
        });
        System.out.println("GENERO 3 COLORI CASUALI");
        List<VarianteColore> coloriCasuali3 = generaColoriCasuali(3);
        coloriCasuali3.forEach(cc -> {
            System.out.println(cc.getDescrizione());
        });
        System.out.println("PROVO A GENERARE 4 COLORI CASUALI");
        List<VarianteColore> coloriCasuali4 = generaColoriCasuali(4);
        coloriCasuali4.forEach(cc -> {
            System.out.println(cc.getDescrizione());
        });
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

    /**
     * Genera un colore casuale tra quelli presenti su DB
     *
     * @return VarianteColore
     */
    private VarianteColore ColoreCasuale() {
        List<VarianteColore> colori = varianteColoreRepository.findAll();
        int min = 0;
        int max = colori.size() - 1;
        int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
        VarianteColore coloreCasuale = colori.get(randomNum);
        return coloreCasuale;
    }

    /**
     * Genera una quantità variabile di colori casuali, se quella quantità è
     * maggiore uguale il totale colori su DB otteniamo tutti i colori presenti
     * su DB
     *
     * @param num
     * @return List<VarianteColore>
     */
    private List<VarianteColore> generaColoriCasuali(int num) {

        List<VarianteColore> colori = varianteColoreRepository.findAll();
        List<VarianteColore> coloriCasuali = new ArrayList<>();
        if (colori.size() <= num) {
            coloriCasuali = colori;
        } else {
            int max;
            for (int i = 0; i < num; i++) {
                max = colori.size() - 1;
                int randomNum = ThreadLocalRandom.current().nextInt(0, max + 1);
                VarianteColore coloreCasuale = colori.get(randomNum);
                coloriCasuali.add(coloreCasuale);
                colori.remove(coloreCasuale);
            }
        }
        return coloriCasuali;
    }

    /**
     * Genera una quantità variabile di talie casuali, se quella quantità è
     * maggiore uguale il totale taglie su DB otteniamo tutte le taglie presenti
     * su DB
     *
     * @param num
     * @return List<VarianteTaglia>
     */
    private List<VarianteTaglia> generaTaglieCasuali(int num) {
        List<VarianteTaglia> taglie = varianteTagliaRepository.findAll();
        List<VarianteTaglia> taglieCasuali = new ArrayList<>();
        if (taglie.size() <= num) {
            taglieCasuali = taglie;
        } else {
            int max;
            for (int i = 0; i < num; i++) {
                max = taglie.size() - 1;
                int randomNum = ThreadLocalRandom.current().nextInt(0, max + 1);
                VarianteTaglia tagliaCasuale = taglie.get(randomNum);
                taglieCasuali.add(tagliaCasuale);
                taglie.remove(tagliaCasuale);
            }
        }
        return taglieCasuali;
    }
}
