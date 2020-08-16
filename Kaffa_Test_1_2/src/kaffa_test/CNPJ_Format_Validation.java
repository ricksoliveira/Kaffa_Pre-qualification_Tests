package kaffa_test;

public class CNPJ_Format_Validation {
    
    private String cnpj;
    
    public CNPJ_Format_Validation(String cnpj){
        this.cnpj = cnpj;
    }
    
    public boolean checkFormat(){
        
        // This condition is used to check if the given String has the special characters in the correct way of the String
        if(this.cnpj.length() == 18){
            
            if(this.cnpj.charAt(2) == '.' && this.cnpj.charAt(6) == '.' && this.cnpj.charAt(10) == '/' && this.cnpj.charAt(15) == '-'){
                
                // If it is, it then removes the dash, slash and dots and saves it in another String
                String rem = cnpj;
                rem = rem.replaceAll("\\.", "");
                rem = rem.replaceAll("\\/", "");
                rem = rem.replaceAll("\\-", "");
                
                // Check to see if the new String has only numbers between 0 and 9
                if(rem.matches("[0-9]+")){
                    return true;
                }
                else{
                    return false;
                }
            }
            
            else{
                return false;
            }
            
        }
        
        // In case the given String doesn't have special characters, it will only have 14 digits
        // this condition checks if they are all numbers
        else if(this.cnpj.length() == 14 && this.cnpj.matches("[0-9]+")){
            return true;
        }
        
        else{
            return false;
        }
        
    }
    
}
