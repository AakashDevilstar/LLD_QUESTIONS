package Model;

public class Player {
	
	public String name;
	public PlayingPiece playingpiece;
	
	public Player(String name,PlayingPiece playingpiece){
		this.name=name;
		this.playingpiece=playingpiece;
	}
	
	public String getName() {
		return name;
	}
	
	public void SetName(String name) {
		this.name=name;
	}
	
	public void SetPlayingPiece(PlayingPiece playingpiece) {
		this.playingpiece=playingpiece;
	}
	
	public PlayingPiece getPlayingPiece() {
		return playingpiece;
	}
	
}