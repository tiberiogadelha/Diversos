class MochilaProblem {
	ArrayList<Item> itens;
	ArrayList<Fracionado> mochila;
	double valor_mochila = 0.0;
	
	public MochilaProblem(ArrayList<Item> itens) {
		this.itens = itens;
		mochila = new ArrayList<>();
	}
	
	public void knapsackSolver(double pesoMaximo) {
		double target = pesoMaximo;
		int i = 0;
		
		while(target > 0 && i < itens.size()) {
			Item item = itens.get(i);
			if(item.getPeso() <= target) {
				Fracionado fr = new Fracionado(1, item);
				i++;
				target -= item.getPeso();
				mochila.add(fr);
				valor_mochila += item.getValor();
				
			} else {
				double peso = item.getPeso();
				double target1 = target;
				double fracao = target1/peso;
				Fracionado fr = new Fracionado(fracao, item);
				target -= (fracao * item.getPeso());
				mochila.add(fr);
				valor_mochila += item.getValor() * fracao;
			}
		}
		
		System.out.println(mochila.toString() + " - Valor da mochila: " + valor_mochila);
	}
}

class Item implements Comparable<Item>{
	private double peso;
	private double valor;
	
	public Item(double peso, double valor) {
		this.peso = peso;
		this.valor = valor;
	}
	
	@Override
	public int compareTo(Item o) {
		double preco1 = (this.valor/this.peso); 
		double preco2 = (o.getValor()/ o.getPeso());
		
		int compare = 0;
		
		if(preco1 < preco2) {
			compare = 1;
		} else if(preco1 > preco2) {
			compare = -1;
		}
		
		return compare;
	}
	
	public double getPeso() {
		return this.peso;
	}
	
	public double getValor() {
		return this.valor;
	}
	
	
}

class Fracionado {
	double fracao;
	Item item;
	
	public Fracionado(double fracao, Item item) {
		this.fracao = fracao;
		this.item = item;
	}
	
	@Override
	public String toString() {
		return "Fracao: " + this.fracao + " | Item: (peso: " + this.item.getPeso() + 
				", valor: " + this.item.getValor() + ")";
	}
}
