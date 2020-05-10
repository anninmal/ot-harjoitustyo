# Arkkitehtuurikuvaus
## Rakenne
Koodin pakkausrakenne koostuu kahdesta pakkauksesta: *charactersheetgenerator.domain*, ja *charactersheetgenerator.ui*.

* *charactersheetgenerator.ui* sisältää käyttöliittymäluokan CSG5eUi. Käyttöliittymä on toteutettu JavaFX:llä.

* *charactersheetgenerator.domain* sisältää sovelluksen sovelluslogiikan.

## Käyttöliittymä
Luokka charactersheetgenerator.ui.CSG5eUi sisältää käyttöliittymän, joka koostuu aloitusnäkymästä ja lomakenäkymästä. Näkymät on toteutettu erillisinä **Scene**-olioina, joista **stage** näyttää aina jomman kumman. Hahmolomakkeen rakentamisesta vastaa metodi createCharacterSheet, jota redrawCharacterSheet-metodi kutsuu. Metodia kutsutaan aina, kun nappia "Generate!" painetaan jommassa kummassa näkymässä. Ensimmäisessä näkymässä olevia valintoja käytetään jokaisen uuden lomakkeen luomiseen.

Käyttöliittymä tuntee luokan [CharacterSheet](https://github.com/anninmal/ot-harjoitustyo/blob/master/CharacterSheetGenerator5e/src/main/java/charactersheetgenerator/domain/CharacterSheet.java), joka vastaa lomakkeen tiedoista ja niiden satunnaistamisesta, ja josta käyttöliittymä poimii kaiken tarvittavan tiedon. [SheetSaver](https://github.com/anninmal/ot-harjoitustyo/blob/master/CharacterSheetGenerator5e/src/main/java/charactersheetgenerator/domain/SheetSaver.java)-oliota käyttöliittymä käyttää lomakkeiden tallentamiseen. Käyttöliittymä ei siis vastaa sovelluslogiikasta.

## Sovelluslogiikka
Suurimmasta osasta sovelluksen toiminnallisuuksista vastaa luokka CharacterSheet, joka tuntee seuraavat luokat:
- Race, joka hallitsee rotuihin liittyviä tietoja
- CharacterClass, joka hallitsee luokiin liittyviä tietoja
- Background, joka hallitsee taustoihin liittyviä tietoja
- FileReader, joka vastaa tiedostojen lukemisesta

CharacterSheet-luokka käyttää FileReader-oliota lukeakseen tiedostoja, joiden tiedot tallennetaan listoihin. Luokka vastaa tietyn tai satunnaisen rodun/luokan/taustan/hengenlaadun valitsemisesta, kykyarvojen satunnaisesta generoimisesta, kykyarvojen ja niihin liittyvän tiedon käsittelystä, muiden satunnaisten piirteiden valitsemisesta, ja käyttöliittymälle sopivien tekstien rakentamisesta.

### Luokka/pakkauskaavio
<img src="https://github.com/anninmal/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/luokkapakkauskaavio_uusi.png">

## Lomakkeen tallennus
Generoidun lomakkeen voi tallentaa tekstitiedostoon. Tallennuksesta vastaa luokka SheetSaver. Tallennettava tieto formatoidaan suhteellisen lukijaystävälliseen muotoon.

<img src="https://github.com/anninmal/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/tesktiesimerkki.png">

## Tiedostot
Sovellus lukee tietoja kolmesta eri tiedostosta, *races.txt*, *classes.txt* ja *backgrounds.txt*, joilla on toisiaan vastaava formaatti. Jokainen tiedosto alkaa merkkien selityksellä. Esimerkki:
 <pre>
 Key: NAM: Name, SPE: speed, ASI: ability score increase ([ability score index][increase]), TRA: trait, PRO: proficiency
  
 START
 NAMHalfling
 SPE25
 ASI12
 ASI51
 TRA[Lucky] When you roll a 1 on The D20 for an Attack roll, ability check, or saving throw, you can reroll the die and must use the new roll.
 TRA[Brave] You have advantage on Saving Throws against being Frightened.
 TRA[Halfling Nimbleness] You can move through the space of any creature that is of a size larger than yours.
 TRA[Naturally Stealthy] You can attempt to hide even when you are obscured only by a creature that is at least one size larger than you.
 PROCommon
 PROHalfling
 STOP
 </pre>

Jokaista ominaisuutta siis edeltää kolmikirjaiminen koodi, jonka avulla ohjelma lajittelee tekstin. Yhteen erilliseen olioon tuleva tieto on avainsanojen START ja STOP välissä.

## Toiminnallisuuksia
#### Hahmolomakken luominen
CharacterSheet-luokan kostruktori luo tarvittavat listat ja oliot. setUpSheet-metodi kutsuu FileReader-oliota kolmesti, ja tallentaa palatuetut listat omiin muuttujaiinsa. setUpSheet-metodikutsun yhteydessä myös luodaan hengenlaadut ja tallennetaan ne listamuuttujaan.

generateSheet-metodi vastaa lomakkeen tietojen luomisesta ja arpomisesta. Parametreineä on toivottu rotu, luokka, tausta ja hengenlaatu. null-arvoinen parametri johtaa ominaisuuden satunnaiseen arpomiseen. generateCharacterSheet kutsuu seuraavia metodeja:
- **pickRace** — asettaa roduksi valitun hahmon rodun, tai arpoo satunnaisen.
- **pickClass** — asettaa luokaksi valitun hahmon luokan, tai arpoo satunnaisen.
- **pickBackground** — asettaa taustaksi valitun hahmon taustan, tai arpoo satunnaisen.
- **pickAlignment** — asettaa hengenlaaduksi valitun hahmon hengenlaadun, tai arpoo satunnaisen.
- **generateAbilityScores** — arpoo satunnaiset kykyarvot.
- **applyRacialBonuses** — jokainen rotu korottaa joitain tiettyjä kykyarjova, joten tämä metodi asettaa kykyarvoille valitun rodun mukaisen bonuksen.
- **generateAbilityScoreModifiers** — jokaisella kykyarvolla on vastaava "modifier", eli tietyille nopanheitoille ja onimaisuuksille lisättävä korotus. Metodi generoi kykyarvojen mukaiset modifierit.
- **assignEquipment** — kokoaa kaikista eri lähteistä peräisin olevat varusteet yhteen listaan.
- **assignProficiencies** — kokoaa kaikista eri lähteistä peräisin olevat taitoperehtyneisyydet yhteen listaan.
- **assignProficiencyMarkers** — arpoo hahmolle tiettyjä perehtyneisyyksiä ja generoi perehtyneisyyksien mukaiset merkit, joita käytetään käyttöliittymässä.
- **assignSavesAndSkills** — generoi perehtyneisyyksien mukaisen listan arvoja, jota käytetään käyttöliittymässä. Perehtyneisyysmerkit kertovat, mille arvoille asetetaan perehtyneisyysbonus.
- **assignSpells** — arpoo hahmolle tason 0 loitsut.
- **assignSpells** — arpoo hahmolle tason 1 loitsut.

Valtaosa sovelluksen toiminnallisuuksista käsittelee suuria määriä listoja, ja kätyttää hyväkseen niin monia toistolauseita, että toimintojen kuvaamista järkevän kokoisella ja pituisella sekvenssikaavion piirtäminen on hyvin hankalaa. Seuraava sekvenssikaavio kuitenkin kuvaa suurin piirtein yksinkertaista toiminnallisuutta, eli hahmolomakkeen luonnin yhteydesä tapahtuvaa hengenlaatulistan luomista, sekä satunnaisen hengenlaadun arpomista.

<img src="https://github.com/anninmal/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/sekvenssikaavio_viikko5.png?raw=true">

## Ohjelman heikkoudet
#### Käyttöliittymä
Käyttöliittymän koodi on hyvin pitkä ja voi olla vaikeaselkoinen. Koodista voi olla vaikea löytää etsimänsä. Koodia voisi mahdollisesti parantaa pilkkomalla se esim. eri luokkiin. Koodia voisi muutenkin tiivistää.

#### CharacterSheet-luokka
Kyseinen luokka on pitkä ja myös hieman sekava, ja sen toiminnallisuusksia voisi myös jakaa eri luokkiin. Metodeja voisi kenties myös optimoida, ja suurta luitaa listoja voisi ehkä myös karsia optimoinalla koodia. 
