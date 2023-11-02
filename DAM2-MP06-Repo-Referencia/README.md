# Exemples DAM2-MP06 #

## Arrencada ràpida ##
Execució ràpida dels diferents exemples i resolusions de problemes

## Windows ##
```bash
.\run.ps1 cat.iesesteveterradas.mp06.uf1.exemples.MainExemples

# For PR11Main class
.\run.ps1 cat.iesesteveterradas.mp06.uf1.solucions.pr11.PR11Main

# For PR12Main class
.\run.ps1 cat.iesesteveterradas.mp06.uf1.solucions.pr12.PR12Main

# For PR122cat. Execució directa d'un exercici 
.\run.ps1 cat.iesesteveterradas.mp06.uf1.solucions.pr12.PR122cat ./data/pr12/numeros.txt

# For PR125cp cat. Execució directa d'un exercici 
.\run.ps1 cat.iesesteveterradas.mp06.uf1.solucions.pr12.PR125cp "./data/pr12/numeros.txt" "./data/pr12/numeros_copia.txt"

# For PR13Main class
.\run.ps1 cat.iesesteveterradas.mp06.uf1.solucions.pr13.PR13Main

# For PR14Main class
.\run.ps1 cat.iesesteveterradas.mp06.uf1.solucions.pr14.PR14Main

```

## Linux ##
```bash
run.sh cat.iesesteveterradas.mp06.uf1.exemples.MainExemples

# For PR11Main class
run.sh cat.iesesteveterradas.mp06.uf1.solucions.pr11.PR11Main

# For PR12Main class
run.sh cat.iesesteveterradas.mp06.uf1.solucions.pr12.PR12Main

# For PR122cat cat. Execució directa d'un exercici 
run.sh cat.iesesteveterradas.mp06.uf1.solucions.pr12.PR122cat ./data/Arxiu.txt

# For PR13Main class
run.sh cat.iesesteveterradas.mp06.uf1.solucions.pr13.PR13Main

# For PR14Main class
run.sh cat.iesesteveterradas.mp06.uf1.solucions.pr14.PR14Main

```

## Compilació i funcionament ##

### Execució senzilla ###

#### Windows ####
```bash
run.ps1 <com.project.Main> <param1> <param2> <param3>
run.sh <com.project.Main> <param1> <param2> <param3>
```
#### Linux ####
```bash
run.ps1 <com.project.Main> <param1> <param2> <param3>
run.sh <com.project.Main> <param1> <param2> <param3>
```

On:
* <com.project.Main>: és la classe principal que vols executar.
* \<param1>, \<param2>, \<param3>: són els paràmetres que necessites passar a la teva aplicació.


### Execució pas a pas ###

Si prefereixes executar el projecte pas a pas, pots seguir les següents instruccions:

Neteja el projecte per eliminar fitxers anteriors:
```bash
mvn clean
```

Compila el projecte:
```bash
mvn compile test
```

Executa la classe principal:
```bash
mvn exec:java -q -Dexec.mainClass="<com.project.Main>" <param1> <param2> <param3>
```

On:
* <com.project.Main>: és la classe principal que vols executar.
* \<param1>, \<param2>, \<param3>: són els paràmetres que necessites passar a la teva aplicació.

Executa el menú d'exemples:
```bash
run.ps1 cat.iesesteveterradas.mp06.uf1.exemples.MainExemples
```

## Prompts IA ##

Aquí teniu un prompt que guia a ChatGPT o Bard per produir millor codi
```
Si us plau, proporciona'm un codi que resolgui la tasca que especificaré a continuació seguint els principis de SOLID i les millors pràctiques de Clean Code i les millors pràctiques professionals en el sector tecnològic en general.

Tingues en compte el següent:

Especificitat: Com més específic siguis amb el que estàs cercant, més fàcil serà per a mi proporcionar una resposta que s'ajusti a les teves necessitats.

Complexitat: Adherir-se estrictament a tots els principis de disseny i bones pràctiques pot resultar en solucions més extenses o complexes, depenent del problema en qüestió. És important equilibrar la necessitat de seguir aquestes pràctiques amb la simplicitat i llegibilitat del codi, especialment en exemples més petits.

Contingut del codi: Alguns principis o pràctiques poden ser més rellevants segons el context. Per exemple, si em demanes un petit fragment de codi, és possible que no tots els principis SOLID siguin aplicables. En aquests casos, em centraré en els aspectes més pertinents de les bones pràctiques.
```