class N_Rainhas {
	
	private int n;
	private ArrayList<int[]> validAnswers;

	
	public N_Rainhas(int n) {
		this.n = n;
		this.validAnswers = new ArrayList<int[]>();
	}
	
	public int getN() {
		return this.n;
	}
	
	
	
	public ArrayList<int[]> getAnswers() {
		return this.validAnswers;
	}
	
	public void n_rainhas(int i, int[] positions) {
		if(i == n) {
			validAnswers.add(positions);
			System.out.println(Arrays.toString(positions));
		} else {
			
			for(int j = 1; j <= n; j++) {
				positions[i] = j;
			
				if(isValid(positions, i)) {
					int index = i + 1;
					n_rainhas(index, positions);
				} 
				
			}
		}
	}

	private boolean isValid(int[] posic, int i) {
		for(int j = 0; j < i; j++) {
			if((posic[j] == posic[i]) || (Math.abs(posic[i] - posic[j]) == Math.abs(i - j)) ) {
				return false;
			}
		}
		return true;
	}
	
	
	
}