import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random random=new Random();
        int computerNumber=random.nextInt(100);
        int computerNumber2=(int)(Math.random()*100);
        System.out.println(computerNumber);
        System.out.println(computerNumber2);
        Scanner scanner=new Scanner(System.in);
        int right=0;
        int selected;
        int[] wrongSelected=new int[5];
        boolean isWin=false;
        boolean isWrong=false;
        while (right<5){
            System.out.print("Tahmininizi Giriniz :");
            selected=scanner.nextInt();
            if (selected<0 || selected>99){
                System.out.println("Lütfen 0-100 arasında bir değer giriniz.");
                if (isWrong){
                    right++;
                    System.out.println("Çok fazla hatalı giriş yaptınız. Kalan Hak :"+(5-right));
                }else {
                    isWrong=true;
                    System.out.println("Bir sonraki hatalı girişinizde hakkınızdan düşülecektir.");
                }
                continue;
            }
            if (selected==computerNumber){
                System.out.println("Tebrikler. Doğru tahmin ettiniz. Tahmininiz :"+computerNumber);
                isWin = true;
                break;
            }else {
                System.out.println("Hatalı giriş.");
                if (selected>computerNumber){
                    System.out.println("Daha küçük bir sayı giriniz.");
                }else {
                    System.out.println("Daha büyük bir sayı giriniz.");
                }
                wrongSelected[right++]=selected;
                System.out.println("Kalan hak :"+(5-right));
            }
        }
        if (!isWin){
            System.out.println("Kaybettiniz!");
            if (!isWrong){
                System.out.println("Tahminleriniz : "+ Arrays.toString(wrongSelected));
            }
        }
    }
}