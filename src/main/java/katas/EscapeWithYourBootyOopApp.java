package katas;
import java.util.HashMap;
import java.util.Map;

public class EscapeWithYourBootyOopApp {

	public static abstract class AShip {
		public int row;
		public int column;

		public enum BoatStates {
			OK, NEAR_NAVY, OUT_OF_BOUNDS, NEAR_PIRATE;
		}

		public abstract void move();

		public static boolean checkAllAdjacentTiles(char[][] map, AShip myShip, AShip navyShip) {
			return false;
		}

		public static BoatStates checkTile(int checkRow, int checkColumn, AShip ship, char[][] map) {
			return BoatStates.OK;
		}

		protected static boolean isNear(int checkRow, int checkColumn, AShip ship) {
			return false;
		}
	}

	public static class MyShip extends AShip {
		@Override
		public void move() {
			column++;
		}

		public static boolean checkAllAdjacentTiles(char[][] map, MyShip myShip, NavyShip navyShip) {
			int[][] move = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 0 }, { 0, 1 }, { 1, -1 }, { 1, 0 },
					{ 1, 1 } };
			for (int i = 0; i < move.length; i++) {
				if (BoatStates.NEAR_NAVY == checkTile(myShip.row + move[i][0], myShip.column + move[i][1], navyShip,
						map)) {
					return false;
				}
			}
			return true;
		}

		public static BoatStates checkTile(int checkRow, int checkColumn, NavyShip navyShip, char[][] map) {
			if (checkRow < 0 || checkColumn < 0) {
				return BoatStates.OUT_OF_BOUNDS;
			}

			else if (checkRow >= map.length || checkColumn >= map[checkRow].length) {
				return BoatStates.OUT_OF_BOUNDS;
			} else {
				if (isNear(checkRow, checkColumn, navyShip)) {
					return BoatStates.NEAR_NAVY;
				}
			}
			return BoatStates.OK;

		}

		public MyShip(int _row, int _column) {
			this.row = _row;
			this.column = _column;
		}
	}

	public static class NavyShip extends AShip {
		private boolean isAscending;

		@Override
		public void move() {
			if (isAscending) {
				row--;
			} else {
				row++;
			}
		}

		public static boolean checkAllAdjacentTiles(char[][] map, MyShip myShip, NavyShip navyShip) {
			int[][] move = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 0 }, { 0, 1 }, { 1, -1 }, { 1, 0 },
					{ 1, 1 } };
			for (int i = 0; i < move.length; i++) {
				if (BoatStates.NEAR_PIRATE == checkTile(navyShip.row + move[i][0], navyShip.column + move[i][1], myShip,
						map)) {
					return false;
				}
			}
			return true;
		}

		public static BoatStates checkTile(int checkRow, int checkColumn, MyShip myShip, char[][] map) {
			if (checkRow < 0 || checkColumn < 0) {
				return BoatStates.OUT_OF_BOUNDS;
			}

			else if (checkRow >= map.length || checkColumn >= map[checkRow].length) {
				return BoatStates.OUT_OF_BOUNDS;
			} else {
				if (isNear(checkRow, checkColumn, myShip)) {
					return BoatStates.NEAR_PIRATE;
				}
			}
			return BoatStates.OK;

		}

		private static boolean isNear(int checkRow, int checkColumn, MyShip myShip) {
			boolean result = false;
			if (myShip.row == checkRow && myShip.column == checkColumn) {
				result = true;
			}
			return result;
		}

		public NavyShip(int _row, int _column) {
			this.row = _row;
			this.column = _column;
		}
	}

	public static boolean checkCourse(char[][] map) {
		boolean result = false;
		
		Map<String, MyShip> myShipPozitions = new HashMap<>();
		myShipPozitions = findMyShip(map);
		Map<String, NavyShip> navyShipPozitions = new HashMap<>();
		navyShipPozitions = findNavyShip(map);
		
		boolean isNotTheEnd = true;
		while (isNotTheEnd) {
			for (MyShip player : myShipPozitions.values()) {
				if (player.column == map[0].length - 1) {
					isNotTheEnd = false;
				} else {
					player.move();
				}
				for (NavyShip navy : navyShipPozitions.values()) {
					if (!MyShip.checkAllAdjacentTiles(map, player, navy)) {
						return false;
					}
				}
			}
			for (NavyShip navy : navyShipPozitions.values()) {
				if (navy.row == 0) {
					navy.isAscending = false;
				}
				if (navy.row == map.length - 1) {
					navy.isAscending = true;
				}
				navy.move();
				for (MyShip player : myShipPozitions.values()) {
					if (!NavyShip.checkAllAdjacentTiles(map, player, navy)) {
						return false;
					}
				}
			}
			result = true;
		}
		return result;
	}

	public static Map<String, MyShip> findMyShip(char[][] map) {
		Map<String, MyShip> myShipPozitions = new HashMap<>();
		int iter = 0;
		for (int row = 0; row < map.length; ++row) {
			for (int column = 0; column < map[row].length; ++column) {
				if (map[row][column] == 'X') {

					myShipPozitions.put("X" + iter, new MyShip(row, column));
					iter++;
				}
			}
		}
		return myShipPozitions;
	}

	public static Map<String, NavyShip> findNavyShip(char[][] map) {

		Map<String, NavyShip> navyShipPozitions = new HashMap<String, NavyShip>();
		int iter = 0;
		for (int row = 0; row < map.length; ++row) {
			for (int column = 0; column < map[row].length; ++column) {
				if (map[row][column] == 'N') {
					navyShipPozitions.put("N" + iter, new NavyShip(row, column));
					iter++;
				}
			}
		}
		return navyShipPozitions;
	}
}
