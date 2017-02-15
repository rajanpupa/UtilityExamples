package dto;
import java.util.ArrayList;
import java.util.List;


public class TopObject {
	List<ABC> abcList;
	
	public void addAbc(ABC abc){
		if(abcList == null){
			abcList = new ArrayList<ABC>();
		}
		abcList.add(abc);
	}
	public List<ABC> getAbcList(){
		return abcList;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("{\tabcList : [ \n");
		for(int i=0; i<abcList.size(); i++){
			ABC abc = abcList.get(i);
			sb.append("\n\t\t" + abc.toString());
			if(i<abcList.size()-1){
				sb.append(",");
			}
		}
		sb.append("\n\t]\n}");
		return sb.toString();
	}
}
