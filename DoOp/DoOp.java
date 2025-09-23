public class DoOp {
    public static String operate(String[] args) {
        if(args.length==0){
            return "it depend on the input.";
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
            res=a/b;
        break;
        default:
        return "Error";
        
       }
       return Integer.toString(res);
    }
}