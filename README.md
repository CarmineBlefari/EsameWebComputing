# EsameWebComputing

PROGETTO WEB 
COMPUTING
Affitto e Vendita di Immobili.

Configurazione

l'applicazione si apre sulla posta 2409

amministratore presente nel database
username: carmine
password: blefari

INIZIO
• Nella pagina iniziale è presente una nav bar che consente di accedere
alle funzionalita principali del sito,di accedere a pagine che 
descrivono sommariamente cosa si potrà fare con questo sito e anche 
ad una pagina info che permette di contattare il proprietario della 
pagina creata.
• È presenta anche una funzionalità non richiesta nella traccia che 
permette di dare una valutazione sommaria e approssimata di un 
eventuale immobile
• Inolte è presente anche un footer che permette oltra ad avere altre 
informazioni sul sito,anche di accedere ai principali social del sito
ACCEDI
• Una volta cliccato il tasto accedi si apre una nuova pagina dove è sia 
possibile fare il login che registrarsi come nuovo utente
• Sono supportati gli elementi richiesti in traccia quindi si può accedere 
o registrarsi come venditore,acquirente o amministatore
Venditore
• Nella pagina venditore è presente nel corpo un form che permette 
l’aggiunta di un nuovo annuncio
• Esso presenta tutti i campi richiesti 
• Con il menu di sopra possiamo accedere agli annunci creati : da qui 
possiamo eliminare l’annuncio , selenzionando la check box inserita e 
poi cliccando il bottone elimina annuncio oppure modificarso
eseguendo la stessa operazione
• Inoltre nel menu della nav bar è presenta anche la pagina messaggi
dove sono presenti i messaggi inviati dagli acquirenti al venditore
Acquirente
• Nella pagina è presente un Contatta il Venditore che permette 
compilando il form di contattare un venditore inviandoli un messaggio
• Accedendo alla pagina annunci dalla nav bar si apre la pagina degli 
annunci
• Qui è possibile cercare annunci per descrizione,prezzo,metri o 
tipologia 
• È possibile anche inserire una recensione selenzionando la check box 
dell’annuncio, scrivendo la recensione nella text area e cliccando il 
pulsante inserisci recensione
Amministratore
• Accedendo a questa pagina e cliccando su Azioni nella nav bar si apre 
una pagina dove è possibile bannare un utente o renderlo 
amministratore, inserendo l’username dell’utente nel campo e 
cliccando il pulsante vicino
• Inolte è possibile anche modificare o eliminare annunci come nella 
pagina venditore

Posizione
per inserire una posizione essa puo essere cercata tramite la barra di ricerca
poi bisogna cliccare sulla mappa la posizione cercata ed essa verrà inserita
in automatico nel campo dell'aggiunta dell'annuncio

Classi Java
Gestione
Le classi 
Database,GestioneAnnunci,Gestio
neAnnunciRest,Messaggi,Annunci
,GestioneMessaggi,azioniAnnunci,
azioniMessaggi servono per 
svolgere le principali operazioni 
del sito web : 
aggiungere,modificare,eliminare
annunci,bannare o promuovere 
utenti,iniviare messaggi,etc..
Visualizzazzione
• Le classi con Loggato e le classi 
Login servono sia per accedere 
che registrarsi al sito web ma 
anche per aprire le pagine degli 
annunci tramite richieste
CSS,HTML,JAVASCRIPT,JSP
CSS, JAVASCRIPT
• Nella cartella css è presente 
tutto il codice necessario per 
stilizzare la pagina,senza l’uso d 
bootstrap , mentre nella cartella 
js sono presenti le funzioni 
principali che vengono svolte sul 
sito e che vengono richiamate 
tramite ajax dalle classi java
HTML,JSP
• I file html contengono le pagine 
che non vengono collegate al 
server quindi 
index,immobili,utenti,info e
valuta, mentre i file jsp
presentono le pagine dopo login 
e registrazione
Cosa Uso?
• Nel sito sono presenti funzionalità interessanti come valutazione di un 
immobile,possibilità di collegarsi a social networks,inolte il sito è 
responsive quindi diminuendo o aumentando la grandezza della 
pagina esso si adatterà alle misure.
• Inolte questo presenta la possibiltà anche di crearsi un toggle-collapse
che lo rende carino e mostra la nav bar cliccandolo.
• È presente HTML5,JAVASCRIPT,JQUERY,vengono usate le servlet , 
vengono usate pagine jsp e anche il linguaggio jstl.
• Importante è anche la presenza di un controller Rest e del linguaggio 
ajax
Database
• Nel database sono presenti tre tabelle : users,annunci,messaggi
• In users vengono aggiunti gli utenti che si registrano al sito web
• In annunci vengono aggiunti gli annunci creati dai venditori e mostrati 
ad acquirenti e amministratori
• In messaggi vengono aggiunti i messaggi inviati dagli acquirenti ai 
venditori
