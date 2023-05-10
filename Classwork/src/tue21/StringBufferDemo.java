package tue21;
//MenuDriven

//if you have not passed anything in string buffer its capacity is 16 which is by default size

//ensure capacity and capacity

//methods
//append is for all datatype helps to add alpha numeric
//in replace end index is excluded
//reverse
// insert(at given poosition)
// delete(end wala excluded hai)


class MutableStrings{
    public void display(){
        String name = "Coditas";
        name.concat("Solutions");
        System.out.println(name);

        StringBuffer stringBuffer = new StringBuffer("Kritis");
        stringBuffer.append("Journey");
        stringBuffer.ensureCapacity(67);
        System.out.println(stringBuffer);

    }

}


public class StringBufferDemo {
    public static void main(String[] args){
        MutableStrings mutableString = new MutableStrings();
        mutableString.display();

    }
}
