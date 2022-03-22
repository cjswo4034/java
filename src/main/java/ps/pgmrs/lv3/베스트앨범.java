package ps.pgmrs.lv3;

import ps.pgmrs.Solution;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.groupingBy;

public class 베스트앨범 implements Solution<int[]> {
    @Override
    public int[] solution(Object... params) {
        return solution((String[]) params[0], (int[]) params[1]);
    }

    public int[] solution(String[] genres, int[] plays) {
        Map<String, List<Song>> songs = IntStream.range(0, genres.length)
                .mapToObj(i -> new Song(i, plays[i], genres[i]))
                .sorted()
                .collect(groupingBy(song -> song.genre, Collectors.toList()));

        return sortedGenres(songs).stream()
                .map(songs::get)
                .flatMap(songs2 -> songs2.stream().limit(2))
                .mapToInt(song -> song.index)
                .toArray();
    }


    List<String> sortedGenres(Map<String, List<Song>> songs) {
        return songs.entrySet().stream()
                .sorted((e1, e2) -> -Integer.compare(sum(e1.getValue()), sum(e2.getValue())))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public int[] solution2(String[] genres, int[] plays) {
        Map<String, List<Song>> songs = IntStream.range(0, genres.length)
                .mapToObj(i -> new Song(i, plays[i], genres[i]))
                .sorted()
                .collect(groupingBy(Song::getGenre));

        return songs
                .entrySet().stream()
                .sorted((e1, e2) -> -Integer.compare(sum(e1.getValue()), sum(e2.getValue())))
                .flatMap(entry -> entry.getValue().stream().limit(2))
                .mapToInt(song -> song.index)
                .toArray();
    }

    int sum(List<Song> songs) {
        int sum = 0;
        for (Song song: songs)
            sum += song.play;
        return sum;
    }

    class Song implements Comparable<Song> {
        String genre;
        int index;
        int play;

        public Song(int index, int play, String genre) {
            this.index = index;
            this.genre = genre;
            this.play = play;
        }

        public String getGenre() {
            return genre;
        }

        @Override
        public int compareTo(Song o) {
            if (!genre.equals(o.genre))
                return genre.compareTo(o.genre);
            if (play != o.play)
                return -Integer.compare(play, o.play);
            return Integer.compare(index, o.index);
        }
    }
}
