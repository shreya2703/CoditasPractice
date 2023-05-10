public class StringMethod {
    public static void main(String[] args){
        String name = "Shreya";
        System.out.println(name);


        //Methods in String

        //1 concat()
        String fullname="";
        fullname = name.concat(" Kalluraya");
        System.out.println(fullname);

        //2 toUpperCase()
        System.out.println(name.toUpperCase());

        //3 toLowerCase()
        System.out.println(name.toLowerCase());

        //4 getBytes()
        System.out.println(name.getBytes());

        //5 contains()
        System.out.println(name.contains("S"));

        //6 replace()
        System.out.println(name.replace("a","z"));

        //7 isEmpty()
        System.out.println(name.isEmpty());

        //8 charAt()
        System.out.println(name.charAt(2));

        //9 codePointAt()
        System.out.println(name.codePointAt(5));

        //10 codePointCount
        System.out.println(name.codePointCount(1,3));

        //11 compare to
        String name1 = "Shreya";
        System.out.println(name.compareTo(name1));

        //12 compareToIgnoreCase()
        String name2 ="shreya";
        System.out.println(name.compareToIgnoreCase(name2));

        //13 contentEquals
        System.out.println(name.contentEquals("Shreya"));

        //14 codePointBefore()
        System.out.println(name.codePointBefore(3));

        //15 intern
        System.out.println(name.intern());

        //16 endsWith()
        System.out.println(name.endsWith("a"));

        //17 trim
        System.out.println(name.trim());

        //18 hashCode
        System.out.println(name.hashCode());

    }
}
