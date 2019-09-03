package com.mycompany.vera_2;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class LecturaEscrituraTextoTest {

    ArrayList agregarOrac = new ArrayList();
    String ruta;
    @BeforeEach
    void setUp() {
        agregarOrac.add("The first man who stepped on the moon.");
        ruta = "texto.txt";
    }

    @Test
    void main() {
    }

    @Test
    void agregarOraciones() {
        assertSame("The first man who stepped on the moon.", LecturaEscrituraTexto.agregarOraciones((String) agregarOrac.get(0)));
        LecturaEscrituraTexto.leerArchivo(ruta);
    }

    @Test
    void leerArchivo() {
        LecturaEscrituraTexto.leerArchivo(ruta);
    }

    @Test
    void quitarOraciones() {
        assertSame("The first man who stepped on the moon.", LecturaEscrituraTexto.quitarOraciones((String) agregarOrac.get(0)));
        LecturaEscrituraTexto.leerArchivo(ruta);
    }

}