package Temperaturas;

public class MainDinamico {
    //En este array meses meteremos los datos de las temperaturas de los 12 meses
        public static int[][] meses=new int[12][];
        // En este array resultados meteremos por cada mes la temperatura media, el día más caluroso, el día más frio
        // y las correspondientes temperaturas
        public static double[][] resultados=new double [12][5];


        public static void main(String[] args) {
            //creo que el array de meses de 12 filas y tantas columnas como días tenga el mes
            meses=MetodosDinamicos.crearArrayMeses();
            // llenamos el array de 12x31 con datos aleatorios con el método cargarArray() e iremos calculando las columnas
            // del array de resultados (temperatura media, maxima y minima y los correspondientes dias )
            MetodosDinamicos.cargarArray(meses, resultados);
            //con los métodos siguientes obtenemos los datos que nos pide el ejercicio
            Metodos.MostrarTemperaturaMediaPorMes(resultados); // con este metodo recorro el array de resultados y muestro
            // la columnas 0 con la media de temperatura del mes
            Metodos.MostrarDíaMasYMenosCalurosoPorMes(resultados); // con este metodo recorro el array de resultados y muestro
            // las columnas 0, 2,3,4,5  que tienen el nuemro del mes
            // y los días y temperaturas máximas y mínimas
            Metodos.recorrerResultados(resultados); // metodo para recorrer el array y Mostrar el días mas caluroso y
            // el  más frío, y el mes/dia que corresponden

        }
    }


