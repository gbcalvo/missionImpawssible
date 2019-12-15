public class ObstacleHandler implements Runnable{
		private boolean iterate;
		private Game game;
		public ObstacleHandler(Game instance){
				game = instance;
				iterate = true;
		}
		public void run(){
				while(iterate){
						moveObstacles();
						try{
								Thread.sleep(1000);
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
								val = game.map[y][x].content;
								if(val == 3){
										q.enqueue(x,y,5);
										if(y == 0 || game.map[y-1][x].content != 5){
												q.enqueue(x,y+1, 4);
										}
										else{
												q.enqueue(x,y-1,3);
										}
								}
								else if(val == 4){
										q.enqueue(x,y,5);
										if(y == 15 || game.map[y+1][x].content != 5){
												q.enqueue(x, y-1, 3);
										}
										else{
												q.enqueue(x, y+1, 4);
										}

								}
								else if(val == 6){
										q.enqueue(x,y,8);
										if(x == 29 || game.map[y][x+1].content != 8){
												q.enqueue(x-1, y, 7);
										}
										else{
												q.enqueue(x+1, y, 6);
										}

								}
								else if(val == 7){
										q.enqueue(x,y,8);
										if(x == 0 || game.map[y][x-1].content != 8){
												q.enqueue(x+1, y, 6);
										}
										else{
												q.enqueue(x-1, y, 7);
										}

								}
						}
				}


				Node curr = q.dequeue();
				while(curr != null){
						update(curr);
						curr = q.dequeue();
				}

		}
		private void update(Node x){
				game.map[x.coordinateY][x.coordinateX].content = x.newValue;
		}
		public void end(){
				iterate = false;
		}

}