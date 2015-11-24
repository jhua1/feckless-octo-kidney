import cs1.Keyboard;  //if comfortable with Scanner, you may comment this out

		
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
	double count = 0;
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
	holder = _board[x1][y1];
	_board[x1][y1] = _board[x2][y2];
	_board[x2][y2] = holder;
    }
    public void scramble(){
	for ( int x = 0; x < 30; x++){ //Swaps random cards around to scramble
	    int a = (int)(Math.random()*3);
	    int b = (int)(Math.random()*3);
	    int m = (int)(Math.random()*3);
	    int n = (int)(Math.random()*3);
	    swap(a,b,m,n);
	}
    }
    
    public void print() { 
        for (Tile[] x : _board){             //For each row
	    for (Tile y : x){          //For each int
		System.out.print(y.toString()+" ");
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

    public void play(){
	randomize(_words);
    }
	

	
		
    //DO NOT MODIFY main()
    public static void main(String[] args){
	Concentration test = new Concentration();
	test.play();
	test.populate();
	test.print();
	test.scramble();
	test.print();
	//	Concentration game = new Concentration();
	//	game.play();
    }

}//end class Concentration

