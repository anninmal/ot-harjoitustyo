# Arkkitehtuurikuvaus
## Rakenne
Koodin pakkausrakenne koostuu kahdesta pakkauksesta: *charactersheetgenerator.domain*, ja *charactersheetgenerator.ui*.

* *charactersheetgenerator.ui* sisältää käyttöliittymäluokan CSG5eUi. Käyttöliittymä on toteutettu JavaFX:llä.

* *charactersheetgenerator.domain* sisältää sovelluksen sovelluslogiikan.

## Käyttöliittymä
Luokka charactersheetgenerator.ui.CSG5eUi sisältää käyttöliittymän, joka koostuu aloitusnäkymästä ja lomakenäkymästä. Näkymät on toteutettu erillisinä **Scene**-olioina, joista **stage** näyttää aina jomman kumman. Hahmolomakkeen rakentamisesta vastaa metodi createCharacterSheet(), jota redrawCharacterSheet()-metodi kutsuu. Metodia kutsutaan aina, kun nappia "Generate!" painetaan jommassa kummassa näkymässä. Ensimmäisessä näkymässä olevia valintoja käytetään jokaisen uuden lomakkeen luomiseen.

Käyttöliittymä tuntee luokan [CharacterSheet](https://github.com/anninmal/ot-harjoitustyo/blob/master/CharacterSheetGenerator5e/src/main/java/charactersheetgenerator/domain/CharacterSheet.java), joka vastaa lomakkeen tiedoista ja niiden satunnaistamisesta, ja josta käyttöliittymä poimii kaiken tarvittavan tiedon. [SheetSaver](https://github.com/anninmal/ot-harjoitustyo/blob/master/CharacterSheetGenerator5e/src/main/java/charactersheetgenerator/domain/SheetSaver.java)-oliota käyttöliittymä käyttää lomakkeiden tallentamiseen. Käyttöliittymä ei siis vastaa sovelluslogiikasta.

## Sovelluslogiikka
Suurimmasta osasta sovelluksen toiminnallisuuksista vastaa luokka CharacterSheet.

### Luokka/pakkauskaavio
<img src="https://github.com/anninmal/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/luokka-pakkauskaavio1.png?raw=true">

## Sekvenssikaavio
Sekvenssikaavio kuvaa hahmolomakkeen luonnin yhteydesä tapahtuvaa hengenlaatulistan luomista, sekä satunnaisen hengenlaadun arpomista.
<img src="https://github.com/anninmal/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/sekvenssikaavio_viikko5.png?raw=true">
