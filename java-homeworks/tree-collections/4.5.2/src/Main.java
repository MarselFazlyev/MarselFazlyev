
public class Main {

    public static void main(String[] args) {
        Storage storage = new Storage();

        Candidate candidate1 = (new Candidate("Камалиев Юнус Тагирович", 'м', 37, 5, 2));
        Candidate candidate2 = (new Candidate("Пирожкова  Татьяна Валерьевна", 'Ж', 35, 5, 4));
        Candidate candidate3 = (new Candidate("Шивкина  Жанна Сергеевна", 'Ж', 80, 3, 4));
        Candidate candidate4 = (new Candidate("Одрузов  Борис Константинович", 'м', 45, 4, 1));
        Candidate candidate5 = (new Candidate("Щипачев  Митрий Митриевич", 'м', 66, 4, 3));
        Candidate candidate6 = (new Candidate("Метеоритов  Магомед Обалдуевич", 'м', 5, 2, 5));
        Candidate candidate7 = (new Candidate("Щепка  Орест Майклович", 'м', 45, 5, 5));
        Candidate candidate8 = (new Candidate("Ухогорлоносов  Юрий Джонович", 'м', 22, 2, 2));
        Candidate candidate9 = (new Candidate("Иванов  Филипп Сершеевич", 'м', 27, 3, 2));
        Candidate candidate10 = (new Candidate("Ильин  Марсель Тимурович", 'м', 40, 3, 4));
        Candidate candidate11 = (new Candidate("Михайлов  Женек Ответович", 'м', 63, 5, 5));
        Candidate candidate12 = (new Candidate("Аглиуллин Ибрагим Мухамедказыевич", 'м', 25, 1, 5));

        storage.addCandidate(candidate1);
        storage.addCandidate(candidate2);
        storage.addCandidate(candidate3);
        storage.addCandidate(candidate4);
        storage.addCandidate(candidate5);
        storage.addCandidate(candidate6);
        storage.addCandidate(candidate7);
        storage.addCandidate(candidate8);
        storage.addCandidate(candidate9);
        storage.addCandidate(candidate10);
        storage.addCandidate(candidate11);
        storage.addCandidate(candidate12);

        System.out.println(storage);
        // TODO: 24.03.2022 Переопределить toString для красивого вывода в Storage, сделать задачу через компаратор.


    }
}
