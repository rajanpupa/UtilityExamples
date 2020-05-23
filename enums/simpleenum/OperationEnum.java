package simpleenum;

public enum OperationEnum implements Operator{

	SUM {
		@Override
		public double calculate(int... values) {
			int ans = 0;
			for(int i : values) {
				ans += i;
			}
			return ans;
		}
	}
	;
	

}
