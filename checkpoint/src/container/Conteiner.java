package container;

public class Conteiner {
	String id;
	int contMove;
	

	@Override
	public String toString() {
		return "Conteiner ID= " + id + ", contMove= " + contMove;
	}

	public Conteiner(String id, int contMove) {
		super();
		this.id = id;
		this.contMove = contMove;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getContMove() {
		return contMove;
	}

	public void setContMove(int contMove) {
		this.contMove = contMove;
	}

}