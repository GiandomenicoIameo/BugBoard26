# Passi per l'installazione

L'applicazione si compone di due parti: la parte front-end, il cui codice sorgente è visionabile nella directory `front-end/`, e la parte back-end, scaricabile dal seguente link.

L'unico requisito di cui necessita l'applicazione è Docker. Quest'ultimo viene impiegato esclusivamente per avviare la parte back-end.  

Per una maggiore comprensione del processo di installazione, il documento è stato diviso in due parti: nella prima verranno illustrati i passi necessari per l'installazione del  front-end, mentre nella seconda quelli per il back-end.  

## Front-end
Per l'installazione del front-end è sufficiente scaricare il file presente nella sezione Releases del repository, a seconda del sistema in uso sul proprio computer.

### Download del file `.deb` e installazione (Debian-based)

Una volta scaricato, è sufficiente  posizionarsi nella stessa directory del file `.deb` e digitare il seguente comando:

```bash
sudo dpkg --force-depends -i bugboard_1.0.0_amd64.deb
```

Una volta installato, per poterlo avviare basterà individuare l'eseguibile `bugboard` e avviarlo:

```bash
whereis bugboard
./bugboard
```

Potrebbe accadere che l'applicazione non venga installata a causa della mancanza di dipendenze. Lo strumento di GitHub Actions che crea il pacchetto, compila prendendo come riferimento le dipendenze dell'ultima versione di Ubuntu in uso sui server di GitHub (Ubuntu 24.04 o successivi). 

Se il sistema su cui l'applicazione viene installata usa una versione precedente di Ubuntu (come la 22.04), i nomi di alcuni pacchetti di sistema differiscono leggermente, generando il blocco in fase di
installazione.   

Il seguente comando serve a dire al gestore pacchetti del sistema di scaricare le versioni corrispondenti delle librerie non soddisfate:

```bash
sudo apt --fix-broken install
```
### Esecuzione su Windows
