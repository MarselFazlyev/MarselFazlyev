public class Main {
    public static Movie[] getMovies(){
        return new Movie[] {
                new Movie( "Терминатор", 1990, 16),
                new Movie("Матрица", 2000, 14),
                new Movie(" Чистилище",1995,18),
                new Movie("Король-Лев",1998,1)
        };
    }

    public static Theatre[] getTheatres() {
        return new Theatre[]{
                new Theatre("7 дней в Савраске",2020,16 ),
                new Theatre("Куртизанка",2005, 18),
                new Theatre("Дядя Ваня",1990,2),
                new Theatre("Гамлет",1800,5)
        };
    }
    
    public static void validEvent(Event event) {
        if (event.getTitle()==null||event.getReleaseYear()==0||event.getAge()==0){
            throw new RuntimeException("Не заполнено одно из полей события!");
        }
    }

    public static void main(String[] args) {
        for (Event event: getMovies()) {
            validEvent(event);
        }
        for (Event event: getTheatres()) {
            validEvent(event);
        }
        System.out.println("Все события успешно заполнены!");

    }
}
