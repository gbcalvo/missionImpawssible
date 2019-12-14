public class GameEngine{
		public GameEngine(){
				Game game = new Game();
				ObstacleHandler handler = new ObstacleHandler(game);
				Thread t1 = new Thread(handler);
				t1.start();


				//mapHandler- will handle refreshing screen on a thread
				//obstacleHandler - will handle the tile contents
				//playerTracker - will track player movement and check collisions, also scrolls the map
		}
}