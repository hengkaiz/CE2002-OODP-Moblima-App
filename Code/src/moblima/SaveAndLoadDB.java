package moblima;

import cinema.*;
import movies.MovieDatabase;
import user.UserDatabase;
import admin.AdminDatabase;
import movies.HolidayDatabase;
import booking.BookingDatabase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

//initialize the databases here
public class SaveAndLoadDB {

    public void saveShowTimeDB(ShowTimeDatabase stdb, int cineplexNumber) {
		try {
			switch (cineplexNumber){
				case 1: 
					FileOutputStream fos = new FileOutputStream("ShowTimeDB1.txt");
				    ObjectOutputStream oos = new ObjectOutputStream(fos);
				    oos.writeObject(stdb);
				    oos.close();
				    fos.close();
				    System.out.println("ShowTime DB Serialized and saved");
				    break;
				case 2:
					FileOutputStream fos2 = new FileOutputStream("ShowTimeDB2.txt");
				    ObjectOutputStream oos2 = new ObjectOutputStream(fos2);
				    oos2.writeObject(stdb);
				    oos2.close();
				    fos2.close();
				    System.out.println("ShowTime DB Serialized and saved");
				    break;
				case 3:
					FileOutputStream fos3 = new FileOutputStream("ShowTimeDB3.txt");
				    ObjectOutputStream oos3 = new ObjectOutputStream(fos3);
				    oos3.writeObject(stdb);
				    oos3.close();
				    fos3.close();
				    System.out.println("ShowTime DB Serialized and saved");
				    break;
			}
//			FileOutputStream fos = new FileOutputStream("ShowTimeDB.txt");
//		    ObjectOutputStream oos = new ObjectOutputStream(fos);
//		    oos.writeObject(stdb);
//		    oos.close();
//		    fos.close();
//		    System.out.println("ShowTime DB Serialized and saved");
		}
		catch(IOException ie) {
			System.out.println("Saving error occurred " + ie);
		}
    }
    
    public ShowTimeDatabase loadShowTimeDB(int cineplexNum) {
        try {
			switch (cineplexNum){
			case 1: 
				FileInputStream fis = new FileInputStream("ShowTimeDB1.txt");
				ObjectInputStream ois = new ObjectInputStream(fis);
				ShowTimeDatabase stdb = (ShowTimeDatabase) ois.readObject();
				ois.close();
				fis.close();
				System.out.println("ShowTime DB Deserialized and loaded");
		        return stdb;
			case 2:
				FileInputStream fis2 = new FileInputStream("ShowTimeDB2.txt");
				ObjectInputStream ois2 = new ObjectInputStream(fis2);
				ShowTimeDatabase stdb2 = (ShowTimeDatabase) ois2.readObject();
				ois2.close();
				fis2.close();
				System.out.println("ShowTime DB Deserialized and loaded");
		        return stdb2;
			case 3:
				FileInputStream fis3 = new FileInputStream("ShowTimeDB3.txt");
				ObjectInputStream ois3 = new ObjectInputStream(fis3);
				ShowTimeDatabase stdb3 = (ShowTimeDatabase) ois3.readObject();
				ois3.close();
				fis3.close();
				System.out.println("ShowTime DB Deserialized and loaded");
		        return stdb3;
			}
//			FileInputStream fis = new FileInputStream("ShowTimeDB.txt");
//			ObjectInputStream ois = new ObjectInputStream(fis);
//
//			ShowTimeDatabase stdb = (ShowTimeDatabase) ois.readObject();
//			ois.close();
//			fis.close();
//			System.out.println("ShowTime DB Deserialized and loaded");
//	        return stdb;
		        
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			
		} catch (ClassNotFoundException e) {
			System.out.println("Class not found");
			
		} catch (IOException e) {
			System.out.println("Loading error occurred");
		}
        return null;
    }
    
	public void saveMovieDB(MovieDatabase mdb) {
		try {
			FileOutputStream fos = new FileOutputStream("MovieDB.txt");
		    ObjectOutputStream oos = new ObjectOutputStream(fos);
		    oos.writeObject(mdb);
		    oos.close();
		    fos.close();
		    System.out.println("MovieDB Serialized and saved");
		}
		catch(IOException ie) {
			System.out.println("Saving error occurred " + ie);
		}
	}
	
	public MovieDatabase loadMovieDB() {
        try {
			FileInputStream fis = new FileInputStream("MovieDB.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);

			MovieDatabase mdb = (MovieDatabase) ois.readObject();
			ois.close();
			fis.close();
			System.out.println("MovieDB Deserialized and loaded");
	        return mdb;
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			
		} catch (ClassNotFoundException e) {
			System.out.println("Class not found");
			
		} catch (IOException e) {
			System.out.println("Loading error occurred" + e);
		}
        return null;
	}
	
	
	public void saveUserDB(UserDatabase udb) {
		try {
			FileOutputStream fos = new FileOutputStream("UserDB.txt");
		    ObjectOutputStream oos = new ObjectOutputStream(fos);
		    oos.writeObject(udb);
		    oos.close();
		    fos.close();
		    System.out.println("UserDB Serialized and saved");
		}
		catch(IOException ie) {
			System.out.println("Saving error occurred " + ie);
		}
	}
	
	public UserDatabase loadUserDB() {
        try {
			FileInputStream fis = new FileInputStream("UserDB.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);

			UserDatabase udb = (UserDatabase) ois.readObject();
			ois.close();
			fis.close();
			System.out.println("UserDB Deserialized and loaded");
	        return udb;
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			
		} catch (ClassNotFoundException e) {
			System.out.println("Class not found");
			
		} catch (IOException e) {
			System.out.println("Loading error occurred");
		}
        return null;
	}
    
	public void saveAdminDB(AdminDatabase adb) {
		try {
			FileOutputStream fos = new FileOutputStream("AdminDB.txt");
		    ObjectOutputStream oos = new ObjectOutputStream(fos);
		    oos.writeObject(adb);
		    oos.close();
		    fos.close();
		    System.out.println("AdminDB Serialized and saved");
		}
		catch(IOException ie) {
			System.out.println("Saving error occurred " + ie);
		}
	}
	
	public AdminDatabase loadAdminDB() {
        try {
			FileInputStream fis = new FileInputStream("AdminDB.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);

			AdminDatabase adb = (AdminDatabase) ois.readObject();
			ois.close();
			fis.close();
			System.out.println("UserDB Deserialized and loaded");
	        return adb;
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			
		} catch (ClassNotFoundException e) {
			System.out.println("Class not found");
			
		} catch (IOException e) {
			System.out.println("Loading error occurred");
		}
        return null;
	}
	
	public void saveHolidayDB(HolidayDatabase hdb) {
		try {
			FileOutputStream fos = new FileOutputStream("HolidayDB.txt");
		    ObjectOutputStream oos = new ObjectOutputStream(fos);
		    oos.writeObject(hdb);
		    oos.close();
		    fos.close();
		    System.out.println("HolidayDB Serialized and saved");
		}
		catch(IOException ie) {
			System.out.println("Saving error occurred " + ie);
		}
	}
	
	public HolidayDatabase loadHolidayDB() {
        try {
			FileInputStream fis = new FileInputStream("HolidayDB.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);

			HolidayDatabase hdb = (HolidayDatabase) ois.readObject();
			ois.close();
			fis.close();
			System.out.println("HolidayDB Deserialized and loaded");
	        return hdb;
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			
		} catch (ClassNotFoundException e) {
			System.out.println("Class not found");
			
		} catch (IOException e) {
			System.out.println("Loading error occurred");
		}
        return null;
	}
	
	public void saveCineplex(Cineplex cdb) {
		try {
			switch (cdb.getCineplexNumber()){
			case 1: 
				FileOutputStream fos = new FileOutputStream("Cineplex1.txt");
			    ObjectOutputStream oos = new ObjectOutputStream(fos);
			    oos.writeObject(cdb);
			    oos.close();
			    fos.close();
			    System.out.println("Cineplex1 Serialized and saved");
			    break;
			case 2:
				FileOutputStream fos2 = new FileOutputStream("Cineplex2.txt");
			    ObjectOutputStream oos2 = new ObjectOutputStream(fos2);
			    oos2.writeObject(cdb);
			    oos2.close();
			    fos2.close();
			    System.out.println("Cineplex2 Serialized and saved");
			    break;
			case 3:
				FileOutputStream fos3 = new FileOutputStream("Cineplex3.txt");
			    ObjectOutputStream oos3 = new ObjectOutputStream(fos3);
			    oos3.writeObject(cdb);
			    oos3.close();
			    fos3.close();
			    System.out.println("Cineplex3 Serialized and saved");
			    break;
			}
		}
		catch(IOException ie) {
			System.out.println("Saving error occurred " + ie);
		}
	}
	
	public Cineplex loadCineplex(int cineplexNum) {
        try {
			switch (cineplexNum){
			case 1: 
				FileInputStream fis = new FileInputStream("Cineplex1.txt");
				ObjectInputStream ois = new ObjectInputStream(fis);
				Cineplex c1 = (Cineplex) ois.readObject();
				ois.close();
				fis.close();
				System.out.println("Cineplex1 Deserialized and loaded");
		        return c1;
			case 2:
				FileInputStream fis2 = new FileInputStream("Cineplex2.txt");
				ObjectInputStream ois2 = new ObjectInputStream(fis2);
				Cineplex c2 = (Cineplex) ois2.readObject();
				ois2.close();
				fis2.close();
				System.out.println("Cineplex2 Deserialized and loaded");
		        return c2;
			case 3:
				FileInputStream fis3 = new FileInputStream("Cineplex3.txt");
				ObjectInputStream ois3 = new ObjectInputStream(fis3);
				Cineplex c3 = (Cineplex) ois3.readObject();
				ois3.close();
				fis3.close();
				System.out.println("Cineplex3 Deserialized and loaded");
		        return c3;
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			
		} catch (ClassNotFoundException e) {
			System.out.println("Class not found");
			
		} catch (IOException e) {
			System.out.println("Loading error occurred");
		}
        return null;
	}
	
	public void saveBookingDB(BookingDatabase bdb) {
		try {
			FileOutputStream fos = new FileOutputStream("BookingDB.txt");
		    ObjectOutputStream oos = new ObjectOutputStream(fos);
		    oos.writeObject(bdb);
		    oos.close();
		    fos.close();
		    System.out.println("BookingDB Serialized and saved");
		}
		catch(IOException ie) {
			System.out.println("Saving error occurred " + ie);
		}
	}
	
	public BookingDatabase loadBookingDB() {
        try {
			FileInputStream fis = new FileInputStream("BookingDB.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);

			BookingDatabase bdb = (BookingDatabase) ois.readObject();
			ois.close();
			fis.close();
			System.out.println("HolidayDB Deserialized and loaded");
	        return bdb;
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			
		} catch (ClassNotFoundException e) {
			System.out.println("Class not found");
			
		} catch (IOException e) {
			System.out.println("Loading error occurred");
		}
        return null;
	}
	
	
	
	
	
//	public static void main(String[] args) {
//		SaveAndLoadDB fff2 = new SaveAndLoadDB();
		
//		MovieDatabase mdb = new MovieDatabase();

//		Movie cA = new Movie("Charlie's Angel", 0, AgeRating.PARENTAL_GUIDANCE13, "Charlie's Angels have always provided security and investigative skills to private clients. Now the Townsend Agency has expanded internationally with the smartest and most highly trained women from all over the globe — multiple teams of Angels guided by multiple Bosleys, completing the toughest missions around the world. When a young systems engineer blows the whistle on a dangerous technology, these Angels are called into action, putting their lives on the line to protect people.", MovieStatus.COMING_SOON);
//		cA.addMovieCast("Jaclyn Smith");
//		cA.addMovieCast("Kristen Stewart");
//		cA.addMovieCast("Elizabeth Banks");
//		cA.addMovieCast("Naomi Scott");
//		cA.addMovieCast("Drew Barrymore");
//		cA.addMovieDirector("Elizabeth Banks");
//		cA.addMovieDirector("McG");
//		
//		cA.updateOverallRating();
//		mdb.getMovies().add(cA);
//		
//		
//		Movie tDF = new Movie("Terminator: Dark Fate", 1560, AgeRating.NO_CHILDREN_UNDER16, "In Mexico City, a newly modified liquid Terminator -- the Rev-9 model -- arrives from the future to kill a young factory worker named Dani Ramos. Also sent back in time is Grace, a hybrid cyborg human who must protect Ramos from the seemingly indestructible robotic assassin. But the two women soon find some much-needed help from a pair of unexpected allies -- seasoned warrior Sarah Connor and the T-800 Terminator.", MovieStatus.NOW_SHOWING);
//		tDF.addMovieCast("Linda Hamilton");
//		tDF.addMovieCast("Arnold Schwarzenegger");
//		tDF.addMovieCast("Mackenzie Davis");
//		tDF.addMovieCast("Gabriel Luna");
//		tDF.addMovieDirector("Tim Miller");
//		tDF.getReviewList().add(new Review("tommy", 3.4, "I was alternately interested and bored by the repetition... Can you tell that I am not the demographic for this film? But at least it was good to see the talented and gorgeous Mackenzie Davis."));
//		tDF.getReviewList().add(new Review("daniel", 3.2, "If you're able to accept the bold choices the movie is built around, this is a welcome follow up to Terminator 2."));
//		tDF.getReviewList().add(new Review("robert", 3.1,"Part sequel, part reboot, it's a lot of what we've seen before with just enough personality and solid action."));
//		tDF.getReviewList().add(new Review("brian",4.5,"Awesome movie"));
//		tDF.getReviewList().add(new Review("eric",5,"As sequels go, Dark Fate is pretty good, a perfectly fun time at the movies."));
//		
//		tDF.updateOverallRating();
//		mdb.getMovies().add(tDF);
//		
//		Movie gM = new Movie("Gemini Man", 950, AgeRating.PARENTAL_GUIDANCE13, "Henry Brogan is an elite 51-year-old assassin who's ready to call it quits after completing his 72nd job. His plans get turned upside down when he becomes the target of a mysterious operative who can seemingly predict his every move. To his horror, Brogan soon learns that the man who's trying to kill him is a younger, faster, cloned version of himself.", MovieStatus.NOW_SHOWING);
//		gM.addMovieCast("Will Smith");
//		gM.addMovieCast("Mary Elizabeth Winstead");
//		gM.addMovieCast("Benedict Wong");
//		gM.addMovieDirector("Ang Lee");
//		gM.getReviewList().add(new Review("jay",1.5,"The best cloning, however, is in the script, which only has ideas duplicated from other films."));
//		gM.getReviewList().add(new Review("hengkai",2,"A cloned human is created by no god, but a human body needs a soul to animate it. Nature abhors a vacuum. What kinds of entities will creep in and animate that human clone are stories the horror genre will address in the future, but this is a good start."));
//		gM.getReviewList().add(new Review("zhengtian",2.1,"Not so good"));
//		gM.getReviewList().add(new Review("louis",1.6,"It is embarrassing that a movie with this much star power with this much money being poured into the attempts at visual spectacle couldn't spare a pittance for a script doctor to clean up the horrific dialogue."));
//		
//		gM.updateOverallRating();
//		mdb.getMovies().add(gM);
//		
//		Movie tAF = new Movie("The Addams Family", 1000, AgeRating.GENERAL, "Members of the mysterious and spooky Addams family -- Gomez, Morticia, Pugsley, Wednesday, Uncle Fester and Grandma -- are readily preparing for a visit from their even creepier relatives. But trouble soon arises when shady TV personality Margaux Needler realizes that the Addams' eerie hilltop mansion is standing in the way of her dream to sell all the houses in the neighborhood.", MovieStatus.PREVIEW);
//		tAF.addMovieCast("Finn Wolfhard");
//		tAF.addMovieCast("Chloë Grace Moretz");
//		tAF.addMovieCast("Oscar Isaac");
//		tAF.addMovieCast("Charlize Theron");
//		tAF.addMovieCast("Nick Kroll");
//		tAF.addMovieDirector("Conrad Vernon");
//		tAF.addMovieDirector("Greg Tiernan");
//		tAF.getReviewList().add(new Review("Allen",4.3,"Good watch for the family"));
//		
//		tAF.updateOverallRating();
//		mdb.getMovies().add(tAF);
//		
//		Movie fT = new Movie("Frozen 2", 2000, AgeRating.GENERAL, "Elsa the Snow Queen and her sister Anna embark on an adventure far away from the kingdom of Arendelle. They are joined by friends, Kristoff, Olaf, and Sven.", MovieStatus.PREVIEW);
//		fT.addMovieCast("Idina Menzel");
//		fT.addMovieCast("Kristen Bell");
//		fT.addMovieCast("Josh Gad");
//		fT.addMovieCast("Evan Rachel Wood");
//		fT.addMovieCast("Jonathan Groff");
//		fT.addMovieDirector("Jennifer Lee");
//		fT.addMovieDirector("Chris Buck");
//		fT.getReviewList().add(new Review("yixing",4,"Good movie to watch together with the kids"));
//		fT.getReviewList().add(new Review("prof",3,"Not a disappointing movie, great buildup from frozen 1"));
//		fT.getReviewList().add(new Review("winston",3.4,"The graphics and CGI for movie is really good. It feels so realistic"));
//		
//		fT.updateOverallRating();
//		mdb.getMovies().add(fT);
//		
//		Movie j =new Movie("Joker", 2900, AgeRating.RESTRICTED21, "Forever alone in a crowd, failed comedian Arthur Fleck seeks connection as he walks the streets of Gotham City. Arthur wears two masks -- the one he paints for his day job as a clown, and the guise he projects in a futile attempt to feel like he's part of the world around him. Isolated, bullied and disregarded by society, Fleck begins a slow descent into madness as he transforms into the criminal mastermind known as the Joker.", MovieStatus.END_OF_SHOWING);
//		j.addMovieCast("Joaquin Phoenix");
//		j.addMovieCast("Zazie Beetz");
//		j.addMovieCast("Robert De Niro");
//		j.addMovieCast("Frances Conroy");
//		j.addMovieDirector("Todd Phillips");
//		j.getReviewList().add(new Review("ronald",4.6,"If there is a meaningful difference between performing and acting, Joaquin Phoenix surely exemplifies the former here, creepily contorting as the Clown Prince of Crime in Todd Phillips' timely, toxic take on the Making of a Murdering Madman."));
//		j.getReviewList().add(new Review("arthur",4.7,"A movie that borders on genius-repellant, dark, terrifying, disgusting, brilliant and unforgettable."));
//		j.getReviewList().add(new Review("hengkai",5,"Sensational movie"));
//		j.getReviewList().add(new Review("betty",5,"What the film wants to say - about mental illness or class divisions in society - is not as interesting as what it accidentally says about whiteness."));
//		j.getReviewList().add(new Review("olivia",4.8,"Definitely an oscar nominee for movie of the year"));
//		
//		j.updateOverallRating();
//		mdb.getMovies().add(j);
//		
//		Movie m = new Movie("Maleficent", 1800, AgeRating.GENERAL, "Maleficent travels to a grand old castle to celebrate young Aurora's upcoming wedding to Prince Phillip. While there, she meets Aurora's future mother-in-law -- a conniving queen who hatches a devious plot to destroy the land's fairies. Hoping to stop her, Maleficent joins forces with a seasoned warrior and a group of outcasts to battle the queen and her powerful army.", MovieStatus.NOW_SHOWING);
//		m.addMovieCast("Angelina Jolie");
//		m.addMovieCast("Michelle Pfeiffer");
//		m.addMovieCast("Harris Dickinson");
//		m.addMovieCast("Elle Fanning");
//		m.addMovieDirector("Joachim Ronning");
//		m.getReviewList().add(new Review("angel",2.6,"There's no need for this [sequel]... It's almost not campy enough."));
//		m.getReviewList().add(new Review("ryan",3.4,"The bottom line is that Maleficent 2 takes a brilliant character and doesn't completely bugger things up."));
//		
//		m.updateOverallRating();
//		mdb.getMovies().add(m);
//		
//		Movie pDP = new Movie("Pokemon Detective Pikachu", 7500, AgeRating.GENERAL, "Ace detective Harry Goodman goes mysteriously missing, prompting his 21-year-old son, Tim, to find out what happened. Aiding in the investigation is Harry's former Pokémon partner, wise-cracking, adorable super-sleuth Detective Pikachu. Finding that they are uniquely equipped to work together, as Tim is the only human who can talk with Pikachu, they join forces to unravel the tangled mystery.", MovieStatus.NOW_SHOWING);
//		pDP.addMovieCast("Ryan Reynolds");
//		pDP.addMovieCast("Justice Smith");
//		pDP.addMovieDirector("Rob Letterman");
//		pDP.getReviewList().add(new Review("yixing",4.2,"CGI for the pokemons were fantastic."));
//		pDP.getReviewList().add(new Review("evan",3.2,"Reynolds is in his element when allowed to be goofy, and this stuff is nothing if not surreal, especially in the second act."));
//		pDP.getReviewList().add(new Review("jessica",3.4,"Pikachu is very cute. I like the movie a lot."));
//		
//		pDP.updateOverallRating();
//		mdb.getMovies().add(pDP);
//				
//		Movie lC = new Movie("Last Christmas", 0, AgeRating.PARENTAL_GUIDANCE13, "Nothing seems to go right for young Kate, a frustrated Londoner who works as an elf in a year-round Christmas shop. But things soon take a turn for the better when she meets Tom -- a handsome charmer who seems too good to be true. As the city transforms into the most wonderful time of the year, Tom and Kate's growing attraction turns into the best gift of all -- a Yuletide romance.", MovieStatus.COMING_SOON);
//		lC.addMovieCast("Emilia Clarke");
//		lC.addMovieCast("Henry Golding");
//		lC.addMovieDirector("Paul Feig");
//		
//		lC.updateOverallRating();
//		mdb.getMovies().add(lC);
//				
//		Movie iT2 = new Movie("IT 2", 2380, AgeRating.MATURE18, "Defeated by members of the Losers' Club, the evil clown Pennywise returns 27 years later to terrorize the town of Derry, Maine, once again. Now adults, the childhood friends have long since gone their separate ways. But when people start disappearing, Mike Hanlon calls the others home for one final stand. Damaged by scars from the past, the united Losers must conquer their deepest fears to destroy the shape-shifting Pennywise -- now more powerful than ever.", MovieStatus.END_OF_SHOWING);
//		iT2.addMovieCast("Jessica Chastain");
//		iT2.addMovieCast("Bill Skarsgard");
//		iT2.addMovieCast("James McAvoy");
//		iT2.addMovieCast("Isaiah Mustafa");
//		iT2.addMovieCast("James Ransone");
//		iT2.getReviewList().add(new Review("xinmun",4.5,"excellent movie with an unexpected plot twist. would recommend to watch"));
//		iT2.getReviewList().add(new Review("hope",4.2,"A great movie worth rewatching again."));
//		iT2.getReviewList().add(new Review("yixing",3.5,"Good movie."));
//		iT2.getReviewList().add(new Review("paul",4.7,"Splendid movie"));
//		iT2.getReviewList().add(new Review("aaron",2.9,"Movie was very captivating, theres such a deeper meaning to the ending"));
//		
//		iT2.updateOverallRating();
//		mdb.getMovies().add(iT2);
//		
//		MovieDatabase mdb = null;
//		fff2.saveMovieDB(mdb);
//		mdb = fff2.loadMovieDB();
//
//		System.out.println(mdbcopy.getMovieTitlesList());
//		mdbcopy.printMovieDetails();
//		mdbcopy.printMovieDetails();
//		mdbcopy.printMovieDetails();
//		mdbcopy.printMovieDetails();
//		mdbcopy.printMovieDetails();
//		mdbcopy.printMovieDetails();
//		mdbcopy.printMovieDetails();
//		mdbcopy.printMovieDetails();
//		mdbcopy.printMovieDetails();
//		mdbcopy.printMovieDetails();
		
//		ShowTimeDatabase stdb1= new ShowTimeDatabase();
//		stdb1.getShowTimes().add(new ShowTime(1200, mdb.getMovies().get(0), 1, 1, 1, MovieFormat.TWO_DIMENSION));
//		stdb1.getShowTimes().add(new ShowTime(1500, mdb.getMovies().get(0), 1, 1, 1, MovieFormat.TWO_DIMENSION));
//		stdb1.getShowTimes().add(new ShowTime(1800, mdb.getMovies().get(0), 1, 1, 1, MovieFormat.TWO_DIMENSION));
//		stdb1.getShowTimes().add(new ShowTime(1200, mdb.getMovies().get(1), 1, 1, 2, MovieFormat.THREE_DIMENSION));
//		stdb1.getShowTimes().add(new ShowTime(1800, mdb.getMovies().get(1), 1, 1, 2, MovieFormat.TWO_DIMENSION));
//		stdb1.getShowTimes().add(new ShowTime(1900, mdb.getMovies().get(1), 1, 1, 3, MovieFormat.TWO_DIMENSION));
//		stdb1.getShowTimes().add(new ShowTime(1300, mdb.getMovies().get(2), 1, 1, 4, MovieFormat.TWO_DIMENSION));
//		stdb1.getShowTimes().add(new ShowTime(1400, mdb.getMovies().get(2), 1, 1, 5, MovieFormat.BLOCKBUSTER));
//		stdb1.getShowTimes().add(new ShowTime(1900, mdb.getMovies().get(2), 1, 1, 6, MovieFormat.TWO_DIMENSION));
//		stdb1.getShowTimes().add(new ShowTime(1100, mdb.getMovies().get(3), 1, 1, 7, MovieFormat.TWO_DIMENSION));
//		stdb1.getShowTimes().add(new ShowTime(1400, mdb.getMovies().get(3), 1, 1, 8, MovieFormat.TWO_DIMENSION));
//		stdb1.getShowTimes().add(new ShowTime(1700, mdb.getMovies().get(3), 1, 1, 9, MovieFormat.BLOCKBUSTER));
//		stdb1.getShowTimes().add(new ShowTime(1400, mdb.getMovies().get(4), 1, 1, 1, MovieFormat.TWO_DIMENSION));
//		stdb1.getShowTimes().add(new ShowTime(2300, mdb.getMovies().get(5), 1, 1, 2, MovieFormat.TWO_DIMENSION));
//		stdb1.getShowTimes().add(new ShowTime(1300, mdb.getMovies().get(6), 1, 1, 3, MovieFormat.TWO_DIMENSION));
//		stdb1.getShowTimes().add(new ShowTime(1600, mdb.getMovies().get(6), 1, 1, 4, MovieFormat.TWO_DIMENSION));
//		stdb1.getShowTimes().add(new ShowTime(2100, mdb.getMovies().get(6), 1, 1, 5, MovieFormat.TWO_DIMENSION));
//		stdb1.getShowTimes().add(new ShowTime(1300, mdb.getMovies().get(7), 1, 1, 6, MovieFormat.THREE_DIMENSION));
//		stdb1.getShowTimes().add(new ShowTime(2300, mdb.getMovies().get(7), 1, 1, 7, MovieFormat.TWO_DIMENSION));
//		stdb1.getShowTimes().add(new ShowTime(1200, mdb.getMovies().get(0), 2, 1, 8, MovieFormat.TWO_DIMENSION));
//		stdb1.getShowTimes().add(new ShowTime(1500, mdb.getMovies().get(0), 2, 1, 9, MovieFormat.TWO_DIMENSION));
//		stdb1.getShowTimes().add(new ShowTime(1800, mdb.getMovies().get(0), 2, 1, 1, MovieFormat.TWO_DIMENSION));
//		stdb1.getShowTimes().add(new ShowTime(1500, mdb.getMovies().get(1), 2, 1, 2, MovieFormat.TWO_DIMENSION));
//		stdb1.getShowTimes().add(new ShowTime(1800, mdb.getMovies().get(1), 2, 1, 3, MovieFormat.TWO_DIMENSION));
//		stdb1.getShowTimes().add(new ShowTime(1900, mdb.getMovies().get(1), 2, 1, 4, MovieFormat.TWO_DIMENSION));
//		stdb1.getShowTimes().add(new ShowTime(1300, mdb.getMovies().get(2), 2, 1, 5, MovieFormat.TWO_DIMENSION));
//		stdb1.getShowTimes().add(new ShowTime(1400, mdb.getMovies().get(2), 2, 1, 6, MovieFormat.TWO_DIMENSION));
//		stdb1.getShowTimes().add(new ShowTime(1900, mdb.getMovies().get(2), 2, 1, 7, MovieFormat.TWO_DIMENSION));
//		stdb1.getShowTimes().add(new ShowTime(1100, mdb.getMovies().get(3), 2, 1, 8, MovieFormat.TWO_DIMENSION));
//		stdb1.getShowTimes().add(new ShowTime(1400, mdb.getMovies().get(3), 2, 1, 9, MovieFormat.TWO_DIMENSION));
//		stdb1.getShowTimes().add(new ShowTime(1700, mdb.getMovies().get(3), 2, 1, 1, MovieFormat.THREE_DIMENSION));
//		stdb1.getShowTimes().add(new ShowTime(1400, mdb.getMovies().get(4), 3, 1, 2, MovieFormat.TWO_DIMENSION));
//		stdb1.getShowTimes().add(new ShowTime(2300, mdb.getMovies().get(5), 3, 1, 3, MovieFormat.TWO_DIMENSION));
//		stdb1.getShowTimes().add(new ShowTime(2400, mdb.getMovies().get(8), 100, 1, 4, MovieFormat.TWO_DIMENSION));
//		stdb1.getShowTimes().add(new ShowTime(2400, mdb.getMovies().get(9), 100, 1, 5, MovieFormat.TWO_DIMENSION));
//		stdb1.getShowTimes().add(new ShowTime(1300, mdb.getMovies().get(6), 2, 1, 6, MovieFormat.TWO_DIMENSION));
//		stdb1.getShowTimes().add(new ShowTime(1600, mdb.getMovies().get(6), 2, 1, 7, MovieFormat.TWO_DIMENSION));
//		stdb1.getShowTimes().add(new ShowTime(2200, mdb.getMovies().get(6), 2, 1, 8, MovieFormat.TWO_DIMENSION));
//		stdb1.getShowTimes().add(new ShowTime(1300, mdb.getMovies().get(7), 2, 1, 9, MovieFormat.THREE_DIMENSION));
//		stdb1.getShowTimes().add(new ShowTime(2300, mdb.getMovies().get(7), 2, 1, 1, MovieFormat.TWO_DIMENSION));
//		stdb1.getShowTimes().add(new ShowTime(1500, mdb.getMovies().get(0), 3, 1, 2, MovieFormat.TWO_DIMENSION));
//		stdb1.getShowTimes().add(new ShowTime(1500, mdb.getMovies().get(0), 3, 1, 3, MovieFormat.TWO_DIMENSION));
//		stdb1.getShowTimes().add(new ShowTime(1800, mdb.getMovies().get(0), 3, 1, 4, MovieFormat.BLOCKBUSTER));
//		stdb1.getShowTimes().add(new ShowTime(1600, mdb.getMovies().get(1), 3, 1, 5, MovieFormat.TWO_DIMENSION));
//		stdb1.getShowTimes().add(new ShowTime(1800, mdb.getMovies().get(1), 3, 1, 6, MovieFormat.TWO_DIMENSION));
//		stdb1.getShowTimes().add(new ShowTime(1700, mdb.getMovies().get(1), 3, 1, 7, MovieFormat.TWO_DIMENSION));
//		stdb1.getShowTimes().add(new ShowTime(1000, mdb.getMovies().get(2), 3, 1, 8, MovieFormat.TWO_DIMENSION));
//		stdb1.getShowTimes().add(new ShowTime(1300, mdb.getMovies().get(2), 3, 1, 9, MovieFormat.TWO_DIMENSION));
//		stdb1.getShowTimes().add(new ShowTime(1900, mdb.getMovies().get(2), 3, 1, 1, MovieFormat.TWO_DIMENSION));
//		stdb1.getShowTimes().add(new ShowTime(1200, mdb.getMovies().get(3), 3, 1, 2, MovieFormat.BLOCKBUSTER));
//		stdb1.getShowTimes().add(new ShowTime(1300, mdb.getMovies().get(3), 3, 1, 3, MovieFormat.TWO_DIMENSION));
//		stdb1.getShowTimes().add(new ShowTime(1700, mdb.getMovies().get(3), 3, 1, 4, MovieFormat.TWO_DIMENSION));
//		stdb1.getShowTimes().add(new ShowTime(1400, mdb.getMovies().get(4), 3, 1, 5, MovieFormat.TWO_DIMENSION));
//		stdb1.getShowTimes().add(new ShowTime(2300, mdb.getMovies().get(5), 3, 1, 6, MovieFormat.TWO_DIMENSION));
//		stdb1.getShowTimes().add(new ShowTime(1100, mdb.getMovies().get(6), 3, 1, 7, MovieFormat.THREE_DIMENSION));
//		stdb1.getShowTimes().add(new ShowTime(1500, mdb.getMovies().get(6), 3, 1, 8, MovieFormat.TWO_DIMENSION));
//		stdb1.getShowTimes().add(new ShowTime(2100, mdb.getMovies().get(6), 3, 1, 9, MovieFormat.TWO_DIMENSION));
//		stdb1.getShowTimes().add(new ShowTime(1400, mdb.getMovies().get(7), 3, 1, 1, MovieFormat.TWO_DIMENSION));
//		stdb1.getShowTimes().add(new ShowTime(2200, mdb.getMovies().get(7), 3, 1, 2, MovieFormat.THREE_DIMENSION));
//		stdb1.getShowTimes().add(new ShowTime(1200, mdb.getMovies().get(0), 4, 1, 3, MovieFormat.TWO_DIMENSION));
//		stdb1.getShowTimes().add(new ShowTime(1400, mdb.getMovies().get(0), 4, 1, 4, MovieFormat.TWO_DIMENSION));
//		stdb1.getShowTimes().add(new ShowTime(1900, mdb.getMovies().get(0), 4, 1, 5, MovieFormat.TWO_DIMENSION));
//		stdb1.getShowTimes().add(new ShowTime(1100, mdb.getMovies().get(1), 4, 1, 6, MovieFormat.TWO_DIMENSION));
//		stdb1.getShowTimes().add(new ShowTime(1700, mdb.getMovies().get(1), 4, 1, 7, MovieFormat.TWO_DIMENSION));
//		stdb1.getShowTimes().add(new ShowTime(1900, mdb.getMovies().get(1), 4, 1, 8, MovieFormat.TWO_DIMENSION));
//		stdb1.getShowTimes().add(new ShowTime(1200, mdb.getMovies().get(2), 4, 1, 9, MovieFormat.TWO_DIMENSION));
//		stdb1.getShowTimes().add(new ShowTime(1600, mdb.getMovies().get(2), 4, 1, 1, MovieFormat.TWO_DIMENSION));
//		stdb1.getShowTimes().add(new ShowTime(1900, mdb.getMovies().get(2), 4, 1, 2, MovieFormat.TWO_DIMENSION));
//		stdb1.getShowTimes().add(new ShowTime(1000, mdb.getMovies().get(3), 4, 1, 3, MovieFormat.TWO_DIMENSION));
//		stdb1.getShowTimes().add(new ShowTime(1300, mdb.getMovies().get(3), 4, 1, 4, MovieFormat.TWO_DIMENSION));
//		stdb1.getShowTimes().add(new ShowTime(1700, mdb.getMovies().get(3), 4, 1, 5, MovieFormat.THREE_DIMENSION));
//		stdb1.getShowTimes().add(new ShowTime(1400, mdb.getMovies().get(4), 4, 1, 6, MovieFormat.TWO_DIMENSION));
//		stdb1.getShowTimes().add(new ShowTime(1500, mdb.getMovies().get(4), 4, 1, 7, MovieFormat.TWO_DIMENSION));
//		stdb1.getShowTimes().add(new ShowTime(2300, mdb.getMovies().get(5), 4, 1, 8, MovieFormat.TWO_DIMENSION));
//		stdb1.getShowTimes().add(new ShowTime(1300, mdb.getMovies().get(6), 4, 1, 9, MovieFormat.TWO_DIMENSION));
//		stdb1.getShowTimes().add(new ShowTime(1500, mdb.getMovies().get(6), 4, 1, 1, MovieFormat.TWO_DIMENSION));
//		stdb1.getShowTimes().add(new ShowTime(2300, mdb.getMovies().get(6), 4, 1, 2, MovieFormat.TWO_DIMENSION));
//		stdb1.getShowTimes().add(new ShowTime(1100, mdb.getMovies().get(7), 4, 1, 3, MovieFormat.TWO_DIMENSION));
//		stdb1.getShowTimes().add(new ShowTime(2200, mdb.getMovies().get(7), 4, 1, 4, MovieFormat.THREE_DIMENSION));
//		stdb1.getShowTimes().add(new ShowTime(1300, mdb.getMovies().get(0), 5, 1, 5, MovieFormat.TWO_DIMENSION));
//		stdb1.getShowTimes().add(new ShowTime(1700, mdb.getMovies().get(0), 5, 1, 6, MovieFormat.TWO_DIMENSION));
//		stdb1.getShowTimes().add(new ShowTime(1900, mdb.getMovies().get(0), 5, 1, 7, MovieFormat.THREE_DIMENSION));
//		stdb1.getShowTimes().add(new ShowTime(1100, mdb.getMovies().get(1), 5, 1, 8, MovieFormat.TWO_DIMENSION));
//		stdb1.getShowTimes().add(new ShowTime(1600, mdb.getMovies().get(1), 5, 1, 9, MovieFormat.TWO_DIMENSION));
//		stdb1.getShowTimes().add(new ShowTime(1700, mdb.getMovies().get(1), 5, 1, 1, MovieFormat.BLOCKBUSTER));
//		stdb1.getShowTimes().add(new ShowTime(1400, mdb.getMovies().get(2), 5, 1, 2, MovieFormat.TWO_DIMENSION));
//		stdb1.getShowTimes().add(new ShowTime(1600, mdb.getMovies().get(2), 5, 1, 3, MovieFormat.TWO_DIMENSION));
//		stdb1.getShowTimes().add(new ShowTime(1800, mdb.getMovies().get(2), 5, 1, 4, MovieFormat.TWO_DIMENSION));
//		stdb1.getShowTimes().add(new ShowTime(1300, mdb.getMovies().get(3), 5, 1, 5, MovieFormat.TWO_DIMENSION));
//		stdb1.getShowTimes().add(new ShowTime(1200, mdb.getMovies().get(3), 5, 1, 6, MovieFormat.TWO_DIMENSION));
//		stdb1.getShowTimes().add(new ShowTime(1600, mdb.getMovies().get(3), 5, 1, 7, MovieFormat.TWO_DIMENSION));
//		stdb1.getShowTimes().add(new ShowTime(1400, mdb.getMovies().get(4), 5, 1, 8, MovieFormat.TWO_DIMENSION));
//		stdb1.getShowTimes().add(new ShowTime(1800, mdb.getMovies().get(5), 5, 1, 9, MovieFormat.TWO_DIMENSION));
//		stdb1.getShowTimes().add(new ShowTime(2100, mdb.getMovies().get(5), 5, 1, 1, MovieFormat.THREE_DIMENSION));
//		stdb1.getShowTimes().add(new ShowTime(1300, mdb.getMovies().get(6), 5, 1, 2, MovieFormat.TWO_DIMENSION));
//		stdb1.getShowTimes().add(new ShowTime(1500, mdb.getMovies().get(6), 5, 1, 3, MovieFormat.TWO_DIMENSION));
//		stdb1.getShowTimes().add(new ShowTime(2200, mdb.getMovies().get(6), 5, 1, 4, MovieFormat.TWO_DIMENSION));
//		stdb1.getShowTimes().add(new ShowTime(1100, mdb.getMovies().get(7), 5, 1, 5, MovieFormat.TWO_DIMENSION));
//		stdb1.getShowTimes().add(new ShowTime(2200, mdb.getMovies().get(7), 5, 1, 6, MovieFormat.TWO_DIMENSION));
//
//		ShowTimeDatabase stdb1copy = null;
//		fff2.saveShowTimeDB(stdb1, 1);
//		stdb1copy = fff2.loadShowTimeDB(1);
//		System.out.println(stdb1copy.getShowTimes());
//		
//		ShowTimeDatabase stdb2= new ShowTimeDatabase();
//		stdb2.getShowTimes().add(new ShowTime(1300, mdb.getMovies().get(0), 1, 2, 1, MovieFormat.TWO_DIMENSION));
//		stdb2.getShowTimes().add(new ShowTime(1500, mdb.getMovies().get(0), 1, 2, 6, MovieFormat.TWO_DIMENSION));
//		stdb2.getShowTimes().add(new ShowTime(1900, mdb.getMovies().get(0), 1, 2, 1, MovieFormat.TWO_DIMENSION));
//		stdb2.getShowTimes().add(new ShowTime(1300, mdb.getMovies().get(1), 1, 2, 2, MovieFormat.TWO_DIMENSION));
//		stdb2.getShowTimes().add(new ShowTime(1900, mdb.getMovies().get(1), 1, 2, 2, MovieFormat.TWO_DIMENSION));
//		stdb2.getShowTimes().add(new ShowTime(2100, mdb.getMovies().get(1), 1, 2, 3, MovieFormat.TWO_DIMENSION));
//		stdb2.getShowTimes().add(new ShowTime(1300, mdb.getMovies().get(2), 1, 2, 4, MovieFormat.TWO_DIMENSION));
//		stdb2.getShowTimes().add(new ShowTime(1400, mdb.getMovies().get(2), 1, 2, 5, MovieFormat.TWO_DIMENSION));
//		stdb2.getShowTimes().add(new ShowTime(1900, mdb.getMovies().get(2), 1, 2, 6, MovieFormat.TWO_DIMENSION));
//		stdb2.getShowTimes().add(new ShowTime(1100, mdb.getMovies().get(3), 1, 2, 1, MovieFormat.THREE_DIMENSION));
//		stdb2.getShowTimes().add(new ShowTime(1300, mdb.getMovies().get(3), 1, 2, 2, MovieFormat.TWO_DIMENSION));
//		stdb2.getShowTimes().add(new ShowTime(1700, mdb.getMovies().get(3), 1, 2, 3, MovieFormat.TWO_DIMENSION));
//		stdb2.getShowTimes().add(new ShowTime(1300, mdb.getMovies().get(4), 1, 2, 1, MovieFormat.TWO_DIMENSION));
//		stdb2.getShowTimes().add(new ShowTime(2300, mdb.getMovies().get(5), 1, 2, 2, MovieFormat.TWO_DIMENSION));
//		stdb2.getShowTimes().add(new ShowTime(1300, mdb.getMovies().get(6), 1, 2, 3, MovieFormat.TWO_DIMENSION));
//		stdb2.getShowTimes().add(new ShowTime(1700, mdb.getMovies().get(6), 1, 2, 4, MovieFormat.TWO_DIMENSION));
//		stdb2.getShowTimes().add(new ShowTime(2100, mdb.getMovies().get(6), 1, 2, 5, MovieFormat.TWO_DIMENSION));
//		stdb2.getShowTimes().add(new ShowTime(1300, mdb.getMovies().get(7), 1, 2, 6, MovieFormat.THREE_DIMENSION));
//		stdb2.getShowTimes().add(new ShowTime(2300, mdb.getMovies().get(7), 1, 2, 1, MovieFormat.TWO_DIMENSION));
//		stdb2.getShowTimes().add(new ShowTime(1200, mdb.getMovies().get(0), 2, 2, 2, MovieFormat.TWO_DIMENSION));
//		stdb2.getShowTimes().add(new ShowTime(1300, mdb.getMovies().get(0), 2, 2, 3, MovieFormat.THREE_DIMENSION));
//		stdb2.getShowTimes().add(new ShowTime(1900, mdb.getMovies().get(0), 2, 2, 1, MovieFormat.TWO_DIMENSION));
//		stdb2.getShowTimes().add(new ShowTime(1300, mdb.getMovies().get(1), 2, 2, 2, MovieFormat.TWO_DIMENSION));
//		stdb2.getShowTimes().add(new ShowTime(1900, mdb.getMovies().get(1), 2, 2, 3, MovieFormat.BLOCKBUSTER));
//		stdb2.getShowTimes().add(new ShowTime(2000, mdb.getMovies().get(1), 2, 2, 4, MovieFormat.TWO_DIMENSION));
//		stdb2.getShowTimes().add(new ShowTime(1100, mdb.getMovies().get(2), 2, 2, 5, MovieFormat.TWO_DIMENSION));
//		stdb2.getShowTimes().add(new ShowTime(1400, mdb.getMovies().get(2), 2, 2, 6, MovieFormat.TWO_DIMENSION));
//		stdb2.getShowTimes().add(new ShowTime(1900, mdb.getMovies().get(2), 2, 2, 1, MovieFormat.TWO_DIMENSION));
//		stdb2.getShowTimes().add(new ShowTime(1100, mdb.getMovies().get(3), 2, 2, 2, MovieFormat.TWO_DIMENSION));
//		stdb2.getShowTimes().add(new ShowTime(1300, mdb.getMovies().get(3), 2, 2, 3, MovieFormat.TWO_DIMENSION));
//		stdb2.getShowTimes().add(new ShowTime(1700, mdb.getMovies().get(3), 2, 2, 1, MovieFormat.TWO_DIMENSION));
//		stdb2.getShowTimes().add(new ShowTime(1300, mdb.getMovies().get(4), 3, 2, 2, MovieFormat.TWO_DIMENSION));
//		stdb2.getShowTimes().add(new ShowTime(2300, mdb.getMovies().get(5), 3, 2, 3, MovieFormat.THREE_DIMENSION));
//		stdb2.getShowTimes().add(new ShowTime(2400, mdb.getMovies().get(8), 100, 2, 4, MovieFormat.TWO_DIMENSION));
//		stdb2.getShowTimes().add(new ShowTime(2400, mdb.getMovies().get(9), 100, 2, 5, MovieFormat.TWO_DIMENSION));
//		stdb2.getShowTimes().add(new ShowTime(1300, mdb.getMovies().get(6), 2, 2, 6, MovieFormat.TWO_DIMENSION));
//		stdb2.getShowTimes().add(new ShowTime(1700, mdb.getMovies().get(6), 2, 2, 1, MovieFormat.TWO_DIMENSION));
//		stdb2.getShowTimes().add(new ShowTime(2200, mdb.getMovies().get(6), 2, 2, 2, MovieFormat.TWO_DIMENSION));
//		stdb2.getShowTimes().add(new ShowTime(1300, mdb.getMovies().get(7), 2, 2, 3, MovieFormat.TWO_DIMENSION));
//		stdb2.getShowTimes().add(new ShowTime(2300, mdb.getMovies().get(7), 2, 2, 1, MovieFormat.TWO_DIMENSION));
//		stdb2.getShowTimes().add(new ShowTime(1300, mdb.getMovies().get(0), 3, 2, 2, MovieFormat.TWO_DIMENSION));
//		stdb2.getShowTimes().add(new ShowTime(1700, mdb.getMovies().get(0), 3, 2, 3, MovieFormat.THREE_DIMENSION));
//		stdb2.getShowTimes().add(new ShowTime(1900, mdb.getMovies().get(0), 3, 2, 4, MovieFormat.TWO_DIMENSION));
//		stdb2.getShowTimes().add(new ShowTime(1700, mdb.getMovies().get(1), 3, 2, 5, MovieFormat.TWO_DIMENSION));
//		stdb2.getShowTimes().add(new ShowTime(1900, mdb.getMovies().get(1), 3, 2, 6, MovieFormat.TWO_DIMENSION));
//		stdb2.getShowTimes().add(new ShowTime(2000, mdb.getMovies().get(1), 3, 2, 1, MovieFormat.BLOCKBUSTER));
//		stdb2.getShowTimes().add(new ShowTime(1000, mdb.getMovies().get(2), 3, 2, 2, MovieFormat.TWO_DIMENSION));
//		stdb2.getShowTimes().add(new ShowTime(1300, mdb.getMovies().get(2), 3, 2, 3, MovieFormat.TWO_DIMENSION));
//		stdb2.getShowTimes().add(new ShowTime(1900, mdb.getMovies().get(2), 3, 2, 1, MovieFormat.TWO_DIMENSION));
//		stdb2.getShowTimes().add(new ShowTime(1200, mdb.getMovies().get(3), 3, 2, 2, MovieFormat.BLOCKBUSTER));
//		stdb2.getShowTimes().add(new ShowTime(1300, mdb.getMovies().get(3), 3, 2, 3, MovieFormat.TWO_DIMENSION));
//		stdb2.getShowTimes().add(new ShowTime(1700, mdb.getMovies().get(3), 3, 2, 4, MovieFormat.TWO_DIMENSION));
//		stdb2.getShowTimes().add(new ShowTime(1300, mdb.getMovies().get(4), 3, 2, 5, MovieFormat.TWO_DIMENSION));
//		stdb2.getShowTimes().add(new ShowTime(2300, mdb.getMovies().get(5), 3, 2, 6, MovieFormat.TWO_DIMENSION));
//		stdb2.getShowTimes().add(new ShowTime(1100, mdb.getMovies().get(6), 3, 2, 1, MovieFormat.TWO_DIMENSION));
//		stdb2.getShowTimes().add(new ShowTime(1300, mdb.getMovies().get(6), 3, 2, 2, MovieFormat.THREE_DIMENSION));
//		stdb2.getShowTimes().add(new ShowTime(2100, mdb.getMovies().get(6), 3, 2, 3, MovieFormat.TWO_DIMENSION));
//		stdb2.getShowTimes().add(new ShowTime(1300, mdb.getMovies().get(7), 3, 2, 1, MovieFormat.TWO_DIMENSION));
//		stdb2.getShowTimes().add(new ShowTime(2200, mdb.getMovies().get(7), 3, 2, 2, MovieFormat.TWO_DIMENSION));
//		stdb2.getShowTimes().add(new ShowTime(1200, mdb.getMovies().get(0), 4, 2, 3, MovieFormat.TWO_DIMENSION));
//		stdb2.getShowTimes().add(new ShowTime(1300, mdb.getMovies().get(0), 4, 2, 4, MovieFormat.TWO_DIMENSION));
//		stdb2.getShowTimes().add(new ShowTime(1900, mdb.getMovies().get(0), 4, 2, 5, MovieFormat.TWO_DIMENSION));
//		stdb2.getShowTimes().add(new ShowTime(1100, mdb.getMovies().get(1), 4, 2, 6, MovieFormat.TWO_DIMENSION));
//		stdb2.getShowTimes().add(new ShowTime(1700, mdb.getMovies().get(1), 4, 2, 1, MovieFormat.TWO_DIMENSION));
//		stdb2.getShowTimes().add(new ShowTime(1900, mdb.getMovies().get(1), 4, 2, 2, MovieFormat.TWO_DIMENSION));
//		stdb2.getShowTimes().add(new ShowTime(1200, mdb.getMovies().get(2), 4, 2, 3, MovieFormat.TWO_DIMENSION));
//		stdb2.getShowTimes().add(new ShowTime(1700, mdb.getMovies().get(2), 4, 2, 1, MovieFormat.TWO_DIMENSION));
//		stdb2.getShowTimes().add(new ShowTime(1900, mdb.getMovies().get(2), 4, 2, 2, MovieFormat.TWO_DIMENSION));
//		stdb2.getShowTimes().add(new ShowTime(1000, mdb.getMovies().get(3), 4, 2, 3, MovieFormat.THREE_DIMENSION));
//		stdb2.getShowTimes().add(new ShowTime(1300, mdb.getMovies().get(3), 4, 2, 4, MovieFormat.TWO_DIMENSION));
//		stdb2.getShowTimes().add(new ShowTime(1700, mdb.getMovies().get(3), 4, 2, 5, MovieFormat.TWO_DIMENSION));
//		stdb2.getShowTimes().add(new ShowTime(1300, mdb.getMovies().get(4), 4, 2, 6, MovieFormat.TWO_DIMENSION));
//		stdb2.getShowTimes().add(new ShowTime(1700, mdb.getMovies().get(4), 4, 2, 1, MovieFormat.TWO_DIMENSION));
//		stdb2.getShowTimes().add(new ShowTime(2300, mdb.getMovies().get(5), 4, 2, 2, MovieFormat.TWO_DIMENSION));
//		stdb2.getShowTimes().add(new ShowTime(1300, mdb.getMovies().get(6), 4, 2, 3, MovieFormat.TWO_DIMENSION));
//		stdb2.getShowTimes().add(new ShowTime(1600, mdb.getMovies().get(6), 4, 2, 1, MovieFormat.TWO_DIMENSION));
//		stdb2.getShowTimes().add(new ShowTime(2300, mdb.getMovies().get(6), 4, 2, 2, MovieFormat.THREE_DIMENSION));
//		stdb2.getShowTimes().add(new ShowTime(1100, mdb.getMovies().get(7), 4, 2, 3, MovieFormat.TWO_DIMENSION));
//		stdb2.getShowTimes().add(new ShowTime(2200, mdb.getMovies().get(7), 4, 2, 4, MovieFormat.TWO_DIMENSION));
//		stdb2.getShowTimes().add(new ShowTime(1300, mdb.getMovies().get(0), 5, 2, 5, MovieFormat.TWO_DIMENSION));
//		stdb2.getShowTimes().add(new ShowTime(1700, mdb.getMovies().get(0), 5, 2, 6, MovieFormat.BLOCKBUSTER));
//		stdb2.getShowTimes().add(new ShowTime(1900, mdb.getMovies().get(0), 5, 2, 1, MovieFormat.TWO_DIMENSION));
//		stdb2.getShowTimes().add(new ShowTime(1100, mdb.getMovies().get(1), 5, 2, 2, MovieFormat.TWO_DIMENSION));
//		stdb2.getShowTimes().add(new ShowTime(1700, mdb.getMovies().get(1), 5, 2, 3, MovieFormat.TWO_DIMENSION));
//		stdb2.getShowTimes().add(new ShowTime(1900, mdb.getMovies().get(1), 5, 2, 1, MovieFormat.TWO_DIMENSION));
//		stdb2.getShowTimes().add(new ShowTime(1300, mdb.getMovies().get(2), 5, 2, 2, MovieFormat.TWO_DIMENSION));
//		stdb2.getShowTimes().add(new ShowTime(1700, mdb.getMovies().get(2), 5, 2, 3, MovieFormat.TWO_DIMENSION));
//		stdb2.getShowTimes().add(new ShowTime(1900, mdb.getMovies().get(2), 5, 2, 4, MovieFormat.BLOCKBUSTER));
//		stdb2.getShowTimes().add(new ShowTime(1300, mdb.getMovies().get(3), 5, 2, 5, MovieFormat.TWO_DIMENSION));
//		stdb2.getShowTimes().add(new ShowTime(1200, mdb.getMovies().get(3), 5, 2, 6, MovieFormat.TWO_DIMENSION));
//		stdb2.getShowTimes().add(new ShowTime(1700, mdb.getMovies().get(3), 5, 2, 1, MovieFormat.TWO_DIMENSION));
//		stdb2.getShowTimes().add(new ShowTime(1300, mdb.getMovies().get(4), 5, 2, 2, MovieFormat.TWO_DIMENSION));
//		stdb2.getShowTimes().add(new ShowTime(1900, mdb.getMovies().get(5), 5, 2, 3, MovieFormat.THREE_DIMENSION));
//		stdb2.getShowTimes().add(new ShowTime(2100, mdb.getMovies().get(5), 5, 2, 1, MovieFormat.TWO_DIMENSION));
//		stdb2.getShowTimes().add(new ShowTime(1300, mdb.getMovies().get(6), 5, 2, 2, MovieFormat.TWO_DIMENSION));
//		stdb2.getShowTimes().add(new ShowTime(1600, mdb.getMovies().get(6), 5, 2, 3, MovieFormat.TWO_DIMENSION));
//		stdb2.getShowTimes().add(new ShowTime(2200, mdb.getMovies().get(6), 5, 2, 4, MovieFormat.THREE_DIMENSION));
//		stdb2.getShowTimes().add(new ShowTime(1100, mdb.getMovies().get(7), 5, 2, 5, MovieFormat.TWO_DIMENSION));
//		stdb2.getShowTimes().add(new ShowTime(2200, mdb.getMovies().get(7), 5, 2, 6, MovieFormat.TWO_DIMENSION));
//		
//		ShowTimeDatabase stdb2copy = null;
//		fff2.saveShowTimeDB(stdb2, 2);
//		stdb2copy = fff2.loadShowTimeDB(2);
//		System.out.println(stdb2copy.getShowTimes());
//		
//		ShowTimeDatabase stdb3= new ShowTimeDatabase();
//		stdb3.getShowTimes().add(new ShowTime(1400, mdb.getMovies().get(0), 1, 3, 1, MovieFormat.TWO_DIMENSION));
//		stdb3.getShowTimes().add(new ShowTime(1600, mdb.getMovies().get(0), 1, 3, 6,MovieFormat.TWO_DIMENSION));
//		stdb3.getShowTimes().add(new ShowTime(2000, mdb.getMovies().get(0), 1, 3, 1,MovieFormat.TWO_DIMENSION));
//		stdb3.getShowTimes().add(new ShowTime(1100, mdb.getMovies().get(1), 1, 3, 2,MovieFormat.TWO_DIMENSION));
//		stdb3.getShowTimes().add(new ShowTime(1700, mdb.getMovies().get(1), 1, 3, 2,MovieFormat.TWO_DIMENSION));
//		stdb3.getShowTimes().add(new ShowTime(2200, mdb.getMovies().get(1), 1, 3, 3,MovieFormat.TWO_DIMENSION));
//		stdb3.getShowTimes().add(new ShowTime(1200, mdb.getMovies().get(2), 1, 3, 4,MovieFormat.THREE_DIMENSION));
//		stdb3.getShowTimes().add(new ShowTime(1600, mdb.getMovies().get(2), 1, 3, 5,MovieFormat.TWO_DIMENSION));
//		stdb3.getShowTimes().add(new ShowTime(1900, mdb.getMovies().get(2), 1, 3, 6,MovieFormat.TWO_DIMENSION));
//		stdb3.getShowTimes().add(new ShowTime(1500, mdb.getMovies().get(3), 1, 3, 1,MovieFormat.THREE_DIMENSION));
//		stdb3.getShowTimes().add(new ShowTime(1700, mdb.getMovies().get(3), 1, 3, 2,MovieFormat.TWO_DIMENSION));
//		stdb3.getShowTimes().add(new ShowTime(2000, mdb.getMovies().get(3), 1, 3, 3,MovieFormat.TWO_DIMENSION));
//		stdb3.getShowTimes().add(new ShowTime(1300, mdb.getMovies().get(4), 1, 3, 1,MovieFormat.BLOCKBUSTER));
//		stdb3.getShowTimes().add(new ShowTime(2200, mdb.getMovies().get(5), 1, 3, 2,MovieFormat.TWO_DIMENSION));
//		stdb3.getShowTimes().add(new ShowTime(1300, mdb.getMovies().get(6), 1, 3, 3,MovieFormat.TWO_DIMENSION));
//		stdb3.getShowTimes().add(new ShowTime(1800, mdb.getMovies().get(6), 1, 3, 4,MovieFormat.TWO_DIMENSION));
//		stdb3.getShowTimes().add(new ShowTime(2100, mdb.getMovies().get(6), 1, 3, 5,MovieFormat.TWO_DIMENSION));
//		stdb3.getShowTimes().add(new ShowTime(1300, mdb.getMovies().get(7), 1, 3, 6,MovieFormat.TWO_DIMENSION));
//		stdb3.getShowTimes().add(new ShowTime(2100, mdb.getMovies().get(7), 1, 3, 1,MovieFormat.TWO_DIMENSION));
//		stdb3.getShowTimes().add(new ShowTime(1200, mdb.getMovies().get(0), 2, 3, 2,MovieFormat.TWO_DIMENSION));
//		stdb3.getShowTimes().add(new ShowTime(1500, mdb.getMovies().get(0), 2, 3, 3,MovieFormat.TWO_DIMENSION));
//		stdb3.getShowTimes().add(new ShowTime(1900, mdb.getMovies().get(0), 2, 3, 1,MovieFormat.THREE_DIMENSION));
//		stdb3.getShowTimes().add(new ShowTime(1300, mdb.getMovies().get(1), 2, 3, 2,MovieFormat.TWO_DIMENSION));
//		stdb3.getShowTimes().add(new ShowTime(1500, mdb.getMovies().get(1), 2, 3, 3,MovieFormat.TWO_DIMENSION));
//		stdb3.getShowTimes().add(new ShowTime(2000, mdb.getMovies().get(1), 2, 3, 4,MovieFormat.TWO_DIMENSION));
//		stdb3.getShowTimes().add(new ShowTime(1200, mdb.getMovies().get(2), 2, 3, 5,MovieFormat.TWO_DIMENSION));
//		stdb3.getShowTimes().add(new ShowTime(1500, mdb.getMovies().get(2), 2, 3, 6,MovieFormat.TWO_DIMENSION));
//		stdb3.getShowTimes().add(new ShowTime(1900, mdb.getMovies().get(2), 2, 3, 1,MovieFormat.TWO_DIMENSION));
//		stdb3.getShowTimes().add(new ShowTime(1100, mdb.getMovies().get(3), 2, 3, 2,MovieFormat.TWO_DIMENSION));
//		stdb3.getShowTimes().add(new ShowTime(1300, mdb.getMovies().get(3), 2, 3, 3,MovieFormat.TWO_DIMENSION));
//		stdb3.getShowTimes().add(new ShowTime(1600, mdb.getMovies().get(3), 2, 3, 1,MovieFormat.THREE_DIMENSION));
//		stdb3.getShowTimes().add(new ShowTime(1300, mdb.getMovies().get(4), 3, 3, 2,MovieFormat.TWO_DIMENSION));
//		stdb3.getShowTimes().add(new ShowTime(2200, mdb.getMovies().get(5), 3, 3, 3,MovieFormat.TWO_DIMENSION));
//		stdb3.getShowTimes().add(new ShowTime(2400, mdb.getMovies().get(8), 100, 3, 4,MovieFormat.TWO_DIMENSION));
//		stdb3.getShowTimes().add(new ShowTime(2400, mdb.getMovies().get(9), 100, 3, 5,MovieFormat.BLOCKBUSTER));
//		stdb3.getShowTimes().add(new ShowTime(1300, mdb.getMovies().get(6), 2, 3, 6,MovieFormat.TWO_DIMENSION));
//		stdb3.getShowTimes().add(new ShowTime(1600, mdb.getMovies().get(6), 2, 3, 1,MovieFormat.TWO_DIMENSION));
//		stdb3.getShowTimes().add(new ShowTime(2000, mdb.getMovies().get(6), 2, 3, 2,MovieFormat.TWO_DIMENSION));
//		stdb3.getShowTimes().add(new ShowTime(1300, mdb.getMovies().get(7), 2, 3, 3,MovieFormat.BLOCKBUSTER));
//		stdb3.getShowTimes().add(new ShowTime(2300, mdb.getMovies().get(7), 2, 3, 7,MovieFormat.TWO_DIMENSION));
//		stdb3.getShowTimes().add(new ShowTime(1300, mdb.getMovies().get(0), 3, 3, 2,MovieFormat.TWO_DIMENSION));
//		stdb3.getShowTimes().add(new ShowTime(1600, mdb.getMovies().get(0), 3, 3, 3,MovieFormat.TWO_DIMENSION));
//		stdb3.getShowTimes().add(new ShowTime(1900, mdb.getMovies().get(0), 3, 3, 4,MovieFormat.TWO_DIMENSION));
//		stdb3.getShowTimes().add(new ShowTime(1600, mdb.getMovies().get(1), 3, 3, 5,MovieFormat.TWO_DIMENSION));
//		stdb3.getShowTimes().add(new ShowTime(1900, mdb.getMovies().get(1), 3, 3, 6,MovieFormat.THREE_DIMENSION));
//		stdb3.getShowTimes().add(new ShowTime(2100, mdb.getMovies().get(1), 3, 3, 1,MovieFormat.TWO_DIMENSION));
//		stdb3.getShowTimes().add(new ShowTime(1000, mdb.getMovies().get(2), 3, 3, 2,MovieFormat.TWO_DIMENSION));
//		stdb3.getShowTimes().add(new ShowTime(1500, mdb.getMovies().get(2), 3, 3, 3,MovieFormat.TWO_DIMENSION));
//		stdb3.getShowTimes().add(new ShowTime(1900, mdb.getMovies().get(2), 3, 3, 1,MovieFormat.TWO_DIMENSION));
//		stdb3.getShowTimes().add(new ShowTime(1400, mdb.getMovies().get(3), 3, 3, 2,MovieFormat.TWO_DIMENSION));
//		stdb3.getShowTimes().add(new ShowTime(1600, mdb.getMovies().get(3), 3, 3, 3,MovieFormat.TWO_DIMENSION));
//		stdb3.getShowTimes().add(new ShowTime(1900, mdb.getMovies().get(3), 3, 3, 4,MovieFormat.TWO_DIMENSION));
//		stdb3.getShowTimes().add(new ShowTime(1300, mdb.getMovies().get(4), 3, 3, 5,MovieFormat.TWO_DIMENSION));
//		stdb3.getShowTimes().add(new ShowTime(2300, mdb.getMovies().get(5), 3, 3, 6,MovieFormat.TWO_DIMENSION));
//		stdb3.getShowTimes().add(new ShowTime(1400, mdb.getMovies().get(6), 3, 3, 1,MovieFormat.TWO_DIMENSION));
//		stdb3.getShowTimes().add(new ShowTime(1600, mdb.getMovies().get(6), 3, 3, 2,MovieFormat.TWO_DIMENSION));
//		stdb3.getShowTimes().add(new ShowTime(2100, mdb.getMovies().get(6), 3, 3, 3,MovieFormat.TWO_DIMENSION));
//		stdb3.getShowTimes().add(new ShowTime(1500, mdb.getMovies().get(7), 3, 3, 7,MovieFormat.THREE_DIMENSION));
//		stdb3.getShowTimes().add(new ShowTime(2200, mdb.getMovies().get(7), 3, 3, 2,MovieFormat.TWO_DIMENSION));
//		stdb3.getShowTimes().add(new ShowTime(1200, mdb.getMovies().get(0), 4, 3, 3,MovieFormat.TWO_DIMENSION));
//		stdb3.getShowTimes().add(new ShowTime(1300, mdb.getMovies().get(0), 4, 3, 4,MovieFormat.TWO_DIMENSION));
//		stdb3.getShowTimes().add(new ShowTime(1600, mdb.getMovies().get(0), 4, 3, 5,MovieFormat.TWO_DIMENSION));
//		stdb3.getShowTimes().add(new ShowTime(1100, mdb.getMovies().get(1), 4, 3, 6,MovieFormat.TWO_DIMENSION));
//		stdb3.getShowTimes().add(new ShowTime(1500, mdb.getMovies().get(1), 4, 3, 1,MovieFormat.TWO_DIMENSION));
//		stdb3.getShowTimes().add(new ShowTime(1900, mdb.getMovies().get(1), 4, 3, 2,MovieFormat.TWO_DIMENSION));
//		stdb3.getShowTimes().add(new ShowTime(1200, mdb.getMovies().get(2), 4, 3, 3,MovieFormat.THREE_DIMENSION));
//		stdb3.getShowTimes().add(new ShowTime(1500, mdb.getMovies().get(2), 4, 3, 1,MovieFormat.TWO_DIMENSION));
//		stdb3.getShowTimes().add(new ShowTime(1900, mdb.getMovies().get(2), 4, 3, 2,MovieFormat.TWO_DIMENSION));
//		stdb3.getShowTimes().add(new ShowTime(1200, mdb.getMovies().get(3), 4, 3, 3,MovieFormat.TWO_DIMENSION));
//		stdb3.getShowTimes().add(new ShowTime(1500, mdb.getMovies().get(3), 4, 3, 4,MovieFormat.BLOCKBUSTER));
//		stdb3.getShowTimes().add(new ShowTime(1700, mdb.getMovies().get(3), 4, 3, 5,MovieFormat.TWO_DIMENSION));
//		stdb3.getShowTimes().add(new ShowTime(1300, mdb.getMovies().get(4), 4, 3, 6,MovieFormat.TWO_DIMENSION));
//		stdb3.getShowTimes().add(new ShowTime(1700, mdb.getMovies().get(4), 4, 3, 1,MovieFormat.TWO_DIMENSION));
//		stdb3.getShowTimes().add(new ShowTime(2100, mdb.getMovies().get(5), 4, 3, 7,MovieFormat.TWO_DIMENSION));
//		stdb3.getShowTimes().add(new ShowTime(1300, mdb.getMovies().get(6), 4, 3, 3,MovieFormat.TWO_DIMENSION));
//		stdb3.getShowTimes().add(new ShowTime(1500, mdb.getMovies().get(6), 4, 3, 1,MovieFormat.TWO_DIMENSION));
//		stdb3.getShowTimes().add(new ShowTime(2300, mdb.getMovies().get(6), 4, 3, 2,MovieFormat.BLOCKBUSTER));
//		stdb3.getShowTimes().add(new ShowTime(1300, mdb.getMovies().get(7), 4, 3, 3,MovieFormat.TWO_DIMENSION));
//		stdb3.getShowTimes().add(new ShowTime(2100, mdb.getMovies().get(7), 4, 3, 4,MovieFormat.TWO_DIMENSION));
//		stdb3.getShowTimes().add(new ShowTime(1300, mdb.getMovies().get(0), 5, 3, 5,MovieFormat.TWO_DIMENSION));
//		stdb3.getShowTimes().add(new ShowTime(1600, mdb.getMovies().get(0), 5, 3, 6,MovieFormat.TWO_DIMENSION));
//		stdb3.getShowTimes().add(new ShowTime(1900, mdb.getMovies().get(0), 5, 3, 1,MovieFormat.THREE_DIMENSION));
//		stdb3.getShowTimes().add(new ShowTime(1100, mdb.getMovies().get(1), 5, 3, 2,MovieFormat.TWO_DIMENSION));
//		stdb3.getShowTimes().add(new ShowTime(1500, mdb.getMovies().get(1), 5, 3, 3,MovieFormat.TWO_DIMENSION));
//		stdb3.getShowTimes().add(new ShowTime(1900, mdb.getMovies().get(1), 5, 3, 7,MovieFormat.TWO_DIMENSION));
//		stdb3.getShowTimes().add(new ShowTime(1300, mdb.getMovies().get(2), 5, 3, 2,MovieFormat.THREE_DIMENSION));
//		stdb3.getShowTimes().add(new ShowTime(1600, mdb.getMovies().get(2), 5, 3, 3,MovieFormat.TWO_DIMENSION));
//		stdb3.getShowTimes().add(new ShowTime(1900, mdb.getMovies().get(2), 5, 3, 4,MovieFormat.TWO_DIMENSION));
//		stdb3.getShowTimes().add(new ShowTime(1300, mdb.getMovies().get(3), 5, 3, 5,MovieFormat.TWO_DIMENSION));
//		stdb3.getShowTimes().add(new ShowTime(1600, mdb.getMovies().get(3), 5, 3, 6,MovieFormat.TWO_DIMENSION));
//		stdb3.getShowTimes().add(new ShowTime(1900, mdb.getMovies().get(3), 5, 3, 1,MovieFormat.TWO_DIMENSION));
//		stdb3.getShowTimes().add(new ShowTime(1300, mdb.getMovies().get(4), 5, 3, 2,MovieFormat.TWO_DIMENSION));
//		stdb3.getShowTimes().add(new ShowTime(1900, mdb.getMovies().get(5), 5, 3, 3,MovieFormat.TWO_DIMENSION));
//		stdb3.getShowTimes().add(new ShowTime(2200, mdb.getMovies().get(5), 5, 3, 1,MovieFormat.TWO_DIMENSION));
//		stdb3.getShowTimes().add(new ShowTime(1300, mdb.getMovies().get(6), 5, 3, 7,MovieFormat.TWO_DIMENSION));
//		stdb3.getShowTimes().add(new ShowTime(1600, mdb.getMovies().get(6), 5, 3, 3,MovieFormat.TWO_DIMENSION));
//		stdb3.getShowTimes().add(new ShowTime(2200, mdb.getMovies().get(6), 5, 3, 4,MovieFormat.TWO_DIMENSION));
//		stdb3.getShowTimes().add(new ShowTime(1100, mdb.getMovies().get(7), 5, 3, 5,MovieFormat.THREE_DIMENSION));
//		stdb3.getShowTimes().add(new ShowTime(2200, mdb.getMovies().get(7), 5, 3, 6,MovieFormat.TWO_DIMENSION));
//		
//		ShowTimeDatabase stdb3copy = null;
//		fff2.saveShowTimeDB(stdb3, 3);
//		stdb3copy = fff2.loadShowTimeDB(3);
//		System.out.println(stdb3copy.getShowTimes());

//		MovieDatabase mdbcopy = null;
//		fff2.saveMovieDB(mdb);
//		mdbcopy = fff2.loadMovieDB();
//		mdbcopy.printMovieDetails();
//		mdbcopy.printMovieDetails();
//		mdbcopy.printMovieDetails();
//		mdbcopy.printMovieDetails();
//		mdbcopy.printMovieDetails();
//		mdbcopy.printMovieDetails();
//		mdbcopy.printMovieDetails();
//		mdbcopy.printMovieDetails();
//		mdbcopy.printMovieDetails();
//		mdbcopy.printMovieDetails();
//		mdbcopy.printMovieDetails();
//		System.out.println(mdbcopy.getMovieTitlesList());
		
//		ShowTimeDatabase stdb = new ShowTimeDatabase();
//		ShowTimeDatabase stdbcopy = null;
//		fff2.saveShowTimeDB(stdb);
//		stdbcopy = fff2.loadShowTimeDB();
//		System.out.println(stdbcopy.getShowTimes());
		
//		AdminDatabase adb = new AdminDatabase();
//		AdminDatabase adbcopy = null;
//		fff2.saveAdminDB(adb);
//		adbcopy = fff2.loadAdminDB();
//		System.out.println(adbcopy.getAdminList());
		
//		UserDatabase udb = new UserDatabase();
//		udb.addUser("hk" , "123");
//		udb.addUser("yxing" , "password");
//		udb.addUser("munnie" , "mokmok");
//		udb.addUser("hopet" , "ricky");
//		udb.addUser("jor" , "nadroj");
//		UserDatabase udbcopy = null;
//		fff2.saveUserDB(udb);
//		udbcopy = fff2.loadUserDB();
//		System.out.println(udbcopy.getUserList());
//	
//		HolidayDatabase hdb = new HolidayDatabase();
//		hdb.addHoliday();
//		hdb.addHoliday();
//		hdb.addHoliday();
//		HolidayDatabase hdbcopy = null;
//		fff2.saveHolidayDB(hdb);
//		hdbcopy = fff2.loadHolidayDB();
//		hdbcopy.printHolidays();
		
//		Cineplex c= new Cineplex();
//		Cineplex ccopy = null;
//		c.addCinemasToCineplex();
//		fff2.saveCineplex(c);
//		ccopy = fff2.loadCineplex(3);
//		for (int i=0; i<ccopy.getCinemas().size();i++)
//			System.out.println(ccopy.getCinemas().get(i).getCinemaNumber() + "..." + ccopy.getCinemas().get(i).getCode()+ "..." + ccopy.getCinemas().get(i).getType());
		
		
//		BookingDatabase bdb = new BookingDatabase();
//		BookingDatabase bdbcopy = null;
		
//	}
}
