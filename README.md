# Character Sheet Generator 5e
(Dungeons & Dragons 5e hahmolomakegeneraattori)

Sovelluken avulla voidaan luoda satunnaistettu Dungeons & Dragons 5e hahmolomake tason 1 hahmolle, noudattaen pelaajan käsikirjan (Player's Handbook) perusohjeita. Hahmolomake voidaan tallentaa tiedostolle.

### Dokumentointi

[Vaatimusmäärittely](https://github.com/anninmal/ot-harjoitustyo/blob/master/dokumentaatio/vaatimusmaarittely.md)

[Työaikakirjanpito](https://github.com/anninmal/ot-harjoitustyo/blob/master/dokumentaatio/tyoaikakirjanpito.md)

[Arkkitehtuurikuvaus](https://github.com/anninmal/ot-harjoitustyo/blob/master/dokumentaatio/arkkitehtuuri.md)

### Releaset

[Viikko 5](https://github.com/anninmal/ot-harjoitustyo/releases/tag/viikko5)

### Komentorivitoimintojen ohjeet

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
