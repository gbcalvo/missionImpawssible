public class ObstacleHandler implements Runnable{
		Tile[][] map;
		public ObstacleHandler(Game game){
				this.map = game.map;
		}
		public void run(){
				while(true){
						moveObstacles();
						System.out.println("waiting");
						try{
								Thread.sleep(500);
						}catch(Exception e){
							e.printStackTrace();
						}
				}
		}

		private void moveObstacles(){
				Queue q = new Queue();
				int val;
				for(int y = 0; y < 18; y++){
						for(int x = 0; x < 30; x++){
								val = map[y][x].content;
								if(val == 3){
										q.enqueue(x,y,5);
										if(y == 0 || map[y-1][x].content != 5){
												q.enqueue(x,y+1, 4);
										}
										else{
												q.enqueue(x,y-1,3);
										}
								}
								else if(val == 4){
										q.enqueue(x,y,5);
										if(y == 15 || map[y+1][x].content != 5){
												q.enqueue(x, y-1, 3);
										}
										else{
												q.enqueue(x, y+1, 4);
										}

								}
								else if(val == 6){
										q.enqueue(x,y,8);
										if(x == 29 || map[y][x+1].content != 8){
												q.enqueue(x, y-1, 7);
										}
										else{
												q.enqueue(x, y+1, 6);
										}

								}
								else if(val == 7){
										q.enqueue(x,y,8);
										if(x == 0 || map[y][x-1].content != 8){
												q.enqueue(x, y+1, 6);
										}
										else{
												q.enqueue(x, y-1, 7);
										}

								}
						}
				}


				Node curr = q.dequeue();
				while(curr != null){
						update(curr);
						curr = q.dequeue();
				}
				System.out.println("updated!");
		}
		private void update(Node x){
				map[x.coordinateY][x.coordinateX].content = x.newValue;
		}

}