# Testausdokumentti


## Yksikkö- ja integraatiotestaus
#### Sovelluslogiikka
Sovelluslogiikan testejä suorittavat testiluokat CharacterSheetTest, FileReaderTest ja SheetSaverTest, joiden testit kattavat myös muiden luokkien toiminnallisuudet. Testeittä on pyritty varmistamaan, että kaikki metodit toimivat halutulla tavalla. Testausta kuitenkin vaikeuttaa hiukan se, että monet metodit perustuvat satunnaiseen arpomiseen, mikä tarkoittaa, että metodikutsujen tulokset eivät aina ole täysin ennustettavissa.

Testit tarkistavat myös, että tiedostot on luettu, ja että tiedostojen perusteella luoduilla olioilla on tarvittavat tiedot, eikä mitään puutu.

#### Testikattavuus
Sovelluksen testit ovat kattavia. Ainoastaan Main-luokka on vailla testausta.

<img src="https://github.com/anninmal/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/testikattavuus.png">

## Järjestelmätestaus
Sovelluksen mahdollisia virhetilanteita on testattu manuaalisesti antamalla tyhjiä syötteitä ja poistamalla sovelluksen tarvitsemat tiedostot. Tiedostojen puuttuessa, sovelluksen on tarkoitus antaa virheilmoitus tavallisten valintojen sijaan.
