// Team LameNameBoyz -- Elias Milborn, James Hua
// APCS Pd10
// HW37 -- Rational Equality
// 2015-11-25

import cs1.Keyboard;  //if comfortable with Scanner, you may comment this out

/*The game works out fine. Only things that are not addressed includes when a person chooses a tile that is already matched and flipped over. The other thing is that the Scrambler requires the addition of the method getFace() to Tile which allows us to Scramble up the board.
 */
		
public class Concentration {

    //instance variables
    private Tile[][] _board;     //storage for 4x4 grid of Tiles.
    private int _numberFaceUp;   //count of Tiles with faces visible
    private String[] _words = {"1","2","3","4","5","6","7","8"};     //list of unique Strings used for Tile vals
    private static int _numRows = 4;


    //insert constructor and methods here
    public Concentration(){
	_board = new Tile[4][4];
	_numberFaceUp = 0;
    }

    public void populate(){
	double count =0;
	for (int x=0 ; x < _board.length ; x++){
	    for (int y = 0 ; y< _board[x].length ; y++){
		_board[x][y] = new Tile(_words[(int)count]);
		count += 0.5;
	    }
	}
    }

    //Swap method to be used in scrambling
    public void swap(int x1, int y1, int x2, int y2){
	String holder = ""; //to hold the place of first tile
	holder = _board[x1][y1].getFace();
	_board[x1][y1] = _board[x2][y2];
	_board[x2][y2] = new Tile(holder);
    }
    public void scramble(){
	for ( int x = 0; x < 50; x++){ //Swaps random cards around to scramble
	    int a = (int)(Math.random()*4);
	    int b = (int)(Math.random()*4);
	    int m = (int)(Math.random()*4);
	    int n = (int)(Math.random()*4);
	    swap(a,b,m,n);
	}
    }
    
    public void print() { 
        for (Tile[] x : _board){             //For each row
	    for (Tile y : x){          //For each int
		System.out.print(y.toString()+"\t ");
	    }
	    System.out.print("\n");
	}
    }


    public void randomize(String[] x){
	int count = 0;
	while (count< x.length){
	    String bck = x[count];
	    int ran = (int)(Math.random()*(x.length - 1));
	    x[count] = x[ran];
	    x[ran] = bck;
	    count++;
	}
    }

    //Method for each turn when you flip two tiles
    public void turn(){
	System.out.println("Here is your board");
	print();
	System.out.println("Choose a tile");
	//Choosing first tile
	System.out.println("Pick a row and column");
	int x1 = 0;
	int y1 = 0;
	x1 = Keyboard.readInt();
	y1 = Keyboard.readInt();
	if (!_board[x1][y1].isFaceUp()){

	    _board[x1][y1].flip(); 
	    print(); //Showing the tile that is chosen
	
	    System.out.println("Choose another tile");
	    //Choosing second tile
	    System.out.println("Pick a row and column");
	    int x2 = 0;
	    int y2 = 0;
	    x2 = Keyboard.readInt();
	    y2 = Keyboard.readInt();
	    if (!_board[x2][y2].isFaceUp()){		
		_board[x2][y2].flip();
		print();
	
		if (_board[x1][y1].equals(_board[x2][y2])){
		    System.out.println("Successful match");
		    _numberFaceUp += 2;
		}
		else{
		    System.out.println("No match");
		    _board[x1][y1].flip();
		    _board[x2][y2].flip();
		}
	    }
	    else {System.out.println("Your Tile is already flipped over");}
	}
	else{System.out.println("This Tile is already flipped over");}
    }
	    
    public void play(){
	randomize(_words);
	populate();
	scramble();
	while (_numberFaceUp < 16){
	    turn();
	}
	System.out.println("Congragulations You Win!"); //This is only if you match all 16
    }
	

	
		
    //DO NOT MODIFY main()
    public static void main(String[] args){
	Concentration game = new Concentration();
       	game.play();
    }

}//end class Concentration

