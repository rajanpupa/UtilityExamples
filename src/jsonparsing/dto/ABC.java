package dto;

import java.util.ArrayList;
import java.util.List;


public class ABC {
	public String keyA;
    public List<B> lstB=new ArrayList<B>();
    
	public String getKeyA() {
		return keyA;
	}
	public void setKeyA(String keyA) {
		this.keyA = keyA;
	}
	public List<B> getLstB() {
		return lstB;
	}
	public void setLstB(List<B> lstB) {
		this.lstB = lstB;
	}
    public void addB(B b){
    	lstB.add(b);
    }
    
    @Override
    public String toString() {
    	StringBuilder sb = new StringBuilder("{");
    	
    	sb.append("keyA:" + keyA);
    	sb.append(", lstB: [");
    	
    	for(int i=0; i<lstB.size(); i++){
    		B b = lstB.get(i);
    		sb.append(b.toString() );
    		if(i<lstB.size()-1){
    			sb.append(",");
    		}
    	}
    	sb.append("]}");
    	
    	return sb.toString();
    }
    
}
