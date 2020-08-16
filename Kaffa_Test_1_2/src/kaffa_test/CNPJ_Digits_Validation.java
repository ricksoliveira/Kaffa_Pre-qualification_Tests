package kaffa_test;

public class CNPJ_Digits_Validation {
    
    private String cnpj;
    private final int vCnpj[] = new int[14];
    
    // The constructor sets the String to the "only digits" format by removing the special Characters
    // Then copies it in an array
    public CNPJ_Digits_Validation(String cnpj){
        this.cnpj = cnpj;
        this.cnpj = this.cnpj.replaceAll("\\.", "");
        this.cnpj = this.cnpj.replaceAll("\\-", "");
        this.cnpj = this.cnpj.replaceAll("\\/", "");
        
        for(int i=0; i<14; i++){
            this.vCnpj[i] = Character.getNumericValue(this.cnpj.charAt(i));
        }
    }
    
    // This method checks if the 4 numbers after the / are 0000
    // Since there are no CNPJ numbers wich contains /0000
    public boolean checkDigits(){
        
        if(this.vCnpj[8] == 0 && this.vCnpj[9] == 0 && this.vCnpj[10] == 0 && this.vCnpj[11] == 0){
            return false;
        }
        
        // If those digits aren't 0000, then it proceeds to calculate the first
        // of the last two digits
        else{
            if(this.checkPreLastDigit()){
                return true;
            }
            return false;
        }
    }
    
    
    // It calculates the last two digits of the CNPJ using the rule
    // of module 11 by Receita Federal
    private boolean checkPreLastDigit(){
        
        int vNumber1[] = new int[]{5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
        int vAnswer1[] = new int[12];
        int d1, soma = 0;
        
        // This rule consists in multiplying the each number of the CNPJ (excluding the last two)
        // by a specific decreasing order and getting the total sum of them
        for(int i=0; i<12; i++){
            vAnswer1[i] = this.vCnpj[i] * vNumber1[i];
            soma += vAnswer1[i];
        }

        // The sum is divided by 11 and the rest of the division determines
        // the first of the two last digits
        if(soma % 11.0 < 2){
            d1 = 0;
        }
        else{
            d1 = (int) (11 - soma % 11.0);
        }
        
        // If the pre last digit is equal to the pre last in the given String
        // it then calculates the very last digit
        if(this.vCnpj[12] == d1){
            if(this.checkLastDigit()){
                return true;
            }
        }
        return false;
    }
    
    // For the last digit of the CNPJ the same process is repeated
    // but with one extra number for the pre last digit multiplication
    private boolean checkLastDigit(){
        
        int vNumber2[] = new int[]{6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
        int vAnswer2[] = new int[13];
        int d2;
        int soma = 0;

        for(int i=0; i<13; i++){
            vAnswer2[i] = this.vCnpj[i] * vNumber2[i];
            soma += vAnswer2[i];
        }

        if(soma % 11.0 < 2){
            d2 = 0;
        }
        else{
            d2 = (int) (11 - soma % 11.0);
        }

        // Returns true if the last digit is valid
        if(d2 == this.vCnpj[13]){
            return true;
        }
        return false;
    }
    
}
