# PA_Lab5
Crăciun Tudor, 2A3, Laboratorul 5 PA
Am fracționat codul în cât mai multe clase. Codul este executat în CatalogManager, unde inițializăm și apoi afișăm catalogul. Momentan am făcut doar partea Compulsory.
Clasa CatalogUtil se ocupă de operațiile de încărcare și salvare iar clasa Catalog de interacțiunea cu utilizatorul. 

Update: Am făcut mare parte din Optional. Am creat clase aferente pentru fiecare comandă, pe care le-am extins dintr-o clasă abstractă (care reprezintă o comandă generică, cu atribute generice). Shell-ul este pornit din clasa CatalogManager, funcția shell. Aceasta apelează o funcție din ShellManager care initializează toate operațiile necesare. De acolo (sper eu) totul devine intuitiv: se inițializează lista cu toate comenzile disponibile și, în mod repetitiv, se acceptă comenzi, până se introduce una greșită (sau exit).
