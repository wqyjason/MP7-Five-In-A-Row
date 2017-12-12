
public class FIAR {
    /** value of the max height of the board.*/
    public static final int MAX_HEIGHT = 16;
    /** value of the max width of the board.*/
    public static final int MAX_WIDTH = 16;
    /** value of the min height of the board.*/
    public static final int MIN_HEIGHT = 6;
    /** value of the min width of the board.*/
    public static final int MIN_WIDTH = 6;
    /** value of the min n of the board.*/
    public static final int MIN_N = 4;
    /** title of the game.*/
    @SuppressWarnings("checkstyle:visibilitymodifier")
    public java.lang.String title;
    /** total number of the game. */
    @SuppressWarnings("checkstyle:visibilitymodifier")
    public static int boardId = -1;

    /** boardHeight the height of the current board. */
    private int boardHeight = 0;
    /** boardWidth the width of the current board. */
    private int boardWidth = 0;
    /** boardValue the value of the current board. */
    private int boardValue = 0;
    /** boardId the id of the current id. */
//    private int boardId = 0;
    /** boards. */
    private Player[][] board;
    /** game started.*/
    private boolean gameStarted = false;
    /** game ended. */
    private boolean gameEnded = false;

    /** Constructor.*/
    public FIAR() {
        boardId++;
    }

    /** Constructor.
     * @param otherBoard otherBoard
     */
    public FIAR(final FIAR otherBoard) {
        setWidth(otherBoard.getWidth());
        setHeight(otherBoard.getHeight());
        setN(otherBoard.getN());
        board = new Player[getWidth()][getHeight()];
        boardId++;
    }

    /** Constructor.
     * @param setWidth width
     * @param setHeight height
     */
    public FIAR(final int setWidth, final int setHeight) {
        setWidth(setWidth);
        setHeight(setHeight);
        board = new Player[getWidth()][getHeight()];
        boardId++;
    }

    /** Constructor.
     * @param setWidth width
     * @param setHeight height
     * @param setN N
     */
    public FIAR(final int setWidth, final int setHeight, final int setN) {
        setWidth(setWidth);
        setHeight(setHeight);
        setN(setN);
        board = new Player[getWidth()][getHeight()];
        boardId++;
    }

    /**
     * set the height of the board.
     * @param setHeight input height
     * @return true if success; otherwise false
     */
    public final boolean setHeight(final int setHeight) {
        int max = 0;
        if (!gameStarted) {
            if (setHeight >= MIN_HEIGHT && setHeight <= MAX_HEIGHT) {
                boardHeight = setHeight;
                board = new Player[boardWidth][boardHeight];
                if (boardWidth > boardHeight) {
                    max = boardWidth;
                } else {
                    max = boardHeight;
                }
                if (boardValue >= max) {
                    boardValue = 0;
                }
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }

        }

    /**
     * set the width of the board.
     * @param setWidth input width
     * @return true if success; otherwise false
     */
    public final boolean setWidth(final int setWidth) {
        int max = 0;
        if (!gameStarted) {
            if (setWidth >= MIN_HEIGHT && setWidth <= MAX_HEIGHT) {
                boardWidth = setWidth;
                board = new Player[boardWidth][boardHeight];
                if (boardWidth > boardHeight) {
                    max = boardWidth;
                } else {
                    max = boardHeight;
                }
                if (boardValue >= max) {
                    boardValue = 0;
                }
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
        }

   /**
    * get the height of the current board.
    * @return the current height
    */
    public final int getHeight() {
        return boardHeight;
    }

    /**
     * get the width of the current board.
     * @return the current width
     */
    public final int getWidth() {
        return boardWidth;
    }

    /**
     * set n of the board.
     * @param newN number of n
     * @return true if success; otherwise flase
     */
    public final boolean setN(final int newN) {
        int max = 0;
        if (boardWidth > boardHeight) {
            max = boardWidth;
        } else {
            max = boardHeight;
        }
        if (!gameStarted) {
            if (boardWidth != 0 && boardHeight != 0) {
                if (newN >= MIN_N && newN < max) {
                       boardValue = newN;
                       return true;
                } else {
                       return false;
                      }
            } else {
                return false;
               }
        } else {
            return false;
        }

     }


    /**
     * get the number of n.
     * @return number of n
     */
    public final int getN() {
        return boardValue;
    }

    /**
     * Set the board at a specific position.
     * @param player the player attempting the move
     * @param setX the X coordinate that they are trying to place a tile at
     * @param setY the Y coordinate that they are trying to place a tile at
     * @return true if the move succeeds, false on error
     */
    public boolean setBoardAt(final Player player, final int setX, final int setY) {
        gameStarted = true;
        if (board[setX][setY] != null) {
            return false;
        }
        if (!gameEnded) {
            board[setX][setY] = player;
            return true;
        } else {
            return false;
        }
    }

    /**
     *Get the player at a specific board position.
     * @param getX  the X coordinate to get the player at
     * @param getY  the Y coordinate to get the player at
     * @return the player whose tile is at that position,
     * or null or error or if nobody has played at that position
     */
    public final Player getBoardAt(final int getX, final int getY) {
        if (gameStarted) {
                if (getX >= 0 && getX <= boardWidth && getY >= 0 && getY <= boardHeight) {
                        return board[getX][getY];
        } else {
            return null;
            }
        } else {
            return null;
        }
    }

    /**
     * Drop a tile in a particular column.
     * @param player the player attempting the move
     * @param setX the X coordinate for the stack that they are trying to drop a tile in
     * @return true if the move succeeds, false on error
     */
    public final boolean setBoardAt(final Player player, final int setX) {
        gameStarted = true;
        if (!gameEnded) {
            if (setX < boardWidth) {
                for (int i = 0; i < boardHeight; i++) {
                    if (board[setX][i] == null) {
                        board[setX][i] = player;
                        return true;
                    }
                }
                return false;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     * Return a copy of the board.
     * @return a copy of the current board
     */
    public final Player[][] getBoard() {
        Player[][] copy = new Player[boardWidth][boardHeight];
        if (boardHeight == 0 || boardWidth == 0) {
            return null;
        }
        for (int i = 0; i < boardWidth; i++) {
            for (int j = 0; j < boardHeight; j++) {
                if (board[i][j] == null) {
                    copy[i][j] = null;
                } else {
                    copy[i][j] = new Player(board[i][j]);
                }
            }
        }
        return copy;
    }

    /**
     * Return the winner of the game, or null if the game has not ended.
     * @return the winner of the game, or null if the game has not ended
     */
    public final Player getWinner() {
        for (int i = 0; i < boardWidth; i++) {
            for (int j = 0; j < boardHeight; j++) {
                if (j + boardValue < boardHeight) {
                    int count = 0;
                    for (int k = 0; k < boardValue; k++) {
                        if (getBoardAt(i, j + k) == null || getBoardAt(i, j + k + 1) == null) {
                            continue;
                        } else if (!getBoardAt(i, j + k).equals(getBoardAt(i, j + k + 1))) {
                            continue;
                        } else {
                            count++;
                        }
                    }
                    if (count == boardValue && boardValue >= MIN_N) {
                        getBoardAt(i, j).addScore();
                        gameEnded = true;
                        return getBoardAt(i, j);
                    }
                }
                if (i + boardValue < boardWidth) {
                    int count = 0;
                    for (int k = 0; k < boardValue; k++) {
                        if (getBoardAt(i + k, j) == null || getBoardAt(i + k + 1, j) == null) {
                            continue;
                        } else if (!getBoardAt(i + k, j).equals(getBoardAt(i + k + 1, j))) {
                            continue;
                        } else {
                            count++;
                        }
                    }
                    if (count == boardValue && boardValue >= MIN_N) {
                        getBoardAt(i, j).addScore();
                        gameEnded = true;
                        return getBoardAt(i, j);
                    }
                }
                if (i + boardValue < boardWidth && j + boardValue < boardHeight) {
                    int count = 0;
                    for (int k = 0; k < boardValue; k++) {
                        if (getBoardAt(i + k, j + k) == null
                                || getBoardAt(i + k + 1, j + k + 1) == null) {
                            continue;
                        } else if (!getBoardAt(i + k, j + k).equals(
                                getBoardAt(i + k + 1, j + k + 1))) {
                            continue;
                        } else {
                            count++;
                        }
                    }
                    if (count == boardValue && boardValue >= MIN_N) {
                        getBoardAt(i, j).addScore();
                        gameEnded = true;
                        return getBoardAt(i, j);
                    }
                }
                if (i + boardValue < boardWidth && j - boardValue >= 0) {
                    int count = 0;
                    for (int k = 0; k < boardValue; k++) {
                        if (getBoardAt(i + k, j - k) == null
                                || getBoardAt(i + k + 1, j - k - 1) == null) {
                            continue;
                        } else if (!getBoardAt(i + k, j - k).equals(
                                getBoardAt(i + k + 1, j - k - 1))) {
                            continue;
                        } else {
                            count++;
                        }
                    }
                    if (count == boardValue && boardValue >= MIN_N) {
                        getBoardAt(i, j).addScore();
                        gameEnded = true;
                        return getBoardAt(i, j);
                    }
                }
            }
        }
        return null;
    }

    /**
     * Return the total number of games that have been created.
     * @return the total number of games that have been created
     */
    public static int getTotalGames() {
        return boardId + 1;
    }

    /**
     * Get the current board's id.
     * @return the current board's id
     */
    public final int getID() {
        // TODO Auto-generated method stub
        return boardId;
    }

}
