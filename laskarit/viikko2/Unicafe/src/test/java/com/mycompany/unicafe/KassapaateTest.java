package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class KassapaateTest {
    
    Kassapaate paate;
    Maksukortti kortti;
    
    @Before
    public void setUp() {
        paate = new Kassapaate();
        kortti = new Maksukortti(500);
    }
    
    @Test
    public void oikeaRahamaara() {
        assertEquals(100000, paate.kassassaRahaa());
    }
    
    @Test
    public void oikeaEdullinenLounasmaara() {
        assertEquals(0, paate.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void oikeaMaukasLounasmaara() {
        assertEquals(0, paate.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void syoEdullisestiKasvattaaKassanRahamaaraaOikein() {
        paate.syoEdullisesti(300);
        assertEquals(100240, paate.kassassaRahaa());
    }
    
    @Test
    public void syoMaukkaastiKasvattaaKassanRahamaaraaOikein() {
        paate.syoMaukkaasti(500);
        assertEquals(100400, paate.kassassaRahaa());
    }
    
    @Test
    public void syoEdullisestiAntaaOikeanVaihtorahan() {
        paate.syoEdullisesti(300);
        assertEquals(60, paate.syoEdullisesti(300));
    }
    
    @Test
    public void syoMaukkaastiAntaaOikeanVaihtorahan() {
        paate.syoMaukkaasti(500);
        assertEquals(100, paate.syoMaukkaasti(500));
    }
    
    @Test
    public void syoEdulliststiKerranKasvattaaMyytyjenEdullistenLounaidenMaaraa() {
        paate.syoEdullisesti(240);
        assertEquals(1, paate.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void syoMaukkaastiKerranKasvattaaMyytyjenMaukkaidenLounaidenMaaraa() {
        paate.syoMaukkaasti(400);
        assertEquals(1, paate.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void syoEdulliststiKahdestiKasvattaaMyytyjenEdullistenLounaidenMaaraa() {
        paate.syoEdullisesti(240);
        paate.syoEdullisesti(240);
        assertEquals(2, paate.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void syoMaukkaastiKahdestiKasvattaaMyytyjenMaukkaidenLounaidenMaaraa() {
        paate.syoMaukkaasti(400);
        paate.syoMaukkaasti(400);
        assertEquals(2, paate.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void riittamatonEdullinenMaksuEiKasvataKassanRahamaaraa() {
        paate.syoEdullisesti(100);
        assertEquals(100000, paate.kassassaRahaa());
    }
    
    @Test
    public void riittamatonMaukasMaksuEiKasvataKassanRahamaaraa() {
        paate.syoMaukkaasti(100);
        assertEquals(100000, paate.kassassaRahaa());
    }
    
    @Test
    public void riittamatonEdullinenMaksuPalauttaaRahat() {
        paate.syoEdullisesti(100);
        assertEquals(100, paate.syoEdullisesti(100));
    }
    
    @Test
    public void riittamatonMaukasMaksuPalauttaaRahat() {
        paate.syoMaukkaasti(100);
        assertEquals(100, paate.syoMaukkaasti(100));
    }
    
    @Test
    public void riittamatonEdullinenMaksuEiMuutaMyytyjenLounaidenMaaraa() {
        paate.syoEdullisesti(100);
        assertEquals(0, paate.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void riittamatonMaukasMaksuEiMuutaMyytyjenLounaidenMaaraa() {
        paate.syoMaukkaasti(100);
        assertEquals(0, paate.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void kortiltaVeloitetaanEdullisenLounaanVerran() {
        paate.syoEdullisesti(kortti);
        assertEquals(260, kortti.saldo());
    }
    
    @Test
    public void kortiltaVeloitetaanMaukkaanLounaanVerran() {
        paate.syoMaukkaasti(kortti);
        assertEquals(100, kortti.saldo());
    }
    
    @Test
    public void palauttaaTrueJosEdullisenLounaanOstoOnnistuu() {
        assertTrue(paate.syoEdullisesti(kortti));
    }
    
    @Test
    public void palauttaaTrueJosMaukkaanLounaanOstoOnnistuu() {
        assertTrue(paate.syoMaukkaasti(kortti));
    }
    
    @Test
    public void syoEdulliststiKortillaKerranKasvattaaMyytyjenEdullistenLounaidenMaaraa() {
        paate.syoEdullisesti(kortti);
        assertEquals(1, paate.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void syoMaukkaastiKortillaKerranKasvattaaMyytyjenMaukkaidenLounaidenMaaraa() {
        paate.syoMaukkaasti(kortti);
        assertEquals(1, paate.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void syoEdulliststiKortillaKahdestiKasvattaaMyytyjenEdullistenLounaidenMaaraa() {
        paate.syoEdullisesti(kortti);
        paate.syoEdullisesti(kortti);
        assertEquals(2, paate.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void syoMaukkaastiKortillaKahdestiKasvattaaMyytyjenMaukkaidenLounaidenMaaraa() {
        kortti.lataaRahaa(400);
        paate.syoMaukkaasti(kortti);
        paate.syoMaukkaasti(kortti);
        assertEquals(2, paate.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void edullinenMaksuRiittamattomallaSaldollaEiVeloitaKorttia() {
        paate.syoMaukkaasti(kortti);
        paate.syoEdullisesti(kortti);
        assertEquals(100, kortti.saldo());
    }
    
    @Test
    public void maukasMaksuRiittamattomallaSaldollaEiVeloitaKorttia() {
        paate.syoEdullisesti(kortti);
        paate.syoMaukkaasti(kortti);
        assertEquals(260, kortti.saldo());
    }
    
    @Test
    public void edullinenMaksuRiittamattomallaSaldollaEiMuutaMyytyjenLounaidenMaaraa() {
        paate.syoMaukkaasti(kortti);
        paate.syoEdullisesti(kortti);
        assertEquals(0, paate.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void maukasMaksuRiittamattomallaSaldollaEiMuutaMyytyjenLounaidenMaaraa() {
        paate.syoEdullisesti(kortti);
        paate.syoMaukkaasti(kortti);
        assertEquals(0, paate.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void palauttaaFalseJosEdullisenLounaanOstoEiOnnistu() {
        paate.syoMaukkaasti(kortti);
        assertFalse(paate.syoEdullisesti(kortti));
    }
    
    @Test
    public void palauttaaFalseJosMaukkaanLounaanOstoEiOnnistu() {
        paate.syoEdullisesti(kortti);
        assertFalse(paate.syoMaukkaasti(kortti));
    }
    
    @Test
    public void kassanRahamaaraEiMuutuKunOstetaanKortillaEdullisesti() {
        paate.syoEdullisesti(kortti);
        assertEquals(100000, paate.kassassaRahaa());
    }
    
    @Test
    public void kassanRahamaaraEiMuutuKunOstetaanKortillaMaukkaasti() {
        paate.syoMaukkaasti(kortti);
        assertEquals(100000, paate.kassassaRahaa());
    }
    
    @Test
    public void lataaRahaaKortilleLataaRahaaKortille() {
        paate.lataaRahaaKortille(kortti, 100);
        assertEquals(600, kortti.saldo());
    }
    
    @Test
    public void lataaRahaaKortilleKasvattaaKassanRahamaaraa() {
        paate.lataaRahaaKortille(kortti, 100);
        assertEquals(100100, paate.kassassaRahaa());
    }
    
    @Test
    public void lataaRahaaKortilleEiOnnistuJosAnnettuSummaOnNegatiivinen() {
        paate.lataaRahaaKortille(kortti, -100);
        assertEquals(500, kortti.saldo());
    }
    
    @Test
    public void lataaRahaaKortilleEiKasvataKassanRahamaaraaJosAnnettuSummaOnNegatiivinen() {
        paate.lataaRahaaKortille(kortti, -100);
        assertEquals(100000, paate.kassassaRahaa());
    }
}
