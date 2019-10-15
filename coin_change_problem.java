class CoinProblem {
	int[] coins = {100, 50, 25, 10, 5, 1};
	ArrayList<Tuple> pocket = new ArrayList<>();
	
	public CoinProblem() {
		
	}
	
	public void solver(double change) {
		double target = change * 100;
		int i = 0;
		
		while(target > 0) {
			if(coins[i] <= target) {
				double quantity = Math.floor(target/coins[i]);
				Tuple tuple = new Tuple(quantity, coins[i]);
				target -= quantity * coins[i];
				pocket.add(tuple);
			}
			i++;
		}
		
		System.out.println(pocket.toString());
	}
}

class Tuple {
	double quantity;
	int coin_value;
	
	public Tuple(double quantity, int coin_value) {
		this.quantity = quantity;
		this.coin_value = coin_value;
	}
	
	@Override
	public String toString() {
		return "Coin value: " + this.coin_value + " - quantity: " + this.quantity;
	}
}
