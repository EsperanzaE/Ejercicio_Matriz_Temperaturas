package Temperaturas;

 enum Mes {
    ENERO, FEBRERO, MARZO, ABRIL, MAYO, JUNIO, JULIO, AGOSTO, SEPTIEMBRE, OCTUBRE, NOVIEMBRE,
    DICIEMBRE}

//con este método monto el array meses de 12*31 con los datos de las temperaturas medias por cada día de cada mes
//y aparte monto la primera y segunda columna del array resultados de 12*5 con la temperatura
//media del mes, el dia mas frio, el dia mas caluroso y las correspondientes temperaturas
// La temperatura se obtendrá mediante la función Random de un intervalo entre 5 y 25 grados centígrados.
public class Metodos {
    public static Mes tablaMeses[] = Mes.values();
    public static StringBuilder stringBuilder = new StringBuilder();

    /**
     * Con este método cargo el array principal de 12 x31 con las temperaturas medias por dia en los 12 meses
     * del año. A la mismma vez obtendo el array resultados de 12x5 donde voy obteniendo los datos que pide el
     * ejercicio;temperatura media, maxima y minima y los correspondientes dias
     * @param meses array de salida de 12x31
     * @param resultados array de salida de 12 x 4
     */
    public static void cargarArray(int[][] meses, double[][] resultados) {
        double media, maxima, minima;
        int diaMasFrio, diaMasCaluroso, dias;
        for (int i = 0; i < meses.length; i++) {
            media = 0;
            maxima = 0;
            minima = 100;
            diaMasFrio = 0;
            diaMasCaluroso = 0;
            dias = calculaDias(i);//metodo para saber los dias que tiene un mes
            for (int j = 0; j < dias; j++) {//calculo una temperatura media entre 5 y 25
                meses[i][j] = (int) ( Math.random() * ( 25 - 5 + 1 ) + 5 );
                media = media + meses[i][j];
                if (maxima < meses[i][j]) {
                    maxima = meses[i][j];//guardo la temperatura máxima
                    diaMasCaluroso = j + 1;//guardo el día en que se dio esa temperatura maxima
                }
                if (minima > meses[i][j]) {
                    minima = meses[i][j];//guardo la temperatura mínima
                    diaMasFrio = j + 1;//guardo el día en que se dio esa temperatura mínima
                }
            }
            media = media / dias;

            //antes de incrementar el numero de filas, cargo en el array de resultados en la misma fila,
            //las columna con el numero del mes, la media, la temeperatura maxima del mes y la mínima y los correspondientes días
            resultados[i][0] = media; //temperatura media del mes
            resultados[i][1] = diaMasCaluroso; //dia con la temperatura maxima del mes
            resultados[i][2] = maxima; //temperatura maxima del mes
            resultados[i][3] = diaMasFrio; //dia con la temperatura minima del mes
            resultados[i][4] = minima; //temperatura minima del mes
        }
    }

    /**
     * método para calcular el número de días que tiene un mes
     * precondicion: el argumento u ha de ser un valor entre 0 y 11
     * postcodicion. ninguna
     *
     * @param i orden de la fila del array que es el mes menos 1
     * @return dias que es el numero de dias que tiene el mes
     */
    private static int calculaDias(int i) {
        int dias = 0;
        if (( i + 1 ) == 1 || ( i + 1 ) == 3 || ( i + 1 ) == 5 ||
                ( i + 1 ) == 7 || ( i + 1 ) == 8 || ( i + 1 ) == 10 ||
                ( i + 1 ) == 12) {//meses de 31 dias
            dias = 31;
        } else {
            if (( i + 1 ) == 2) {//mes de febrero con 28 días
                dias = 28;
            } else {//meses de 30 días
                dias = 30;
            }
        }
        return dias;
    }

    /**
     * precondicion: ninguna
     * postcondicion. ninguna
     * con este metodo recorro el array de resultados y muestro las columnas 0 que contiene la media de la
     * temperatura de cada mes
     * @param resultados que es el array de 12x4 formado en el metodo cargarArray
     */
    public static void MostrarTemperaturaMediaPorMes(double[][] resultados) {
        for (int i = 0; i < 12; i++) {
            stringBuilder.append("\n la temperatura media del mes " + tablaMeses[i] + " es: " + resultados[i][0]);
        }
        System.out.println(stringBuilder);
        stringBuilder.setLength(0);
    }

    /**
     *  precondicion: ninguna
     *  postcondicion. ninguna
     * con este metodo recorro el array de resultados y muestro las columnas 1 2,3,4  que tienen y
     * los días y temperaturas máximas y mínimas
     * @param resultados que es el array de 12x4 formado en el metodo cargarArray
     */

    public static void MostrarDíaMasYMenosCalurosoPorMes(double[][] resultados) {
        for (int i = 0; i < 12; i++) {
            stringBuilder.append("\n los datos del mes " + tablaMeses[i] + " son:");
            stringBuilder.append("\n el día más caluroso fue el día " + (int) resultados[i][1] +
                    " con la temperatura de " + resultados[i][2]);
            stringBuilder.append("\n el día más frío fue el día " + (int) resultados[i][3] +
                    " con la temperatura de " + resultados[i][4]);
        }
        System.out.println(stringBuilder);
        stringBuilder.setLength(0);
    }

    /**
     *  precondicion: ninguna
     *      *  postcondicion. ninguna
     * metodo para recorrer el array y mostrar el día mas caluroso y el  más frío, y el mes/dia
     * que corresponden
     * @param resultados que es el array de 12x4 formado en el metodo cargarArray
     */

    public static void recorrerResultados(double[][] resultados) {
        Double maxima, minima;
        int diaMasFrio = 0, diaMasCaluroso = 0;
        int mesMasfrio = 0, mesMasCaluroso = 0;
        maxima = 0.0;
        minima = 100.0;
        for (int indice = 0; indice < resultados.length; indice++) {
            if (resultados[indice][2] > maxima) {  // temperatura máxima)
                maxima = resultados[indice][2];
                diaMasCaluroso = (int) resultados[indice][1];
                mesMasCaluroso = indice;
            }
            if (resultados[indice][4] < minima) {  // temperatura máxima)

                minima = resultados[indice][4];
                diaMasFrio = (int) resultados[indice][3];
                mesMasfrio = indice;
            }

        }
        stringBuilder.append("\n el día más frío del año fue el día " + (int) diaMasFrio + " del mes " +
                tablaMeses[(int) mesMasfrio] + " con la temperatura de " + minima);
        stringBuilder.append("\n el día más caluroso del año fue el día " + (int) diaMasCaluroso + " del mes " +
                tablaMeses[(int) mesMasCaluroso] + " con la temperatura de " + maxima);
        System.out.println(stringBuilder);
        stringBuilder.setLength(0);
    }
}