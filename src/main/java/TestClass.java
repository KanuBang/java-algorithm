
import java.util.*;

public class TestClass {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int find = sc.nextInt();
        int[] target = new int[n];
        for(int i = 0; i < n; i++) {
            target[i] = sc.nextInt();
        }


        for(int i=0; i < n; i++){

            int now = target[i];

            int start = 0;
            int end = find - 1;
            int mid = (start + end) / 2;
            int mid_val = arr[mid];

            while(start <= end) {

            }
        }

    }
}
