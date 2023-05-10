package customException;

public class Register {
    public void checkCitizenship(String citizenship,int age) {
        if(age<18)
            try {
                throw new AgeNotValidException(" So you are not eligible");
            }catch(AgeNotValidException e){
                 //System.out.println(e.getMessage()) ;
            }
        if(!citizenship.equalsIgnoreCase("Indian"))
            try {
                throw new NonIndianCitizenshipException(" So you are not eligible");
            } catch (NonIndianCitizenshipException e) {
                //throw new RuntimeException(e);
                //System.out.println(e.getMessage());
            }
    }
}
