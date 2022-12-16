public class MinHeap {

    private int[] Heap;
    private int size;
    private int maxsize;



    public MinHeap(int maxsize) {

        this.maxsize = maxsize;
        this.size = 0;
        Heap = new int[maxsize];

    }

    private int parent(int pos) {
        return (pos - 1) / 3;
    }


    private int leftChild(int pos) {
        return (3 * pos) + 1;
    }

    private int midleChild(int pos) {
        return (3 * pos) + 2;
    }

    private int rightChild(int pos) {
        return (3 * pos) + 3;
    }


    private boolean isLeaf(int pos) {

        if (pos > (maxsize / 2)) {
            return true;
        }

        return false;
    }


    private void swap(int fpos, int spos) {

        int tmp;
        tmp = Heap[fpos];

        Heap[fpos] = Heap[spos];
        Heap[spos] = tmp;
    }


    public boolean checkTreeMinHeap(int[] numbers) {
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < numbers[parent(i)]) {
                return false;
            }
        }
        size= numbers.length;
        return true;
    }


    public void insert(int element) {

        if (size >= maxsize) {
            return;
        }

        int current = size;
        Heap[size] = element;
        size++;
        while (Heap[current] < Heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    void setHeap(int[] numbers) {
        for (int n = 0; n < numbers.length; n++) {
            Heap[n] = numbers[n];
        }
    }

    public void print() {
        for (int i = 0; i <= size / 3; i++) {

            System.out.print(" PARENT : " + Heap[i]);

            if ((3 * i + 1) < size) {
                System.out.print(" LEFT CHILD  : " + Heap[3 * i + 1]);
            }
            if ((3 * i + 2) < size) {
                System.out.print(" MIDDLE CHILD  : " + Heap[3 * i + 2]);
            }
            if ((3 * i + 3) < size) {
                System.out.print(" RIGHT CHILD  : " + Heap[3 * i + 3]);
            }

            System.out.println();
        }
    }


}