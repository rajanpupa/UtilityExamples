package simpleenum;

public enum TransactionState {

    COMPLETE, 
    REJECTED, 
    PENDING
    ;

    public boolean isTransactionComplete(){
        switch(this){
            case COMPLETE:
                return true;
            case PENDING:
                return false;
            case REJECTED:
                return false;
            default:
                return false;
        }
    }
    
    public static void main(String[] args) {
		TransactionState ts = TransactionState.PENDING;
		System.out.println(ts.isTransactionComplete());
	}
}
