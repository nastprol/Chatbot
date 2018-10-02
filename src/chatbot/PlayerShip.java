package chatbot; 

public class PlayerShip extends Ship {
	
	public PlayerShip(int length, int position)
	{
		super(length, position);
	}
	
	public PlayerShip(int position,Orientation orientation,int length)
	{
		super(position, orientation, length);
	}
	
	public void FirstUpdate(int position) {
		this.position = position;
		this.orientation = Orientation.unknown;
		this.length = 1;
	}
	
	public void MoveShip(int position) {
		if (this.orientation == Orientation.unknown) {
			if (this.position % 10 == position % 10)
				this.orientation = Orientation.vertically;
			else
				this.orientation = Orientation.horizontally;
		}
		if (this.position > position)
			this.position = position;
		this.length++;

	}


}
