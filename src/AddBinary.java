public class AddBinary {

    //67. Add Binary

    public static void main(String[] args) {

        System.out.print(addBinary("11110","10101"));

    }


    public static String addBinary(String a, String b) {
        if(a==null || b==null) {
            return null;
        }
        //1111
        //1010
        int length= a.length() > b.length() ? a.length() : b.length();
        int add=0;
        StringBuilder sb= new StringBuilder();
        for(int i=0;i<length;i++){
            int digitA= 0;
            int digitB= 0;
            if(a.length()-1-i>=0){
                digitA= Integer.valueOf(String.valueOf(a.charAt(a.length()-1-i)));
            }

            if(b.length()-1-i>=0){
                digitB= Integer.valueOf(String.valueOf(b.charAt(b.length()-1-i)));
            }
            int sum=digitA+digitB+add;
            if(sum>=2){
                add=1;
            } else {
                add=0;
            }

            sb.append(String.valueOf(sum%2));
        }

        if(add==1){
            sb.append("1");
        }
        return sb.reverse().toString();
    }

}
