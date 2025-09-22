public class ComputeArray {
    public static int[] computeArray(int[] array) {
        int[] result = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            int nbr = array[i];

            if (nbr % 3 == 0) {
                result[i] = nbr *5;      
            } else if (nbr % 3 == 1) {
                result[i] = nbr +7;       
            } else { 
                result[i] = nbr ;      
            }
        }

        return result;
    }
}
