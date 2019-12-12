import java.io.*;
public class MapGenerator{
		public MapGenerator(){}

		public Tile[][] generateMap(File file){
				Tile[][] output = new Tile[18][30];
				try{
						FileReader fr = new FileReader(file);
						BufferedReader br = new BufferedReader(fr);
						String line = br.readLine();
						String[] tokenized;
						int[] intTokens;
						int y =0;
						while(line  != null){
								tokenized = line.split(" ");
								intTokens = new int[tokenized.length];
								for(int x = 0; x < tokenized.length; x++){
										output[y][x] = new Tile(Integer.parseInt(tokenized[x]));
								}
								y++;
								line = br.readLine();
						}
				}catch(IOException e){
					e.printStackTrace();
				}
				
				return output;
		}
}