import java.util.*;

class Info {
    int month;
    int day;
    int hour;
    int minute;

    final int[] dayOfMonth = { 0, 0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334 };// 2월 1일 기준 32가 되면 되므로

    String userName;
    String productName;

    Info(String userName, String productName) {
        this.userName = userName;
        this.productName = productName;
    }

    public long get_MinuteBase_Time() {
        int mm_part = minute;
        int hh_part = hour * 60;
        int MM_part = (dayOfMonth[month] + (day-1)) * 1440;

        return MM_part + hh_part + mm_part;
    }
}



public class Main {
    private static int N, F;
    private static int day, hour, minute;
    private static int deadline;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        HashMap<String, Info> hashMap = new HashMap();
        TreeMap<String,Long> output_Map= new TreeMap<>();


        String[] input_NLF = new String[3];

        for (int i = 0; i < 3; i++)
            input_NLF[i] = sc.next();

        N = Integer.valueOf(input_NLF[0]);
        F = Integer.valueOf(input_NLF[2]);

        day = Integer.valueOf(input_NLF[1].substring(0, 3));
        hour = Integer.valueOf(input_NLF[1].substring(4, 6));
        minute = Integer.valueOf(input_NLF[1].substring(7, 9));

        deadline = day* 1440 + hour * 60 + minute;

        for (int i = 0; i < N; i++) {

            String[] input_info = new String[4];

            for (int k = 0; k < 4; k++)
                input_info[k] = sc.next();

            String myHash = input_info[3] +"$$$"+ input_info[2]; // 키값

            Info info = new Info(input_info[3], input_info[2]);

            info.month = Integer.valueOf(input_info[0].substring(5, 7));
            info.day = Integer.valueOf(input_info[0].substring(8, 10));

            info.hour = Integer.valueOf(input_info[1].substring(0, 2));
            info.minute = Integer.valueOf(input_info[1].substring(3, 5));

            if (!hashMap.containsKey(myHash)) hashMap.put(myHash, info);

            else {
                Info preInfo = hashMap.get(myHash);

                long pre_value = preInfo.get_MinuteBase_Time();
                long cur_value = info.get_MinuteBase_Time();

                long gap = (cur_value - pre_value) - deadline;

                if (gap > 0) {
                    long tmp_fee=0;
                    if(output_Map.containsKey(preInfo.userName)){
                        tmp_fee=output_Map.get(preInfo.userName);
                    }
                    output_Map.put(preInfo.userName, tmp_fee+gap*F);
                }
                hashMap.remove(myHash);
            }
        }

        if (output_Map.isEmpty()) {
            System.out.println(-1);
            return;
        }

        for(Map.Entry<String,Long> entry : output_Map.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }

    }
}