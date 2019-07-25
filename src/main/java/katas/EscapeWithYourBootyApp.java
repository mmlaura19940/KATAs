package katas;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EscapeWithYourBootyApp {
	
	public static class Position {
		public int row;
		public int column;
	}
	
	static boolean resultX = true;
	public static boolean checkCourse(char[][] map) {
		System.out.println(Arrays.deepToString(map));
		boolean result = false;
		List<Integer> indexesX = new ArrayList<>();
		indexesX = findX(map);
		List<Integer> indexesNRow = new ArrayList<>();
		indexesNRow = findNRow(map);
		List<Integer> indexesNColumn = new ArrayList<>();

		Map<String, Position> actorPositions = findActors(map);
		for (Map.Entry<String, Position> entry : actorPositions.entrySet()) {
		    String key = entry.getKey();
		    Object value = entry.getValue();

		}
		while (checkAllAdjacentTiles(map, indexesX.get(0), indexesX.get(1))||!resultX) {
			map = swapAll(map, indexesNRow, indexesNColumn);
			indexesX.set(1, indexesX.get(1) + 1);
			if (indexesX.get(1) == map[0].length - 1) {
				result = checkAllAdjacentTiles(map, indexesX.get(0), indexesX.get(1));
				break;
			}
		}
		if (!resultX) {
			result= false;
		}
		return result;
	}

	public static char[][] swapAll(char[][] map, List<Integer> indexesNRow, List<Integer> indexesNColumn) {
		int[] usedColumns = new int[indexesNColumn.size()];
		for (int row = 0; row < map.length; ++row) {
			int iter = 0;
			boolean swapX = false;
			for (int column = 0; column < map[row].length; ++column) {
				if (map[row][column] == 'X' && !swapX) {
					map = swapX(map, row, column);
					swapX = true;
					if(checkAllAdjacentTiles(map, row, column + 1)) {
						resultX= false ;
					}
				}
				if (map[row][column] == 'N') {
					if (indexesNRow.get(iter) == 0) {
						if (row == map.length - 1) {
							indexesNRow.set(iter, map.length - 1);
							map = swapUpN(map, row, column);
							usedColumns[iter] = column;
						}
						if (usedColumns[iter] != column) {
							map = swapDownN(map, row, column);
							usedColumns[iter] = column;
						}
					}
					if (indexesNRow.get(iter) == map.length - 1) {
						if (row == 0) {
							indexesNRow.set(iter, 0);
							map = swapDownN(map, row, column);
							usedColumns[iter] = column;
						}
						if (usedColumns[iter] != column) {
							map = swapUpN(map, row, column);
							usedColumns[iter] = column;
						}
					}
					iter++;
				}
			}
		}
		return map;
	}

	public static char[][] swapX(char[][] map, int i, int j) {
		char t = map[i][j];
		map[i][j] = map[i][j + 1];
		map[i][j + 1] = t;
		return map;
	}

	public static char[][] swapDownN(char[][] map, int i, int j) {
		char t = map[i][j];
		map[i][j] = map[i + 1][j];
		map[i + 1][j] = t;
		return map;
	}

	public static char[][] swapUpN(char[][] map, int i, int j) {
		char t = map[i][j];
		map[i][j] = map[i - 1][j];
		map[i - 1][j] = t;
		return map;
	}

	public static boolean checkAllAdjacentTiles(char[][] map, int playerPosRow, int playerPosColumn) {
		int[][] move = {
			{-1, -1},
			{-1, 0},
			{-1, 1},
			{0, -1},
			{0, 0},
			{0, 1},
			{1, -1},
			{1, 0},
			{1, 1}
		};
		if (BoatStates.NEAR_NAVY == checkTile(map, playerPosRow, playerPosColumn, playerPosRow - 1, playerPosColumn - 1)) {
			return false;
		}
		if (BoatStates.NEAR_NAVY == checkTile(map, playerPosRow, playerPosColumn, playerPosRow-1, playerPosColumn)) {
			return false;
		}
		if (BoatStates.NEAR_NAVY == checkTile(map, playerPosRow, playerPosColumn, playerPosRow - 1, playerPosColumn + 1)) {
			return false;
		}
		if (BoatStates.NEAR_NAVY == checkTile(map, playerPosRow, playerPosColumn, playerPosRow, playerPosColumn - 1)) {
			return false;
		}
		if (BoatStates.NEAR_NAVY == checkTile(map, playerPosRow, playerPosColumn, playerPosRow, playerPosColumn + 1)) {
			return false;
		}
		if (BoatStates.NEAR_NAVY == checkTile(map, playerPosRow, playerPosColumn, playerPosRow +1, playerPosColumn -1)) {
			return false;
		}
		if (BoatStates.NEAR_NAVY == checkTile(map, playerPosRow, playerPosColumn, playerPosRow+1, playerPosColumn)) {
			return false;
		}
		if (BoatStates.NEAR_NAVY == checkTile(map, playerPosRow, playerPosColumn, playerPosRow + 1, playerPosColumn + 1)) {
			return false;
		}
		return true;
	}

	public static BoatStates checkTile(char[][] map, int playerPosRow, int playerPosColumn, int posRowTocheck, 
			int posColumnToCheck) {
		if (posRowTocheck < 0 || posColumnToCheck < 0) {
			return BoatStates.OUT_OF_BOUNDS;
		}

		else if (posRowTocheck >= map.length|| posColumnToCheck >= map[posRowTocheck].length) {
			return BoatStates.OUT_OF_BOUNDS;
		} else {
			if (isNavy(map, posRowTocheck, posColumnToCheck)) {
				return BoatStates.NEAR_NAVY;
			}
		}
		return BoatStates.OK;

	}

	private static boolean isNavy(char[][] map, int posRow, int posColumn) {
		return map[posRow][posColumn] == 'N';
	}

	public static List<Integer> findX(char[][] a) {
		List<Integer> indexes = new ArrayList<>();
		for (int row = 0; row < a.length; ++row) {
			for (int column = 0; column < a[row].length; ++column) {
				if (a[row][column] == 'X') {
					indexes.add(row);
					indexes.add(column);
				}
			}

		}
		return indexes;
	}

	public static List<Integer> findNColumn(char[][] a) {
		List<Integer> indexes = new ArrayList<>();
		for (int row = 0; row < a.length; ++row) {
			for (int column = 0; column < a[row].length; ++column) {
				if (a[row][column] == 'N') {
					indexes.add(column);
				}
			}

		}
		return indexes;
	}

	public static List<Integer> findNRow(char[][] a) {
		List<Integer> indexes = new ArrayList<>();
		for (int row = 0; row < a.length; ++row) {
			for (int column = 0; column < a[row].length; ++column) {
				if (a[row][column] == 'N') {
					indexes.add(row);
				}
			}

		}
		return indexes;
	}
	
	public static Map<String, Position> findActors(char[][] map) {
		Map<String, Position> actorPositions= new HashMap<>();
		Position poz= new Position();
		for (int row = 0; row < map.length; ++row) {
			for (int column = 0; column < map[row].length; ++column) {
				if (map[row][column] == 'N') {
					poz.row=row;
					poz.column=column;
					actorPositions.put("N",poz);
				}
				if (map[row][column] == 'X') {
					poz.row=row;
					poz.column=column;
					actorPositions.put("X",poz);
				}
			}

		}
		return actorPositions;
	}
	public enum BoatStates {
		OK, NEAR_NAVY, OUT_OF_BOUNDS;
	}

}
