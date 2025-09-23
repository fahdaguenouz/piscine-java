public class DoOp {
    public static String operate(String[] args) {
        if(args.length==0){
            return "Error";
        }
       int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[2]);

       String op = args[1];
    //   System.out.println(a+b);
      int res=0;
       switch (op){
        case "+":
            res=a+b;
        break;
         case "-":
            res=a-b;
        break;
         case "*":
            res=a*b;
        break;
         case "/":
         if(b<0){
            return "Error";
        }
            res=a/b;
        break;
        case "%":
        if(b<0){
            return "Error";
        }
            res=a%b;
        break;
        default:
        return "Error";
        
       }
       return Integer.toString(res);
    }
}