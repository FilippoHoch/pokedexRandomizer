# Pokédex Randomizer – Sub project 

## Il progetto 

Il progetto si compone principalmente da due sotto progetti, il primo [pokedexRandomizer](https://github.com/FilippoHoch/pokedexRandomizer)  e il secondo [guessThePokemon](https://github.com/FilippoHoch/guessThePokemon). La prima parte del progetto è stata svolta senza l’aiuto di Borghesi a causa del fatto che i gruppi la prima volta erano diversi da quelli attuali. Abbiamo comunque spiegato al compagno il progetto e ci siamo consultati per migliorarlo. Il secondo progetto invece è stato concepito solo successivamente alla creazione dei nuovi gruppi pertanto, è molto più arretrato rispetto allo sviluppo del primo. 

## Pokédex Randomizer 

Questo programma, dato un file log di una Rom Pokémon randomizzata, permette di visualizzare l’intero Pokédex del gioco con le modifiche apportate dalla randomizzazione del gioco, quali la modifica dei tipi dei Pokémon, le abilità che essi hanno, ma anche i tipi delle mosse e la loro potenza. 

Nello specifico una Randomizer è generata da un programma chiamato ["Universal Pokémon Randomizer”](https://github.com/Dabomstew/universal-pokemon-randomizer)


Questo Pokédex è fornito delle immagini ufficiali dei Pokémon che possono essere visualizzate selezionandoli nella lista posta sul lato sinistro della finestra; inoltre è possibile visualizzare in cosa si evolve ogni Pokémon e cliccando il nome dell’evoluzione si aprirà direttamente la finestra legata alle informazioni del Pokémon evoluto. 

## Installation 

For installation it is necessary to add / change the library of the project, by entering that of "JavaFX".  In addition, you must enter the Virtual machine (VM Options), within the "mainApp" configurations, the code is as follows: 
```bash
--module-path 

"path of your javaFX libraries" 

--add-modules 

javafx.controls,javafx.fxml 
```
Or follow this [video](https://youtu.be/FylHot91Lz8)

## Prima settimana 

Nella prima settimana di lavoro, ci siamo focalizzati soprattutto sulla parte del codice del progetto, migliorandolo e risolvendo alcuni piccoli problemi riscontrati, abbiamo aggiunto diverso commenti e Javadoc in modo da rendere il codice più comprensibile e pulito. Inoltre abbiamo cambiato i riferimenti alle immagini, in modo tale da utilizzare quelle ufficiali con un riferimento http. Facendo così che il programma risulti più leggero per la condivisione.  

## Seconda settimana

In maniera opposta a quanto svolto nella prima settimana ci siamo concentratti principalmente sul secondo progetto, anche se abbiamo tentato di migliorare quest'ultimo con purtoppo scarsi risultati, infatti avevamo intenzione di aggiungere un file eseguibile per l'avvio del programma, ma per una serie di motivi e dopo consiglio di Vaccari e Vivante abbiamo deciso di cancellare questa funzionalità, questo perchè l'operazione era decisamente lunga e poco remunerativa al punto tale da convincerci ad abbandonare l'idea.

## Terza settimana

In questa settimana, questa parte del progetto è stata messa un pò in secondo piano per poterci dedicare maggiormente alla seconda parte, nel frattempo abbiamo comunque rifinto il codice, risolvendo alcuni problemi riguardanti i riferimenti ipertestuali e la grafica.

## Quarta settimana

Durante la settimana, siamo riusciti nella correzione di alcune problematiche, migliorando il codice e aggiungendo commenti.

## Autori 

- [Filippo Hoch](https://github.com/FilippoHoch)
- [Paolo Braga](https://github.com/PaoloBraga)
- [Gabriele Borghesi](https://github.com/Gabry-EXE)
- [Daniele Romano](https://github.com/ROMA030)


# Pokédex Randomizer - Manuale

## Come funziona?

Questo programma permette tramite uno speciale file di poter cambiare le caratteristiche, statistiche e mosse dei vari Pokémon.
Per esempio, possiamo cambiare un personaggio iconico come Pikachu e cambiargli totalmente i suoi tratti caratteristici, cambiandolo e rendendolo completamente randomico.

## Come funziona il codice?

Questo programma, dato un file “.log” di una Rom Pokémon randomizzata, permette di visualizzare l’intero Pokédex del gioco con le modifiche apportate dalla randomizzazione del gioco, quali la modifica dei tipi dei Pokémon, le abilità che essi hanno, ma anche i tipi delle mosse e la loro potenza.
Nello specifico una Randomizer è generata da un programma chiamato "Universal Pokémon Randomizer”.

## A cosa serve il codice?

Il codice originale fu creato principalmente per la creazione di una mod che potesse permettere di aggiungere un aspetto importante negli altri giochi che i giochi originali Pokémon non avevano: la randomicità e la fortuna di poter trovare personaggi forti, deboli, veloci e altre caratteristiche anche se normalmente non sarebbe mai stato possibile.
Questa mod, anche se potrebbe essere molto basilare, ha cambiato molto lo sviluppo dei videogiochi, infatti quasi tutti i videogiochi ora hanno una mod simile, a volte più famosa del videogioco stesso.

## Come si utilizza il codice?

Dopo aver fatto partire il programma, si aprirà una finestra, la quale mostra una serie di sprite di Pokémon con dei nomi diversi dai propri, questo Pokédex è fornito delle immagini ufficiali dei Pokémon che possono essere visualizzate selezionandoli nella lista posta sul lato sinistro della finestra; inoltre è possibile visualizzare in cosa si evolve ogni Pokémon e cliccando il nome dell’evoluzione si aprirà direttamente la finestra legata alle informazioni del Pokémon evoluto. Ovviamente, caratteristiche, statistiche e mosse saranno diverse da quelle originali.

## Siti utilizzati per ottenere informazioni necessarie

Oltre al sito ufficiale, abbiamo utilizzato anche altri siti molto utili:
- [fontmeme.com](https://fontmeme.com/it/font-pokemon/): questo sito è stato utile per la creazione di varie scritte nello stile proprio dei vari giochi Pokémon;
- [veekun/pokedex](https://github.com/veekun/pokedex): questo sito è stato utilizzato per ottenere informazioni sull’id, il peso e le abilità dei pokémon;
- [veekun.com/dex/downloads](https://veekun.com/dex/downloads): consultato per poter utilizzare gli sprite che erano necessari per rappresentare le orme o le sprite dei pokémon.
