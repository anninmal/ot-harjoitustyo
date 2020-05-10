# Käyttöohje

Lataa suoritettava jar tiedosto [CSG5e.jar](https://github.com/anninmal/ot-harjoitustyo/releases/tag/loppupalautus)

## Konfigurointi

Ohjelman oletuksena on, että:
- hakemistoissa */scr/main/resources/races* on tiedosto *races.txt*
- hakemistoissa */scr/main/resources/classes* on tiedosto *classes.txt*
- hakemistoissa */scr/main/resources/backgrounds* on tiedosto *backgrounds.txt*

Tiedostot sisältävät sovelluksen tarvitseman tiedon rotujen, luokkien ja taustojen ominaisuuksista. Uusia rotuja, luokkia ja taustoja voi lisätä, kunhan noudattaa samaa formaattia, kuin muu tiedostoissa oleva tieto.

## Ohjelman käynnistäminen

Ohjelma käynnistetään komentorivin komennolla <code>java -jar CSG5e.jar</code>

## Hahmon piirteiden valitseminen

Sovelluksen ensimmäinen näkymä kertoo, mitä käyttäjän kuuluu tehdä.
Hahmolle voi kirjoittaa nimen, jos haluaa hahmolomakkeeseen nimen.
Avattavista valikoista voi valita hahmolle haluamansa rodun, luokan, hengenlaadun ja taustan.
Jos jättää vaihtoehdon tyhjäksi, sovellus satunnaistaa kyseisen piirteen.

Hahmolomake generoidaan painamalla nappia "Generate!".

## Lomakenäkymä

Lomakenäkymässä näkyy generoitu hahmolomake.

Samoilla asetuksilla voi generoida uuden lomakkeen painamalla "Generate!"-nappia uudestaan.

Aloitusnäkymään, missä voi muokata valintojaan, pääsee painamalla nappia "Back".

Jos haluaa tallentaa generoimansa hahmolomakkeen, onnistuu se painamalla nappia "Save Sheet".

<img src="https://github.com/anninmal/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/savesheet.png">

Nappia painettaessa sovellus antaa käyttäjän syöttää haluamansa nimen tiedostolle. Jos nimikenttä jätetään tyhjäksi, sovellus ei tallenna tiedostoa. Tiedosto luodaan painamalla nappia "Save". Tiedosto löytyy sovelluksen päähakemistotosta.
