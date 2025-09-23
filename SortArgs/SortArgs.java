import java.util.Arrays;
public class SortArgs {
    public static void sort(String[] args) {
        int[] nbr = new int[args.length];
        for (int i = 0; i < args.length; i++) {
            nbr[i] = Integer.parseInt(args[i]);
        }
        Arrays.sort(nbr);
        for (int i = 0; i < nbr.length; i++) {
            System.out.print(nbr[i]);
            if (i < nbr.length - 1) {
                System.out.print(" ");
            }
        }
        System.out.println(); 
    }
}