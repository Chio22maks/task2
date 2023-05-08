public class Main {
    public static void main(String[] args) {
        canculeted("V + VII");
    }
    public static void canculeted(String arg) {
        Integer integer;
        Integer integer2;
        String a = "V";
        String b = "I";
        String c = "X";

        String[] split = arg.split(" ");

        if (split.length>3){throw new RuntimeException();}

        boolean flag = false;
        String first = split[0];
        if (Roman.I.name().equals(first)) flag = true;
        if (Roman.II.name().equals(first)) flag = true;
        if (Roman.III.name().equals(first)) flag = true;
        if (Roman.IV.name().equals(first)) flag = true;
        if (Roman.V.name().equals(first)) flag = true;
        if (Roman.VI.name().equals(first)) flag = true;
        if (Roman.VII.name().equals(first)) flag = true;
        if (Roman.VIII.name().equals(first)) flag = true;
        if (Roman.IX.name().equals(first)) flag = true;
        if (Roman.X.name().equals(first)) flag = true;

        boolean flag2 = false;
        String second = split[2];
        if (Roman.I.name().equals(second)) flag2 = true;
        if (Roman.II.name().equals(second)) flag2 = true;
        if (Roman.III.name().equals(second)) flag2 = true;
        if (Roman.IV.name().equals(second)) flag2 = true;
        if (Roman.V.name().equals(second)) flag2 = true;
        if (Roman.VI.name().equals(second)) flag2 = true;
        if (Roman.VII.name().equals(second)) flag2 = true;
        if (Roman.VIII.name().equals(second)) flag2 = true;
        if (Roman.IX.name().equals(second)) flag2 = true;
        if (Roman.X.name().equals(second)) flag2 = true;
        if (flag && flag2 || !flag && !flag2) {

            boolean flag3 = false;
            if (first.startsWith(a) || first.startsWith(b) || first.startsWith(c)) {
                flag3 = true;
                Roman roman = Roman.valueOf(first);
                int firstArab = roman.value;
                integer = firstArab;
                Roman secondRoman = Roman.valueOf(second);
                integer2 = secondRoman.getValue();

            } else {
                integer = Integer.valueOf(first);
                integer2 = Integer.valueOf(second);
            }
            if (integer > 10 || integer <=0 || integer2 > 10 || integer2 <=0) {
                throw new RuntimeException();
            }
            String znak= split[1];
            switch (znak) {
                case "+" -> { if(flag3) System.out.println(toRomanNumeral(integer + integer2));
                else  System.out.println(integer + integer2);
                }
                case "-" -> { if(flag3) System.out.println(toRomanNumeral(integer - integer2));
                else  System.out.println(integer - integer2);
                }
                case "*" -> { if(flag3) System.out.println(toRomanNumeral(integer * integer2));
                else   System.out.println(integer * integer2);
                }
                case "/" -> { if(flag3) System.out.println(toRomanNumeral(integer / integer2));
                else  System.out.println(integer / integer2);
                }
            }
        } else {
            throw new RuntimeException();
        }
    }
    public enum Roman {
        I(1),
        II(2),
        III(3),
        IV(4),
        V(5),
        VI(6),
        VII(7),
        VIII(8),
        IX(9),
        X(10);

        private int value;

        Roman(int i) {
            value = i;
        }

        void Roman(int i) { /// добавил void
            this.value = i;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }


    }
    public static String toRomanNumeral(int number) {
        if (number<=0){throw new RuntimeException();
        }
        String[] romanNumerals = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < romanNumerals.length; i++) {
            while (number >= values[i]) {
                number -= values[i];
                sb.append(romanNumerals[i]);
            }
        }
        return sb.toString();
    }}