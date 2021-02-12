package de.chess.game;

public class MoveList {
	
	private Move[] moves;
	
	private int count;
	
	private int picked;
	
	public MoveList() {
		moves = new Move[BoardConstants.MAX_POSSIBLE_MOVES];
	}
	
	public Move[] getMoves() {
		return moves;
	}
	
	public int getCount() {
		return count;
	}
	
	public void setMoves(Move[] moves) {
		this.moves = moves;
	}
	
	public void setCount(int count) {
		this.count = count;
	}
	
	public void addMove(int from, int to, int captured, int promoted, int flag) {
		moves[count] = new Move(from, to, captured, promoted, flag);
		count++;
	}
	
	public Move getMove(int i) {
		return moves[i];
	}
	
	public void setMove(Move move, int i) {
		moves[i] = move;
	}
	
	public boolean hasMovesLeft() {
		return picked < count;
	}
	
	public Move next() {
		picked++;
		
		Move best = null;
		
		for(int i=0; i<count; i++) {
			Move m = moves[i];
			
			if(m.getScore() != Integer.MIN_VALUE) {
				if(best == null || m.getScore() > best.getScore()) {
					best = m;
				}
			}
		}
		
		best.setScore(Integer.MIN_VALUE);
		
		return best;
	}
	
}
