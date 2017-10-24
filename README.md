# ADT

## Esercizio 2

Si consideri la definizione del tipo di dato astratto Dizionario. Si
implementi il tipo di dato astratto utilizzando gli alberi di ricerca "semplici"
e almeno una tra le seguenti strutture dati:

- Alberi Rosso Neri
- Tabelle Hash

Ogni implementazione deve permettere di usare tipi generici sia per il tipo 
chiave, sia per il tipo valore. 

### Unit Testing

Implementare gli unit-test degli algoritmi secondo le indicazioni
suggerite nel documento [Unit Testing](UnitTesting.md).

### Confronti

Si inseriscano i dati contenuti nel file `records.csv` nei dizionari
implementati. Si ripeta questa operazione usando come chiave i tre campi
presenti nel file (field1, field2 e field3; in tutti i casi il "valore" è 
l'intero record). Nel caso un record abbia chiave uguale a uno già presente è 
corretto sostituire l'istanza precedentemente memorizzata con il nuovo valore.

**Nota importante**: Nel caso si implementino le tabelle hash è necessario 
implementare opportune funzioni di hashing per le tre chiavi usate (i.e., è 
vietato utilizzare le funzioni eventualmente fornite dalla libreria standard del
linguaggio scelto).

Si misurino i tempi di risposta in modo da poter rispondere alle seguenti
domande:

  - Qual'è il tempo di inserimento dei 20.000.000 di record nei due container?
  - Una volta caricati i record nei container, misurate il tempo di accesso
    a 1.000.000 di chiavi scelte a caso. Che differenza c'è nei tempi di
    risposta dei due container realizzati?

Rispondete alla domanda precedente cancellando i record invece di accedervi.

Si crei una breve relazione a commento dei risultati ottenuti. I risultati
sono quelli che vi sareste aspettati? Se sì, perché? Se no, fate delle
ipotesi circa il motivo per cui gli algoritmi non funzionano come vi aspettate
e verificatele.
