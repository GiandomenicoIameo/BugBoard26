# Guida all'installazione del front-end di BugBoard26

L'applicazione si compone di due parti: la parte front-end, il cui codice sorgente è visionabile nella directory `front-end/`, e la parte back-end scaricabile da [GitHub Pages](https://github.com/ubiestubi/ProgettoIngSoft). L'unico requisito di cui necessita l'applicazione è Docker. Quest'ultimo viene impiegato esclusivamente per avviare la parte back-end.  

Per l'installazione del front-end è sufficiente scaricare il file presente nella sezione Releases del repository, a seconda del sistema in uso sul proprio computer.

## Installazione su Ubuntu-based (`.deb`)

Una volta scaricato il file `.deb`, è sufficiente  posizionarsi nella stessa directory del file appena scaricato e digitare il seguente comando:

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
Se nonostante ciò le dipendenze non vengono installate a causa di versioni vecchie dei repository, è possibile aggirare il problema modificando le dipendenze da `Depends` a `Recommends` e ricompilare poi il pacchetto.

### Estrazione del pacchetto
I metadati di controllo del file `.deb` possono essere estratti nella directory  temporanea `/tmp/extracted/`. Quindi, aprire il terminale, spostarsi nella directory in cui è stato salvato il pacchetto e digitare:

```bash
dpkg-deb -R bugboard_1.0.0_amd64.deb /tmp/extracted/
```
### Spostamento delle dipendenze in `Recommends`
Una volta fatto ciò, per spostare le dipendenze basta aprire il file `/tmp/extracted/DEBIAN/control` con un editor di testo e sostituire `Depends:` con `Recommends:`, in modo che eventuali librerie mancanti non blocchino l'installazione.

### Ricompilazione del pacchetto
Dopodiché basta ricreare un nuovo pacchetto `.deb` aggiornato con le nuove intestazioni. Quindi, posizionarsi nella directory `/tmp/` e digitare:

```bash
dpkg-deb -b extracted/ bugboard_1.0.0_amd64.deb
```

### Installazione del pacchetto
Come ultimo passaggio ci basta installare il nuovo file `.deb` riconfigurato (dalla stessa directory in cui è stato creato, ad esempio `/tmp/`):

```bash
sudo apt install ./bugboard_1.0.0_amd64.deb
rm -rf /tmp/extracted/
```

## Installazione su Windows (`.zip`)
Su Windows la procedura è molto più semplice: basta scaricare il file `.zip` dalla sezione Releases, decomprimerlo e avviare l'eseguibile dell'applicazione.

> [!IMPORTANT]
> **Avviso SmartScreen su Windows**
> 
> Al primo avvio Windows può mostrare l'avviso di Microsoft Defender SmartScreen.
> Il motivo è che i file scaricati da internet vengono contrassegnati da Windows
> con il *Mark of the Web*, e l'eseguibile di BugBoard26 non è firmato
> digitalmente, quindi Windows non lo riconosce come app nota. Non indica un
> problema dell'applicazione. Clicca su **Ulteriori informazioni** e poi su
> **Esegui comunque**.
