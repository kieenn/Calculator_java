package Console;

public class Console_Calculator {
    private static String bieuThuc;

    public Console_Calculator() {

    }


    private String Tinh(String a,String operator, String b){
        double result;
        if(operator.equals('+')){
            result = Sum(a,b);
        }
        else if(operator.equals('-')){
            result= Minus(a,b);
        }
        else if(operator.equals('*')){
            result = Time(a,b);
        }
        else if(operator.equals('/')){
            result = Divide(a,b);
        } else{
            result = Sum(a,b);
        }
        bieuThuc = a + operator + b +'=' + result;
        return bieuThuc;
    }
    public static double Sum(String a, String b) {
        double result = Double.parseDouble(a) + Double.parseDouble(b);
        bieuThuc = a + "+" + b + "=" + result;
        return result;
    }

    public static double Minus(String a, String b) {
        double result = Double.parseDouble(a) - Double.parseDouble(b);
        bieuThuc = a + "-" + b + "=" + result;
        return result;
    }

    public static double Time(String a, String b) {
        double result = Double.parseDouble(a) * Double.parseDouble(b);
        bieuThuc = a + "*" + b + "=" + result;
        return result;
    }

    public static double Divide(String a, String b) {
        double result = Double.parseDouble(a) / Double.parseDouble(b);
        bieuThuc = a + "/" + b + "=" + result;
        return result;
    }

    public static double  percent(String a){
        double result = Double.parseDouble(a)/100;
        bieuThuc = a +"%="+result;
        return result;
    }

    public static double XX(String a){
        double result = Math.pow(Double.parseDouble(a),2);
        bieuThuc = a +"^2 =" + result;
        return result;
    }
    public static double DivideX(String a){
        double result = 1/Double.parseDouble(a);
        bieuThuc = "1/"+a +"="+result;
        return result;
    }

    public static double sqrt(String a){
        double result = Math.sqrt(Double.parseDouble(a));
        bieuThuc = "sqrt("+a+")="+result;
        return result;
    }

    public static double PlusOrMinus(String a){
        double result = Double.parseDouble(a);
        if(result > 0){
            result = -result;
        }else result = Math.abs(result);

        bieuThuc = a + "+/- = "+result;
        return  result;
    }

}
