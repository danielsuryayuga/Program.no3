import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void tampilkanMenu() {
        System.out.println(" ");
        System.out.println("Menu");
        System.out.println("1. Random Data");
        System.out.println("2. Simulasi Bubble Sort - Ascending");
        System.out.println("3. Simulasi Selection Sort - Ascending");
        System.out.println("4. Simulasi Bubble Sort - Descending");
        System.out.println("5. Simulasi Selection Sort - Descending");
        System.out.println("6. Keluar");
    }

    public static int[] bubbleSortAscending(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
                System.out.println("Iterasi " + (i + 1) + ", Langkah " + (j + 1) + ": " + Arrays.toString(arr));
            }
            if (!swapped) {
                break;
            }
        }
        return arr;
    }

    public static int[] selectionSortAscending(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
            System.out.println("Iterasi " + (i + 1) + ": " + Arrays.toString(arr));
        }
        return arr;
    }

    public static int[] bubbleSortDescending(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] < arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            System.out.println("Iterasi " + (i + 1) + ": " + Arrays.toString(arr));
            if (!swapped) {
                break;
            }
        }
        return arr;
    }

    public static int[] selectionSortDescending(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[maxIndex]) {
                    maxIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[maxIndex];
            arr[maxIndex] = temp;
            System.out.println("Iterasi " + (i + 1) + ": " + Arrays.toString(arr));
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println("Selamat datang di Program Simulasi");

        Scanner scanner = new Scanner(System.in);
        int[] dataAcak = null;

        while (true) {
            tampilkanMenu();
            System.out.print("Masukkan Pilihan Anda: ");
            String pilihan = scanner.nextLine();

            if (pilihan.equals("1")) {
                System.out.println(" ");
                System.out.println("Random Data");
                System.out.print("Masukkan batas atas: ");
                int batasAtas = Integer.parseInt(scanner.nextLine());
                System.out.print("Masukkan batas bawah: ");
                int batasBawah = Integer.parseInt(scanner.nextLine());

                if (batasBawah >= batasAtas) {
                    System.out.println("Batas atas harus lebih besar dari batas bawah. Silahkan masukkan ulang angka yang benar.");
                    return;
                }

                int jumlahData = 5;
                dataAcak = new int[jumlahData];
                Random random = new Random();

                for (int i = 0; i < jumlahData; i++) {
                    dataAcak[i] = random.nextInt(batasAtas - batasBawah + 1) + batasBawah;
                }

                System.out.println("Berikut random data yang dihasilkan:");
                System.out.println(Arrays.toString(dataAcak));
            } else if (pilihan.equals("2")) {
                System.out.println(" ");
                System.out.println("Bubble Sort - Ascending");
                int[] bubbleSortAscending = bubbleSortAscending(Arrays.copyOf(dataAcak, dataAcak.length));
                System.out.println(Arrays.toString(bubbleSortAscending));
            } else if (pilihan.equals("3")) {
                System.out.println(" ");
                System.out.println("Selection Sort - Ascending");
                int[] selectionSortAscending = selectionSortAscending(Arrays.copyOf(dataAcak, dataAcak.length));
                System.out.println(Arrays.toString(selectionSortAscending));
            } else if (pilihan.equals("4")) {
                System.out.println(" ");
                System.out.println("Bubble Sort - Descending");
                int[] bubbleSortDescending = bubbleSortDescending(Arrays.copyOf(dataAcak, dataAcak.length));
                System.out.println(Arrays.toString(bubbleSortDescending));
            } else if (pilihan.equals("5")) {
                System.out.println(" ");
                System.out.println("Selection Sort - Descending");
                int[] selectionSortDescending = selectionSortDescending(Arrays.copyOf(dataAcak, dataAcak.length));
                System.out.println(Arrays.toString(selectionSortDescending));
            } else if (pilihan.equals("6")) {
                System.out.println(" ");
                System.out.println("Terima kasih telah menggunakan program ini. Sampai jumpa lagi!");
                break;
            } else {
                System.out.println("Pilihan tidak valid");
            }
        }

        scanner.close();
    }
}
