public class Calculator{
    private int result;

    //Adding
    public void add(int ... params){
        for (Integer param:params){
            this.result +=param;
        }
    }

    //Getting Result
    public int getResult(){
        return this.result;
    }

    //Cleaning result
    public void cleanResult(){
        this.result =0;
    }
}