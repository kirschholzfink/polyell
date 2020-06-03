# polyell

Aufgabe 2.3:Polyell von Stochastika

Alle 7 Millisekunden treffen sich eine beliebige Anzahl n von Reitern in Stochastika, um ihr berühm-
tes Polyell auszutragen. Jeder Reiter meldet sich zu Turnierbeginn mit der Angabe seiner Aus-dem-
Sattel-Stoß-Wahrscheinlichkeit an. Die Turnierteilnehmer reiten danach im Kreis. Der schwächste Rei-
ter (Nr. 1) beginnt und versucht, seinen Vordermann (Nr. 2) aus dem Sattel zu stoßen. Sitzt Nr. 2
anschließend noch im Sattel, so ist er als Nächster dran. Andernfalls ist Nr. 3 (der Vordermann von
Nr. 2) der Nächste. Der Vordermann des letzten Reiters ist Nr. 1. Das Turnier ist zu Ende, wenn nur
noch ein Reiter im Sattel sitzt.
Die Wahrscheinlichkeit, dass Reiter i seinen Vordermann i + 1 trifft und aus dem Sattel stößt,
beträgt p(i) . Weiter gilt: ∀i < j : p(i) < p(j) .

Aufgabenstellung

Schreiben Sie ein Programm, welches ein Polyell simuliert. Dazu werden nach der Turnieranmeldung
• die Reiter für das Turnier angeordnet
• das Turnier durchgeführt und protokolliert
• der Turniersieger benannt
Zudem sollen m Turniere mit den gleichen Reitern und Wahrscheinlichkeiten durchgeführt werden.
Dazu wird die Protokollfunktion deaktiviert. Ermittelt wird für jeden Reiter die Anzahl der Siege
(absolut und prozentual).
