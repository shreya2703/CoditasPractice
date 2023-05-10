package tue21;
//it is present in util language
//whole string ko parts m divide by default delimeter is space
//true karne pr delimeter bhi show karta hai
//by using tokenizer string ko array m convert

import java.util.StringTokenizer;

class TokenDemo{
//always write it inside main
    public void Display(){
        StringTokenizer stringToken = new StringTokenizer("Hii, how are you",",",true);
        while(stringToken.hasMoreTokens()){
            System.out.println(stringToken.nextToken());
        }
    }

}

public class StringTokenizerDemo {
    public static void main(String[] args){

        TokenDemo td = new TokenDemo();
        td.Display();

    }
}
