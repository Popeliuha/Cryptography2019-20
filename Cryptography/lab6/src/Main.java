import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws Exception {
        int p = 3, g = 11, e = 7, d = 3;
        long C, X;
        int n = p*g;
        int f=(p-1)*(g-1);
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < 25 ; i++) {
            StringBuilder sb=new StringBuilder();
            char t1 = 'a';
            int t11=t1-'a'+i;
            t11=t11%26;
            sb.append((char)(t11+'a'));
            map.put(i, sb.toString());
        }
        String text = "abcde";
        System.out.println("Вхідний текст: " + text);
        System.out.print("Зашифрований текст: ");
        String encr = "";
        for(int i = 0; i < text.length(); i++) {
            char t = text.charAt(i);
            if (t == ' ') {
                continue;
            }
            String y = String.valueOf(t);
            for (Map.Entry entry: map.entrySet()) {
                if (y.equals(entry.getValue())) {
                    int m = (int) entry.getKey();
                    encr += (long)Math.pow(m,e)%n;
                    System.out.print(encr + " ");
                    encr = "";
                }
            }
        }

        System.out.println("\nРозшифрований текст: " + text);
    }
}
