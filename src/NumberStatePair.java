public class NumberStatePair{

    double number;
    boolean state;

    public NumberStatePair(){
        this(0,false);

    }

    public NumberStatePair(double number, boolean state){
        this.number = number;
        this.state = state;

    }



    public double getNumber(){
        return number;
    }

    public boolean getState(){
        return state;
    }

    public void setState(boolean newState){
        this.state = newState;
    }

    public void setNumber(double newNumber){
        this.number = newNumber;
    }
}
