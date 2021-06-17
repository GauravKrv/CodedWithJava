package Regex;

import org.junit.BeforeClass;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;*/

public class EmailValidator {
    private Pattern pattern;
    private Matcher matcher;

    private static final String EMAIL_PATTERN = "^[A-Za-z0-9-\\+]+(\\.[A-Za-z0-9-]+)*@"
            + "^[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    public EmailValidator(){
        pattern = Pattern.compile(EMAIL_PATTERN);
    }

    public boolean validate(final String hex){
        matcher = pattern.matcher(hex);
        return matcher.matches();
    }

}

class EmailTest{
   private EmailValidator emailValidator;

   @BeforeClass
    public void initData(){
       emailValidator = new EmailValidator();
   }

   //@DataProvider
   public Object[][] ValidEmailProvider(){
       return new Object[][] {new String[] {
               "gauravkrv@gmail.com", "gaurav55krv@gmail.com", "gauravkrv@gmailcom"
       }};
   }
}
