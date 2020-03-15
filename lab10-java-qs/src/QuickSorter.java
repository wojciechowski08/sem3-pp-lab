import java.io.Console;
import java.util.Random;

class QuickSorter implements Runnable{

    // CONCURRENT
    int[] data;
    int start,end;
    QuickSorter(int[] data,int start,int end) {
        this.data=data;
        this.start=start;
        this.end=end;
    }
    public void run(){
        quickSort(this.data,this.start,this.end);
    }
    // CONCURRENT END

    static void swap(int[] data, int i, int j){
        int tmp=data[i];
        data[i]=data[j];
        data[j]=tmp;
    }
    static int partition(int[] data, int start, int end) {
        if(start==end)
            return start;
        int pivot=data[end];
        int s=start-1;
        for(int i=start;i<end;i++)
            if(data[i]<=pivot)
                swap(data,++s,i);
        swap(data,++s,end);
        return s;
    }
    static void quickSort(int[] data, int start, int end) {
        if (end<=start)
            return;
        int s=partition(data,start,end);
        quickSort(data,start,s-1);
        quickSort(data,s+1,end);
    }
    static int[] randomList(int n,int k) {
        Random random=new Random();
        int[] data=new int[n];
        for(int i=0;i<data.length;i++)
            data[i]=random.nextInt(k);
        return data;
    }
    public static void main(String[] args) {
        int[] data={3,1,2,8,5,6, 2, 5, 3, 2, 6, 4, 7};
        quickSort(data,0,data.length-1);
        for(int i:data)
            System.out.print(i + " ");
        int n=10000000;
        data=randomList(n,1000000);

        // CONCURRENT
        int s=partition(data,0,n-1);
        Thread t1 = new Thread(new QuickSorter(data,0,s-1));
        Thread t2 = new Thread(new QuickSorter(data,s+1,data.length-1));
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        }catch(InterruptedException e){
            System.out.println(e);
        }
        //CONCURRENT END

    }
}

//import java.util.concurrent.Semaphore;
//
//class Quicksorter extends Thread {
//
//    private static Semaphore semaphore = new Semaphore(1);
//
//    int partition(int arr[], int low, int high) {
//        int pivot = arr[high];
//        int i = (low - 1);
//        for (int j = low; j < high; j++) {
//            if (arr[j] < pivot) {
//                i++;
//
//                int temp = arr[i];
//                arr[i] = arr[j];
//                arr[j] = temp;
//            }
//        }
//
//        int temp = arr[i + 1];
//        arr[i + 1] = arr[high];
//        arr[high] = temp;
//
//        return i + 1;
//    }
//
//    @Override
//    public void run() {
//
//        int arr[] = {10, 7, 8, 9, 1, 5};
//        int n = arr.length;
//        try {
//            semaphore.acquire();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        sort(arr, 0, n - 1);
//        System.out.println("sorted array \n");
//        printArray(arr);
//
//        semaphore.release();
//
//    }
//
//    void sort(int arr[], int low, int high) {
//        if (low < high) {
//            int pi = partition(arr, low, high);
//
//            sort(arr, low, pi - 1);
//            sort(arr, pi + 1, high);
//        }
//    }
//
//
//    static void printArray(int arr[]) {
//        int n = arr.length;
//        for (int i = 0; i < n; ++i)
//            System.out.print(arr[i] + " ");
//        System.out.println();
//    }
//
//    public static void main(String[] args) {
//        Quicksorter ob1 = new Quicksorter();
//        Quicksorter ob2 = new Quicksorter();
//
//        ob1.start();
//        ob2.start();
//
//        ob1.join();
//        ob2.join();
//    }
//}

