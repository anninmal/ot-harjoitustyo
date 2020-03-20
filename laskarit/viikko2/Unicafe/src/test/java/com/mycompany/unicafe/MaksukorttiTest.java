package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(10);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti!=null);      
    }
    
    @Test
    public void alksusaldoOikein() {
        assertEquals("saldo: 0.10", kortti.toString());
    }
    
    @Test
    public void rahanLataaminenToimiiOikein() {
        kortti.lataaRahaa(5);
        assertEquals("saldo: 0.15", kortti.toString());
    }
    
    @Test
    public void rahaVaheneeOikein() {
        kortti.otaRahaa(6);
        assertEquals("saldo: 0.4", kortti.toString());
    }
    
    @Test
    public void saldoEiMuutuJosRahaEiRiita() {
        kortti.otaRahaa(15);
        assertEquals("saldo: 0.10", kortti.toString());
    }
    
    @Test
    public void palauttaaTrueJosTarpeeksiRahaa () {
        assertTrue(kortti.otaRahaa(5));
    }
    
    @Test
    public void palauttaaFalseJosEiTarpeeksiRahaa () {
        assertFalse(kortti.otaRahaa(15));
    }
    
    @Test
    public void palauttaaSaldon() {
        assertEquals(10, kortti.saldo());
    }
}
