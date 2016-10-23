
import java.util.Arrays;


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
        System.arraycopy(intersection, 0, result, 0, result.length);
        return result;
    }

    /*
     * тест пересечения
    */
    public static boolean testArrayIntersection(){
        double[] array1 = {1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0};
        double[] array2 = {2.0, 4.0, 6.0, 8.0};
        double[] result = arrayIntersection(array1,array2);
        double[] correctResult = {2.0,4.0,6.0};

        if(!Arrays.equals(result, correctResult))
            return false;

        double[] array11 = {1.0, 2.0, 3.0, 4.0, 5.0 ,6.0, 7.0};
        double[] array21 = {1.0, 1.0, 1.0, 7.0};
        double[] result1 = arrayIntersection(array11,array21);
        double[] correctResult1 = {1.0, 1.0, 1.0, 7.0};

        if(!Arrays.equals(result1, correctResult1))
            return false;

        return true;
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

        boolean passTests = testArrayIntersection();
        if(passTests){
            System.out.println("Running tests: true");
        }
        else{
            System.out.println("Running tests: false");
        }

        double[] array1 = {2.5, 3.0, 4.1, 5.5, 6.6, 7.9};
        double[] array2 = {2.3, 4.1, 6.6, 7.9};
        double[] result = arrayIntersection(array1,array2);

        System.out.println("SourceArrays:");
        printArray(array1);
        printArray(array2);

        System.out.println("Intersection:");
        printArray(result);

    }
}
