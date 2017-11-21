package numerosPerdidos;

import numerosPerdidos.NumerosPerdidos;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class NumerosPerdidosIT {

    @InjectMocks
    NumerosPerdidos puntosColombia;

    private List<Integer> listaA;
    private List<Integer> listaB;
    private List<Integer> listaNumerosPerdidos;
    private final Integer BMIN = 203;
    private final Integer BMAX = 208;
    private final Integer NUMEROSPERDIDOSMIN = 204;
    private final Integer NUMEROSPERDIDOSMAX = 206;
    private final Integer NUMEROPERDIDO = 204;

    public NumerosPerdidosIT() {

        listaA = new ArrayList<>();
        listaA.add(203);
        listaA.add(204);
        listaA.add(205);
        listaA.add(206);
        listaA.add(207);
        listaA.add(208);
        listaA.add(203);
        listaA.add(204);
        listaA.add(205);
        listaA.add(206);

        listaB = new ArrayList<>();
        listaB.add(203);
        listaB.add(204);
        listaB.add(204);
        listaB.add(205);
        listaB.add(206);
        listaA.add(207);
        listaB.add(205);
        listaB.add(208);
        listaB.add(203);
        listaB.add(206);
        listaB.add(205);
        listaB.add(206);
        listaB.add(204);

        listaNumerosPerdidos = new ArrayList<>();
        listaNumerosPerdidos.add(204);
        listaNumerosPerdidos.add(205);
        listaNumerosPerdidos.add(206);

    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

//  (1.1)
    @Test
    public void testListaATieneFrecuencia(){
        assertTrue("La lista no tiene frecuencia " ,
                !puntosColombia.getListaFrecuencia(listaA).isEmpty());
    }

//  (1.2)
    @Test
    public void testListaBTieneFrecuencia(){
        assertTrue("La lista no tiene frecuencia " ,
                !puntosColombia.getListaFrecuencia(listaB).isEmpty());
    }

//  (1.3)
    @Test
    public void test204EsNumeroPerdido(){
        assertTrue("La lista no tiene frecuencia " ,
                puntosColombia.getListaNumerosPerdidos(listaA, listaB).contains(NUMEROPERDIDO));
    }

//  (1.4)
    @Test
    public void testListaNumerosPerdidosSonNumerosPerdido(){
        assertTrue("La lista no tiene frecuencia " ,
                puntosColombia.getListaNumerosPerdidos(listaA, listaB).containsAll(listaNumerosPerdidos));
    }

//  (4.2)
    @Test
    public void testBMin203() {
        assertTrue("No se esta obteniendo bien el minimo numero de B " ,
                puntosColombia.getListaMin(listaB)==BMIN);
    }

//  (4.1)
    @Test
    public void testBMAx208() {
        assertTrue("No se esta obteniendo bien el maximo numero de B " ,
                puntosColombia.getListaMax(listaB)==BMAX);
    }

//  (4.0)
    @Test
    public void testDifBMAxBMinMenorIgual100() {
        assertTrue("La diferencia entre el max y el min de b no es menor o igual a 100 " ,
                puntosColombia.getDifListaMaxListamin(listaB)<=100);
    }

//  (5.2)
    @Test
    public void testTamagnoListaBEntre1Y200000() {
        assertTrue("Tamagno de lista B debe oscilar entre 1 y 200000 " ,
                puntosColombia.validateTamagnoListaBEntre1Y200000(listaB));
    }

//  (5.1)
    @Test
    public void testTamagnoListaAMayorIgual1() {
        assertTrue("Tamagno de lista A debe ser >= 1 " ,
                puntosColombia.validateTamagnoListaAMayorIgual1(listaA));
    }

//  (6)
    @Test
    public void testTamagnoListaAMenorIgualTamagnoListaB() {
        assertTrue("Tamagno de lista A debe ser <= que el de la lista B " ,
                puntosColombia.validateTamagnoListaAMenorIgualTamagnoListaB(listaA, listaB));
    }

//  (7.1)
    @Test
    public void testTamagnoListaNumerosPerdidosEntre1Y10000() {
        assertTrue("Tamagno de lista Numeros Perdidos debe oscilar entre 1 y 10000 " ,
                puntosColombia.validateTamagnoListaNumerosPerdidosEntre1Y10000(listaNumerosPerdidos));
    }

//  (7.2)
    @Test
    public void testListaNumerosPerdidosPerteneceAListaB() {
        assertTrue("Los elementos de la lista de numeros perdidos deben pertenecer a la lista B " ,
                puntosColombia.validateListaNumerosPerdidosPerteneceAListaB(listaNumerosPerdidos, listaB));
    }

//  (8.2)
    @Test
    public void testNumerosPerdidosMin204() {
        assertTrue("No se esta obteniendo bien el minimo numero de perdidos " ,
                puntosColombia.getListaMin(listaNumerosPerdidos)==NUMEROSPERDIDOSMIN);
    }

//  (8.1)
    @Test
    public void testNumerosPerdidosMax206() {
        assertTrue("No se esta obteniendo bien el maximo numero de perdidos " ,
                puntosColombia.getListaMax(listaNumerosPerdidos)==NUMEROSPERDIDOSMAX);
    }

//  (8.0)
    @Test
    public void testDifNumerosPerdidosMAxNumerosPerdidosMinMenor101() {
        assertTrue("La diferencia entre el max y el min de los numeroes perdidos no es menor a 101 " ,
                puntosColombia.getDifListaMaxListamin(listaNumerosPerdidos)<101);
    }

}
