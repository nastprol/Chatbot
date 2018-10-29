package chatbot;

import java.util.ArrayList;
import java.util.Arrays;

import db.DataBase;
import db.IDataBase;

public class Chatbot {

	private IGame game;
	private IGameFactory gameFactory;
	private IParser parser;
	private IDataBase db;

	Chatbot(IGameFactory gameFactory) {
		this.gameFactory = gameFactory;
		game = this.gameFactory.create(db, -1); //������ ������ ��� ����� ID
		parser = this.gameFactory.createParser();
		db = new DataBase();
		db.initDatabase();
		db.connect();
	}
	
	protected IGame getGame() {
		return game;
	}

	public Reply ProcessRequest(String userRequest, int id) {

		String request = userRequest.toLowerCase();
		switch (request) {
		case "/help":{
			return new Reply("/exit if you wanna leave this game\n"
					+ "/start if you wanna start or restart game\n"
					+ "/whoareyou if you wanna get know game's rules", null);
		}
		case "/exit":{
			this.game.SetInactive();
			return new Reply("Game is over", null);
		}
		case "":
		{
			return new Reply("", null);
		}
		case "\n":
		{
			return new Reply("", null);
		}
		case "/start": {
			if (game.isActive()) {
				game = this.gameFactory.create(db, id);
				parser = this.gameFactory.createParser();
			}
			game.SetActive();
			
			return new Reply(game.GetIntroductionMessage(), null);
		}
		case "/whoareyou": {
			return new Reply(game.GetIntroductionMessage(), null);
		}
		default: {
			return parser.ProcessPlayerAnswer(request, id);
		}
		}
	}
}