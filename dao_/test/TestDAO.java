package dao_.test;

import java.util.List;

import dao_.dao.ActorDAO;
import dao_.domain.Actor;

public class TestDAO {
	public static void main(String[] args) {

		ActorDAO actorDAO = new ActorDAO();

		List<Actor> actors = actorDAO.queryMulti("select * from actor where id >= ?", Actor.class, 1);

		for (Actor actor : actors) {
			System.out.println(actor);
		}

	}
}
