/**
 * Побочный класс
 * @author Suika
 * @since 05.01.2017
 */
public class Calculator{
    private int result;
    private boolean divZer = false;
    //Adding
    public void add(int ... params){
        for (Integer param:params){
            this.result +=param;
        }
    }

    //choosing our action:
    public void action(String s, int a, int b) {
        this.result=0;
        switch(s){
            case "+":{
                this.result = a+b;
                break;
            }
            case "-":{
                this.result = a-b;
                break;
            }
            case "*":{
                this.result = a*b;
                break;
            }
            case "/":{
                if (b==0) {
                    this.divZer=true;
                    break;
                }else {
                    this.result = a / b;
                    break;
                }
            }
            case "%":{
                this.result = a%b;
                break;
            }
            case "pow":{
                this.result = (int)Math.pow(a,b);
                break;
            }
        }
    }

    //Getting Result
    public void getResult(){
        if (this.divZer==false){
            System.out.println("Result is : "+this.result);
        }else{
            System.out.println("You tried to divide on 0, nothing happened");
        }
    }

    //Cleaning result
    public void cleanResult(){
        this.divZer=false;
        this.result =0;
    }
}