import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

 class Converter {
    Map<Character, Integer> romanKeyMap = new HashMap<>();
    TreeMap<Integer, String> arabianKeyMap = new TreeMap<>();

     Converter() {
        romanKeyMap.put('I', 1);
        romanKeyMap.put('V', 5);
        romanKeyMap.put('X', 10);
        romanKeyMap.put('L', 50);
        romanKeyMap.put('C', 100);
        romanKeyMap.put('D', 500);
        romanKeyMap.put('M', 1000);

        arabianKeyMap.put(1000, "M");
        arabianKeyMap.put(900, "CM");
        arabianKeyMap.put(500, "D");
        arabianKeyMap.put(400, "CD");
        arabianKeyMap.put(100, "C");
        arabianKeyMap.put(90, "XC");
        arabianKeyMap.put(50, "L");
        arabianKeyMap.put(40, "XL");
        arabianKeyMap.put(10, "X");
        arabianKeyMap.put(9, "IX");
        arabianKeyMap.put(5, "V");
        arabianKeyMap.put(4, "IV");
        arabianKeyMap.put(1, "I");
    }


         int toArabian(String s) {

            char[] arr = s.toCharArray();
            int arabian;
            int result = romanKeyMap.get(arr[s.length()-1]);
            for (int i = s.length()-1-1; i >=0; i--) {
                arabian = romanKeyMap.get(arr[i]);

                if (arabian < romanKeyMap.get(arr[i + 1])) {
                    result -= arabian;
                } else {
                    result += arabian;
                }

            }
            return result;

        }

        String toRoman(int number) {
        int l =  arabianKeyMap.floorKey(number);
        if ( number == l ) {
            return arabianKeyMap.get(number);
        }
        return arabianKeyMap.get(l) + toRoman(number-l);
    }

        public boolean isRoman(String number){
        return romanKeyMap.containsKey(number.charAt(0));
    }
    }

