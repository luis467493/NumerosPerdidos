package numerosPerdidos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class NumerosPerdidos {

    private List<Integer> listaA = new ArrayList<>();
    private List<Integer> listaB = new ArrayList<>();
    private List<Integer> listaNumerosPerdidos = new ArrayList<>();

    public static void main(String[] args) {
        NumerosPerdidos puntosColombia = new NumerosPerdidos();
        puntosColombia.lecturaPantalla();
    }

    public void lecturaPantalla(){
        System.out.println("Por favor ingrese n - el tamaño de la primera lista " );
        Scanner consola = new Scanner(System.in);
        Integer consolaN = Integer.parseInt(consola.nextLine());
        System.out.println("n =  " + consolaN );

        System.out.println("Por favor ingrese n enteros separados por espacios que componen la primera lista.  " );
        Arrays.stream(consola.nextLine().split(" ")).mapToInt(n -> new Integer(String.valueOf(n))).forEach(listaA::add);
        listaA.forEach( n -> {System.out.println("n =  " + n );} );

        System.out.println("Por favor ingrese m - el tamaño de la segunda lista " );
        Integer consolaM = Integer.parseInt(consola.nextLine());
        System.out.println("m =  " + consolaM );

        System.out.println("Por favor ingrese m enteros separados por espacios que componen la segunda lista.  " );
        Arrays.stream(consola.nextLine().split(" ")).mapToInt(m -> new Integer(String.valueOf(m))).forEach(listaB::add);
        listaB.forEach( m -> {System.out.println("m =  " + m );} );

        if (getDifListaMaxListamin(listaB)<=100 &&
            consolaN == listaA.size() &&
            validateTamagnoListaAMayorIgual1(listaA) &&
            validateTamagnoListaBEntre1Y200000(listaB) &&
            validateTamagnoListaAMenorIgualTamagnoListaB(listaA, listaB)
            ) {
            System.out.println("proceda");
            listaNumerosPerdidos = getListaNumerosPerdidos(listaA, listaB);

            if (validateTamagnoListaNumerosPerdidosEntre1Y10000(listaNumerosPerdidos) &&
                validateListaNumerosPerdidosPerteneceAListaB(listaNumerosPerdidos, listaB) &&
                getDifListaMaxListamin(listaNumerosPerdidos)<101) {

                listaNumerosPerdidos = getListaSinDuplicados(listaNumerosPerdidos);
                getListaOrdenadasAsc(listaNumerosPerdidos);

                listaNumerosPerdidos.forEach(numeroPerdido -> {System.out.print(numeroPerdido + " ");});

            }

        }
    }

    public boolean validateTamagnoListaAMenorIgualTamagnoListaB(List<Integer> listaA, List<Integer> listaB) {
        return ( (listaA.size() <= listaB.size()) ? true: false );
    }

    public boolean validateTamagnoListaAMayorIgual1(List<Integer> listaA) {
        return ( (listaA.isEmpty()) ? false: true);
    }

    public boolean validateTamagnoListaBEntre1Y200000(List<Integer> listaB) {
        return ( (listaB.size() >= 1 && listaB.size() <= 200000) ? true: false );
    }

    public int getListaMax(List<Integer> lista) {
        return (lista.stream().mapToInt(i -> i).max().getAsInt());
    }

    public int getListaMin(List<Integer> lista) {
        return (lista.stream().mapToInt(i -> i).min().getAsInt());
    }

    public int getDifListaMaxListamin(List<Integer> lista) {
        return getListaMax(lista)-getListaMin(lista);
    }

    public boolean validateTamagnoListaNumerosPerdidosEntre1Y10000(List<Integer> listaNumerosPerdidos) {
        return ( (listaNumerosPerdidos.size() >= 1 && listaNumerosPerdidos.size() <= 10000) ? true: false );
    }

    public boolean validateListaNumerosPerdidosPerteneceAListaB(List<Integer> listaNumerosPerdidos, List<Integer> listaB) {
        return listaB.containsAll(listaNumerosPerdidos);
    }

    public HashMap<Integer, Integer> getListaFrecuencia(List<Integer> lista) {
        HashMap<Integer, Integer> frecuencia = new HashMap<Integer, Integer>();
        Set<Integer> quipu = new HashSet<Integer>(lista);

        for (Integer key : quipu) {
            frecuencia.put(key, Collections.frequency(lista, key));
        }

        return frecuencia;
    }

    public List<Integer> getListaNumerosPerdidos(List<Integer> listaA, List<Integer> listaB) {

        List<Integer> listaNumerosPerdidos = new ArrayList<>();

        HashMap<Integer, Integer> frecuenciaListaA = getListaFrecuencia(listaA);
        HashMap<Integer, Integer> frecuenciaListaB = getListaFrecuencia(listaB);

        frecuenciaListaA.forEach(
            (claveA,valorA) -> {
                if ( frecuenciaListaB.get(claveA) != null &&  valorA != frecuenciaListaB.get(claveA)) {
                    listaNumerosPerdidos.add(claveA);
                }
            }
        );

        return listaNumerosPerdidos;
    }

    public List<Integer> getListaSinDuplicados(List<Integer> lista){
        return lista.stream().distinct().collect(Collectors.toList());
    }

    public void getListaOrdenadasAsc(List<Integer> lista){
        Collections.sort(lista);
    }

}
