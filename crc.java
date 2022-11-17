import java.util.*;
class crc
{
      public static void main(String args[])
      {
           //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	   Scanner sc = new Scanner(System.in);
           System.out.println("Enter Generator:");
           String gen = sc.next();//br.readLine();
           System.out.println("Enter Data:");
           String data = sc.next();//br.readLine();
           String code = data;
           int i;
           for(i=1;i<gen.length();i++)
              code = code + "0";
           //System.out.println(code);
           code = data + div(code,gen);
          //System.out.println(code);
           System.out.println("The transmitted Code Word is: " + code);
           System.out.println("Please enter the received Code Word: ");
           String rec = sc.next();//br.readLine();
           if(Integer.parseInt(div(rec,gen)) == 0)
               System.out.println("The received code word contains no errors.");
           else
               System.out.println("The received code word contains errors.");
       }
       static String div(String num1,String num2)
       {
            int pointer = num2.length(); 
            String result = num1.substring(0, pointer);
            String remainder = "";
            for(int i = 0; i < num2.length(); i++)
            {
                 if(result.charAt(i) == num2.charAt(i))
                    remainder += "0";
                 else
                    remainder += "1";
            }
            while(pointer < num1.length())
            {
                 if(remainder.charAt(0) == '0')
                 {
                    remainder = remainder.substring(1, remainder.length());
                    remainder = remainder + String.valueOf(num1.charAt(pointer));
                    pointer++;
                 }
                 result = remainder;
                 remainder = "";
                 for(int i = 0; i < num2.length(); i++)
                 {
                     if(result.charAt(i) == num2.charAt(i))
                    	 remainder += "0";
                     else
                         remainder += "1";
                  }
             }
              return remainder.substring(1,remainder.length());
       }
}
