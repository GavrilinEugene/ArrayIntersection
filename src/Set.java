import java.util.Arrays;


public class Set {
    public static final double defaultEpsilon = 0.001;

    public static double[] intersection(double[] first, double[] second, double epsilon){

        double[] intersection = new double[first.length];
        int intersectionSetLength = 0;

        for(int firstSetIndex = 0; firstSetIndex < first.length; firstSetIndex ++){
            for(int secondSetIndex = 0; secondSetIndex < second.length; secondSetIndex++){
                if(isEqual(first[firstSetIndex],second[secondSetIndex], epsilon))
                    intersection[intersectionSetLength ++] = first[firstSetIndex];
            }
        }
        return trim(intersection, intersectionSetLength);
    }

    private static boolean isEqual(double firstElement, double secondElement, double epsilon){
        return Math.abs(firstElement - secondElement) < epsilon;
    }

    private static double[] trim(double[] set, int length){
        double[] ret = new double[length];
        System.arraycopy(set, 0, ret, 0, length);
        return ret;
    }


    private static boolean checkTests() {
        System.out.print("running tests: ");
        boolean testResult = testArrayIntersection();
        if(testResult == true)
            System.out.println("TRUE");
        else
            System.out.println("FALSE");
        return testResult;
    }

    private static boolean testArrayIntersection(){
        return Arrays.equals(intersection(new double[]{1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0},
                                          new double[]{2.0, 4.0, 6.0, 8.0},
                                          defaultEpsilon),
                                          new double[]{2.0,4.0,6.0});

    }

    public static void printSet(double[] set){
        System.out.print("{");
        for(double element: set)
            System.out.print(element + " ");
        System.out.println("}");
    }

    public static void main(String[] args){

        boolean passTests = checkTests();
        if(!passTests)
            return;

        double[] array1 = {2.5, 3.0, 4.1, 5.5, 6.6, 7.9};
        double[] array2 = {2.3, 4.1, 6.6, 7.9};
        double[] result = intersection(array1,array2, defaultEpsilon);

        System.out.println("SourceArrays:");
        printSet(array1);
        printSet(array2);

        System.out.println("Intersection:");
        printSet(result);
    }
}
