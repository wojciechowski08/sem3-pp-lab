package Book;

public class NegativeQtyException extends Exception {
    public NegativeQtyException(){
    }
    public NegativeQtyException(String message){
        super(message);
    }
}
