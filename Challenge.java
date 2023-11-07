
public class PPchallenge{

    public static void main(String args[]){
        String sentence = "Hello \"there\" 13.";
        System.out.println(sentence);
        System.out.println(CapLetter(sentence));
        System.out.println(QuoteMark(sentence));
        System.out.println(LastChar(sentence));
        System.out.println(Period(sentence));
        System.out.println(checkNums(sentence));
    }

    public static boolean CapLetter(String sentence){
        //check first latter to be sure it is a capital
        char first = sentence.charAt(0);
        if (Character.isUpperCase(first)){
            return true;
        }else{
            return false;
        }
    }

    public static boolean QuoteMark(String sentence){
        //count how many quote marks there are
        int len = sentence.length();
        int i = 0;
        int count = 0;
        while (i<len){
            char check = sentence.charAt(i);
            if (check == '"'){
                count++;
            }
            i++;
        }
        //if the remainder after devided by 2 is even, then valid
        if ((count %2) == 0 ){
            return true;
        }
        else{
            return false;
        }
    }

    public static boolean LastChar(String sentence){
        //checking last char to be equal to one of the valid selections
        int len = sentence.length();
        char last = sentence.charAt(len-1);
        if ((last == '!')||(last == '?')||(last == '.')){
            return true;
        }else{
            return false;
        }
    }

    public static boolean Period(String sentence){
        //making usre the . doesnt appear anyhwere apart from the end
        int len = sentence.length();
        int i = 0;
        int count = 0;
        while (i<len-1){
            char check = sentence.charAt(i);
            if (check == '.'){
                count++;
            }
            i++;
        }
        if (count >0){
            return false;
        }else{
            return true;
        }
    }

    public static boolean checkNums(String sentence){
        int i = 0;
        int len = sentence.length();
        int count = 0;
        while (i<len-1){
            //checking for one and two digit numbers
            char check1 = sentence.charAt(i);
            char check2 = sentence.charAt(i+1);
            //if flag1 is true and flag2 is fasle then a single digit has been found
            // if both flags true then a to digit number has been found
            boolean flag1 = Character.isDigit(check1);
            boolean flag2 = Character.isDigit(check2);

            //if a single digit number incremnet counter to say a single digit less than 13 was found
            if (flag1 || !flag2){
                count++;
            }
            //check if two digit number is less than 13, if so increment 
            if(flag1 || flag2){
                if((check1 == '1') || (check2 < '3')){
                    count++;
                }
                i++;
            }
            i++;
        
        }
        //if counter has been incremented then invalid string
        if (count==0){
            return true;
        }else{
            return false;
        }
    }
}