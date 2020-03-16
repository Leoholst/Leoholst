import java.util.Arrays;

public class BubbleSort {
	public static void main(String[] args) {
		int array[] = {3,5,6,2,3,9,4,7,5,2};
		bubble(array);
	}
	public static void bubble(int[] array) {
		int list = array.length;
		for(int i=1; i<(list-1); i++) {
			for(int j=0; j<(list-i); j++) {
				if(array[j] > array[j+1]) {
					int tal = array[j];
					array[j] = array[j+1];
					array[j+1] = tal;
				}
			}
		}
		System.out.println(Arrays.toString(array));
	}
}