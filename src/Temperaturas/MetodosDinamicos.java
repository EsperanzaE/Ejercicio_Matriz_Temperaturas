package Temperaturas;

public class MetodosDinamicos {
    /**
     * creo un arrau de 12x2 para meter el numero de dias que tiene cada mez y montar el array de los 12 meses
     */
    public static int[][] mesDias = {{0, 31}, {1, 28}, {2, 31}, {3, 30}, {4, 31}, {5, 30}, {6, 31}, {7, 31}, {8, 30}, {9, 31}, {10, 30}, {11, 31}};

    /**
     * creo que el array de meses de 12 filas y tantas columnas como días tenga el mes
     * @return meses array de 12xnumero de dias de cada mes
     */
    public static int[][] crearArrayMeses() {
        int[][] meses = new int[12][];
        for (int i = 0; i < 12; i++) {
            meses[mesDias[i][0]] = new int[mesDias[i][1]];
        }
        return meses;
    }

    /**
     * Con este método cargo el array principal de 12 x31 con las temperaturas medias por dia en los 12 meses
     * del año. A la mismma vez obtendo el array resultados de 12x5 donde voy obteniendo los datos que pide el
     * ejercicio;temperatura media, maxima y minima y los correspondientes dias
     * @param meses array de salida de 12x31
     * @param resultados array de salida de 12 x 4
     */
    public static void cargarArray(int[][] meses, double[][] resultados) {
        double media, maxima, minima;
        int diaMasFrio, diaMasCaluroso;
        for (int i = 0; i < meses.length; i++) {
            media = 0;
            maxima = 0;
            minima = 100;
            diaMasFrio = 0;
            diaMasCaluroso = 0;
            for (int j = 0; j < meses[i].length; j++) {//calculo una temperatura media entre 5 y 25
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
            media = media / meses[i].length;

            //antes de incrementar el numero de filas, cargo en el array de resultados en la misma fila,
            //las columna con el numero del mes, la media, la temeperatura maxima del mes y la mínima y los correspondientes días
            resultados[i][0] = media; //temperatura media del mes
            resultados[i][1] = diaMasCaluroso; //dia con la temperatura maxima del mes
            resultados[i][2] = maxima; //temperatura maxima del mes
            resultados[i][3] = diaMasFrio; //dia con la temperatura minima del mes
            resultados[i][4] = minima; //temperatura minima del mes
        }
    }
}
