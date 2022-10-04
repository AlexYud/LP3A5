package QuicksortForkJoin;

import java.util.concurrent.RecursiveAction;

public class QuicksortForkJoin extends RecursiveAction{
  private int[] lista;
  private int left;
  private int right;

  public QuicksortForkJoin(int[] data) {
    this.lista = data;
    left = 0;
    right = data.length - 1;
  }

  public QuicksortForkJoin(int[] data, int left, int right) {
    this.lista = data;
    this.left = left;
    this.right = right;
  }


  @Override
  protected void compute() {
    if(left < right){
      int pivot = partition(lista, left, right);
      invokeAll(new QuicksortForkJoin(lista, left, pivot),
                new QuicksortForkJoin(lista, pivot + 1, right));
    }
  }

  private int partition(int[] array, int low, int high) {
    int pivot = array[low];
    int i = low - 1;
    int j  = high + 1;
    while (true){
      do {
        i++;
      }
      while (array[i] < pivot);

      do {
        j--;
      }
      while (array[j] > pivot);
      if (i >= j)
        return j;

      troca(array, i, j);
    }
  }

  private void troca(int[] array, int i, int j) {
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }
}
