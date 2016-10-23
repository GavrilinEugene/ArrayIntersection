/**
 * Класс для поиска пересечения массивов типа double
 */
public class ArrayIntersection {

    /**
     * Поиск пересечения
     * @param firstArray первый массив
     * @param secondArray второй массив
     * @return пересечение массивов
     */
    public static double[] arrayIntersection(double[] firstArray, double[] secondArray){
        // массив пересечений не больше по размеру, чем исходные массивы
        double[] intersection = new double[firstArray.length];
        int index = 0;

        for(int i = 0; i < firstArray.length; i ++){
            for(int j = 0; j < secondArray.length; j ++){
                if(firstArray[i] == secondArray[j])
                    intersection[index ++] = firstArray[i];
            }

        }

        // убираем лишние нулевые элементы
        double[] result = new double[index];
        for(int i = 0; i < result.length; i++)
            result[i] = intersection[i];

        return result;
    }

    /*
     * форматированный вывод массива
     */
    public static void printArray(double[] array){
        System.out.print("{");
        for(double element: array)
            System.out.print(element + " ");
        System.out.println("}");
    }

    public static void main(String[] args){
        double[] array1 = {1,2,3,4,5,6,7};
        double[] array2 = {2,4,6,8};
        double[] result = arrayIntersection(array1,array2);

        System.out.println("SourceArrays:");
        printArray(array1);
        printArray(array2);

        System.out.println("Intersection:");
        printArray(result);

    }
}
