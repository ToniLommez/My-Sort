class Mergesort{
    public static void sort(int array[]) {
        mergesort(array, 0, array.length-1);
    }

    public static void mergesort(int array[], int esq, int dir) {
        if (esq < dir) {
            int meio = (esq + dir) / 2;
            mergesort(array, esq, meio);
            mergesort(array, meio + 1, dir);
            intercalar(array, esq, meio, dir);
        }
    }

    public static void intercalar(int array[], int esq, int meio, int dir) {
        int novo[] = new int[dir - esq + 1];
        int i = esq;
        int j = meio + 1;
        int pos = 0;
        while (i <= meio && j <= dir)
            novo[pos++] = (array[i] < array[j]) ? array[i++] : array[j++];
        while (i <= meio)
            novo[pos++] = array[i++];
        while (j <= dir)
            novo[pos++] = array[j++];
        pos = 0;
        while(pos < novo.length)
            array[esq++] = novo[pos++];
    }

    public static void main(String[] args){
        int[] array = {2, 6, 4, 3, 7, 4, 8, 2};
        
        sort(array);

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}