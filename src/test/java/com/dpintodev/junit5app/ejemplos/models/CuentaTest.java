package com.dpintodev.junit5app.ejemplos.models;
//import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

    /*
    CREACIÓN DE PRUEBA UNITARIA:
    1. Instanciar la clase a probar, Cuenta, de models; 2. Pasar los inputs para contrastar.
    3.VALOR ESPERADO/EXPECTATIVA, DE TIPO String VS REALIDAD; 4.PASAMOS UN NOMBRE de Cuenta
    A NUESTRO OBJETO cuenta, Y ES EL QUE ESPERAMOS QUE SEA, Andrés
    . ejecutamos test:
    CTRL + SHIFT F10 (o en los ticks verdes en el código)

    PROBAREMOS 1º: LA CUENTA ; Y 2º EL SALDO  (haremos 2 tests, 2 metodos)
     */
class CuentaTest {
    @Test
    void testNombreCuenta() {
        //1.INSTANCIAR CLASE A PROBAR (podríamos pasar constructor, de hecho, pasamos inputs: Andrés, y su saldo)
        //saldo : pasamos el valor en String, ya que un float, double, tendría sus limitaciones en tamaño, precisión.
        Cuenta cuenta = new Cuenta("Andrés", new BigDecimal("1000.12345"));

        //a)UN ESECENARIO DE PRUEBA: PASAR inputs, DATOS DE ENTRADA PARA CONTRASTAR
            //cuenta.setPersona("Andrés"); probamos mét set que está correcto (ahora comentado daría null, no asignamos);
            // así que queremos probar tambien el CONSTRUCTOR

        //-->  VALOR ESPERADO/EXPECTATIVA, DE TIPO String VS REALIDAD; y ejecutamos TEST
        String esperado = "Andrés";
        String real = cuenta.getPersona();
        //PASAMOS UN NOMBRE de Cuenta A NUESTRO OBJETO cuenta, Y ES EL QUE ESPERAMOS QUE SEA, Andrés:
        assertEquals(esperado, real);
        // ----------------------------------------------
        //NOTA: con el assertEqual, usamos ese met.de Assertions como si fuera propio de la Clase;
        // no hace falta antes escribir Assertions. "lo que sea" e importar arriba.

        //podriamos también usar expresión booleana con lo siguiente, pero el assertEquals ya lo incluye, es más completo:
        //assertTrue(real.equals("Andrés"));  <-- de hecho, si escribo "Andre" y no esta esta línea comentada, fallaría
                                        //y con que falle un met.falla todoo, por mucho que el assertEquals esté bien

    }
        @Test
        void testSaldoCuenta(){
            //TRUCO: ALT + CTRL + V : para colocar automat. el objeto cuenta con tipo de dato Cuenta solo empezando a escribir lo de new Cuenta
            Cuenta cuenta = new Cuenta("Andrés", new BigDecimal("1000.12345"));

            //AFIRMAMOS VALOR ESPERADO: saldo 1000 es BigDecimal, PERO, LO COMPARAREMOS CON VALOR CONVERTIDO A double, DE BigDecimal; perfecto
            assertEquals(1000.12345, cuenta.getSaldo().doubleValue());

            //OTRA PRUEBA (de regla de negocio): QUIERO ASEGURARME DE QUE EL SALDO NUNCA SEA NEGATIVO; SI ES FALSO, ESTARÍA PERFECTO:
            /**
             * Se usa el metodo compareTo de BigDecimal para comparar el saldo con el valor cero.
             * Si el resultado de la comparación es menor que cero, significa que el saldo es negativo.
             * El metodo assertFalse de JUnit verifica que la expresión dentro de los paréntesis sea falsa.
             * En este caso, se espera que el saldo no sea negativo, por lo que la expresión:
             * cuenta.getSaldo().compareTo(BigDecimal.ZERO) < 0 debe ser falsa.
             */
            assertFalse(cuenta.getSaldo().compareTo(BigDecimal.ZERO) < 0 );
            assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0 ); //<--- SERÍA LO MISMO (saldo esperado > 0) pero usando TRUE

        }

        /**
         * COMPARAREMOS 2 Objetos Cuenta (con mismos inputs) en una nueva prueba :
         *  a) COMPARAR POR REFERENCIA, POR INSTANCIA:
         * .y comparar si estas referencias son iguales (ya que método equals COMPARA POR REFERENCIA en memoria);
         * aunque podemos también comparar por 	VALOR, por atributos (si saldo es igual, los objetos son iguales pero guardados en otras direcciones de memoria)
         * b) COMPARAR POR VALOR:
         */
        @Test
        void testReferenciaCuenta() {
            //CREAMOS DOS INSTANCIAS IGUALES:
            Cuenta cuenta = new Cuenta("John Doe", new BigDecimal("8900.999"));
            Cuenta cuenta2 = new Cuenta("John Doe", new BigDecimal("8900.999"));
            //VER SI ESTAS 2 cuentas SON IGUALES con nNOtEquals: <-- PASA EL TEST
            assertNotEquals(cuenta2, cuenta);

        }
    }