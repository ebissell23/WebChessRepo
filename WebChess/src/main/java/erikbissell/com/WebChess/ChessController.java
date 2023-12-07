package erikbissell.com.WebChess;
import java.util.Arrays;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/chess")


public class ChessController {
   
    private Chessboard chessboard;

    public ChessController(){
        this.chessboard = new Chessboard();
    }

    //@CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/board")
    public Piece[][] getChessboard(){
        Piece[][] chessboardData = chessboard.getBoard();
        System.out.println("Chessboard Data: " + Arrays.deepToString(chessboardData));
        return chessboardData;
    }
    @PostMapping("/api/chess/move")
  //  @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<String> movePiece(
      @RequestParam int sourceRow, 
      @RequestParam int sourceCol, 
      @RequestParam int destRow, 
      @RequestParam int destCol){
        try {
          if(chessboard.movePiece(sourceRow, sourceCol, destRow, destCol)){
            return ResponseEntity.ok("Success");
          }
          else{
            return ResponseEntity.badRequest().body("Invalid Move");
          }
        }
        catch(Exception e){
          return ResponseEntity.status(500).body("Internal server error");
        }


    }


    
    
}



/*const ChessboardComponent = ({ chessboard }) => {

  useEffect(() => {
    fetch('http://localhost:8080/api/chess/board')
      .then(response => response.json())
      .then(data => getChessboard(data));
  }, []);

  // Function to render a single square
  const renderSquare = (row, col) => {
    const isWhite = (row + col) % 2 === 0;
    const squareColor = isWhite ? 'white' : 'black';
    
    return (
      <div
        key={`${row}-${col}`}
        className={`square ${squareColor}`}
      >
      </div>
    );
  };
  // Function to render a single row
  const renderRow = (row) => {
    const squares = [];
    for (let col = 0; col < 8; col++) {
      squares.push(renderSquare(row, col));
    }
    return squares;
  };

  // Function to render the entire chessboard
  const renderChessboard = () => {
    const rows = [];
    for (let row = 0; row < 8; row++) {
      rows.push(
        <div key={row} className="board-row">
          {renderRow(row)}
        </div>
      );
    }
    return rows;
  };

  return (
    <div className="chessboard">
      {renderChessboard()}
    </div>
  );
};

export default ChessboardComponent;

*/