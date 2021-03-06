# Character Sheet Generator 5e
(Dungeons & Dragons 5e hahmolomakegeneraattori)

Sovelluken avulla voidaan luoda satunnaistettu Dungeons & Dragons 5e hahmolomake tason 1 hahmolle, noudattaen pelaajan käsikirjan (Player's Handbook) perusohjeita. Hahmolomake voidaan tallentaa tiedostolle.

## Dokumentointi
[Käyttöohje](https://github.com/anninmal/ot-harjoitustyo/blob/master/dokumentaatio/kayttoohje.md)

[Vaatimusmäärittely](https://github.com/anninmal/ot-harjoitustyo/blob/master/dokumentaatio/vaatimusmaarittely.md)

[Arkkitehtuurikuvaus](https://github.com/anninmal/ot-harjoitustyo/blob/master/dokumentaatio/arkkitehtuuri.md)

[Testausdokumentti](https://github.com/anninmal/ot-harjoitustyo/blob/master/dokumentaatio/testausdokumentti.md)

[Työaikakirjanpito](https://github.com/anninmal/ot-harjoitustyo/blob/master/dokumentaatio/tyoaikakirjanpito.md)

## Releaset

[Viikko 5](https://github.com/anninmal/ot-harjoitustyo/releases/tag/viikko5)

[Viikko 6](https://github.com/anninmal/ot-harjoitustyo/releases/tag/viikko6)

[Loppupalautus](https://github.com/anninmal/ot-harjoitustyo/releases/tag/loppupalautus)

## Komentorivitoimintojen ohjeet

Ohjelman testaus:
```
mvn test
```


Testikattavuusraportin luonti:
```
mvn jacoco:report
```
(Tiedosto _target/site/jacoco/index.html_ avaa testikattavuusraportin.)


Jar-tiedostin generointi:
```
mvn package
```
(_CharacterSheetGenerator5e-1.0-SNAPSHOT.jar_-niminen suoritettava jar-tiedosto löytyy hakemistosta _target_.)


Checkstyle:
```
 mvn jxr:jxr checkstyle:checkstyle
```
(Checkstyle-raportti löytyy tiedostosta *target/site/checkstyle.html*)
