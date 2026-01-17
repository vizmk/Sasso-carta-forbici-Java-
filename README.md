# Rock-Paper-Scissors Extended – Java Console Game

![Java](https://img.shields.io/badge/Java-17+-orange)
![OOP](https://img.shields.io/badge/Paradigm-OOP-blue)
![Status](https://img.shields.io/badge/Project-Educational-success)
![Platform](https://img.shields.io/badge/Platform-Console-lightgrey)

---

## 📖 Overview
**Rock-Paper-Scissors Extended** è un gioco console sviluppato in **Java** che implementa una versione avanzata del classico *Rock–Paper–Scissors*.

Oltre alla modalità standard, il programma consente di:
- definire **opzioni personalizzate** (numero dispari)
- applicare automaticamente le regole di vittoria/sconfitta tramite un **algoritmo circolare**
- gestire un **sistema di rating persistente** letto da file

Il progetto è stato realizzato come esercizio didattico avanzato per consolidare concetti di **OOP**, **gestione dello stato**, **file I/O** e **logica algoritmica**.

---

## 👤 Author
**Vincenzo Cavallaro**  
*Studente di Ingegneria Informatica*

---

## 🎯 Objectives
- Applicare correttamente i principi della **programmazione orientata agli oggetti**
- Separare input/output dalla logica di gioco
- Gestire uno **stato persistente** tramite file
- Implementare un algoritmo generico e scalabile
- Supportare **regole di gioco dinamiche**

---

## 🕹️ Game Commands

| Command     | Description |
|------------|-------------|
| `rock` / `paper` / `scissors` | Gioca una mossa (modalità standard) |
| `<custom option>`             | Gioca una mossa personalizzata |
| `!rating`                     | Mostra il punteggio attuale |
| `!exit`                       | Termina il gioco |

---

## ⚙️ Game Setup

Dopo l’inserimento del nome utente, il programma richiede un elenco opzionale di mosse:

rock,paper,scissors,lizard,spock


- Le opzioni devono essere **separate da virgola**
- Se la riga è **vuota**, il gioco usa le opzioni predefinite:
rock, paper, scissors

makefile
Copia codice

Output:
Okay, let's start



---

## 🧠 Game Logic (Extended Rules)

- Ogni opzione:
  - pareggia con sé stessa
  - perde contro **la prima metà** delle altre opzioni
  - vince contro **la seconda metà**

Le opzioni vengono trattate come un **cerchio ordinato**.  
L’algoritmo funziona correttamente **solo con un numero dispari di opzioni**, come richiesto dalla specifica.

---

## 🏆 Rating System

Il punteggio iniziale viene letto dal file `rating.txt`.

Formato del file:
Tim 350
Jane 200
Alex 400


Regole:
- Vittoria → **+100 punti**
- Pareggio → **+50 punti**
- Sconfitta → **+0 punti**

Se l’utente non è presente nel file, il punteggio parte da **0**.

---

## 📂 Project Structure

rockpaperscissors/
├── Main.java
│ └── Gestisce input/output e flusso principale
├── Logic.java
│ ├── Gestione rating
│ ├── Logica di confronto
│ ├── Algoritmo circolare
│ └── Lettura file rating.txt
└── rating.txt


---

## 🧱 Class Responsibilities

### Main
- Gestisce l’interazione con l’utente
- Interpreta i comandi (`!rating`, `!exit`)
- Avvia il gioco e delega la logica

### Logic
- Incapsula lo **stato del gioco**
- Implementa le regole di vittoria/sconfitta
- Gestisce il rating e le opzioni
- Legge il punteggio iniziale da file

---

## 🧠 Concepts Applied
- Object-Oriented Programming (OOP)
- Encapsulation
- Separation of Concerns
- File I/O (Scanner, File)
- Algorithmic Thinking
- Input validation
- State management

---

## ▶️ How to Run

```bash
javac rockpaperscissors/Main.java
java rockpaperscissors.Main
Assicurarsi che il file rating.txt sia presente nella working directory.

🚀 Possible Extensions
Persistenza del rating su file

Modalità multiplayer

Interfaccia grafica (JavaFX / Swing)

Test automatici (JUnit)

Statistiche di gioco

📌 Notes
Questo progetto è pensato come esercizio didattico avanzato, ma utilizza soluzioni scalabili e riutilizzabili, simili a quelle adottate in contesti reali di sviluppo software.
