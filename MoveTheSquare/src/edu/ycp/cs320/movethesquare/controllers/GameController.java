package edu.ycp.cs320.movethesquare.controllers;

import edu.ycp.cs320.movethesquare.model.Game;
import edu.ycp.cs320.movethesquare.model.Square;

public class GameController {
	public void computeSquareMoveDirection(Game game, Square square, double mouseX, double mouseY) {
		if (mouseX >= 0 && mouseX < game.getWidth() && mouseY >= 0 && mouseY < game.getHeight()) {
			double dx = mouseX - (square.getX() + square.getWidth()/2);
			double dy = mouseY - (square.getY() + square.getHeight()/2);
			
			double moveX = 0, moveY = 0;
			if (dx > 0) {
				moveX = Game.MOVE_DIST;
			} else {
				moveX = -Game.MOVE_DIST;
			}
			if (dy > 0) {
				moveY = Game.MOVE_DIST;
			} else {
				moveY = -Game.MOVE_DIST;
			}
			
			game.setSquareDx(moveX);
			game.setSquareDy(moveY);
		}
	}

	public void moveSquare(Game model, Square square) {
		double newX = square.getX() + model.getSquareDx();
		double newY = square.getY() + model.getSquareDy();
		
		if(newX - square.getWidth() < 0) {
			square.setX(square.getWidth());
		}
		else if(newX + square.getWidth() > model.getWidth()) {
			square.setX(model.getWidth() - square.getWidth());
		}
		else {
			square.setX(newX);
		}
		
		if(newY < 0) {
			square.setY(0);
		}
		else if(newY + square.getHeight() > model.getHeight()) {
			square.setY(model.getHeight() - square.getHeight());
		}
		else {
			square.setY(newY);
		}
	}
}
